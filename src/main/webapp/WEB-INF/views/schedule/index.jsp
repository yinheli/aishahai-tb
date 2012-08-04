<%@ page pageEncoding="UTF-8" %>
<%@ include file="../tag.jsp" %>
<head>
    <title>定时服务</title>
</head>
<body>
<div class="title">
	<p>定时任务</p>	
</div>
<c:if test="${!empty list}">
<div class="table-result-wrap">
<table id="cron-info" width="100%">
	<thead>
		<tr>
			<th rowspan="2" align="center" valign="middle">任务名称</th>
			<th rowspan="2" align="center" valign="middle">任务描述</th>
			<th rowspan="2" align="center" valign="middle" width="250px">任务类</th>
			<th colspan="4" align="center" valign="middle">触发器</th>
		</tr>
		<tr>
			<th align="center">表达式</th>
			<th align="center">上次执行时间</th>
			<th align="center">下次执行时间</th>
			<th align="center">操作</th>
		</tr>
	</thead>
	<c:forEach var="item" items="${list}">
	<tr>
		<td>${item.job.key.name}</td>
		<td>${item.job.description}</td>
		<td>${item.job.jobClass.canonicalName}</td>

		<c:forEach items="${item.triggers}" var="trigger">
			<td><code>${trigger.cronExpression}</code></td>
			<td>
				<fmt:formatDate value="${trigger.previousFireTime}" pattern="HH:mm:ss" />
			</td>
			<td>
				<fmt:formatDate value="${trigger.nextFireTime}" pattern="HH:mm:ss" />
			</td>
			<td><a href="#" title="立即执行 - ${item.job.description}" onclick="return trigger('${item.job.key.name}')">执行</a>
			</td>
		</c:forEach>
	</tr>
</c:forEach>
</table>
</div> <!-- #end table-result-wrap -->
<script>
	function trigger(key) {
		$.post('${ctx}/ajax/schedule/trigger/' + key, null, function(r) {
			if (r == 'success') {
				alert("触发成功");
				location.reload();
			} else {
				if (r.indexOf('<') != -1) {
					location.reload();
				} else {
					alert(r);
				}
			}
		});
		return false;
	}
</script>
</c:if>
<c:if test="${empty list}">
	<p class="empty">No data</p>
</c:if>
</body>
</html>