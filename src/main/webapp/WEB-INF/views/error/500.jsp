<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@include file="../tag.jsp"%>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory" %>
<%response.setStatus(500);%>

<%
	Throwable ex = null;
	if (exception != null)
		ex = exception;
	if (request.getAttribute("javax.servlet.error.exception") != null)
		ex = (Throwable) request.getAttribute("javax.servlet.error.exception");

	//记录日志
	Logger logger = LoggerFactory.getLogger("500.jsp");
	logger.error(ex.getMessage(), ex);
%>

<!DOCTYPE HTML>
<html>
<head>
	<title>500 - 系统内部错误</title>
</head>

<body>
<div><h1>系统发生内部错误.</h1></div>
<div><a href="<c:url value="/"/>">返回首页</a></div>
</body>
</html>
