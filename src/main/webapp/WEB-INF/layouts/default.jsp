<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ include file="../views/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>爱莎海 - 淘宝工具  - <sitemesh:title /></title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="copyright" content="Copyright (C) 爱莎海   design in tianjin by yinheli @2012 All rights reserved." />
<sitemesh:head />
</head>
<body>
	<div class="wrapper">
		<header>
			<h1>爱莎海 - 淘宝工具</h1>
			<p>又一个小工具</p>
		</header>
		
		<nav>
			<ul>
				<li><a href="${ctx}/">首页</a></li>
				<li><a href="${ctx}/trade">订单信息</a></li>
				<li><a href="${ctx}/task">异步任务</a></li>
				<li><a href="${ctx}/schedule">定时服务</a></li>
				<shiro:user>
					<li><shiro:principal property="name"/>, <a href="${ctx}/logout">退出</a></li>
				</shiro:user>
			</ul>
		</nav>
		
		<div id="main">
			<div id="content">
				<sitemesh:body />
			</div>
		</div>
		
		<%@ include file="footer.jsp" %>
	</div>
</body>
</html>