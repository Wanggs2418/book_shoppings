<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户主页</title>
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">图书清单</h3>
		</div>
	</div>
	
	<div class="container">
		<div class="col-md-12">
			<div class="panel-body">
			<!--响应式表格  -->
				<div class="table table-responsive">
					<table class="table table-border table-hover">
					<!--表头-->
						<thead>
							<tr>
								<th class="text-center">id</th>
								<th class="text-center">书名</th>
								<th class="text-center">价格</th>
								<th class="text-center">作者</th>
								<th class="text-center">数量</th>
							</tr>
						</thead>
						
						<tbody class="text-center">
						<c:forEach items="${requestScope.listbook}" var="book">
							<tr>
								<td>${book.id}</td>
								<td>${book.name}</td>
								<td>${book.price}</td>
								<td>${book.author}</td>
								<td>${book.stock_number}</td>
							</tr>
						</c:forEach>
						</tbody>					
					
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<form method="POST" action="/user/addshopcart">
	<p>书籍id：<input type="text" name="id" size="20"></p>
	<p><input type="submit" value="加入购物车" name="B1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset" value="重置" name="B2"></p>
</form>
</body>
</html>