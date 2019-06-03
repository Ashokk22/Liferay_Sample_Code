<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.warrior.entitymanager.util.EntityManagerConstants"%>
<%@page import="com.warrior.entitymanager.model.EntityManager"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetVocabulary"%>
<%@page import="java.util.List"%>
<%@ page import="com.liferay.portal.kernel.bean.BeanParamUtil" %>

<%@include file="/html/init.jsp" %>
<portlet:defineObjects />
<%

	EntityManager entitymanager = (EntityManager)request.getAttribute(EntityManagerConstants.ENTITYMANAGER_ENTRY);
	long resourcePrimKey = entitymanager.getEntityId();
	//System.out.println(entitymanager);
	long groupId = themeDisplay.getScopeGroupId();
	List<AssetVocabulary> vocabularies = AssetVocabularyLocalServiceUtil.getGroupVocabularies(groupId);
	List<AssetCategory> assetCategoryList = null;
	if(resourcePrimKey>0){
		assetCategoryList = AssetCategoryLocalServiceUtil.getVocabularyCategories(entitymanager.getVocubalaryId(), -1, -1, null);
	}
	
	int status = BeanParamUtil.getInteger(entitymanager, request, "status", WorkflowConstants.STATUS_DRAFT);
	
%>



<portlet:renderURL windowState="normal" var="backURL">
  <portlet:param name="jspPage" value="/html/admin/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:resourceURL var="addToDo">
	<portlet:param name="CMD" value="addToDo" />
</portlet:resourceURL>

<liferay-ui:header
    backURL="<%= backURL %>"
    title="Back To main Page"
/>



<portlet:actionURL name="updateEntity" var="updateEntityURL">
</portlet:actionURL>

<portlet:renderURL var="cancelURL"><portlet:param name="jspPage" value="/html/admin/view.jsp" /></portlet:renderURL>

<aui:form useNamespace="false" action="<%= updateEntityURL.toString() %>" name='<%=portletnamespace + \"fm0\" %>' enctype="multipart/form-data"  method="post">
	<liferay-ui:error key="entity-title-required" message="entity-title-required" />
    <liferay-ui:error key="entity-description-required" message="entity-description-required" />
    <liferay-ui:success key="entity-updated" message="entity-updated"></liferay-ui:success>
	<liferay-ui:success key="entity-added" message="entity-added"></liferay-ui:success>
	<liferay-ui:error key="entity-category-required" message="entity-category-required" />
	<liferay-ui:error key="entity-vocabulary-required" message="entity-vocabulary-required" />

  <aui:fieldset>
		<aui:model-context bean="<%= entitymanager %>" model="<%= EntityManager.class %>" />

	    <c:if test="<%= entitymanager != null %>">
	      <aui:workflow-status id="<%= String.valueOf(resourcePrimKey) %>" status="<%= status %>" />
	    </c:if>

	    <aui:input name="entityId" type="hidden" value="<%= entitymanager.getEntityId() %>" />

      <h1>Add Entity</h1>

    <aui:input name="entityTitle" type="text" value="<%=entitymanager.getTitle() %>"  autoFocus="true" size="45" />
    <aui:input name="entityDesc" type="text" value="<%=entitymanager.getDescription() %>" />

     <aui:select name="vocabId" id="vocabId">
     		<aui:option value="-1">
				<liferay-ui:message key="please-choose" />
			</aui:option>
  		<%
  			for (AssetVocabulary vocabulary : vocabularies)
  			{
  		%>  <aui:option label="<%= HtmlUtil.escape(vocabulary.getTitle(locale)) %>"  value="<%= vocabulary.getVocabularyId() %>" selected='<%=vocabulary.getVocabularyId()==entitymanager.getVocubalaryId()?true:false %>'/>
  		<% } %>

  </aui:select>

  <aui:select name="categoryId" id="category">
	 		<aui:option value="-1">
				<liferay-ui:message key="please-choose" />
			</aui:option>
			<%
			if(assetCategoryList!=null){
  			for (AssetCategory assetCategory : assetCategoryList)
  			{
  		%>  <aui:option label="<%= HtmlUtil.escape(assetCategory.getTitle(locale)) %>"  value="<%= assetCategory.getCategoryId() %>" selected='<%=assetCategory.getCategoryId()==entitymanager.getCategoryId()?true:false %>'/>
  		<% } }%>
			
  </aui:select>

   <aui:button-row>

      <aui:button type="submit" />

      <aui:button
          type="cancel"
          value="Cancel"
          onClick="<%=cancelURL %>"
      />

    </aui:button-row>

  </aui:fieldset>

</aui:form>


<!-- Ajax CAll Using AUI FORM -->
<aui:script use="aui-base,aui-io,aui-io-upload">


    var entitymanager_form = A.one('#<portlet:namespace />fm0');

		entitymanager_form.one('#vocabId').on(
            'change',
            function(event) {

try{

 				//alert("Before")
 				var vocabularyIndex = document.getElementById("vocabId");
				var vocabularyValue = vocabularyIndex.options[vocabularyIndex.selectedIndex].value;
				//alert(vocabularyValue);

			     var sample = "<%= addToDo %>";
			    //alert(sample);

                    A.io.request(
									"<%= addToDo %>"+"&<portlet:namespace />selectedVocabularyId="+vocabularyValue,

                            {
                                    dataType: 'json',
                                    form: {
                                            id: entitymanager_form.getDOM(),
                                            upload: true
                                    },

                                    method: 'POST',
                                     data: {

											 },

                                    on: {

                                            complete: function(event, id, obj) {
                                                    try {




                                                          var responseData = A.JSON.parse(obj.responseText);
															//alert(responseData);

                                                            if (responseData.status == 'success') {
                                    							var select = document.getElementById("category");
																select.options.length = 0;
																for (var i = 0; i < responseData.catArray.length; i++) {
																	var details = responseData.catArray[i];

																    select.options.add(new Option(details.categoryname, details.categoryvalue));
																}

                                                            }
                                                            else
                                                            {
                                                            	alert("Failure")

                                                           }
                                                    }
                                                    catch (e) {
                                                    alert("Exception 1");

     													//alert("Debug:Inform site admin for error: Submitting Lesson Plan form-"+e);
                                                    }




                                            }
                                    }
                            }
                    );
               }
   catch(e)
   {
   //alert("Exception Main");
     //alert("Debug:Inform site admin for error: -"+e);

   }

            }
    );





</aui:script>