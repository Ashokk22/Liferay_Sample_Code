/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.warrior.entitymanager.service.impl;


import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.warrior.entitymanager.model.EntityManager;
import com.warrior.entitymanager.service.base.EntityManagerLocalServiceBaseImpl;
import com.warrior.entitymanager.service.persistence.EntityManagerPersistenceImpl;

/**
 * The implementation of the entity manager local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.warrior.entitymanager.service.EntityManagerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HP
 * @see com.warrior.entitymanager.service.base.EntityManagerLocalServiceBaseImpl
 * @see com.warrior.entitymanager.service.EntityManagerLocalServiceUtil
 */
public class EntityManagerLocalServiceImpl
	extends EntityManagerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.warrior.entitymanager.service.EntityManagerLocalServiceUtil} to access the entity manager local service.
	 */
	private static Log _log = LogFactoryUtil.getLog(EntityManagerLocalServiceImpl.class);
	public List<EntityManager> getEntityManagersByTitle(String title, int start, int end, OrderByComparator obc)
	        throws SystemException {
	        List<EntityManager> entitymanager = entityManagerPersistence.findByTitle(title, start, end, obc);
	        return entitymanager;
	    }

	 public List<EntityManager> getEntityManagersByVocabulary(long vocubalaryId, int start, int end, OrderByComparator obc)
		     throws SystemException {
		     List<EntityManager> entitymanager = entityManagerPersistence.findByVocubalaryId(vocubalaryId, start, end);
		     return entitymanager;
		 }
	 
	 public EntityManager addEntityManager(EntityManager entity, ServiceContext sc)
		{
		  EntityManager objEntityManager  = null;
			try {
				 long plid = sc.getPlid();
				 objEntityManager = entityManagerPersistence.create(counterLocalService.increment(EntityManager.class.getName()));
				 objEntityManager.setTitle(entity.getTitle());
				 objEntityManager.setDescription(entity.getDescription());
				 objEntityManager.setEntityAddDate(entity.getEntityAddDate());
				 objEntityManager.setVocubalaryId(entity.getVocubalaryId());
				 objEntityManager.setCategoryId(entity.getCategoryId());
				 objEntityManager.setCompanyId(entity.getCompanyId());
				 objEntityManager.setGroupId(entity.getGroupId());
				 objEntityManager.setUserId(entity.getUserId());
				 objEntityManager.setEntitystatus(WorkflowConstants.STATUS_APPROVED);
		    	 //PortletPermissionUtil.check(PermissionCheckerFactoryUtil.create(UserLocalServiceUtil.getUser(sc.getUserId()), false), plid, LessonPlanConstants.LESSONPLANPUBLISHER, LessonPlanConstants.LESSON_ADD_LESSONPLAN);
				 entityManagerPersistence.update(objEntityManager, false);
		    	
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				_log.error(e);
				//e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				_log.error(e);
				//e.printStackTrace();
			}

	        return entity;

		}


		public EntityManager updateEntityManager(EntityManager entity, ServiceContext sc)
		{
			EntityManager objEntityManager = null;
			try {
				objEntityManager = getEntity(entity.getEntityId());//lessonPlanPersistence.create(counterLocalService.increment(LessonPlan.class.getName()));
				objEntityManager.setTitle(entity.getTitle());
				objEntityManager.setDescription(entity.getDescription());
				objEntityManager.setEntityAddDate(entity.getEntityAddDate());
				objEntityManager.setVocubalaryId(entity.getVocubalaryId());
				objEntityManager.setCategoryId(entity.getCategoryId());
				objEntityManager.setCompanyId(entity.getCompanyId());
				objEntityManager.setGroupId(entity.getGroupId());
				objEntityManager.setUserId(entity.getUserId());
				objEntityManager.setEntitystatus(WorkflowConstants.STATUS_DRAFT);
				entityManagerPersistence.update(objEntityManager, false);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				_log.error(e);
				//e.printStackTrace();
			} 

	        return objEntityManager;

		}

		public EntityManager getEntity(long entityId)throws SystemException
		{
			EntityManager objEntityManager = entityManagerPersistence.fetchByPrimaryKey(entityId);
			return objEntityManager;
		}

	
		public EntityManager deleteEntityManager(long lessonplanId)throws SystemException, PortalException
		{
			//System.out.println("HERE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			EntityManager objEntityManager = entityManagerPersistence.findByPrimaryKey(lessonplanId);
			//System.out.println("objEntityManager >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+objEntityManager);
			return deleteEntityManager(objEntityManager);
		}
		
		public EntityManager deleteEntityManager(EntityManager objEntityManager)throws SystemException
		{
			EntityManager objEntityManager2 = null;
			try {
				System.out.println("Came >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				objEntityManager2 = entityManagerPersistence.remove(objEntityManager);
				 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				_log.error(e);
				//e.printStackTrace();
			}
			
			return objEntityManager2;
		}
		
		



		public List<EntityManager> getEntityManagers(
	            long groupId, int status, int start, int end, OrderByComparator order)
	        throws SystemException {

	        List<EntityManager> entityManager =entityManagerPersistence.findByG_S(groupId, status, start, end, order);
	        return entityManager;
	    }
		public List<EntityManager> getEntityManagers(
	            long groupId, int status, int start, int end)
	        throws SystemException {

	        List<EntityManager> entitymanagers =entityManagerPersistence.findByG_S(groupId, status, start, end);
	        return entitymanagers;
	    }
		
		public int getEntityManagersByentityCount(long entityId) throws SystemException {
			return entityManagerPersistence.countByEntityId(entityId);
		}


}