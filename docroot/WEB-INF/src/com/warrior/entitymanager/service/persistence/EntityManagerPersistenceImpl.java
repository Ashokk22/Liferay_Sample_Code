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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.warrior.entitymanager.NoSuchEntityManagerException;
import com.warrior.entitymanager.model.EntityManager;
import com.warrior.entitymanager.model.impl.EntityManagerImpl;
import com.warrior.entitymanager.model.impl.EntityManagerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the entity manager service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HP
 * @see EntityManagerPersistence
 * @see EntityManagerUtil
 * @generated
 */
public class EntityManagerPersistenceImpl extends BasePersistenceImpl<EntityManager>
	implements EntityManagerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EntityManagerUtil} to access the entity manager persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EntityManagerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] { String.class.getName() },
			EntityManagerModelImpl.UUID_COLUMN_BITMASK |
			EntityManagerModelImpl.ENTITYADDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the entity managers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EntityManager> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EntityManager> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<EntityManager> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<EntityManager> list = (List<EntityManager>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EntityManager entityManager : list) {
				if (!Validator.equals(uuid, entityManager.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EntityManager>(list);
				}
				else {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public EntityManager findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByUuid_First(uuid, orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
	}

	/**
	 * Returns the first entity manager in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<EntityManager> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByUuid_Last(uuid, orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
	}

	/**
	 * Returns the last entity manager in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EntityManager> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager[] findByUuid_PrevAndNext(long entityId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			EntityManager[] array = new EntityManagerImpl[3];

			array[0] = getByUuid_PrevAndNext(session, entityManager, uuid,
					orderByComparator, true);

			array[1] = entityManager;

			array[2] = getByUuid_PrevAndNext(session, entityManager, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EntityManager getByUuid_PrevAndNext(Session session,
		EntityManager entityManager, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(entityManager);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EntityManager> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the entity managers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (EntityManager entityManager : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(entityManager);
		}
	}

	/**
	 * Returns the number of entity managers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENTITYMANAGER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "entityManager.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "entityManager.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(entityManager.uuid IS NULL OR entityManager.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			EntityManagerModelImpl.UUID_COLUMN_BITMASK |
			EntityManagerModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the entity manager where uuid = &#63; and groupId = &#63; or throws a {@link com.warrior.entitymanager.NoSuchEntityManagerException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching entity manager
	 * @throws com.warrior.entitymanager.NoSuchEntityManagerException if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager findByUUID_G(String uuid, long groupId)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByUUID_G(uuid, groupId);

		if (entityManager == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEntityManagerException(msg.toString());
		}

		return entityManager;
	}

	/**
	 * Returns the entity manager where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching entity manager, or <code>null</code> if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
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
	@Override
	public EntityManager fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof EntityManager) {
			EntityManager entityManager = (EntityManager)result;

			if (!Validator.equals(uuid, entityManager.getUuid()) ||
					(groupId != entityManager.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<EntityManager> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					EntityManager entityManager = list.get(0);

					result = entityManager;

					cacheResult(entityManager);

					if ((entityManager.getUuid() == null) ||
							!entityManager.getUuid().equals(uuid) ||
							(entityManager.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, entityManager);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (EntityManager)result;
		}
	}

	/**
	 * Removes the entity manager where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the entity manager that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager removeByUUID_G(String uuid, long groupId)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = findByUUID_G(uuid, groupId);

		return remove(entityManager);
	}

	/**
	 * Returns the number of entity managers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ENTITYMANAGER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "entityManager.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "entityManager.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(entityManager.uuid IS NULL OR entityManager.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "entityManager.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			EntityManagerModelImpl.UUID_COLUMN_BITMASK |
			EntityManagerModelImpl.COMPANYID_COLUMN_BITMASK |
			EntityManagerModelImpl.ENTITYADDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the entity managers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EntityManager> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<EntityManager> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<EntityManager> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<EntityManager> list = (List<EntityManager>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EntityManager entityManager : list) {
				if (!Validator.equals(uuid, entityManager.getUuid()) ||
						(companyId != entityManager.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EntityManager>(list);
				}
				else {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public EntityManager findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
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
	@Override
	public EntityManager fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EntityManager> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
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
	@Override
	public EntityManager fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EntityManager> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager[] findByUuid_C_PrevAndNext(long entityId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			EntityManager[] array = new EntityManagerImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, entityManager, uuid,
					companyId, orderByComparator, true);

			array[1] = entityManager;

			array[2] = getByUuid_C_PrevAndNext(session, entityManager, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EntityManager getByUuid_C_PrevAndNext(Session session,
		EntityManager entityManager, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(entityManager);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EntityManager> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the entity managers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (EntityManager entityManager : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(entityManager);
		}
	}

	/**
	 * Returns the number of entity managers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ENTITYMANAGER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "entityManager.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "entityManager.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(entityManager.uuid IS NULL OR entityManager.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "entityManager.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupId", new String[] { Long.class.getName() },
			EntityManagerModelImpl.GROUPID_COLUMN_BITMASK |
			EntityManagerModelImpl.ENTITYADDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the entity managers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EntityManager> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EntityManager> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<EntityManager> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<EntityManager> list = (List<EntityManager>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EntityManager entityManager : list) {
				if ((groupId != entityManager.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EntityManager>(list);
				}
				else {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public EntityManager findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByGroupId_First(groupId,
				orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
	}

	/**
	 * Returns the first entity manager in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EntityManager> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
	}

	/**
	 * Returns the last entity manager in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<EntityManager> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager[] findByGroupId_PrevAndNext(long entityId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			EntityManager[] array = new EntityManagerImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, entityManager,
					groupId, orderByComparator, true);

			array[1] = entityManager;

			array[2] = getByGroupId_PrevAndNext(session, entityManager,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EntityManager getByGroupId_PrevAndNext(Session session,
		EntityManager entityManager, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(entityManager);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EntityManager> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the entity managers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (EntityManager entityManager : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(entityManager);
		}
	}

	/**
	 * Returns the number of entity managers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENTITYMANAGER_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "entityManager.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyId", new String[] { Long.class.getName() },
			EntityManagerModelImpl.COMPANYID_COLUMN_BITMASK |
			EntityManagerModelImpl.ENTITYADDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the entity managers where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EntityManager> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<EntityManager> findByCompanyId(long companyId, int start,
		int end) throws SystemException {
		return findByCompanyId(companyId, start, end, null);
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
	@Override
	public List<EntityManager> findByCompanyId(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<EntityManager> list = (List<EntityManager>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EntityManager entityManager : list) {
				if ((companyId != entityManager.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EntityManager>(list);
				}
				else {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public EntityManager findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
	}

	/**
	 * Returns the first entity manager in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EntityManager> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
	}

	/**
	 * Returns the last entity manager in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<EntityManager> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager[] findByCompanyId_PrevAndNext(long entityId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			EntityManager[] array = new EntityManagerImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, entityManager,
					companyId, orderByComparator, true);

			array[1] = entityManager;

			array[2] = getByCompanyId_PrevAndNext(session, entityManager,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EntityManager getByCompanyId_PrevAndNext(Session session,
		EntityManager entityManager, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(entityManager);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EntityManager> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the entity managers where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (EntityManager entityManager : findByCompanyId(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(entityManager);
		}
	}

	/**
	 * Returns the number of entity managers where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyId(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENTITYMANAGER_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "entityManager.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTitle",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTitle", new String[] { String.class.getName() },
			EntityManagerModelImpl.TITLE_COLUMN_BITMASK |
			EntityManagerModelImpl.ENTITYADDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLE = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTitle",
			new String[] { String.class.getName() });

	/**
	 * Returns all the entity managers where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EntityManager> findByTitle(String title)
		throws SystemException {
		return findByTitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EntityManager> findByTitle(String title, int start, int end)
		throws SystemException {
		return findByTitle(title, start, end, null);
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
	@Override
	public List<EntityManager> findByTitle(String title, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE;
			finderArgs = new Object[] { title };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE;
			finderArgs = new Object[] { title, start, end, orderByComparator };
		}

		List<EntityManager> list = (List<EntityManager>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EntityManager entityManager : list) {
				if (!Validator.equals(title, entityManager.getTitle())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

			boolean bindTitle = false;

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTitle) {
					qPos.add(title);
				}

				if (!pagination) {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EntityManager>(list);
				}
				else {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public EntityManager findByTitle_First(String title,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByTitle_First(title,
				orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
	}

	/**
	 * Returns the first entity manager in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByTitle_First(String title,
		OrderByComparator orderByComparator) throws SystemException {
		List<EntityManager> list = findByTitle(title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager findByTitle_Last(String title,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByTitle_Last(title, orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
	}

	/**
	 * Returns the last entity manager in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByTitle_Last(String title,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTitle(title);

		if (count == 0) {
			return null;
		}

		List<EntityManager> list = findByTitle(title, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager[] findByTitle_PrevAndNext(long entityId, String title,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			EntityManager[] array = new EntityManagerImpl[3];

			array[0] = getByTitle_PrevAndNext(session, entityManager, title,
					orderByComparator, true);

			array[1] = entityManager;

			array[2] = getByTitle_PrevAndNext(session, entityManager, title,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EntityManager getByTitle_PrevAndNext(Session session,
		EntityManager entityManager, String title,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

		boolean bindTitle = false;

		if (title == null) {
			query.append(_FINDER_COLUMN_TITLE_TITLE_1);
		}
		else if (title.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TITLE_TITLE_3);
		}
		else {
			bindTitle = true;

			query.append(_FINDER_COLUMN_TITLE_TITLE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTitle) {
			qPos.add(title);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(entityManager);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EntityManager> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the entity managers where title = &#63; from the database.
	 *
	 * @param title the title
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTitle(String title) throws SystemException {
		for (EntityManager entityManager : findByTitle(title,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(entityManager);
		}
	}

	/**
	 * Returns the number of entity managers where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTitle(String title) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TITLE;

		Object[] finderArgs = new Object[] { title };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENTITYMANAGER_WHERE);

			boolean bindTitle = false;

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTitle) {
					qPos.add(title);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TITLE_TITLE_1 = "entityManager.title IS NULL";
	private static final String _FINDER_COLUMN_TITLE_TITLE_2 = "entityManager.title = ?";
	private static final String _FINDER_COLUMN_TITLE_TITLE_3 = "(entityManager.title IS NULL OR entityManager.title = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTITYADDDATE =
		new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEntityAddDate",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYADDDATE =
		new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEntityAddDate", new String[] { String.class.getName() },
			EntityManagerModelImpl.ENTITYADDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ENTITYADDDATE = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEntityAddDate",
			new String[] { String.class.getName() });

	/**
	 * Returns all the entity managers where entityAddDate = &#63;.
	 *
	 * @param entityAddDate the entity add date
	 * @return the matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EntityManager> findByEntityAddDate(String entityAddDate)
		throws SystemException {
		return findByEntityAddDate(entityAddDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<EntityManager> findByEntityAddDate(String entityAddDate,
		int start, int end) throws SystemException {
		return findByEntityAddDate(entityAddDate, start, end, null);
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
	@Override
	public List<EntityManager> findByEntityAddDate(String entityAddDate,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYADDDATE;
			finderArgs = new Object[] { entityAddDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTITYADDDATE;
			finderArgs = new Object[] {
					entityAddDate,
					
					start, end, orderByComparator
				};
		}

		List<EntityManager> list = (List<EntityManager>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EntityManager entityManager : list) {
				if (!Validator.equals(entityAddDate,
							entityManager.getEntityAddDate())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

			boolean bindEntityAddDate = false;

			if (entityAddDate == null) {
				query.append(_FINDER_COLUMN_ENTITYADDDATE_ENTITYADDDATE_1);
			}
			else if (entityAddDate.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ENTITYADDDATE_ENTITYADDDATE_3);
			}
			else {
				bindEntityAddDate = true;

				query.append(_FINDER_COLUMN_ENTITYADDDATE_ENTITYADDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEntityAddDate) {
					qPos.add(entityAddDate);
				}

				if (!pagination) {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EntityManager>(list);
				}
				else {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public EntityManager findByEntityAddDate_First(String entityAddDate,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByEntityAddDate_First(entityAddDate,
				orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("entityAddDate=");
		msg.append(entityAddDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
	}

	/**
	 * Returns the first entity manager in the ordered set where entityAddDate = &#63;.
	 *
	 * @param entityAddDate the entity add date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByEntityAddDate_First(String entityAddDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<EntityManager> list = findByEntityAddDate(entityAddDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager findByEntityAddDate_Last(String entityAddDate,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByEntityAddDate_Last(entityAddDate,
				orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("entityAddDate=");
		msg.append(entityAddDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
	}

	/**
	 * Returns the last entity manager in the ordered set where entityAddDate = &#63;.
	 *
	 * @param entityAddDate the entity add date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByEntityAddDate_Last(String entityAddDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEntityAddDate(entityAddDate);

		if (count == 0) {
			return null;
		}

		List<EntityManager> list = findByEntityAddDate(entityAddDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager[] findByEntityAddDate_PrevAndNext(long entityId,
		String entityAddDate, OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			EntityManager[] array = new EntityManagerImpl[3];

			array[0] = getByEntityAddDate_PrevAndNext(session, entityManager,
					entityAddDate, orderByComparator, true);

			array[1] = entityManager;

			array[2] = getByEntityAddDate_PrevAndNext(session, entityManager,
					entityAddDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EntityManager getByEntityAddDate_PrevAndNext(Session session,
		EntityManager entityManager, String entityAddDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

		boolean bindEntityAddDate = false;

		if (entityAddDate == null) {
			query.append(_FINDER_COLUMN_ENTITYADDDATE_ENTITYADDDATE_1);
		}
		else if (entityAddDate.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ENTITYADDDATE_ENTITYADDDATE_3);
		}
		else {
			bindEntityAddDate = true;

			query.append(_FINDER_COLUMN_ENTITYADDDATE_ENTITYADDDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEntityAddDate) {
			qPos.add(entityAddDate);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(entityManager);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EntityManager> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the entity managers where entityAddDate = &#63; from the database.
	 *
	 * @param entityAddDate the entity add date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEntityAddDate(String entityAddDate)
		throws SystemException {
		for (EntityManager entityManager : findByEntityAddDate(entityAddDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(entityManager);
		}
	}

	/**
	 * Returns the number of entity managers where entityAddDate = &#63;.
	 *
	 * @param entityAddDate the entity add date
	 * @return the number of matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEntityAddDate(String entityAddDate)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ENTITYADDDATE;

		Object[] finderArgs = new Object[] { entityAddDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENTITYMANAGER_WHERE);

			boolean bindEntityAddDate = false;

			if (entityAddDate == null) {
				query.append(_FINDER_COLUMN_ENTITYADDDATE_ENTITYADDDATE_1);
			}
			else if (entityAddDate.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ENTITYADDDATE_ENTITYADDDATE_3);
			}
			else {
				bindEntityAddDate = true;

				query.append(_FINDER_COLUMN_ENTITYADDDATE_ENTITYADDDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEntityAddDate) {
					qPos.add(entityAddDate);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ENTITYADDDATE_ENTITYADDDATE_1 = "entityManager.entityAddDate IS NULL";
	private static final String _FINDER_COLUMN_ENTITYADDDATE_ENTITYADDDATE_2 = "entityManager.entityAddDate = ?";
	private static final String _FINDER_COLUMN_ENTITYADDDATE_ENTITYADDDATE_3 = "(entityManager.entityAddDate IS NULL OR entityManager.entityAddDate = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCRIPTION =
		new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDescription",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION =
		new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDescription", new String[] { String.class.getName() },
			EntityManagerModelImpl.DESCRIPTION_COLUMN_BITMASK |
			EntityManagerModelImpl.ENTITYADDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DESCRIPTION = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDescription",
			new String[] { String.class.getName() });

	/**
	 * Returns all the entity managers where description = &#63;.
	 *
	 * @param description the description
	 * @return the matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EntityManager> findByDescription(String description)
		throws SystemException {
		return findByDescription(description, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<EntityManager> findByDescription(String description, int start,
		int end) throws SystemException {
		return findByDescription(description, start, end, null);
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
	@Override
	public List<EntityManager> findByDescription(String description, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION;
			finderArgs = new Object[] { description };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCRIPTION;
			finderArgs = new Object[] { description, start, end, orderByComparator };
		}

		List<EntityManager> list = (List<EntityManager>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EntityManager entityManager : list) {
				if (!Validator.equals(description,
							entityManager.getDescription())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

			boolean bindDescription = false;

			if (description == null) {
				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_1);
			}
			else if (description.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDescription) {
					qPos.add(description);
				}

				if (!pagination) {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EntityManager>(list);
				}
				else {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public EntityManager findByDescription_First(String description,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByDescription_First(description,
				orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("description=");
		msg.append(description);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
	}

	/**
	 * Returns the first entity manager in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByDescription_First(String description,
		OrderByComparator orderByComparator) throws SystemException {
		List<EntityManager> list = findByDescription(description, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager findByDescription_Last(String description,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByDescription_Last(description,
				orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("description=");
		msg.append(description);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
	}

	/**
	 * Returns the last entity manager in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByDescription_Last(String description,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDescription(description);

		if (count == 0) {
			return null;
		}

		List<EntityManager> list = findByDescription(description, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager[] findByDescription_PrevAndNext(long entityId,
		String description, OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			EntityManager[] array = new EntityManagerImpl[3];

			array[0] = getByDescription_PrevAndNext(session, entityManager,
					description, orderByComparator, true);

			array[1] = entityManager;

			array[2] = getByDescription_PrevAndNext(session, entityManager,
					description, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EntityManager getByDescription_PrevAndNext(Session session,
		EntityManager entityManager, String description,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

		boolean bindDescription = false;

		if (description == null) {
			query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_1);
		}
		else if (description.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3);
		}
		else {
			bindDescription = true;

			query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDescription) {
			qPos.add(description);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(entityManager);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EntityManager> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the entity managers where description = &#63; from the database.
	 *
	 * @param description the description
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDescription(String description)
		throws SystemException {
		for (EntityManager entityManager : findByDescription(description,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(entityManager);
		}
	}

	/**
	 * Returns the number of entity managers where description = &#63;.
	 *
	 * @param description the description
	 * @return the number of matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDescription(String description) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DESCRIPTION;

		Object[] finderArgs = new Object[] { description };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENTITYMANAGER_WHERE);

			boolean bindDescription = false;

			if (description == null) {
				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_1);
			}
			else if (description.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDescription) {
					qPos.add(description);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_1 = "entityManager.description IS NULL";
	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2 = "entityManager.description = ?";
	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3 = "(entityManager.description IS NULL OR entityManager.description = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VOCUBALARYID =
		new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVocubalaryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VOCUBALARYID =
		new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByVocubalaryId", new String[] { Long.class.getName() },
			EntityManagerModelImpl.VOCUBALARYID_COLUMN_BITMASK |
			EntityManagerModelImpl.ENTITYADDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VOCUBALARYID = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVocubalaryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the entity managers where vocubalaryId = &#63;.
	 *
	 * @param vocubalaryId the vocubalary ID
	 * @return the matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EntityManager> findByVocubalaryId(long vocubalaryId)
		throws SystemException {
		return findByVocubalaryId(vocubalaryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<EntityManager> findByVocubalaryId(long vocubalaryId, int start,
		int end) throws SystemException {
		return findByVocubalaryId(vocubalaryId, start, end, null);
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
	@Override
	public List<EntityManager> findByVocubalaryId(long vocubalaryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VOCUBALARYID;
			finderArgs = new Object[] { vocubalaryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VOCUBALARYID;
			finderArgs = new Object[] {
					vocubalaryId,
					
					start, end, orderByComparator
				};
		}

		List<EntityManager> list = (List<EntityManager>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EntityManager entityManager : list) {
				if ((vocubalaryId != entityManager.getVocubalaryId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

			query.append(_FINDER_COLUMN_VOCUBALARYID_VOCUBALARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vocubalaryId);

				if (!pagination) {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EntityManager>(list);
				}
				else {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public EntityManager findByVocubalaryId_First(long vocubalaryId,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByVocubalaryId_First(vocubalaryId,
				orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vocubalaryId=");
		msg.append(vocubalaryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
	}

	/**
	 * Returns the first entity manager in the ordered set where vocubalaryId = &#63;.
	 *
	 * @param vocubalaryId the vocubalary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByVocubalaryId_First(long vocubalaryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EntityManager> list = findByVocubalaryId(vocubalaryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager findByVocubalaryId_Last(long vocubalaryId,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByVocubalaryId_Last(vocubalaryId,
				orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vocubalaryId=");
		msg.append(vocubalaryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
	}

	/**
	 * Returns the last entity manager in the ordered set where vocubalaryId = &#63;.
	 *
	 * @param vocubalaryId the vocubalary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByVocubalaryId_Last(long vocubalaryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVocubalaryId(vocubalaryId);

		if (count == 0) {
			return null;
		}

		List<EntityManager> list = findByVocubalaryId(vocubalaryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager[] findByVocubalaryId_PrevAndNext(long entityId,
		long vocubalaryId, OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			EntityManager[] array = new EntityManagerImpl[3];

			array[0] = getByVocubalaryId_PrevAndNext(session, entityManager,
					vocubalaryId, orderByComparator, true);

			array[1] = entityManager;

			array[2] = getByVocubalaryId_PrevAndNext(session, entityManager,
					vocubalaryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EntityManager getByVocubalaryId_PrevAndNext(Session session,
		EntityManager entityManager, long vocubalaryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

		query.append(_FINDER_COLUMN_VOCUBALARYID_VOCUBALARYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(vocubalaryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(entityManager);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EntityManager> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the entity managers where vocubalaryId = &#63; from the database.
	 *
	 * @param vocubalaryId the vocubalary ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVocubalaryId(long vocubalaryId)
		throws SystemException {
		for (EntityManager entityManager : findByVocubalaryId(vocubalaryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(entityManager);
		}
	}

	/**
	 * Returns the number of entity managers where vocubalaryId = &#63;.
	 *
	 * @param vocubalaryId the vocubalary ID
	 * @return the number of matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVocubalaryId(long vocubalaryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VOCUBALARYID;

		Object[] finderArgs = new Object[] { vocubalaryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENTITYMANAGER_WHERE);

			query.append(_FINDER_COLUMN_VOCUBALARYID_VOCUBALARYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vocubalaryId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_VOCUBALARYID_VOCUBALARYID_2 = "entityManager.vocubalaryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTITYID = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEntityId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYID =
		new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEntityId", new String[] { Long.class.getName() },
			EntityManagerModelImpl.ENTITYID_COLUMN_BITMASK |
			EntityManagerModelImpl.ENTITYADDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ENTITYID = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEntityId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the entity managers where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @return the matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EntityManager> findByEntityId(long entityId)
		throws SystemException {
		return findByEntityId(entityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<EntityManager> findByEntityId(long entityId, int start, int end)
		throws SystemException {
		return findByEntityId(entityId, start, end, null);
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
	@Override
	public List<EntityManager> findByEntityId(long entityId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYID;
			finderArgs = new Object[] { entityId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTITYID;
			finderArgs = new Object[] { entityId, start, end, orderByComparator };
		}

		List<EntityManager> list = (List<EntityManager>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EntityManager entityManager : list) {
				if ((entityId != entityManager.getEntityId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

			query.append(_FINDER_COLUMN_ENTITYID_ENTITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entityId);

				if (!pagination) {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EntityManager>(list);
				}
				else {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public EntityManager findByEntityId_First(long entityId,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByEntityId_First(entityId,
				orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("entityId=");
		msg.append(entityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
	}

	/**
	 * Returns the first entity manager in the ordered set where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByEntityId_First(long entityId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EntityManager> list = findByEntityId(entityId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager findByEntityId_Last(long entityId,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByEntityId_Last(entityId,
				orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("entityId=");
		msg.append(entityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
	}

	/**
	 * Returns the last entity manager in the ordered set where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByEntityId_Last(long entityId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEntityId(entityId);

		if (count == 0) {
			return null;
		}

		List<EntityManager> list = findByEntityId(entityId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the entity managers where entityId = &#63; from the database.
	 *
	 * @param entityId the entity ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEntityId(long entityId) throws SystemException {
		for (EntityManager entityManager : findByEntityId(entityId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(entityManager);
		}
	}

	/**
	 * Returns the number of entity managers where entityId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @return the number of matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEntityId(long entityId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ENTITYID;

		Object[] finderArgs = new Object[] { entityId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENTITYMANAGER_WHERE);

			query.append(_FINDER_COLUMN_ENTITYID_ENTITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entityId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ENTITYID_ENTITYID_2 = "entityManager.entityId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByG_S",
			new String[] { Long.class.getName(), Integer.class.getName() },
			EntityManagerModelImpl.GROUPID_COLUMN_BITMASK |
			EntityManagerModelImpl.ENTITYSTATUS_COLUMN_BITMASK |
			EntityManagerModelImpl.ENTITYADDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_S = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the entity managers where groupId = &#63; and entitystatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param entitystatus the entitystatus
	 * @return the matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EntityManager> findByG_S(long groupId, int entitystatus)
		throws SystemException {
		return findByG_S(groupId, entitystatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<EntityManager> findByG_S(long groupId, int entitystatus,
		int start, int end) throws SystemException {
		return findByG_S(groupId, entitystatus, start, end, null);
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
	@Override
	public List<EntityManager> findByG_S(long groupId, int entitystatus,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S;
			finderArgs = new Object[] { groupId, entitystatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S;
			finderArgs = new Object[] {
					groupId, entitystatus,
					
					start, end, orderByComparator
				};
		}

		List<EntityManager> list = (List<EntityManager>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EntityManager entityManager : list) {
				if ((groupId != entityManager.getGroupId()) ||
						(entitystatus != entityManager.getEntitystatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_ENTITYSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(entitystatus);

				if (!pagination) {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EntityManager>(list);
				}
				else {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public EntityManager findByG_S_First(long groupId, int entitystatus,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByG_S_First(groupId, entitystatus,
				orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", entitystatus=");
		msg.append(entitystatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
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
	@Override
	public EntityManager fetchByG_S_First(long groupId, int entitystatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<EntityManager> list = findByG_S(groupId, entitystatus, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager findByG_S_Last(long groupId, int entitystatus,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByG_S_Last(groupId, entitystatus,
				orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", entitystatus=");
		msg.append(entitystatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
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
	@Override
	public EntityManager fetchByG_S_Last(long groupId, int entitystatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_S(groupId, entitystatus);

		if (count == 0) {
			return null;
		}

		List<EntityManager> list = findByG_S(groupId, entitystatus, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager[] findByG_S_PrevAndNext(long entityId, long groupId,
		int entitystatus, OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			EntityManager[] array = new EntityManagerImpl[3];

			array[0] = getByG_S_PrevAndNext(session, entityManager, groupId,
					entitystatus, orderByComparator, true);

			array[1] = entityManager;

			array[2] = getByG_S_PrevAndNext(session, entityManager, groupId,
					entitystatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EntityManager getByG_S_PrevAndNext(Session session,
		EntityManager entityManager, long groupId, int entitystatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_ENTITYSTATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(entitystatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(entityManager);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EntityManager> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the entity managers where groupId = &#63; and entitystatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param entitystatus the entitystatus
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_S(long groupId, int entitystatus)
		throws SystemException {
		for (EntityManager entityManager : findByG_S(groupId, entitystatus,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(entityManager);
		}
	}

	/**
	 * Returns the number of entity managers where groupId = &#63; and entitystatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param entitystatus the entitystatus
	 * @return the number of matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_S(long groupId, int entitystatus)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_S;

		Object[] finderArgs = new Object[] { groupId, entitystatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ENTITYMANAGER_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_ENTITYSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(entitystatus);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 = "entityManager.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_S_ENTITYSTATUS_2 = "entityManager.entitystatus = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID =
		new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategoryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID =
		new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED,
			EntityManagerImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategoryId", new String[] { Long.class.getName() },
			EntityManagerModelImpl.CATEGORYID_COLUMN_BITMASK |
			EntityManagerModelImpl.ENTITYADDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYID = new FinderPath(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the entity managers where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EntityManager> findByCategoryId(long categoryId)
		throws SystemException {
		return findByCategoryId(categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<EntityManager> findByCategoryId(long categoryId, int start,
		int end) throws SystemException {
		return findByCategoryId(categoryId, start, end, null);
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
	@Override
	public List<EntityManager> findByCategoryId(long categoryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID;
			finderArgs = new Object[] { categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID;
			finderArgs = new Object[] { categoryId, start, end, orderByComparator };
		}

		List<EntityManager> list = (List<EntityManager>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EntityManager entityManager : list) {
				if ((categoryId != entityManager.getCategoryId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				if (!pagination) {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EntityManager>(list);
				}
				else {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public EntityManager findByCategoryId_First(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByCategoryId_First(categoryId,
				orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
	}

	/**
	 * Returns the first entity manager in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching entity manager, or <code>null</code> if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByCategoryId_First(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EntityManager> list = findByCategoryId(categoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager findByCategoryId_Last(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByCategoryId_Last(categoryId,
				orderByComparator);

		if (entityManager != null) {
			return entityManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntityManagerException(msg.toString());
	}

	/**
	 * Returns the last entity manager in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching entity manager, or <code>null</code> if a matching entity manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByCategoryId_Last(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategoryId(categoryId);

		if (count == 0) {
			return null;
		}

		List<EntityManager> list = findByCategoryId(categoryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntityManager[] findByCategoryId_PrevAndNext(long entityId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			EntityManager[] array = new EntityManagerImpl[3];

			array[0] = getByCategoryId_PrevAndNext(session, entityManager,
					categoryId, orderByComparator, true);

			array[1] = entityManager;

			array[2] = getByCategoryId_PrevAndNext(session, entityManager,
					categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EntityManager getByCategoryId_PrevAndNext(Session session,
		EntityManager entityManager, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENTITYMANAGER_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EntityManagerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(entityManager);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EntityManager> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the entity managers where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategoryId(long categoryId) throws SystemException {
		for (EntityManager entityManager : findByCategoryId(categoryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(entityManager);
		}
	}

	/**
	 * Returns the number of entity managers where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategoryId(long categoryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYID;

		Object[] finderArgs = new Object[] { categoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENTITYMANAGER_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CATEGORYID_CATEGORYID_2 = "entityManager.categoryId = ?";

	public EntityManagerPersistenceImpl() {
		setModelClass(EntityManager.class);
	}

	/**
	 * Caches the entity manager in the entity cache if it is enabled.
	 *
	 * @param entityManager the entity manager
	 */
	@Override
	public void cacheResult(EntityManager entityManager) {
		EntityCacheUtil.putResult(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerImpl.class, entityManager.getPrimaryKey(),
			entityManager);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { entityManager.getUuid(), entityManager.getGroupId() },
			entityManager);

		entityManager.resetOriginalValues();
	}

	/**
	 * Caches the entity managers in the entity cache if it is enabled.
	 *
	 * @param entityManagers the entity managers
	 */
	@Override
	public void cacheResult(List<EntityManager> entityManagers) {
		for (EntityManager entityManager : entityManagers) {
			if (EntityCacheUtil.getResult(
						EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
						EntityManagerImpl.class, entityManager.getPrimaryKey()) == null) {
				cacheResult(entityManager);
			}
			else {
				entityManager.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all entity managers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EntityManagerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EntityManagerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the entity manager.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EntityManager entityManager) {
		EntityCacheUtil.removeResult(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerImpl.class, entityManager.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(entityManager);
	}

	@Override
	public void clearCache(List<EntityManager> entityManagers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EntityManager entityManager : entityManagers) {
			EntityCacheUtil.removeResult(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
				EntityManagerImpl.class, entityManager.getPrimaryKey());

			clearUniqueFindersCache(entityManager);
		}
	}

	protected void cacheUniqueFindersCache(EntityManager entityManager) {
		if (entityManager.isNew()) {
			Object[] args = new Object[] {
					entityManager.getUuid(), entityManager.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				entityManager);
		}
		else {
			EntityManagerModelImpl entityManagerModelImpl = (EntityManagerModelImpl)entityManager;

			if ((entityManagerModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						entityManager.getUuid(), entityManager.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					entityManager);
			}
		}
	}

	protected void clearUniqueFindersCache(EntityManager entityManager) {
		EntityManagerModelImpl entityManagerModelImpl = (EntityManagerModelImpl)entityManager;

		Object[] args = new Object[] {
				entityManager.getUuid(), entityManager.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((entityManagerModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					entityManagerModelImpl.getOriginalUuid(),
					entityManagerModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new entity manager with the primary key. Does not add the entity manager to the database.
	 *
	 * @param entityId the primary key for the new entity manager
	 * @return the new entity manager
	 */
	@Override
	public EntityManager create(long entityId) {
		EntityManager entityManager = new EntityManagerImpl();

		entityManager.setNew(true);
		entityManager.setPrimaryKey(entityId);

		String uuid = PortalUUIDUtil.generate();

		entityManager.setUuid(uuid);

		return entityManager;
	}

	/**
	 * Removes the entity manager with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the entity manager
	 * @return the entity manager that was removed
	 * @throws com.warrior.entitymanager.NoSuchEntityManagerException if a entity manager with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager remove(long entityId)
		throws NoSuchEntityManagerException, SystemException {
		return remove((Serializable)entityId);
	}

	/**
	 * Removes the entity manager with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the entity manager
	 * @return the entity manager that was removed
	 * @throws com.warrior.entitymanager.NoSuchEntityManagerException if a entity manager with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager remove(Serializable primaryKey)
		throws NoSuchEntityManagerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EntityManager entityManager = (EntityManager)session.get(EntityManagerImpl.class,
					primaryKey);

			if (entityManager == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEntityManagerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(entityManager);
		}
		catch (NoSuchEntityManagerException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EntityManager removeImpl(EntityManager entityManager)
		throws SystemException {
		entityManager = toUnwrappedModel(entityManager);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(entityManager)) {
				entityManager = (EntityManager)session.get(EntityManagerImpl.class,
						entityManager.getPrimaryKeyObj());
			}

			if (entityManager != null) {
				session.delete(entityManager);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (entityManager != null) {
			clearCache(entityManager);
		}

		return entityManager;
	}

	@Override
	public EntityManager updateImpl(
		com.warrior.entitymanager.model.EntityManager entityManager)
		throws SystemException {
		entityManager = toUnwrappedModel(entityManager);

		boolean isNew = entityManager.isNew();

		EntityManagerModelImpl entityManagerModelImpl = (EntityManagerModelImpl)entityManager;

		if (Validator.isNull(entityManager.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			entityManager.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (entityManager.isNew()) {
				session.save(entityManager);

				entityManager.setNew(false);
			}
			else {
				session.merge(entityManager);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EntityManagerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((entityManagerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						entityManagerModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { entityManagerModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((entityManagerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						entityManagerModelImpl.getOriginalUuid(),
						entityManagerModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						entityManagerModelImpl.getUuid(),
						entityManagerModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((entityManagerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						entityManagerModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { entityManagerModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((entityManagerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						entityManagerModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { entityManagerModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((entityManagerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						entityManagerModelImpl.getOriginalTitle()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
					args);

				args = new Object[] { entityManagerModelImpl.getTitle() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
					args);
			}

			if ((entityManagerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYADDDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						entityManagerModelImpl.getOriginalEntityAddDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITYADDDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYADDDATE,
					args);

				args = new Object[] { entityManagerModelImpl.getEntityAddDate() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITYADDDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYADDDATE,
					args);
			}

			if ((entityManagerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						entityManagerModelImpl.getOriginalDescription()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESCRIPTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION,
					args);

				args = new Object[] { entityManagerModelImpl.getDescription() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESCRIPTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION,
					args);
			}

			if ((entityManagerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VOCUBALARYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						entityManagerModelImpl.getOriginalVocubalaryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VOCUBALARYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VOCUBALARYID,
					args);

				args = new Object[] { entityManagerModelImpl.getVocubalaryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VOCUBALARYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VOCUBALARYID,
					args);
			}

			if ((entityManagerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						entityManagerModelImpl.getOriginalEntityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITYID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYID,
					args);

				args = new Object[] { entityManagerModelImpl.getEntityId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITYID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYID,
					args);
			}

			if ((entityManagerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						entityManagerModelImpl.getOriginalGroupId(),
						entityManagerModelImpl.getOriginalEntitystatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
					args);

				args = new Object[] {
						entityManagerModelImpl.getGroupId(),
						entityManagerModelImpl.getEntitystatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
					args);
			}

			if ((entityManagerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						entityManagerModelImpl.getOriginalCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
					args);

				args = new Object[] { entityManagerModelImpl.getCategoryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
					args);
			}
		}

		EntityCacheUtil.putResult(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
			EntityManagerImpl.class, entityManager.getPrimaryKey(),
			entityManager);

		clearUniqueFindersCache(entityManager);
		cacheUniqueFindersCache(entityManager);

		return entityManager;
	}

	protected EntityManager toUnwrappedModel(EntityManager entityManager) {
		if (entityManager instanceof EntityManagerImpl) {
			return entityManager;
		}

		EntityManagerImpl entityManagerImpl = new EntityManagerImpl();

		entityManagerImpl.setNew(entityManager.isNew());
		entityManagerImpl.setPrimaryKey(entityManager.getPrimaryKey());

		entityManagerImpl.setUuid(entityManager.getUuid());
		entityManagerImpl.setEntityId(entityManager.getEntityId());
		entityManagerImpl.setEntityAddDate(entityManager.getEntityAddDate());
		entityManagerImpl.setTitle(entityManager.getTitle());
		entityManagerImpl.setDescription(entityManager.getDescription());
		entityManagerImpl.setEntitystatus(entityManager.getEntitystatus());
		entityManagerImpl.setCompanyId(entityManager.getCompanyId());
		entityManagerImpl.setGroupId(entityManager.getGroupId());
		entityManagerImpl.setUserId(entityManager.getUserId());
		entityManagerImpl.setVocubalaryId(entityManager.getVocubalaryId());
		entityManagerImpl.setCategoryId(entityManager.getCategoryId());

		return entityManagerImpl;
	}

	/**
	 * Returns the entity manager with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the entity manager
	 * @return the entity manager
	 * @throws com.warrior.entitymanager.NoSuchEntityManagerException if a entity manager with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEntityManagerException, SystemException {
		EntityManager entityManager = fetchByPrimaryKey(primaryKey);

		if (entityManager == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEntityManagerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return entityManager;
	}

	/**
	 * Returns the entity manager with the primary key or throws a {@link com.warrior.entitymanager.NoSuchEntityManagerException} if it could not be found.
	 *
	 * @param entityId the primary key of the entity manager
	 * @return the entity manager
	 * @throws com.warrior.entitymanager.NoSuchEntityManagerException if a entity manager with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager findByPrimaryKey(long entityId)
		throws NoSuchEntityManagerException, SystemException {
		return findByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns the entity manager with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the entity manager
	 * @return the entity manager, or <code>null</code> if a entity manager with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EntityManager entityManager = (EntityManager)EntityCacheUtil.getResult(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
				EntityManagerImpl.class, primaryKey);

		if (entityManager == _nullEntityManager) {
			return null;
		}

		if (entityManager == null) {
			Session session = null;

			try {
				session = openSession();

				entityManager = (EntityManager)session.get(EntityManagerImpl.class,
						primaryKey);

				if (entityManager != null) {
					cacheResult(entityManager);
				}
				else {
					EntityCacheUtil.putResult(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
						EntityManagerImpl.class, primaryKey, _nullEntityManager);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EntityManagerModelImpl.ENTITY_CACHE_ENABLED,
					EntityManagerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return entityManager;
	}

	/**
	 * Returns the entity manager with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the entity manager
	 * @return the entity manager, or <code>null</code> if a entity manager with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EntityManager fetchByPrimaryKey(long entityId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns all the entity managers.
	 *
	 * @return the entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EntityManager> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<EntityManager> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<EntityManager> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<EntityManager> list = (List<EntityManager>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ENTITYMANAGER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ENTITYMANAGER;

				if (pagination) {
					sql = sql.concat(EntityManagerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EntityManager>(list);
				}
				else {
					list = (List<EntityManager>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the entity managers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EntityManager entityManager : findAll()) {
			remove(entityManager);
		}
	}

	/**
	 * Returns the number of entity managers.
	 *
	 * @return the number of entity managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ENTITYMANAGER);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the entity manager persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.warrior.entitymanager.model.EntityManager")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EntityManager>> listenersList = new ArrayList<ModelListener<EntityManager>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EntityManager>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(EntityManagerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ENTITYMANAGER = "SELECT entityManager FROM EntityManager entityManager";
	private static final String _SQL_SELECT_ENTITYMANAGER_WHERE = "SELECT entityManager FROM EntityManager entityManager WHERE ";
	private static final String _SQL_COUNT_ENTITYMANAGER = "SELECT COUNT(entityManager) FROM EntityManager entityManager";
	private static final String _SQL_COUNT_ENTITYMANAGER_WHERE = "SELECT COUNT(entityManager) FROM EntityManager entityManager WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "entityManager.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EntityManager exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EntityManager exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EntityManagerPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static EntityManager _nullEntityManager = new EntityManagerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EntityManager> toCacheModel() {
				return _nullEntityManagerCacheModel;
			}
		};

	private static CacheModel<EntityManager> _nullEntityManagerCacheModel = new CacheModel<EntityManager>() {
			@Override
			public EntityManager toEntityModel() {
				return _nullEntityManager;
			}
		};
}