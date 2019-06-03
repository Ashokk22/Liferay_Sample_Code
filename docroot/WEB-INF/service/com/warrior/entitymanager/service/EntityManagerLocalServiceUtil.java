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

package com.warrior.entitymanager.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for EntityManager. This utility wraps
 * {@link com.warrior.entitymanager.service.impl.EntityManagerLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author HP
 * @see EntityManagerLocalService
 * @see com.warrior.entitymanager.service.base.EntityManagerLocalServiceBaseImpl
 * @see com.warrior.entitymanager.service.impl.EntityManagerLocalServiceImpl
 * @generated
 */
public class EntityManagerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.warrior.entitymanager.service.impl.EntityManagerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the entity manager to the database. Also notifies the appropriate model listeners.
	*
	* @param entityManager the entity manager
	* @return the entity manager that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager addEntityManager(
		com.warrior.entitymanager.model.EntityManager entityManager)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEntityManager(entityManager);
	}

	/**
	* Creates a new entity manager with the primary key. Does not add the entity manager to the database.
	*
	* @param entityId the primary key for the new entity manager
	* @return the new entity manager
	*/
	public static com.warrior.entitymanager.model.EntityManager createEntityManager(
		long entityId) {
		return getService().createEntityManager(entityId);
	}

	/**
	* Deletes the entity manager with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entityId the primary key of the entity manager
	* @return the entity manager that was removed
	* @throws PortalException if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager deleteEntityManager(
		long entityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEntityManager(entityId);
	}

	/**
	* Deletes the entity manager from the database. Also notifies the appropriate model listeners.
	*
	* @param entityManager the entity manager
	* @return the entity manager that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager deleteEntityManager(
		com.warrior.entitymanager.model.EntityManager entityManager)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEntityManager(entityManager);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.warrior.entitymanager.model.EntityManager fetchEntityManager(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEntityManager(entityId);
	}

	/**
	* Returns the entity manager with the matching UUID and company.
	*
	* @param uuid the entity manager's UUID
	* @param companyId the primary key of the company
	* @return the matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchEntityManagerByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEntityManagerByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the entity manager matching the UUID and group.
	*
	* @param uuid the entity manager's UUID
	* @param groupId the primary key of the group
	* @return the matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchEntityManagerByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEntityManagerByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the entity manager with the primary key.
	*
	* @param entityId the primary key of the entity manager
	* @return the entity manager
	* @throws PortalException if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager getEntityManager(
		long entityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEntityManager(entityId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the entity manager with the matching UUID and company.
	*
	* @param uuid the entity manager's UUID
	* @param companyId the primary key of the company
	* @return the matching entity manager
	* @throws PortalException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager getEntityManagerByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEntityManagerByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the entity manager matching the UUID and group.
	*
	* @param uuid the entity manager's UUID
	* @param groupId the primary key of the group
	* @return the matching entity manager
	* @throws PortalException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager getEntityManagerByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEntityManagerByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the entity managers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @return the range of entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> getEntityManagers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEntityManagers(start, end);
	}

	/**
	* Returns the number of entity managers.
	*
	* @return the number of entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static int getEntityManagersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEntityManagersCount();
	}

	/**
	* Updates the entity manager in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param entityManager the entity manager
	* @return the entity manager that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager updateEntityManager(
		com.warrior.entitymanager.model.EntityManager entityManager)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEntityManager(entityManager);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.warrior.entitymanager.model.EntityManager> getEntityManagersByTitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEntityManagersByTitle(title, start, end, obc);
	}

	public static java.util.List<com.warrior.entitymanager.model.EntityManager> getEntityManagersByVocabulary(
		long vocubalaryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEntityManagersByVocabulary(vocubalaryId, start, end, obc);
	}

	public static com.warrior.entitymanager.model.EntityManager addEntityManager(
		com.warrior.entitymanager.model.EntityManager entity,
		com.liferay.portal.service.ServiceContext sc) {
		return getService().addEntityManager(entity, sc);
	}

	public static com.warrior.entitymanager.model.EntityManager updateEntityManager(
		com.warrior.entitymanager.model.EntityManager entity,
		com.liferay.portal.service.ServiceContext sc) {
		return getService().updateEntityManager(entity, sc);
	}

	public static com.warrior.entitymanager.model.EntityManager getEntity(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEntity(entityId);
	}

	public static java.util.List<com.warrior.entitymanager.model.EntityManager> getEntityManagers(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator order)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEntityManagers(groupId, status, start, end, order);
	}

	public static java.util.List<com.warrior.entitymanager.model.EntityManager> getEntityManagers(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEntityManagers(groupId, status, start, end);
	}

	public static int getEntityManagersByentityCount(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEntityManagersByentityCount(entityId);
	}

	public static void clearService() {
		_service = null;
	}

	public static EntityManagerLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EntityManagerLocalService.class.getName());

			if (invokableLocalService instanceof EntityManagerLocalService) {
				_service = (EntityManagerLocalService)invokableLocalService;
			}
			else {
				_service = new EntityManagerLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EntityManagerLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EntityManagerLocalService service) {
	}

	private static EntityManagerLocalService _service;
}