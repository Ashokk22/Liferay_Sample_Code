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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.warrior.entitymanager.service.http.EntityManagerServiceSoap}.
 *
 * @author HP
 * @see com.warrior.entitymanager.service.http.EntityManagerServiceSoap
 * @generated
 */
public class EntityManagerSoap implements Serializable {
	public static EntityManagerSoap toSoapModel(EntityManager model) {
		EntityManagerSoap soapModel = new EntityManagerSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEntityId(model.getEntityId());
		soapModel.setEntityAddDate(model.getEntityAddDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setEntitystatus(model.getEntitystatus());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setVocubalaryId(model.getVocubalaryId());
		soapModel.setCategoryId(model.getCategoryId());

		return soapModel;
	}

	public static EntityManagerSoap[] toSoapModels(EntityManager[] models) {
		EntityManagerSoap[] soapModels = new EntityManagerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EntityManagerSoap[][] toSoapModels(EntityManager[][] models) {
		EntityManagerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EntityManagerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EntityManagerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EntityManagerSoap[] toSoapModels(List<EntityManager> models) {
		List<EntityManagerSoap> soapModels = new ArrayList<EntityManagerSoap>(models.size());

		for (EntityManager model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EntityManagerSoap[soapModels.size()]);
	}

	public EntityManagerSoap() {
	}

	public long getPrimaryKey() {
		return _entityId;
	}

	public void setPrimaryKey(long pk) {
		setEntityId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEntityId() {
		return _entityId;
	}

	public void setEntityId(long entityId) {
		_entityId = entityId;
	}

	public String getEntityAddDate() {
		return _entityAddDate;
	}

	public void setEntityAddDate(String entityAddDate) {
		_entityAddDate = entityAddDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getEntitystatus() {
		return _entitystatus;
	}

	public void setEntitystatus(int entitystatus) {
		_entitystatus = entitystatus;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getVocubalaryId() {
		return _vocubalaryId;
	}

	public void setVocubalaryId(long vocubalaryId) {
		_vocubalaryId = vocubalaryId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	private String _uuid;
	private long _entityId;
	private String _entityAddDate;
	private String _title;
	private String _description;
	private int _entitystatus;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private long _vocubalaryId;
	private long _categoryId;
}