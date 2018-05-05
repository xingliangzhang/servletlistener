<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>servlet监听器demo</title>
</head>
<body style="font-size: 30px;">
	首页
	<br />
	<!-- application对应的上下文隐含对象 -->
	当前在线人数是：<%=application.getAttribute("count") %>
	
	<br/>
	<a href="logout">退出系统</a>

</body>
</html>