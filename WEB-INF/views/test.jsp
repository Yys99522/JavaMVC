<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>  
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
test

<img src="${path != null ? path : imgpath}?timestamp=<%= new Date().getTime() %>" id="pre-img" alt="選擇大頭貼" style="height: 80px;width: 80px;">
</body>
</html>