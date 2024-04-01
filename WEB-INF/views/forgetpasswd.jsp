<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>忘記密碼</title>
<link rel="stylesheet" href="css/style-forgetpasswd.css">
</head>
<body>
<div class="bg">
    <div class="header">
        <div class="header-left">
            <div class="header-left-img">
                <img src="img/icons4.png" alt="顯示異常" style="width: 100%;">
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
                <a href="register">註冊會員</a>
            </div>
        </div>  
    </div>
    <div class="article">
         <div class="loginwindow">
             <form action="forget" method="post" name="login">
                 <div class="loginwindow-top">
                     忘記密碼
                 </div>
                 <div class="login-text" id="login-text">                    
                 	<p><span>帳&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;號：</span><input type="text" name="username" id="username" size="25" maxlength="15"></p>
                 	<p><span>手機/信箱：</span><input type="text" name="email" id="email" size="25"></p>                    	     
                 </div>
                 <input  id='check-btn' type="button" value="送出" onclick="check()">
                 <c:if test="${check!=null }"><span id="message"><c:out value="${check }" /></span></c:if>
             </form>            
         </div>
    </div>
</div>

<script>

    function check(){
    	checkOK=true;
	    var regex_name=/^[A-Za-z0-9]{6,12}$/;
	    var regex_email=/(^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$)|([0][9][0-9]{8})/;
	    var username=document.login.username.value;
	    var email=document.login.email.value;
	    
	    if(username.length==0){
	        alert("請輸入帳號");
	        document.login.username.focus();
	        checkOK=false;
	    }else{
	        if(!regex_name.test(username)){
	            alert("帳號格式錯誤");
	            checkOK=false;
	        }
	    }
	    
	    if(email.length==0){
			alert("請輸入手機或email");
			document.login.email.focus();
			checkOK=false;
		}else{
			if(!regex_email.test(email)){
				alert("手機/email格式錯誤");
				checkOK=false;
			}
		}
		if(checkOK){
			document.login.submit();
		}
    }
   

</script>
</body>
</html>