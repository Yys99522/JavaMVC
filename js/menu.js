/**
 * 
 */
var slideElement = document.getElementById("slideElement");
var showcartBottom = document.getElementById("showcartBottom");
var count = 0;
var key;
var totalMoney = 0;

function showcart() {
    slideElement.style.right = "0px"; // 显示元素
    showcartBottom.style.visibility = "hidden";//隱藏小圖標   
    return true;
}

function backBottom(){
    slideElement.style.right = "-999px"; // 隱藏元素
    showcartBottom.style.visibility = "visible";//顯示小圖標
    return true;
}

function addToCart(classBtnEle) {
	var btn = classBtnEle;
	var productName = btn.parentNode.children[1].innerText;
	var productCost = btn.parentNode.children[3].innerText;
	key = btn.value;
	var cartItem = document.createElement("li");
	cartItem.innerHTML = productName +"<p style='margin:0; padding:0;'>"+productCost+"</p>"+"<button onclick='delFromCart(this)'  name='productlist[]' value='"+ key +"'>-</button>";
    var cartList = document.querySelector(".cartcover ul");
   	cartList.appendChild(cartItem);
   	
   	updateTotal(productCost);
   	
   	count++;
    document.getElementById("redcircle").innerText = count;
    return true;
}

function delFromCart(buttonElement) {
	var btn = buttonElement;
    var cartItem = btn.parentNode;
    var costRemove = cartItem.children[0].innerText;
    updateTotal("-"+costRemove);
    var cartList = document.querySelector(".cartcover ul");
    cartList.removeChild(cartItem);
    
    count--;
    document.getElementById("redcircle").innerText = count;
    return true;
}

function updateTotal(costChange) {
	 var changeDig = parseInt(costChange.replace('$',''));
	 totalMoney += changeDig;
	 
	 var totalElement = document.getElementById("totalCost");
     totalElement.innerText = "總計: $"+totalMoney;
     return true;
}

function paybtn(){
	var list=document.getElementsByName("productlist[]");
	var value="";
	Array.from(list).forEach(function(button){
		value+=button.value+",";
	})
	document.getElementById("productListInput").value = value;
	document.cart.submit();
}