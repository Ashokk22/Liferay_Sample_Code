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

import com.liferay.portal.service.persistence.BasePersistence;

import com.warrior.entitymanager.model.EntityManager;

/**
 * The persistence interface for the entity manager service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HP
 * @see EntityManagerPersistenceImpl
 * @see EntityManagerUtil
 * @generated
 */
public interface EntityManagerPersistence extends BasePersistence<EntityManager> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EntityManagerUtil} to access the entity manager persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the entity managers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first entity manager in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the first entity manager in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last entity manager in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the last entity manager in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.warrior.entitymanager.model.EntityManager[] findByUuid_PrevAndNext(
		long entityId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Removes all the entity managers where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of entity managers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the entity manager where uuid = &#63; and groupId = &#63; or throws a {@link com.warrior.entitymanager.NoSuchEntityManagerException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the entity manager where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the entity manager where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the entity manager where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the entity manager that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the number of entity managers where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the entity managers where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.warrior.entitymanager.model.EntityManager findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the first entity manager in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.warrior.entitymanager.model.EntityManager findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the last entity manager in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.warrior.entitymanager.model.EntityManager[] findByUuid_C_PrevAndNext(
		long entityId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Removes all the entity managers where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of entity managers where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the entity managers where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first entity manager in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the first entity manager in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last entity manager in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the last entity manager in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.warrior.entitymanager.model.EntityManager[] findByGroupId_PrevAndNext(
		long entityId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Removes all the entity managers where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of entity managers where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the entity managers where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first entity manager in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the first entity manager in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last entity manager in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the last entity manager in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.warrior.entitymanager.model.EntityManager[] findByCompanyId_PrevAndNext(
		long entityId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Removes all the entity managers where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of entity managers where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the entity managers where title = &#63;.
	*
	* @param title the title
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByTitle(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByTitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByTitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first entity manager in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the first entity manager in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last entity manager in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the last entity manager in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.warrior.entitymanager.model.EntityManager[] findByTitle_PrevAndNext(
		long entityId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Removes all the entity managers where title = &#63; from the database.
	*
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of entity managers where title = &#63;.
	*
	* @param title the title
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public int countByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the entity managers where entityAddDate = &#63;.
	*
	* @param entityAddDate the entity add date
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByEntityAddDate(
		java.lang.String entityAddDate)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByEntityAddDate(
		java.lang.String entityAddDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByEntityAddDate(
		java.lang.String entityAddDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first entity manager in the ordered set where entityAddDate = &#63;.
	*
	* @param entityAddDate the entity add date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByEntityAddDate_First(
		java.lang.String entityAddDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the first entity manager in the ordered set where entityAddDate = &#63;.
	*
	* @param entityAddDate the entity add date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByEntityAddDate_First(
		java.lang.String entityAddDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last entity manager in the ordered set where entityAddDate = &#63;.
	*
	* @param entityAddDate the entity add date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByEntityAddDate_Last(
		java.lang.String entityAddDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the last entity manager in the ordered set where entityAddDate = &#63;.
	*
	* @param entityAddDate the entity add date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByEntityAddDate_Last(
		java.lang.String entityAddDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.warrior.entitymanager.model.EntityManager[] findByEntityAddDate_PrevAndNext(
		long entityId, java.lang.String entityAddDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Removes all the entity managers where entityAddDate = &#63; from the database.
	*
	* @param entityAddDate the entity add date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEntityAddDate(java.lang.String entityAddDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of entity managers where entityAddDate = &#63;.
	*
	* @param entityAddDate the entity add date
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public int countByEntityAddDate(java.lang.String entityAddDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the entity managers where description = &#63;.
	*
	* @param description the description
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByDescription(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByDescription(
		java.lang.String description, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByDescription(
		java.lang.String description, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first entity manager in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByDescription_First(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the first entity manager in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByDescription_First(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last entity manager in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByDescription_Last(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the last entity manager in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByDescription_Last(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.warrior.entitymanager.model.EntityManager[] findByDescription_PrevAndNext(
		long entityId, java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Removes all the entity managers where description = &#63; from the database.
	*
	* @param description the description
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDescription(java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of entity managers where description = &#63;.
	*
	* @param description the description
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public int countByDescription(java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the entity managers where vocubalaryId = &#63;.
	*
	* @param vocubalaryId the vocubalary ID
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByVocubalaryId(
		long vocubalaryId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByVocubalaryId(
		long vocubalaryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByVocubalaryId(
		long vocubalaryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first entity manager in the ordered set where vocubalaryId = &#63;.
	*
	* @param vocubalaryId the vocubalary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByVocubalaryId_First(
		long vocubalaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the first entity manager in the ordered set where vocubalaryId = &#63;.
	*
	* @param vocubalaryId the vocubalary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByVocubalaryId_First(
		long vocubalaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last entity manager in the ordered set where vocubalaryId = &#63;.
	*
	* @param vocubalaryId the vocubalary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByVocubalaryId_Last(
		long vocubalaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the last entity manager in the ordered set where vocubalaryId = &#63;.
	*
	* @param vocubalaryId the vocubalary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByVocubalaryId_Last(
		long vocubalaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.warrior.entitymanager.model.EntityManager[] findByVocubalaryId_PrevAndNext(
		long entityId, long vocubalaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Removes all the entity managers where vocubalaryId = &#63; from the database.
	*
	* @param vocubalaryId the vocubalary ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVocubalaryId(long vocubalaryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of entity managers where vocubalaryId = &#63;.
	*
	* @param vocubalaryId the vocubalary ID
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public int countByVocubalaryId(long vocubalaryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the entity managers where entityId = &#63;.
	*
	* @param entityId the entity ID
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByEntityId(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByEntityId(
		long entityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByEntityId(
		long entityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first entity manager in the ordered set where entityId = &#63;.
	*
	* @param entityId the entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByEntityId_First(
		long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the first entity manager in the ordered set where entityId = &#63;.
	*
	* @param entityId the entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByEntityId_First(
		long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last entity manager in the ordered set where entityId = &#63;.
	*
	* @param entityId the entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByEntityId_Last(
		long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the last entity manager in the ordered set where entityId = &#63;.
	*
	* @param entityId the entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByEntityId_Last(
		long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the entity managers where entityId = &#63; from the database.
	*
	* @param entityId the entity ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEntityId(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of entity managers where entityId = &#63;.
	*
	* @param entityId the entity ID
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public int countByEntityId(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the entity managers where groupId = &#63; and entitystatus = &#63;.
	*
	* @param groupId the group ID
	* @param entitystatus the entitystatus
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByG_S(
		long groupId, int entitystatus)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByG_S(
		long groupId, int entitystatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByG_S(
		long groupId, int entitystatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.warrior.entitymanager.model.EntityManager findByG_S_First(
		long groupId, int entitystatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the first entity manager in the ordered set where groupId = &#63; and entitystatus = &#63;.
	*
	* @param groupId the group ID
	* @param entitystatus the entitystatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByG_S_First(
		long groupId, int entitystatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.warrior.entitymanager.model.EntityManager findByG_S_Last(
		long groupId, int entitystatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the last entity manager in the ordered set where groupId = &#63; and entitystatus = &#63;.
	*
	* @param groupId the group ID
	* @param entitystatus the entitystatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByG_S_Last(
		long groupId, int entitystatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.warrior.entitymanager.model.EntityManager[] findByG_S_PrevAndNext(
		long entityId, long groupId, int entitystatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Removes all the entity managers where groupId = &#63; and entitystatus = &#63; from the database.
	*
	* @param groupId the group ID
	* @param entitystatus the entitystatus
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_S(long groupId, int entitystatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of entity managers where groupId = &#63; and entitystatus = &#63;.
	*
	* @param groupId the group ID
	* @param entitystatus the entitystatus
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_S(long groupId, int entitystatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the entity managers where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByCategoryId(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByCategoryId(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findByCategoryId(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first entity manager in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByCategoryId_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the first entity manager in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByCategoryId_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last entity manager in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByCategoryId_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the last entity manager in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByCategoryId_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.warrior.entitymanager.model.EntityManager[] findByCategoryId_PrevAndNext(
		long entityId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Removes all the entity managers where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of entity managers where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching entity managers
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the entity manager in the entity cache if it is enabled.
	*
	* @param entityManager the entity manager
	*/
	public void cacheResult(
		com.warrior.entitymanager.model.EntityManager entityManager);

	/**
	* Caches the entity managers in the entity cache if it is enabled.
	*
	* @param entityManagers the entity managers
	*/
	public void cacheResult(
		java.util.List<com.warrior.entitymanager.model.EntityManager> entityManagers);

	/**
	* Creates a new entity manager with the primary key. Does not add the entity manager to the database.
	*
	* @param entityId the primary key for the new entity manager
	* @return the new entity manager
	*/
	public com.warrior.entitymanager.model.EntityManager create(long entityId);

	/**
	* Removes the entity manager with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entityId the primary key of the entity manager
	* @return the entity manager that was removed
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager remove(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	public com.warrior.entitymanager.model.EntityManager updateImpl(
		com.warrior.entitymanager.model.EntityManager entityManager)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the entity manager with the primary key or throws a {@link com.warrior.entitymanager.NoSuchEntityManagerException} if it could not be found.
	*
	* @param entityId the primary key of the entity manager
	* @return the entity manager
	* @throws com.warrior.entitymanager.NoSuchEntityManagerException if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager findByPrimaryKey(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrior.entitymanager.NoSuchEntityManagerException;

	/**
	* Returns the entity manager with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entityId the primary key of the entity manager
	* @return the entity manager, or <code>null</code> if a entity manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrior.entitymanager.model.EntityManager fetchByPrimaryKey(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the entity managers.
	*
	* @return the entity managers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrior.entitymanager.model.EntityManager> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the entity managers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of entity managers.
	*
	* @return the number of entity managers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}