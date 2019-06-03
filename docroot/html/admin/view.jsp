<%@page import="java.util.ArrayList"%>
<%@page import="com.warrior.entitymanager.model.EntityManager"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.warrior.entitymanager.util.ActionUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>


<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>

<%@ page import="java.util.Collections" %>

<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>
<%@include file = "/html/init.jsp" %>
<portlet:defineObjects />

<%
// Used so as to create two different tabs By filtering the resulta By Title and By Date

String tabs1 = ParamUtil.getString(request, "tabs1", "by-Title");
String sortByCol = ParamUtil.getString(request, "orderByCol");
String sortByType = ParamUtil.getString(request, "orderByType");


if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) {


} else {
	sortByCol = "by-Title";
	sortByType = "asc";
}


String tabs1Values = "by-Title,by-Date,by-Vocabulary";

PortletURL tabsURL = renderResponse.createRenderURL();
tabsURL.setParameter("jspPage", "/html/admin/view.jsp");
tabsURL.setParameter("tabs1", tabs1);

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("tabs1", tabs1);

String orderByType = "asc";
OrderByComparator orderByComparator = ActionUtil.getEntityManagerOrderByComparator(tabs1, orderByType);


%>

<portlet:renderURL var="addEntityURL">
  <portlet:param name="jspPage" value="/html/admin/add_entity.jsp" />
</portlet:renderURL>

<input type="button" class="btn btn-primary" value="Add Entity" onClick="location.href = '<%= addEntityURL.toString() %>';" />

<br/>

<liferay-ui:success key="entity-deleted" message="entity-deleted"></liferay-ui:success>
<liferay-ui:error key="entity-deleted-error" message="entity-deleted-error"></liferay-ui:error>



	<liferay-ui:search-container emptyResultsMessage="there-are-no-entity" delta="10" iteratorURL="<%= iteratorURL %>"
	orderByCol="<%= sortByCol %>"
	orderByType="<%= sortByType %>">
	      <liferay-ui:search-container-results>
	      <%
	      //System.out.println("tabs1======="+tabs1);
	      orderByComparator = ActionUtil.getEntityManagerOrderByComparator(sortByCol, sortByType);
	      List<EntityManager> data = ActionUtil.getEntityManagers(renderRequest, searchContainer.getStart(), searchContainer.getEnd(),null);
	      results = new ArrayList<EntityManager>(data);
	      Collections.sort(results,orderByComparator);
	      //System.out.println(results);
	     // Collections.sort(results,orderByComparator);
	      total = ActionUtil.getEntityManagersCount(renderRequest);
	      pageContext.setAttribute("results", results);
	      pageContext.setAttribute("total", total);

	      %>
	      </liferay-ui:search-container-results>

	      <liferay-ui:search-container-row
	          className="com.warrior.entitymanager.model.EntityManager"
	          keyProperty="entityId"
	          modelVar="curententity">

	        <portlet:renderURL windowState="maximized" var="rowURL">
	          <portlet:param name="jspPage" value="/html/admin/view_entity.jsp" />
	          <portlet:param name="resourcePrimKey" value="<%= String.valueOf(curententity.getEntityId()) %>" />
	        </portlet:renderURL>


			<liferay-ui:search-container-column-text
            href="<%= rowURL %>"
            name="entity-title-text"
            property="title"
            orderable="<%= true %>"
            orderableProperty="by-Title"
      		  />

      		  <liferay-ui:search-container-column-text
            href="<%= rowURL %>"
            name="entity-vocubalaryId-text"
            property="vocubalaryId"
            orderable="<%= true %>"
            orderableProperty="by-Vocabulary"
      		  />

			<liferay-ui:search-container-column-text
            href="<%= rowURL %>"
            name="entity-description-text"
            property="description"
            orderable="<%= true %>"
            orderableProperty="description"
      		  />

			<liferay-ui:search-container-column-text
            href="<%= rowURL %>"
            name="entity-PostDate-text"
            property="entityAddDate"
            orderable="<%= true %>"
            orderableProperty="by-Date"
      		  />

			 <liferay-ui:search-container-column-jsp
            path="/html/admin/entity_actions.jsp"
            align="right" />

	      </liferay-ui:search-container-row>

	      <liferay-ui:search-iterator />

	    </liferay-ui:search-container>
	   

