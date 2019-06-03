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

package com.warrior.entitymanager.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.warrior.entitymanager.model.EntityManager;

import java.util.List;

/**
 * The persistence utility for the entity manager service. This utility wraps {@link EntityManagerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HP
 * @see EntityManagerPersistence
 * @see EntityManagerPersistenceImpl
 * @generated
 */
public class EntityManagerUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(EntityManager entityManager) {
		getPersistence().clearCache(entityManager);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EntityManager> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EntityManager> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EntityManager> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EntityManager update(EntityManager entityManager)
		throws SystemException {
		return getPersistence().update(entityManager);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EntityManager update(EntityManager entityManager,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(entityManager, serviceContext);
	}

	/**
	* Returns all the entity managers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the entity managers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @return the range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the entity managers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the entity managers before and after the current entity manager in the ordered set where uuid = &#63;.
	*
	* @param entityId the primary key of the current entity manager
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager[] findByUuid_PrevAndNext(
		long entityId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByUuid_PrevAndNext(entityId, uuid, orderByComparator);
	}

	/**
	* Removes all the entity managers where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of entity managers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the entity manager where uuid = &#63; and groupId = &#63; or throws a {@link com.warrior.entitymanager.NoSuchEntityManagerException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the entity manager where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the entity manager where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the entity manager where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the entity manager that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of entity managers where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the entity managers where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the entity managers where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @return the range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the entity managers where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the entity managers before and after the current entity manager in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param entityId the primary key of the current entity manager
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager[] findByUuid_C_PrevAndNext(
		long entityId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(entityId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the entity managers where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of entity managers where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the entity managers where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the entity managers where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @return the range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the entity managers where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the entity managers before and after the current entity manager in the ordered set where groupId = &#63;.
	*
	* @param entityId the primary key of the current entity manager
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager[] findByGroupId_PrevAndNext(
		long entityId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(entityId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the entity managers where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of entity managers where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the entity managers where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the entity managers where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @return the range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the entity managers where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the entity managers before and after the current entity manager in the ordered set where companyId = &#63;.
	*
	* @param entityId the primary key of the current entity manager
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager[] findByCompanyId_PrevAndNext(
		long entityId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(entityId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the entity managers where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of entity managers where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns all the entity managers where title = &#63;.
	*
	* @param title the title
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByTitle(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title);
	}

	/**
	* Returns a range of all the entity managers where title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @return the range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByTitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title, start, end);
	}

	/**
	* Returns an ordered range of all the entity managers where title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByTitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title, start, end, orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence().findByTitle_First(title, orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitle_First(title, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence().findByTitle_Last(title, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitle_Last(title, orderByComparator);
	}

	/**
	* Returns the entity managers before and after the current entity manager in the ordered set where title = &#63;.
	*
	* @param entityId the primary key of the current entity manager
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager[] findByTitle_PrevAndNext(
		long entityId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByTitle_PrevAndNext(entityId, title, orderByComparator);
	}

	/**
	* Removes all the entity managers where title = &#63; from the database.
	*
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTitle(title);
	}

	/**
	* Returns the number of entity managers where title = &#63;.
	*
	* @param title the title
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTitle(title);
	}

	/**
	* Returns all the entity managers where entityAddDate = &#63;.
	*
	* @param entityAddDate the entity add date
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByEntityAddDate(
		java.lang.String entityAddDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEntityAddDate(entityAddDate);
	}

	/**
	* Returns a range of all the entity managers where entityAddDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param entityAddDate the entity add date
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @return the range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByEntityAddDate(
		java.lang.String entityAddDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEntityAddDate(entityAddDate, start, end);
	}

	/**
	* Returns an ordered range of all the entity managers where entityAddDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param entityAddDate the entity add date
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByEntityAddDate(
		java.lang.String entityAddDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEntityAddDate(entityAddDate, start, end,
			orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where entityAddDate = &#63;.
	*
	* @param entityAddDate the entity add date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByEntityAddDate_First(
		java.lang.String entityAddDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByEntityAddDate_First(entityAddDate, orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where entityAddDate = &#63;.
	*
	* @param entityAddDate the entity add date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByEntityAddDate_First(
		java.lang.String entityAddDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEntityAddDate_First(entityAddDate, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where entityAddDate = &#63;.
	*
	* @param entityAddDate the entity add date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByEntityAddDate_Last(
		java.lang.String entityAddDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByEntityAddDate_Last(entityAddDate, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where entityAddDate = &#63;.
	*
	* @param entityAddDate the entity add date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByEntityAddDate_Last(
		java.lang.String entityAddDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEntityAddDate_Last(entityAddDate, orderByComparator);
	}

	/**
	* Returns the entity managers before and after the current entity manager in the ordered set where entityAddDate = &#63;.
	*
	* @param entityId the primary key of the current entity manager
	* @param entityAddDate the entity add date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager[] findByEntityAddDate_PrevAndNext(
		long entityId, java.lang.String entityAddDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByEntityAddDate_PrevAndNext(entityId, entityAddDate,
			orderByComparator);
	}

	/**
	* Removes all the entity managers where entityAddDate = &#63; from the database.
	*
	* @param entityAddDate the entity add date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEntityAddDate(java.lang.String entityAddDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEntityAddDate(entityAddDate);
	}

	/**
	* Returns the number of entity managers where entityAddDate = &#63;.
	*
	* @param entityAddDate the entity add date
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEntityAddDate(java.lang.String entityAddDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEntityAddDate(entityAddDate);
	}

	/**
	* Returns all the entity managers where description = &#63;.
	*
	* @param description the description
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByDescription(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDescription(description);
	}

	/**
	* Returns a range of all the entity managers where description = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param description the description
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @return the range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByDescription(
		java.lang.String description, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDescription(description, start, end);
	}

	/**
	* Returns an ordered range of all the entity managers where description = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param description the description
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByDescription(
		java.lang.String description, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDescription(description, start, end, orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByDescription_First(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByDescription_First(description, orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByDescription_First(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDescription_First(description, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByDescription_Last(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByDescription_Last(description, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByDescription_Last(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDescription_Last(description, orderByComparator);
	}

	/**
	* Returns the entity managers before and after the current entity manager in the ordered set where description = &#63;.
	*
	* @param entityId the primary key of the current entity manager
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager[] findByDescription_PrevAndNext(
		long entityId, java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByDescription_PrevAndNext(entityId, description,
			orderByComparator);
	}

	/**
	* Removes all the entity managers where description = &#63; from the database.
	*
	* @param description the description
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDescription(java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDescription(description);
	}

	/**
	* Returns the number of entity managers where description = &#63;.
	*
	* @param description the description
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDescription(java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDescription(description);
	}

	/**
	* Returns all the entity managers where vocubalaryId = &#63;.
	*
	* @param vocubalaryId the vocubalary ID
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByVocubalaryId(
		long vocubalaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVocubalaryId(vocubalaryId);
	}

	/**
	* Returns a range of all the entity managers where vocubalaryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param vocubalaryId the vocubalary ID
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @return the range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByVocubalaryId(
		long vocubalaryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVocubalaryId(vocubalaryId, start, end);
	}

	/**
	* Returns an ordered range of all the entity managers where vocubalaryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param vocubalaryId the vocubalary ID
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByVocubalaryId(
		long vocubalaryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVocubalaryId(vocubalaryId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where vocubalaryId = &#63;.
	*
	* @param vocubalaryId the vocubalary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByVocubalaryId_First(
		long vocubalaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByVocubalaryId_First(vocubalaryId, orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where vocubalaryId = &#63;.
	*
	* @param vocubalaryId the vocubalary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByVocubalaryId_First(
		long vocubalaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVocubalaryId_First(vocubalaryId, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where vocubalaryId = &#63;.
	*
	* @param vocubalaryId the vocubalary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByVocubalaryId_Last(
		long vocubalaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByVocubalaryId_Last(vocubalaryId, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where vocubalaryId = &#63;.
	*
	* @param vocubalaryId the vocubalary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByVocubalaryId_Last(
		long vocubalaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVocubalaryId_Last(vocubalaryId, orderByComparator);
	}

	/**
	* Returns the entity managers before and after the current entity manager in the ordered set where vocubalaryId = &#63;.
	*
	* @param entityId the primary key of the current entity manager
	* @param vocubalaryId the vocubalary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager[] findByVocubalaryId_PrevAndNext(
		long entityId, long vocubalaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByVocubalaryId_PrevAndNext(entityId, vocubalaryId,
			orderByComparator);
	}

	/**
	* Removes all the entity managers where vocubalaryId = &#63; from the database.
	*
	* @param vocubalaryId the vocubalary ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVocubalaryId(long vocubalaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVocubalaryId(vocubalaryId);
	}

	/**
	* Returns the number of entity managers where vocubalaryId = &#63;.
	*
	* @param vocubalaryId the vocubalary ID
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVocubalaryId(long vocubalaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVocubalaryId(vocubalaryId);
	}

	/**
	* Returns all the entity managers where entityId = &#63;.
	*
	* @param entityId the entity ID
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByEntityId(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEntityId(entityId);
	}

	/**
	* Returns a range of all the entity managers where entityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param entityId the entity ID
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @return the range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByEntityId(
		long entityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEntityId(entityId, start, end);
	}

	/**
	* Returns an ordered range of all the entity managers where entityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param entityId the entity ID
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByEntityId(
		long entityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEntityId(entityId, start, end, orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where entityId = &#63;.
	*
	* @param entityId the entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByEntityId_First(
		long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence().findByEntityId_First(entityId, orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where entityId = &#63;.
	*
	* @param entityId the entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByEntityId_First(
		long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEntityId_First(entityId, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where entityId = &#63;.
	*
	* @param entityId the entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByEntityId_Last(
		long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence().findByEntityId_Last(entityId, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where entityId = &#63;.
	*
	* @param entityId the entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByEntityId_Last(
		long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEntityId_Last(entityId, orderByComparator);
	}

	/**
	* Removes all the entity managers where entityId = &#63; from the database.
	*
	* @param entityId the entity ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEntityId(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEntityId(entityId);
	}

	/**
	* Returns the number of entity managers where entityId = &#63;.
	*
	* @param entityId the entity ID
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEntityId(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEntityId(entityId);
	}

	/**
	* Returns all the entity managers where groupId = &#63; and entitystatus = &#63;.
	*
	* @param groupId the group ID
	* @param entitystatus the entitystatus
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByG_S(
		long groupId, int entitystatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_S(groupId, entitystatus);
	}

	/**
	* Returns a range of all the entity managers where groupId = &#63; and entitystatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param entitystatus the entitystatus
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @return the range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByG_S(
		long groupId, int entitystatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_S(groupId, entitystatus, start, end);
	}

	/**
	* Returns an ordered range of all the entity managers where groupId = &#63; and entitystatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param entitystatus the entitystatus
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByG_S(
		long groupId, int entitystatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_S(groupId, entitystatus, start, end,
			orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where groupId = &#63; and entitystatus = &#63;.
	*
	* @param groupId the group ID
	* @param entitystatus the entitystatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByG_S_First(
		long groupId, int entitystatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByG_S_First(groupId, entitystatus, orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where groupId = &#63; and entitystatus = &#63;.
	*
	* @param groupId the group ID
	* @param entitystatus the entitystatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByG_S_First(
		long groupId, int entitystatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_S_First(groupId, entitystatus, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where groupId = &#63; and entitystatus = &#63;.
	*
	* @param groupId the group ID
	* @param entitystatus the entitystatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByG_S_Last(
		long groupId, int entitystatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByG_S_Last(groupId, entitystatus, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where groupId = &#63; and entitystatus = &#63;.
	*
	* @param groupId the group ID
	* @param entitystatus the entitystatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByG_S_Last(
		long groupId, int entitystatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_S_Last(groupId, entitystatus, orderByComparator);
	}

	/**
	* Returns the entity managers before and after the current entity manager in the ordered set where groupId = &#63; and entitystatus = &#63;.
	*
	* @param entityId the primary key of the current entity manager
	* @param groupId the group ID
	* @param entitystatus the entitystatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager[] findByG_S_PrevAndNext(
		long entityId, long groupId, int entitystatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByG_S_PrevAndNext(entityId, groupId, entitystatus,
			orderByComparator);
	}

	/**
	* Removes all the entity managers where groupId = &#63; and entitystatus = &#63; from the database.
	*
	* @param groupId the group ID
	* @param entitystatus the entitystatus
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_S(long groupId, int entitystatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_S(groupId, entitystatus);
	}

	/**
	* Returns the number of entity managers where groupId = &#63; and entitystatus = &#63;.
	*
	* @param groupId the group ID
	* @param entitystatus the entitystatus
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_S(long groupId, int entitystatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_S(groupId, entitystatus);
	}

	/**
	* Returns all the entity managers where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByCategoryId(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryId(categoryId);
	}

	/**
	* Returns a range of all the entity managers where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @return the range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByCategoryId(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryId(categoryId, start, end);
	}

	/**
	* Returns an ordered range of all the entity managers where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findByCategoryId(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryId(categoryId, start, end, orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByCategoryId_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByCategoryId_First(categoryId, orderByComparator);
	}

	/**
	* Returns the first entity manager in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByCategoryId_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryId_First(categoryId, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByCategoryId_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByCategoryId_Last(categoryId, orderByComparator);
	}

	/**
	* Returns the last entity manager in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByCategoryId_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryId_Last(categoryId, orderByComparator);
	}

	/**
	* Returns the entity managers before and after the current entity manager in the ordered set where categoryId = &#63;.
	*
	* @param entityId the primary key of the current entity manager
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager[] findByCategoryId_PrevAndNext(
		long entityId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence()
				   .findByCategoryId_PrevAndNext(entityId, categoryId,
			orderByComparator);
	}

	/**
	* Removes all the entity managers where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryId(categoryId);
	}

	/**
	* Returns the number of entity managers where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryId(categoryId);
	}

	/**
	* Caches the entity manager in the entity cache if it is enabled.
	*
	* @param entityManager the entity manager
	*/
	public static void cacheResult(
		com.warrior.entitymanager.model.EntityManager entityManager) {
		getPersistence().cacheResult(entityManager);
	}

	/**
	* Caches the entity managers in the entity cache if it is enabled.
	*
	* @param entityManagers the entity managers
	*/
	public static void cacheResult(
		java.util.List<com.warrior.entitymanager.model.EntityManager> entityManagers) {
		getPersistence().cacheResult(entityManagers);
	}

	/**
	* Creates a new entity manager with the primary key. Does not add the entity manager to the database.
	*
	* @param entityId the primary key for the new entity manager
	* @return the new entity manager
	*/
	public static com.warrior.entitymanager.model.EntityManager create(
		long entityId) {
		return getPersistence().create(entityId);
	}

	/**
	* Removes the entity manager with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entityId the primary key of the entity manager
	* @return the entity manager that was removed
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager remove(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence().remove(entityId);
	}

	public static com.warrior.entitymanager.model.EntityManager updateImpl(
		com.warrior.entitymanager.model.EntityManager entityManager)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(entityManager);
	}

	/**
	* Returns the entity manager with the primary key or throws a {@link com.warrior.entitymanager.NoSuchEntityManagerException} if it could not be found.
	*
	* @param entityId the primary key of the entity manager
	* @return the entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager findByPrimaryKey(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException {
		return getPersistence().findByPrimaryKey(entityId);
	}

	/**
	* Returns the entity manager with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entityId the primary key of the entity manager
	* @return the entity manager, or <code>null</code> if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrior.entitymanager.model.EntityManager fetchByPrimaryKey(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(entityId);
	}

	/**
	* Returns all the entity managers.
	*
	* @return the entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the entity managers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.warrior.entitymanager.model.impl.EntityManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of entity managers
	* @param end the upper bound of the range of entity managers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrior.entitymanager.model.EntityManager> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the entity managers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of entity managers.
	*
	* @return the number of entity managers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EntityManagerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EntityManagerPersistence)PortletBeanLocatorUtil.locate(com.warrior.entitymanager.service.ClpSerializer.getServletContextName(),
					EntityManagerPersistence.class.getName());

			ReferenceRegistry.registerReference(EntityManagerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EntityManagerPersistence persistence) {
	}

	private static EntityManagerPersistence _persistence;
}