<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html style="height: 100%;">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style-login.css">
    <title>登入</title>
    <style>
        a{
            text-decoration: none;
            color: black;
        }
        
        #message{
			font-size: small;
			color: red;
		}
    </style>

    
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
                <form action="login" method="post" name="login">
                    <div class="loginwindow-top">
                        會員登入
                    </div>
                    <p>
                        帳號：<input type="text" name="username" id="username" size="25" maxlength="20">
                    </p>
                    <p>
                        密碼：<input type="password" name="userpasswd" id="userpasswd" size="25" maxlength="20">
                    </p>
                    <div class="loginbut">
						<a href="forgetpasswd">忘記密碼</a><input type="button" value="登入" onclick="check()">
                    </div>
                    <span id="message">
                    	<c:if test="${error!=null }">
                    		<c:out value="${error }"/>
                    	</c:if>
                    </span>
                </form>
            </div>
        </div>
    </div>
    <script>
	    document.getElementById("userpasswd").addEventListener("keyup",function(event){
	        if(event.key ==="Enter"){
	            check();
	        }
	    });
	    
	    function check(){
	        var regex_name=/^[A-Za-z0-9]{6,12}$/;
	        var regex_passwd=/^[A-Za-z0-9]{8,12}$/;
	        var username=document.login.username.value;
	        var userpasswd=document.login.userpasswd.value;
	        var checkOK=true;
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
	        if(userpasswd.length==0){
	            alert("請輸入密碼");
	            document.login.userpasswd.focus();
	            checkOK=false;
	        }else{
	            if(!regex_passwd.test(userpasswd)){
	                alert("密碼格式錯誤");
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