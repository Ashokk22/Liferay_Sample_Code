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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EntityManagerLocalService}.
 *
 * @author HP
 * @see EntityManagerLocalService
 * @generated
 */
public class EntityManagerLocalServiceWrapper
	implements EntityManagerLocalService,
		ServiceWrapper<EntityManagerLocalService> {
	public EntityManagerLocalServiceWrapper(
		EntityManagerLocalService entityManagerLocalService) {
		_entityManagerLocalService = entityManagerLocalService;
	}

	/**
	* Adds the entity manager to the database. Also notifies the appropriate model listeners.
	*
	* @param entityManager the entity manager
	* @return the entity manager that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.warrior.entitymanager.model.EntityManager addEntityManager(
		com.warrior.entitymanager.model.EntityManager entityManager)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.addEntityManager(entityManager);
	}

	/**
	* Creates a new entity manager with the primary key. Does not add the entity manager to the database.
	*
	* @param entityId the primary key for the new entity manager
	* @return the new entity manager
	*/
	@Override
	public com.warrior.entitymanager.model.EntityManager createEntityManager(
		long entityId) {
		return _entityManagerLocalService.createEntityManager(entityId);
	}

	/**
	* Deletes the entity manager with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entityId the primary key of the entity manager
	* @return the entity manager that was removed
	* @throws PortalException if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.warrior.entitymanager.model.EntityManager deleteEntityManager(
		long entityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.deleteEntityManager(entityId);
	}

	/**
	* Deletes the entity manager from the database. Also notifies the appropriate model listeners.
	*
	* @param entityManager the entity manager
	* @return the entity manager that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.warrior.entitymanager.model.EntityManager deleteEntityManager(
		com.warrior.entitymanager.model.EntityManager entityManager)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.deleteEntityManager(entityManager);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _entityManagerLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.warrior.entitymanager.model.EntityManager fetchEntityManager(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.fetchEntityManager(entityId);
	}

	/**
	* Returns the entity manager with the matching UUID and company.
	*
	* @param uuid the entity manager's UUID
	* @param companyId the primary key of the company
	* @return the matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.warrior.entitymanager.model.EntityManager fetchEntityManagerByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.fetchEntityManagerByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the entity manager matching the UUID and group.
	*
	* @param uuid the entity manager's UUID
	* @param groupId the primary key of the group
	* @return the matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.warrior.entitymanager.model.EntityManager fetchEntityManagerByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.fetchEntityManagerByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the entity manager with the primary key.
	*
	* @param entityId the primary key of the entity manager
	* @return the entity manager
	* @throws PortalException if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.warrior.entitymanager.model.EntityManager getEntityManager(
		long entityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.getEntityManager(entityId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.warrior.entitymanager.model.EntityManager getEntityManagerByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.getEntityManagerByUuidAndCompanyId(uuid,
			companyId);
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
	@Override
	public com.warrior.entitymanager.model.EntityManager getEntityManagerByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.getEntityManagerByUuidAndGroupId(uuid,
			groupId);
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
	@Override
	public java.util.List<com.warrior.entitymanager.model.EntityManager> getEntityManagers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.getEntityManagers(start, end);
	}

	/**
	* Returns the number of entity managers.
	*
	* @return the number of entity managers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEntityManagersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.getEntityManagersCount();
	}

	/**
	* Updates the entity manager in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param entityManager the entity manager
	* @return the entity manager that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.warrior.entitymanager.model.EntityManager updateEntityManager(
		com.warrior.entitymanager.model.EntityManager entityManager)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.updateEntityManager(entityManager);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _entityManagerLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_entityManagerLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _entityManagerLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.warrior.entitymanager.model.EntityManager> getEntityManagersByTitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.getEntityManagersByTitle(title,
			start, end, obc);
	}

	@Override
	public java.util.List<com.warrior.entitymanager.model.EntityManager> getEntityManagersByVocabulary(
		long vocubalaryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.getEntityManagersByVocabulary(vocubalaryId,
			start, end, obc);
	}

	@Override
	public com.warrior.entitymanager.model.EntityManager addEntityManager(
		com.warrior.entitymanager.model.EntityManager entity,
		com.liferay.portal.service.ServiceContext sc) {
		return _entityManagerLocalService.addEntityManager(entity, sc);
	}

	@Override
	public com.warrior.entitymanager.model.EntityManager updateEntityManager(
		com.warrior.entitymanager.model.EntityManager entity,
		com.liferay.portal.service.ServiceContext sc) {
		return _entityManagerLocalService.updateEntityManager(entity, sc);
	}

	@Override
	public com.warrior.entitymanager.model.EntityManager getEntity(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.getEntity(entityId);
	}

	@Override
	public java.util.List<com.warrior.entitymanager.model.EntityManager> getEntityManagers(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator order)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.getEntityManagers(groupId, status,
			start, end, order);
	}

	@Override
	public java.util.List<com.warrior.entitymanager.model.EntityManager> getEntityManagers(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.getEntityManagers(groupId, status,
			start, end);
	}

	@Override
	public int getEntityManagersByentityCount(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManagerLocalService.getEntityManagersByentityCount(entityId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EntityManagerLocalService getWrappedEntityManagerLocalService() {
		return _entityManagerLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEntityManagerLocalService(
		EntityManagerLocalService entityManagerLocalService) {
		_entityManagerLocalService = entityManagerLocalService;
	}

	@Override
	public EntityManagerLocalService getWrappedService() {
		return _entityManagerLocalService;
	}

	@Override
	public void setWrappedService(
		EntityManagerLocalService entityManagerLocalService) {
		_entityManagerLocalService = entityManagerLocalService;
	}

	private EntityManagerLocalService _entityManagerLocalService;
}