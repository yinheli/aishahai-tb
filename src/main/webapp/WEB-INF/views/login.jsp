<%@ page pageEncoding="UTF-8"%>
<%@ include file="tag.jsp"%>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter" %>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>登录</title>
</head>
<body>
	<form:form action="" method="post" id="login-form">
		<%
		String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		if(error != null){
		%>
		<div class="error prepend-top" >登录失败，请重试.</div>
		<%
		}
		%>
		<div class="row">
			<label for="username">用户名:</label> <br />
			<input type="text" name="username" id="username">
		</div>
		<div class="row">
			<label for="password">密码:</label> <br />
			<input type="password" name="password" id="password">
		</div>
		<div class="row action">
			<input type="submit" value="login">
			<a href="https://oauth.taobao.com/authorize?client_id=${appKey}&response_type=code&redirect_uri=${appCallback}">用淘宝账号授权登录</a>
		</div>
	</form:form>
</body>
</html>