<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>錯誤訊息</title>
<style>
body {
	font-family: Arial, sans-serif;
	text-align: center;
	background-color: #f0f0f0;
	margin: 0;
	padding: 0;
	}
	  
	.info-box {
	background-color: #fff;
	border: 1px solid #ccc;
	padding: 20px;
	margin: 50px auto;
	max-width: 400px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	}
	
	.success {
	color: blue;
	}
	
	.failure {
	color: red;
	}	
</style>
</head>
<body>
<div class="info-box">

<p><c:out value="${error }"/></p>
<a href="javascript:history.go(-1)">返回上一页</a>

</div>

</body>
</html>