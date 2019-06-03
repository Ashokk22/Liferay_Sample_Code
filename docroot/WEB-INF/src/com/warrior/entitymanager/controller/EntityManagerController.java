package com.warrior.entitymanager.controller;


import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.warrior.entitymanager.model.EntityManager;
import com.warrior.entitymanager.model.impl.EntityManagerImpl;
import com.warrior.entitymanager.service.EntityManagerLocalServiceUtil;
import com.warrior.entitymanager.util.ActionUtil;
import com.warrior.entitymanager.util.EntityManagerConstants;
import com.warrior.entitymanager.util.EntityManagerValidator;


public class EntityManagerController extends MVCPortlet {

	public void updateEntity(ActionRequest request, ActionResponse response)
    throws PortalException, SystemException {

		 _log.info("====================UpdateEntityManager Started===============================");

	ThemeDisplay td =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

	ServiceContext serviceContext = ServiceContextFactory.getInstance(EntityManager.class.getName(),
			request);

	EntityManager entitymanager = ActionUtil.entityManagerFromRequest(request);

    ArrayList<String> errors = new ArrayList();

    // For Disabling default error Message
    PortletConfig portletConfig = (PortletConfig)request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
    SessionMessages.add(request, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

    if (EntityManagerValidator.validateEntityManager(entitymanager, errors)) {
        if (entitymanager.getEntityId() > 0) {
            // Updating

            try {
            	EntityManager fromDB =
            			EntityManagerLocalServiceUtil.getEntityManager(entitymanager.getEntityId());

                if (fromDB != null &&
                    (entitymanager.getEntityId() == fromDB.getEntityId())) {

                    fromDB =
                    		EntityManagerLocalServiceUtil.updateEntityManager(entitymanager, serviceContext);

                    SessionMessages.add(request, "entity-updated");
                }
            }
            catch (PortalException e) {
                errors.add("entity-update-fail");
                _log.info("Error->"+e);
            }
            catch (SystemException e) {
                errors.add("entity-update-fail");
                _log.info("Error->"+e);
            }
        }
        else {
            // Adding

            try {
            	EntityManagerLocalServiceUtil.addEntityManager(entitymanager, serviceContext);
                SessionMessages.add(request, "entity-added");
            }
            catch (Exception e) {
                errors.add("entity-add-fail");
                _log.info("Error->"+e);
            }

        }

    }
    else {
        for (String error : errors) {
            SessionErrors.add(request, error);
        }

        request.setAttribute(EntityManagerConstants.ENTITYMANAGER_ENTRY, entitymanager);
        response.setRenderParameter("entityId", ""+entitymanager.getEntityId());
        response.setRenderParameter("jspPage", "/html/admin/add_entity.jsp");
    }
    _log.info("====================UpdateEntityManager Ended===============================");
}

	  public void render(
	            RenderRequest renderRequest, RenderResponse renderResponse)
	        throws PortletException, IOException {

	        try {
	        	 _log.info("====================Renderer Started===============================");
	        	 EntityManager entityManager = null;

	            long resourcePrimKey =
	                ParamUtil.getLong(renderRequest, "entityId");
	            _log.info("entityId->"+resourcePrimKey);
	            if (resourcePrimKey > 0) {
	            	entityManager = EntityManagerLocalServiceUtil.getEntityManager(resourcePrimKey);
	            }
	            else {
	            	entityManager = new EntityManagerImpl();
	            }

	            renderRequest.setAttribute(EntityManagerConstants.ENTITYMANAGER_ENTRY, entityManager);
	        }
	        catch (Exception e) {
	                throw new PortletException(e);

	        }

	        super.render(renderRequest, renderResponse);
	        _log.info("====================Renderer Ended===============================");

	    }

	  public void deleteEntity(ActionRequest request, ActionResponse response)
      throws Exception {
		  _log.info("====================deleteEntity===============================");
		  
      long primaryKey = ParamUtil.getLong(request, "entityId");
      String cmd = ParamUtil.getString(request, Constants.CMD);
      System.out.println("primaryKey==================="+primaryKey);
      
      //ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

		/*Group group = GroupLocalServiceUtil.getGroup(
			themeDisplay.getScopeGroupId());

		User user = UserLocalServiceUtil.getUserById(group.getClassPK());*/
      	System.out.println("TEST");
      if (Validator.isNotNull(primaryKey)) {
    	 // LessonPlanLocalServiceUtil.deleteLessonPlan(primaryKey);
    	  ServiceContext serviceContext = ServiceContextFactory.getInstance(EntityManager.class.getName(),
    				request);
    	  ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

  		Group group = GroupLocalServiceUtil.getGroup(
  			themeDisplay.getScopeGroupId());
  		User user = themeDisplay.getUser();
  		 
  		EntityManager entityManager = EntityManagerLocalServiceUtil.getEntityManager(primaryKey);
    	  
  		UnicodeProperties typeSettingsProperties = new UnicodeProperties();

		typeSettingsProperties.put("title", entityManager.getTitle());
		
		
		if (cmd.equals(Constants.DELETE)) {
			
			EntityManagerLocalServiceUtil.deleteEntityManager(primaryKey);
		}
		  SessionMessages.add(request, "employee-deleted");
      }
      else {
    	  
          SessionErrors.add(request, "error-deleting");

      }
	 
	  }

	  public void serveResource(ResourceRequest request, ResourceResponse response) {
	    	 _log.info("====================Serve Resource Started===============================");

	    	 System.out.println(request.getParameter("CMD"));
	    	 System.out.println(request.getParameter("resourceURL"));

	    	 if (request.getParameter("CMD").equals("addToDo")) {

	        	Long selectedVocabularyId = Long.parseLong(request.getParameter("selectedVocabularyId"));

	        	List<AssetCategory> assetCategoryList = null;
	    		try {
	    			if (selectedVocabularyId > 0) {
	    				assetCategoryList = AssetCategoryLocalServiceUtil.getVocabularyCategories(selectedVocabularyId, -1, -1, null);
	    			}
	    		} catch (SystemException exc) {
	    			exc.printStackTrace();

	    		}

	        	JSONObject mainjsonObj = JSONFactoryUtil.createJSONObject();

	        	JSONArray objarray = JSONFactoryUtil.createJSONArray();

	        	for (int i=0;i<assetCategoryList.size();i++)
	        	{
	        		AssetCategory objac = assetCategoryList.get(i);
	        		JSONObject details = JSONFactoryUtil.createJSONObject();
	            	details.put("categoryname", objac.getName() );
	            	details.put("categoryvalue", objac.getCategoryId());
	            	objarray.put(details);
	        	}


	        	mainjsonObj.put("catArray", objarray);
	        	mainjsonObj.put("status","success");

	            OutputStream os = null;
	            try {
	            	 os = response.getPortletOutputStream();
	            	 os.write(mainjsonObj.toString().getBytes());
	            }
	            catch(Exception e)
	            {
	            	e.printStackTrace();
	            }
	            finally {
	                try {
						os.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }

	        }
	    	 _log.info("====================Serve Resource Ended===============================");
	    }

    private static Log _log = LogFactoryUtil.getLog(EntityManagerController.class);

}