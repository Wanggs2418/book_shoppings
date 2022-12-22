<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户购物车清单</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">购物车商品</h3>
		</div>
	</div>
	
	<div class="container">
		<div class="col-md-12">
			<div class="panel-body">
			<!--响应式表格  -->
				<div class="table table-responsive">
					<table class="table table-border table-hover">
						<thead>
							<tr>
								<th class="text-center">书名</th>
								<th class="text-center">价格</th>
								<th class="text-center">作者</th>
								<th class="text-center">数量</th>
							</tr>
						</thead>
						<thead>
						<tbody class="text-center">
						<c:forEach items="${sessionScope.shopcart.cart}" var="book">
							<tr>
								<td>${book.name}</td>
								<td>${book.price}</td>
								<td>${book.author}</td>
								<td>${book.stock_number}</td>
							</tr>
						</c:forEach>
						</tbody>					
						
						<thead>
							<tr>
								<th class="text-center">购书总价</th>
								<th class="text-center">${sessionScope.shopcart.total}</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
	<a href="/user/index">继续添加购物</a><br>
	<a href="/user/pay">付款</a>
</body>
</html>