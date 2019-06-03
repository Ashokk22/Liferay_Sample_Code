<%--
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
--%>

<%@page import="com.warrior.entitymanager.util.EntityManagerConstants"%>
<%@page import="com.warrior.entitymanager.model.EntityManager"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>


<%@include file="/html/init.jsp" %>

<portlet:renderURL windowState="normal" var="backURL">
  <portlet:param name="jspPage" value="/html/admin/iew.jsp" />
</portlet:renderURL>

<liferay-ui:header backURL="<%= backURL %>" title="entitymanager" />

<%
EntityManager objEntityManager = (EntityManager) request.getAttribute(EntityManagerConstants.ENTITYMANAGER_ENTRY);
%>

<h1><%= objEntityManager.getTitle() %></h1>

<liferay-ui:ratings className="<%= EntityManager.class.getName() %>"
    classPK="<%= objEntityManager.getEntityId() %>" type="stars" />

<liferay-ui:panel-container extended="<%= false %>"
    id="lessonplanCommentsPanelContainer" persistState="<%= true %>">

  <liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>"
      id="lessonplanCommentsPanel" persistState="<%= true %>"
      title='<%=LanguageUtil.get(pageContext, "comments") %>'>

    <portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL" />

    <liferay-ui:discussion className="<%= EntityManager.class.getName() %>"
        classPK="<%= objEntityManager.getEntityId() %>"
        formAction="<%= discussionURL %>" formName="fm2"
        ratingsEnabled="<%= true %>" redirect="<%= currentURL %>"
        subject="<%= objEntityManager.getTitle() %>"
        userId="<%=objEntityManager.getUserId() %>" />

  </liferay-ui:panel>

</liferay-ui:panel-container>