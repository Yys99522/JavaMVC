<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員資料</title>
<link rel="stylesheet" href="css/style-memberinfo.css">
</head>
<body>

<div class="sectiontext">
	<form action="infochange" method="post" name="info">
       <p>手機：<input type="text" name="phone" id="phone" value="<c:out value="${member.getPhone() }"/>"  disabled></p>
       <p>出生日期：<input type="date" name="birthdate" id="birthdate" value="<c:out value="${member.getBirthdate() }" />" disabled></p>
       <p>性別：<input type="radio" name="sex" id="male" value="1"  <c:if test="${member.getSex()==1 }"><c:out value="checked" /> </c:if>disabled>男
               <input type="radio" name="sex" id="female" value="2" <c:if test="${member.getSex()==2 }"><c:out value="checked" /> </c:if> disabled>女</p>
       <p>地址：
           <select name="county" id="county_box" disabled>
               <option value="<c:out value="${member.getCounty() }" />"><c:out value="${member.getCounty() }" /></option>
           </select>
           <select name="district" id="district_box" disabled>
               <option value="<c:out value="${member.getDistrict() }" />"><c:out value="${member.getDistrict() }" /></option>
           </select>
               <input type="text" name="address" id="address" value="<c:out value="${member.getAddress() }" />"  disabled></p>
       <p>電子信箱：<input type="text" name="email" id="email" value="<c:out value="${member.getEmail() }" />"  disabled></p>
       <p><input type="button"value="編輯"  onclick="cities(),modify()">&nbsp;&nbsp;<input type="button" value="儲存" onclick="savechange()"></p>
    </form>
</div>

  <script src="js/cities.js"></script>
  <script src="js/memberinfo.js"></script>
</body>
</html>