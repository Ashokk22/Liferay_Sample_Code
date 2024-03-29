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

package com.warrior.entitymanager.service.base;

import com.warrior.entitymanager.service.EntityManagerLocalServiceUtil;

import java.util.Arrays;

/**
 * @author HP
 * @generated
 */
public class EntityManagerLocalServiceClpInvoker {
	public EntityManagerLocalServiceClpInvoker() {
		_methodName0 = "addEntityManager";

		_methodParameterTypes0 = new String[] {
				"com.warrior.entitymanager.model.EntityManager"
			};

		_methodName1 = "createEntityManager";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteEntityManager";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteEntityManager";

		_methodParameterTypes3 = new String[] {
				"com.warrior.entitymanager.model.EntityManager"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchEntityManager";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchEntityManagerByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchEntityManagerByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getEntityManager";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getEntityManagerByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getEntityManagerByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getEntityManagers";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getEntityManagersCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateEntityManager";

		_methodParameterTypes19 = new String[] {
				"com.warrior.entitymanager.model.EntityManager"
			};

		_methodName60 = "getBeanIdentifier";

		_methodParameterTypes60 = new String[] {  };

		_methodName61 = "setBeanIdentifier";

		_methodParameterTypes61 = new String[] { "java.lang.String" };

		_methodName66 = "getEntityManagersByTitle";

		_methodParameterTypes66 = new String[] {
				"java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName67 = "getEntityManagersByVocabulary";

		_methodParameterTypes67 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName68 = "addEntityManager";

		_methodParameterTypes68 = new String[] {
				"com.warrior.entitymanager.model.EntityManager",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName69 = "updateEntityManager";

		_methodParameterTypes69 = new String[] {
				"com.warrior.entitymanager.model.EntityManager",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName70 = "getEntity";

		_methodParameterTypes70 = new String[] { "long" };

		_methodName71 = "deleteEntityManager";

		_methodParameterTypes71 = new String[] { "long" };

		_methodName72 = "deleteEntityManager";

		_methodParameterTypes72 = new String[] {
				"com.warrior.entitymanager.model.EntityManager"
			};

		_methodName73 = "getEntityManagers";

		_methodParameterTypes73 = new String[] {
				"long", "int", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName74 = "getEntityManagers";

		_methodParameterTypes74 = new String[] { "long", "int", "int", "int" };

		_methodName75 = "getEntityManagersByentityCount";

		_methodParameterTypes75 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return EntityManagerLocalServiceUtil.addEntityManager((com.warrior.entitymanager.model.EntityManager)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return EntityManagerLocalServiceUtil.createEntityManager(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return EntityManagerLocalServiceUtil.deleteEntityManager(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return EntityManagerLocalServiceUtil.deleteEntityManager((com.warrior.entitymanager.model.EntityManager)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return EntityManagerLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return EntityManagerLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return EntityManagerLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return EntityManagerLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return EntityManagerLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return EntityManagerLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return EntityManagerLocalServiceUtil.fetchEntityManager(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return EntityManagerLocalServiceUtil.fetchEntityManagerByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return EntityManagerLocalServiceUtil.fetchEntityManagerByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return EntityManagerLocalServiceUtil.getEntityManager(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return EntityManagerLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return EntityManagerLocalServiceUtil.getEntityManagerByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return EntityManagerLocalServiceUtil.getEntityManagerByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return EntityManagerLocalServiceUtil.getEntityManagers(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return EntityManagerLocalServiceUtil.getEntityManagersCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return EntityManagerLocalServiceUtil.updateEntityManager((com.warrior.entitymanager.model.EntityManager)arguments[0]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return EntityManagerLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			EntityManagerLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return EntityManagerLocalServiceUtil.getEntityManagersByTitle((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return EntityManagerLocalServiceUtil.getEntityManagersByVocabulary(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return EntityManagerLocalServiceUtil.addEntityManager((com.warrior.entitymanager.model.EntityManager)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return EntityManagerLocalServiceUtil.updateEntityManager((com.warrior.entitymanager.model.EntityManager)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return EntityManagerLocalServiceUtil.getEntity(((Long)arguments[0]).longValue());
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return EntityManagerLocalServiceUtil.deleteEntityManager(((Long)arguments[0]).longValue());
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return EntityManagerLocalServiceUtil.deleteEntityManager((com.warrior.entitymanager.model.EntityManager)arguments[0]);
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return EntityManagerLocalServiceUtil.getEntityManagers(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[4]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return EntityManagerLocalServiceUtil.getEntityManagers(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return EntityManagerLocalServiceUtil.getEntityManagersByentityCount(((Long)arguments[0]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
}