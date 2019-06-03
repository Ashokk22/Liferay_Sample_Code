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

package com.warrior.entitymanager.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EntityManager}.
 * </p>
 *
 * @author HP
 * @see EntityManager
 * @generated
 */
public class EntityManagerWrapper implements EntityManager,
	ModelWrapper<EntityManager> {
	public EntityManagerWrapper(EntityManager entityManager) {
		_entityManager = entityManager;
	}

	@Override
	public Class<?> getModelClass() {
		return EntityManager.class;
	}

	@Override
	public String getModelClassName() {
		return EntityManager.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("entityId", getEntityId());
		attributes.put("entityAddDate", getEntityAddDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("entitystatus", getEntitystatus());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("vocubalaryId", getVocubalaryId());
		attributes.put("categoryId", getCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long entityId = (Long)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
		}

		String entityAddDate = (String)attributes.get("entityAddDate");

		if (entityAddDate != null) {
			setEntityAddDate(entityAddDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer entitystatus = (Integer)attributes.get("entitystatus");

		if (entitystatus != null) {
			setEntitystatus(entitystatus);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long vocubalaryId = (Long)attributes.get("vocubalaryId");

		if (vocubalaryId != null) {
			setVocubalaryId(vocubalaryId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}
	}

	/**
	* Returns the primary key of this entity manager.
	*
	* @return the primary key of this entity manager
	*/
	@Override
	public long getPrimaryKey() {
		return _entityManager.getPrimaryKey();
	}

	/**
	* Sets the primary key of this entity manager.
	*
	* @param primaryKey the primary key of this entity manager
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_entityManager.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this entity manager.
	*
	* @return the uuid of this entity manager
	*/
	@Override
	public java.lang.String getUuid() {
		return _entityManager.getUuid();
	}

	/**
	* Sets the uuid of this entity manager.
	*
	* @param uuid the uuid of this entity manager
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_entityManager.setUuid(uuid);
	}

	/**
	* Returns the entity ID of this entity manager.
	*
	* @return the entity ID of this entity manager
	*/
	@Override
	public long getEntityId() {
		return _entityManager.getEntityId();
	}

	/**
	* Sets the entity ID of this entity manager.
	*
	* @param entityId the entity ID of this entity manager
	*/
	@Override
	public void setEntityId(long entityId) {
		_entityManager.setEntityId(entityId);
	}

	/**
	* Returns the entity add date of this entity manager.
	*
	* @return the entity add date of this entity manager
	*/
	@Override
	public java.lang.String getEntityAddDate() {
		return _entityManager.getEntityAddDate();
	}

	/**
	* Sets the entity add date of this entity manager.
	*
	* @param entityAddDate the entity add date of this entity manager
	*/
	@Override
	public void setEntityAddDate(java.lang.String entityAddDate) {
		_entityManager.setEntityAddDate(entityAddDate);
	}

	/**
	* Returns the title of this entity manager.
	*
	* @return the title of this entity manager
	*/
	@Override
	public java.lang.String getTitle() {
		return _entityManager.getTitle();
	}

	/**
	* Sets the title of this entity manager.
	*
	* @param title the title of this entity manager
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_entityManager.setTitle(title);
	}

	/**
	* Returns the description of this entity manager.
	*
	* @return the description of this entity manager
	*/
	@Override
	public java.lang.String getDescription() {
		return _entityManager.getDescription();
	}

	/**
	* Sets the description of this entity manager.
	*
	* @param description the description of this entity manager
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_entityManager.setDescription(description);
	}

	/**
	* Returns the entitystatus of this entity manager.
	*
	* @return the entitystatus of this entity manager
	*/
	@Override
	public int getEntitystatus() {
		return _entityManager.getEntitystatus();
	}

	/**
	* Sets the entitystatus of this entity manager.
	*
	* @param entitystatus the entitystatus of this entity manager
	*/
	@Override
	public void setEntitystatus(int entitystatus) {
		_entityManager.setEntitystatus(entitystatus);
	}

	/**
	* Returns the company ID of this entity manager.
	*
	* @return the company ID of this entity manager
	*/
	@Override
	public long getCompanyId() {
		return _entityManager.getCompanyId();
	}

	/**
	* Sets the company ID of this entity manager.
	*
	* @param companyId the company ID of this entity manager
	*/
	@Override
	public void setCompanyId(long companyId) {
		_entityManager.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this entity manager.
	*
	* @return the group ID of this entity manager
	*/
	@Override
	public long getGroupId() {
		return _entityManager.getGroupId();
	}

	/**
	* Sets the group ID of this entity manager.
	*
	* @param groupId the group ID of this entity manager
	*/
	@Override
	public void setGroupId(long groupId) {
		_entityManager.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this entity manager.
	*
	* @return the user ID of this entity manager
	*/
	@Override
	public long getUserId() {
		return _entityManager.getUserId();
	}

	/**
	* Sets the user ID of this entity manager.
	*
	* @param userId the user ID of this entity manager
	*/
	@Override
	public void setUserId(long userId) {
		_entityManager.setUserId(userId);
	}

	/**
	* Returns the user uuid of this entity manager.
	*
	* @return the user uuid of this entity manager
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityManager.getUserUuid();
	}

	/**
	* Sets the user uuid of this entity manager.
	*
	* @param userUuid the user uuid of this entity manager
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_entityManager.setUserUuid(userUuid);
	}

	/**
	* Returns the vocubalary ID of this entity manager.
	*
	* @return the vocubalary ID of this entity manager
	*/
	@Override
	public long getVocubalaryId() {
		return _entityManager.getVocubalaryId();
	}

	/**
	* Sets the vocubalary ID of this entity manager.
	*
	* @param vocubalaryId the vocubalary ID of this entity manager
	*/
	@Override
	public void setVocubalaryId(long vocubalaryId) {
		_entityManager.setVocubalaryId(vocubalaryId);
	}

	/**
	* Returns the category ID of this entity manager.
	*
	* @return the category ID of this entity manager
	*/
	@Override
	public long getCategoryId() {
		return _entityManager.getCategoryId();
	}

	/**
	* Sets the category ID of this entity manager.
	*
	* @param categoryId the category ID of this entity manager
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_entityManager.setCategoryId(categoryId);
	}

	/**
	* Returns the status of this entity manager.
	*
	* @return the status of this entity manager
	*/
	@Override
	public int getStatus() {
		return _entityManager.getStatus();
	}

	/**
	* Returns the trash entry created when this entity manager was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this entity manager.
	*
	* @return the trash entry created when this entity manager was moved to the Recycle Bin
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.portlet.trash.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _entityManager.getTrashEntry();
	}

	/**
	* Returns the class primary key of the trash entry for this entity manager.
	*
	* @return the class primary key of the trash entry for this entity manager
	*/
	@Override
	public long getTrashEntryClassPK() {
		return _entityManager.getTrashEntryClassPK();
	}

	/**
	* Returns the trash handler for this entity manager.
	*
	* @return the trash handler for this entity manager
	*/
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return _entityManager.getTrashHandler();
	}

	/**
	* Returns <code>true</code> if this entity manager is in the Recycle Bin.
	*
	* @return <code>true</code> if this entity manager is in the Recycle Bin; <code>false</code> otherwise
	*/
	@Override
	public boolean isInTrash() {
		return _entityManager.isInTrash();
	}

	/**
	* Returns <code>true</code> if the parent of this entity manager is in the Recycle Bin.
	*
	* @return <code>true</code> if the parent of this entity manager is in the Recycle Bin; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean isInTrashContainer() {
		return _entityManager.isInTrashContainer();
	}

	@Override
	public boolean isNew() {
		return _entityManager.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_entityManager.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _entityManager.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_entityManager.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _entityManager.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _entityManager.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_entityManager.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _entityManager.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_entityManager.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_entityManager.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_entityManager.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EntityManagerWrapper((EntityManager)_entityManager.clone());
	}

	@Override
	public int compareTo(
		com.warrior.entitymanager.model.EntityManager entityManager) {
		return _entityManager.compareTo(entityManager);
	}

	@Override
	public int hashCode() {
		return _entityManager.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.warrior.entitymanager.model.EntityManager> toCacheModel() {
		return _entityManager.toCacheModel();
	}

	@Override
	public com.warrior.entitymanager.model.EntityManager toEscapedModel() {
		return new EntityManagerWrapper(_entityManager.toEscapedModel());
	}

	@Override
	public com.warrior.entitymanager.model.EntityManager toUnescapedModel() {
		return new EntityManagerWrapper(_entityManager.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _entityManager.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _entityManager.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_entityManager.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EntityManagerWrapper)) {
			return false;
		}

		EntityManagerWrapper entityManagerWrapper = (EntityManagerWrapper)obj;

		if (Validator.equals(_entityManager, entityManagerWrapper._entityManager)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EntityManager getWrappedEntityManager() {
		return _entityManager;
	}

	@Override
	public EntityManager getWrappedModel() {
		return _entityManager;
	}

	@Override
	public void resetOriginalValues() {
		_entityManager.resetOriginalValues();
	}

	private EntityManager _entityManager;
}