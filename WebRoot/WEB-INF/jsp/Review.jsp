<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Review.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<script type="text/javascript">
		function updatestatus(URL) {

			var xmlhttp;
			if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp = new XMLHttpRequest();
			} else {// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
				}
			}
			xmlhttp.open("GET", URL, false);
			xmlhttp.send();
			location.reload();
		}
	</script>
	<form action="" method="post">
		<table align="center" border="5">
			<tr>
				<td>编号</td>
				<td>任务编号</td>
				<td>任务名称</td>
				<td>任务内容</td>
				<td>需求数量</td>
				<td>发布人昵称</td>
				<td>电话</td>
				<td>发布时间</td>
				<td>状态</td>
				<td>单价</td>
				<td>投票链接</td>
				<td>操作</td>
			</tr>

			<c:forEach items="${requestScope.list }" var="keyword" varStatus="id">
				<tr>
					<td>${id.index+1}</td>
					<td>${keyword.tid }</td>
					<td>${keyword.tname }</td>
					<td>${keyword.tcontent }</td>
					<td>${keyword.tnumber }</td>
					<td>${keyword.name }</td>
					<td>${keyword.phone }</td>
					<td>${keyword.tm }</td>
					<td>${keyword.status }</td>
					<td>${keyword.price }</td>
					<td><a target="_blank" href=${keyword.url }>${keyword.url }</a>
					</td>
					<td><input type="button" name="Y" value="审核通过"
						onclick="updatestatus('UpdateStatus.do?tid=${keyword.tid}&status=审核通过')">
						<input type="button" name="N" value="审核不通过"
						onclick="updatestatus('UpdateStatus.do?tid=${keyword.tid}&status=审核不通过')"></td>
				</tr>
			</c:forEach>

		</table>
	</form>

</body>
</html>
