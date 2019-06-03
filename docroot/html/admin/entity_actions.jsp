<%@page import="com.warrior.entitymanager.model.EntityManager"%>
<%@page import="com.liferay.portlet.trash.util.TrashUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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
%>

<%@include file="/html/init.jsp" %>


<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
EntityManager myEntityManager = (EntityManager)row.getObject();
long groupId = themeDisplay.getScopeGroupId();
String name = EntityManager.class.getName();
String primKey = String.valueOf(myEntityManager.getEntityId());
permissionChecker.hasPermission(groupId, name, primKey, com.liferay.portal.security.permission.ActionKeys.UPDATE);
%>

<liferay-ui:icon-menu>

    <portlet:renderURL var="editURL">
      <portlet:param name="entityId" value="<%=primKey %>" />
      <portlet:param name="jspPage" value="/html/admin/add_entity.jsp" />
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit" url="<%=editURL.toString() %>" />
  
    <portlet:actionURL name="deleteEntity" var="deleteEntityURL">
       <portlet:param name="<%= Constants.CMD %>" value="<%=Constants.DELETE %>" />
       <portlet:param name="entityId" value="<%= primKey %>" />
    </portlet:actionURL>

	<liferay-ui:icon-delete
		label="<%= true %>"
		url="<%= deleteEntityURL.toString() %>"
	/>
	
  

</liferay-ui:icon-menu>