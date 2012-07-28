<%@ page pageEncoding="UTF-8" %>
<%@ include file="../tag.jsp" %>
<html>
<head>
	<title>订单信息</title>
</head>
<body>

<div class="title">
	<p>订单信息</p>	
</div>

<div class="options">
	选择日期: &nbsp; 开始 <input type="text" name="start" id="start" readonly="readonly" /> &nbsp;&nbsp; 结束 <input type="text" name="end" id="end"  readonly="readonly" />
	<button id="sync">同步</button>
</div>


<c:if test="${!empty list.content}">
<div class="table-result-wrap">
	
	<table class="result">
		<thead>
			<tr>
				<th>淘宝订单号</th>
				<th>运单号</th>
				<th>买家昵称</th>
				<th>买家支付宝账号</th>
				<th>订单金额</th>
				<th>本地最后处理时间</th>
				<th>本地备注</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list.content}">
			<tr>
				<td>
					<!-- tid -->
					${item.tid}
				</td>
				<td>
					<!-- out_id -->
					${item.outId}
				</td>
				<td>
					<!-- buyer nick -->
					${item.buyerNick}
				</td>
				<td>
					<!-- buyer alipay -->
					${item.buyerAlipayNo}
				</td>
				<td>
					<!-- payment -->
					${item.payment}
				</td>
				<td>
					<!-- local last update time -->
					<fmt:formatDate value="${item.lastUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
				<td>
					<!-- local note -->
					${item.note}
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<pagebar:pagebar total="${list.totalPages}" current="${list.number}" />
</div>
</c:if>
<c:if test="${empty list.content}">
	<p class="empty">No data</p>
</c:if>
<content tag="javascript">
<%@ include file="../jqueryui.jsp" %>
<script type="text/javascript">
// DOM Ready
$(function() {
	$("#start").datepicker({
		dateFormat: "yy-mm-dd",
		onSelect: function( selectedDate ) {
			var d = new Date(selectedDate);
			d.setDate(d.getDate() + 90);
			$("#end").datepicker("option", "minDate", selectedDate);
			$("#end").datepicker("option", "maxDate", d);
		}
	});	
	
	$("#end").datepicker({
		dateFormat: "yy-mm-dd",
		onSelect: function( selectedDate ) {
			var d = new Date(selectedDate);
			d.setDate(d.getDate() - 90);
			$("#start").datepicker("option", "maxDate", selectedDate);
			$("#start").datepicker("option", "minDate", d);
		}
	});
	
	var processDialog = {
		show: function() {
			$("#dialog:ui-dialog").dialog( "destroy" );
			$("#dialog-modal").dialog({
				draggable: false,
				resizable: false,
				height: 90,
				modal: true
			});
		},
		close: function() {
			$("#dialog:ui-dialog").dialog( "destroy" );
			$('.ui-dialog-titlebar-close').trigger('click');
		},
		process: function(i) {
			$("#progressbar").progressbar({
				value: i
			});
		}		
	};
	
	$("#sync").click(function() {
		processDialog.show();
		processDialog.process(0);
		
		var checker = null;
		
		$.ajax({
			url: "${ctx}/ajax/trade/sync",
			type: "POST",
			data: {start: $("#start").val(), end:$("#end").val()},
			success: function() {
				checker = setInterval(function() {
					$.ajax({
						cache: false,
						url: "${ctx}/ajax/trade/process",
						success: function(r) {
							var i = parseInt(r);
							if (i >= 100) {
								processDialog.process(100);
								if (checker) {
				 					clearInterval(checker);
				 				}
								location.reload();
							}
							processDialog.process(i);
						}
					});
				}, 600);
			},
			error: function() {
 				alert("Error!");
				processDialog.close();
			}
		});
	});
});
</script>

<div id="dialog-modal" title="正在同步">
	<style>.ui-progressbar .ui-progressbar-value { background-image: url(${ctx}/static/jquery-ui/css/ui-lightness/images/pbar-ani.gif); }</style>
	<div id="progressbar" style="margin-top: 10px;"></div>
</div>

</content>
</body>
</html>