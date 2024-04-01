<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>註冊</title>
<link rel="stylesheet" href="css/style-register.css">
</head>
<body onload="cities()">
	<div class="bg">
        <div class="header">
            <div class="header-left">
                <div class="header-left-img">
                    <img src="img/icons4.png" alt="" style="width: 100%;">
                </div>
                <div class="header-left-text">
                    健身鐵工廠
                </div>
            </div>  
            <div class="header-right">
                <div class="header-right-img">
                    <img src="img/icons6.png" alt="">
                </div>
                <div class="header-right-text">
                    <a id="login-link" href="index.jsp">會員登入</a>
                </div>
            </div>  
        </div>
        <div class="navbar">
            <div class="navbar1">公開課</div>
            <div class="navbar2"><a id="link" href="menu.jsp">私教課程</a></div>
            <div class="navbar3">預約體驗</div>
        </div>
        <div class="article">
            <div class="sections">
                <div class="section-top">
                    <div class="sectionphoto">
                        <img src="img/member/0.svg" alt="">						  
                    </div>
                    <div class="section-side">
                       
                    </div>
                </div>
                <div class="sectiontext"> 
                    <form  action="inputdata" method="post" name="register" accept-charset="UTF-8" >
                        <p>姓名：<input type="text" name="membername" id="membername" value="" size="10"></p>
                        <p>帳號：<input type="text" name="username" id="username" value="" placeholder="請輸入6~12碼英數字"><c:if test="${checkAcc!=null }"><c:out value="${checkAcc }" /></c:if></p>
                        <p>密碼：<input type="password" name="userpasswd" id="userpasswd" value="" placeholder="請輸入8~12碼英數字"></p>
                        <p>密碼確認：<input type="password" name="passwd" id="passwd" value="" placeholder="請再次輸入密碼"></p>
                        <p>手機：<input type="text" name="phone" id="phone" value="" ></p>
                        <p>出生日期：<input type="date" name="birthdate" id="birthdate" value=""></p>
                        <p>性別：<input type="radio" name="sex"  value="1" >男
                                <input type="radio" name="sex"  value="2" >女</p>
                        <p>地址：
                            <select name="county" id="county_box">
                                <option value="">選擇縣市</option>
                            </select>
                            <select name="district" id="district_box">
                                <option value="">選擇鄉鎮市區</option>
                            </select>
                                <input type="text" name="address" id="address" value="" ></p>
                        <p>電子信箱：<input type="text" name="email" id="email" value=""></p>
                        <p><input type="button"value="重設"  onclick="reset()">&nbsp;&nbsp;<input type="button" value="儲存" onclick="savechange()"></p>
                    </form>
                </div>
            </div>
        </div>   
    </div>
    
    <script src="js/cities.js"></script>
    <script src="js/register.js"></script>

</body>
</html>