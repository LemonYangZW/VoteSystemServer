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
 <%  
        List<String> list = new ArrayList<String>();  
        list.add("简单是可靠的先决条件");  
        list.add("兴趣是最好的老师");  
        list.add("知识上的投资总能得到最好的回报");  
        request.setAttribute("list", list);  
     %>  

</head>

<body>
	<form action="" method="post">
		<table align="center" border="5" >
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
			</tr>
			
			<c:forEach items="${requestScope.list }" var="keyword" varStatus="id">
			<tr>
			<td>
			${id.index} 
			</td>
			<td>
			${keyword }
			</td>
			</tr>
			</c:forEach>
			
		</table>
	</form>

</body>
</html>
