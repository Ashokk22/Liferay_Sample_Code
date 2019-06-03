package com.warrior.entitymanager.util;

/**
orderByComparator * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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


import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.warrior.entitymanager.model.EntityManager;
import com.warrior.entitymanager.model.impl.EntityManagerImpl;
import com.warrior.entitymanager.service.EntityManagerLocalServiceUtil;
import com.warrior.entitymanager.service.impl.EntityManagerLocalServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

/**
 * @author Rich Sezov
 */
public class ActionUtil {
	private static Log _log = LogFactoryUtil.getLog(ActionUtil.class);
	public static List<EntityManager> getEntityManagers(
		        RenderRequest request, int start, int end) {

		        List<EntityManager> entityManagers;
		        ThemeDisplay themeDisplay =
		            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		        long groupId = themeDisplay.getScopeGroupId();

		        try {
		        	entityManagers = EntityManagerLocalServiceUtil.getEntityManagers(groupId, WorkflowConstants.STATUS_APPROVED, start, end);
		        }
		        catch (SystemException e) {
		        	//e.printStackTrace();
		        	_log.error(e);
		        	entityManagers = Collections.EMPTY_LIST;
		        }

		        return entityManagers;
		    }
	
	  public static List<EntityManager> getEntityManagers(
		        RenderRequest request, int start, int end, String temp) {

		        List<EntityManager> entityManagers;

		        ThemeDisplay themeDisplay =
		            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		        long groupId = themeDisplay.getScopeGroupId();

		        try {
		        	entityManagers = EntityManagerLocalServiceUtil.getEntityManagers(start, end);
		        }
		        catch (SystemException e) {
		        	//e.printStackTrace();
		        	_log.error(e);
		        	entityManagers = Collections.EMPTY_LIST;
		        }

		        return entityManagers;
		    }

	  public static List<EntityManager> getEntityManagers(
		        RenderRequest request, int start, int end, String orderByCol, String orderByType) {

				  boolean orderByAsc = false;

				  if (orderByType.equals("asc")) {
				  orderByAsc = true;
				  }

				  OrderByComparator orderByComparator = null;

				  if (orderByCol.equals("by-Title")) {
				  orderByComparator = new EntityManagerTitleComparator(orderByAsc);
				  } else if (orderByCol.equals("by-Vocabulary")) {
				  orderByComparator = new EntityManagerVocabularyComparator(orderByAsc);
				  } else if (orderByCol.equals("by-Date")) {
				  orderByComparator = new EntityManagerDateComparator(orderByAsc);
				  }

		        List<EntityManager> entityManagers;

		        ThemeDisplay themeDisplay =
		            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		        long groupId = themeDisplay.getScopeGroupId();

		        try {
		        	entityManagers = EntityManagerLocalServiceUtil.getEntityManagers(groupId, WorkflowConstants.STATUS_APPROVED, start, end);
		        	Collections.sort(entityManagers, orderByComparator);
		        }
		        catch (SystemException e) {
		        	//e.printStackTrace();
		        	_log.error(e);
		        	entityManagers = Collections.EMPTY_LIST;
		        }

		        return entityManagers;
		    }


	
	  public static int getEntityManagersCount(RenderRequest request) {

	        ThemeDisplay themeDisplay =
	            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

	        long groupId = themeDisplay.getScopeGroupId();

	        try {
	        	return EntityManagerLocalServiceUtil.getEntityManagersCount();
	        }
	        catch (SystemException e) {
	            return 0;
	        }
	    }

	  public static OrderByComparator getEntityManagerOrderByComparator(
			  String orderByCol, String orderByType) {

			  boolean orderByAsc = false;

			  if (orderByType.equals("asc")) {
			  orderByAsc = true;
			  }

			  OrderByComparator orderByComparator = null;

			  if (orderByCol.equals("by-Title")) {
			  orderByComparator = new EntityManagerTitleComparator(orderByAsc);
			  } else if (orderByCol.equals("by-Vocabulary")) {
			  orderByComparator = new EntityManagerVocabularyComparator(orderByAsc);
			  } else if (orderByCol.equals("by-Date")) {
			  orderByComparator = new EntityManagerDateComparator(orderByAsc);
			  }

			  return orderByComparator;

			  }

  public static EntityManager entityManagerFromRequest(ActionRequest request) {

  	UploadPortletRequest uprequest = PortalUtil.getUploadPortletRequest(request);
  	SimpleDateFormat formatter; String output;
  	formatter = new SimpleDateFormat("MM-dd-yyyy");
  	Date temp = new Date();
  	EntityManager entityManager = new EntityManagerImpl();

      ThemeDisplay themeDisplay =
          (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

      //System.out.println("++++++++++++++++++++++++++++"+request.getParameter("entityTitle")+" "+ParamUtil.getString(uprequest, "entityTitle"));

      entityManager.setCompanyId(themeDisplay.getCompanyId());
      entityManager.setGroupId(themeDisplay.getScopeGroupId());
      entityManager.setUserId(themeDisplay.getUserId());
      entityManager.setTitle(ParamUtil.getString(uprequest, "entityTitle"));
      entityManager.setDescription(ParamUtil.getString(uprequest, "entityDesc"));
      entityManager.setVocubalaryId(ParamUtil.getLong(uprequest, "vocabId"));
      entityManager.setCategoryId(ParamUtil.getLong(uprequest, "categoryId"));
      entityManager.setEntityAddDate(formatter.format(temp));

      if (ParamUtil.getString(uprequest, "entityId") != "") {
    	  entityManager.setEntityId(Long.parseLong(ParamUtil.getString(uprequest, "entityId")));
      }

      return entityManager;
  }

}