<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录页面</title>
</head>
<body>
	<h3>用户登录</h3>
	<!--name中的值与javaBean中对象的属性名称应一致  ,logon（userController）登录状态判断-->
	<form method="POST" action="/user/logon">
	<p>用户名：<input type="text" name="loginname" size="20"></p>
	<p>密码：&nbsp; &nbsp;<input type="password" name="password" size="20"></p>
	<p><input type="submit" value="提交" name="B1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset" value="重置" name="B2"></p>
</form>
	
</body>
</html>