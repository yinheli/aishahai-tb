<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@include file="../views/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>爱莎海 - 淘宝工具  - <sitemesh:title /></title>
<meta charset="UTF-8">
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
				<li><a href="${ctx}/auth_info">授权信息</a></li>
				<li><a href="${ctx}/trade">订单信息</a></li>
			</ul>
		</nav>
		
		<div id="main">
			<div id="content">
				<sitemesh:body />
			</div>
		</div>
		
		<footer>
			copyright 爱莎海  design in tianjin by yinheli @2012
		</footer>
	</div>
</body>
</html>