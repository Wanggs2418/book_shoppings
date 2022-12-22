<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员添加书籍</title>
</head>
<body>
	<!--加入到数据库  -->
	<form method="POST" action="/admin/addDB">
	<p>书名：<input type="text" name="name" size="20"></p>
	<p>价格：<input type="text" name="price" size="20"></p>
	<p>作者：<input type="text" name="author" size="20"></p>
	<p>数量：<input type="text" name="stock_number" size="20"></p>
	<p><input type="submit" value="提交" name="B1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset" value="重置" name="B2"></p>
	</form>
</body>
</html>