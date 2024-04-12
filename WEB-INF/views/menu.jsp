<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>私教課程</title>
<link rel="stylesheet" href="css/style-menu.css">

</head>
<body>

	<button class="showcartBottom" onclick="showcart()" id="showcartBottom">
	    <div class="redcircle" id="redcircle">0</div>
	</button>
	<div class="cartcover" id="slideElement">
	    <h2>購物車</h2>
	    <form action="cart" method="post" name="cart" id="cart">
		    <ul>
		        
		    </ul>
		    <p id="totalCost">總計: $0</p>
		    <input type="hidden" name="productList" id="productListInput">
		    <div class="backBottom" onclick="backBottom()" id="backBottom">返回頁面</div>
		    <button type="button" class="payBottom" onclick="paybtn()" id="payBottom">結帳</button>
	    </form>
	</div>

    <div class="sheld" style="height: 100%;">
        <div class="header">
            <div class="header-left">
                <div class="header-left-img">
                    <img src="img/icons4.png" alt="" style="width: 100%;">
                </div>
                <div class="header-left-text">
                    <a id="link" href="index">健身鐵工廠</a>
                </div>
            </div>  
            <div class="header-right">
                <div class="header-right-img">
                    <img id="member-icon" src="img/icons1.png" alt="" width="24px" height="28px" id="member">
                </div>
                <div class="header-right-text">
                    <a id="member-link" href="memberwindow">會員中心</a>
                </div>
                <div class="header-right-img">
                    <img src="img/icons6.png" alt="">
                </div>
                <div class="header-right-text">
                    <a id="login-link" href="logout">登出</a>
                </div>
            </div> 
        </div>
        <div class="navbar" id="navbar">
            <div class="navbar1">公開課</div>
            <div class="navbar2"><a id="link" href="menu">私教課程</a></div>
            <div class="navbar3">預約體驗</div>
        </div>
        <div class="menu">
            <h2>私教課程</h2>
            
            <c:if test="${menu!=null }">
            	<c:forEach var="num" begin="1" end="${menuSize}" step="2">
            		<div class="course">
            			<c:forEach var="product" items="${menu }" begin="${num }" end="${num+1<menuSize? num+1:menuSize}">
	            			<div class="course-item">
	            				<img src="${product.getImage() }">
	            				<h3>${product.getProductName() }</h3>
	            				<p>${product.getDescript() }</p>
	            				<span class="course-price">${product.getPrice() }</span>
	            				<button class="add-to-cart" onclick="addToCart(this)" value="${product.getProductId() }" id="${product.getProductId() }">加入購物車</button>
	            			</div>
            			</c:forEach>
            		</div>
            	</c:forEach>
            </c:if>
        </div>
        <footer class="footer">
            <p>健身鐡工廠</p>
            <div class="social-icons">
                <a href="#" target="_blank">加入我們<i class="fab fa-facebook"></i></a>
                <a href="#" target="_blank">機不可失<i class="fab fa-twitter"></i></a>
                <a href="#" target="_blank">失不再来<i class="fab fa-instagram"></i></a>
            </div>
        </footer>
    </div>
	<script src="js/menu.js"></script>
</body>
</html>