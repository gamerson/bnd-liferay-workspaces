<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="test_portlet_TestPortlet.caption"/></b>
	<%=request.getAttribute("foo") %>
</p>