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
                <a href="register">註冊會員</a>
            </div>
        </div>  
    </div>
    <div class="article">
         <div class="loginwindow">
             <form action="resetpwd" method="post" name="login">
                 <div class="loginwindow-top">
                     忘記密碼
                 </div>
                 <div class="login-text" id="login-text">                    
                 	<p><span>新&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;碼:</span><input type='password' name='passwd' id='passwd' size='25' maxlength='15'></p>
                    <p><span>再次確認密碼:</span><input type='password'name='passwdcheck' id='passwdcheck' size='25' maxlength='15'></p>
                 </div>
                 <input  id='check-btn' type="button" value="送出" onclick="changepasswd()">
                 <span id="message"></span>
             </form>            
         </div>
    </div>
</div>

<script>
	function changepasswd(){
		var regex_passwd=/^[A-Za-z0-9]{8,12}$/;
		var passwd = document.getElementById("passwd").value;
		var passwdcheck = document.getElementById("passwdcheck").value;
		var data;
		var json;
		
		if(passwd.length==0||passwdcheck.length==0){
			alert("請輸入密碼");
			checkOK=false;
		}else{
			if(!regex_passwd.test(passwd)){
				alert("密碼格式錯誤");
				checkOK=false;
			}
		}
		if(passwd!=passwdcheck){
			alert("兩次輸入密碼不同");
			checkOK=false;
		}else{
			document.login.submit();
		}
	}

</script>

</body>
</html>