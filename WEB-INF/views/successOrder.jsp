<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>訂單完成</title>
</head>
<body>

<p>訂單編號：${orderdetal.get(0).getOrderid() }</p>
<p>付款方式：${orderdetal.get(0).getPaymethod() }</p>
<p>付款狀態：${orderdetal.get(0).getPaystatus() }</p>
<table>
	<tr>
		<th>產品編號</th><th>產品名稱</<th>數量</th><th>價錢</th>
	</tr>
	<c:forEach var="order" items="${orderdetal }">
		<tr>
			<td>${order.getProductid() }</td><td>${menu.get(order.getProductid()-1).getProductName()}</<td>${order.getQuantity() }</td><td>${order.getPrice() }</td>
		</tr>
	</c:forEach>

</table>
</body>
</html>