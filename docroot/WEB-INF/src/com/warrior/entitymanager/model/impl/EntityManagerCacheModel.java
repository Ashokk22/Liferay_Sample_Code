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

package com.warrior.entitymanager.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.warrior.entitymanager.model.EntityManager;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EntityManager in entity cache.
 *
 * @author HP
 * @see EntityManager
 * @generated
 */
public class EntityManagerCacheModel implements CacheModel<EntityManager>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", entityId=");
		sb.append(entityId);
		sb.append(", entityAddDate=");
		sb.append(entityAddDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", entitystatus=");
		sb.append(entitystatus);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", vocubalaryId=");
		sb.append(vocubalaryId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EntityManager toEntityModel() {
		EntityManagerImpl entityManagerImpl = new EntityManagerImpl();

		if (uuid == null) {
			entityManagerImpl.setUuid(StringPool.BLANK);
		}
		else {
			entityManagerImpl.setUuid(uuid);
		}

		entityManagerImpl.setEntityId(entityId);

		if (entityAddDate == null) {
			entityManagerImpl.setEntityAddDate(StringPool.BLANK);
		}
		else {
			entityManagerImpl.setEntityAddDate(entityAddDate);
		}

		if (title == null) {
			entityManagerImpl.setTitle(StringPool.BLANK);
		}
		else {
			entityManagerImpl.setTitle(title);
		}

		if (description == null) {
			entityManagerImpl.setDescription(StringPool.BLANK);
		}
		else {
			entityManagerImpl.setDescription(description);
		}

		entityManagerImpl.setEntitystatus(entitystatus);
		entityManagerImpl.setCompanyId(companyId);
		entityManagerImpl.setGroupId(groupId);
		entityManagerImpl.setUserId(userId);
		entityManagerImpl.setVocubalaryId(vocubalaryId);
		entityManagerImpl.setCategoryId(categoryId);

		entityManagerImpl.resetOriginalValues();

		return entityManagerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		entityId = objectInput.readLong();
		entityAddDate = objectInput.readUTF();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		entitystatus = objectInput.readInt();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		vocubalaryId = objectInput.readLong();
		categoryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(entityId);

		if (entityAddDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entityAddDate);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(entitystatus);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(vocubalaryId);
		objectOutput.writeLong(categoryId);
	}

	public String uuid;
	public long entityId;
	public String entityAddDate;
	public String title;
	public String description;
	public int entitystatus;
	public long companyId;
	public long groupId;
	public long userId;
	public long vocubalaryId;
	public long categoryId;
}