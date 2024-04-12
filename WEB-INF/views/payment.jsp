<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結帳</title>
<link rel="stylesheet" href="css/style-payment.css">
</head>
<body onload="getTotal()" onpageshow="checkPageLoad()">

<div class="checkout">
	<h2>購物車結帳</h2>
	<ul id="orderlist">
		<c:forEach var="num" begin="0" end="${listSize-1 }" items="${value }">
			<li>
				<img src="${menu[num-1].getImage() }">
				<span>${menu[num-1].getProductName() }</span>
				<span name="price">${menu[num-1].getPrice() }</span>
			</li>
		</c:forEach>
	</ul>
	<p id="totalCost">金額計算出了點問題</p>
    <form action="pay" method="post" name="myform">      
    	<label>付款方式：</label>
            <ul>
            	<li>
            		<label for="craditCard">信用卡</label>
            		<input type="radio" id="craditCard" name="payMethod" value="craditCard" required checked>
            	</li>                
                <li>
					<label for="payByCash">現金繳費</label>
                    <input type="radio" id="payByCash" name="payMethod" value="payByCash" required>
                </li>
            </ul>
        <label for="cardNumber" id="cardNumberLabel">卡號：</label>
        <input type="text" id="cardNumber" name="cardNumber" placeholder="請輸入16位數字卡號" maxlength="16">
		<label for="cvc" id="cvcLabel">CVC(安全碼)：</label>
		<input type="password" id="cvc" name="cvc" size="4" maxlength="3">
		<label for="expmonth" id="expdateLabel">有效日期：</label>
		<select name="expmonth" id="expmonth"> <c:forEach var="month" begin="1" end="12"><option value="${month }"><c:out value="${month }"/></option></c:forEach></select> <span id="expmonth_txt">月</span>
		<select name="expyear" id="expyear"> <c:forEach var="year" begin="24" end="30"><option value="${year }"><c:out value="${year }"/></option></c:forEach></select> <span id="expyear_txt">年</span>
        <label for="insrand">輸入認證碼：</label>
        <img src="verifyImg" alt="Random_Number" id="checkpic"/>
        <img src="./img/icons5.gif" alt="reload" onclick="reload()" style="width: 3%;"><br>
        <input type="text" id="insrand" name="insrand" required  maxlength="4">
        <button class="payButton" onclick="return validateCardNumber()" name="orderid" id="orderid">確認支付</button>
    </form>
</div>

<script>
var flag = true;
function validateCardNumber() {
	if(flag){
		var cardNumber = document.getElementById("cardNumber").value;
		if (/^\d{16}$/.test(cardNumber)) {
			   document.myform.submit();
				return true;
		} else {
			alert("请输入16位数字卡号");
			reload();
			document.getElementById("insrand").value = "";
			document.getElementById("cardNumber").focus();
			return false
		}
	}
}

function reload(){
    var img = document.getElementById("checkpic");
    // 做個時間戳,硬轉換鏈接,達到刷新效果
    var time = new Date().getTime();
    img.src = "verifyImg?"+time;
}

var payByCash = document.getElementById("payByCash");
var craditCard = document.getElementById("craditCard");

payByCash.addEventListener("change",function(){
	if(payByCash.checked){
    document.getElementById("cardNumber").style.display = "none";
	document.getElementById("cardNumberLabel").style.display = "none";
	document.getElementById("cardNumber").value = "";
    document.getElementById("cvc").style.display = "none";
	document.getElementById("cvcLabel").style.display = "none";
    document.getElementById("cvc").value = "";
    document.getElementById("expdateLabel").style.display = "none";
	document.getElementById("expmonth").style.display = "none";
    document.getElementById("expyear").style.display = "none";
    document.getElementById("expmonth_txt").style.display = "none";
    document.getElementById("expyear_txt").style.display = "none";
	flag = false;
	return true;
	}
})

craditCard.addEventListener("change",function(){
	if(craditCard.checked){
    document.getElementById("cardNumber").style.display = "flex";
	document.getElementById("cardNumberLabel").style.display = "flex";
	document.getElementById("cardNumber").focus();
    document.getElementById("cvc").style.display = "flex";
	document.getElementById("cvcLabel").style.display = "flex";
    document.getElementById("expdateLabel").style.display = "flex";
	document.getElementById("expmonth").style.display = "inline";
    document.getElementById("expyear").style.display = "inline";
    document.getElementById("expmonth_txt").style.display = "inline";
    document.getElementById("expyear_txt").style.display = "inline";
	flag = true;
	return true;
	}
})

function getTotal(){
	var price=document.getElementsByName("price");
	var cost=0;
	var i=0;
	while(i<price.length){
		cost+=parseFloat(price[i++].textContent);
	}
	document.getElementById("totalCost").innerHTML = "<span>總計: $ "+cost+"</span>";
}

function checkPageLoad(){
    if(window.performance.navigation.type == 1) {
        reload();
    }
}
</script>

</body>
</html>