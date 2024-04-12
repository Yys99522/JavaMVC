<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>變更密碼</title>
<link rel="stylesheet" href="css/style-memberinfo.css">

<style type="text/css">
    #message{
		font-size: small;
		color: red;
	}
</style>

</head>
<body>

<div class="sectiontext">
       <form action="changepasswd" method="post" name="textpasswd">
           <p>目前密碼：<input type="password" name="userpasswd" id="userpasswd" value="" placeholder="請輸入目前密碼">
           <c:if test="${check!=null }"><span id='message'><c:out value="${check }" /></span></c:if></p>
           <p>新密碼：<input type="password" name="newpasswd" id="newpasswd" value="" placeholder="請輸入8~12碼英數字"></p>
           <p>密碼確認：<input type="password" name="passwd" id="passwd" value="" placeholder="請再次輸入密碼"></p>
           <p><input type="reset" value="清除">&nbsp;&nbsp;<input type="button"value="送出"  onclick="modifypasswd()"></p>
       </form>
</div>

<script>
    document.getElementById("passwd").addEventListener("keyup",function(event){
        if(event.key ==="Enter"){
            modifypasswd();
        }
    });
    
    
    function modifypasswd(){
    	var checkOK =true;
    	var regex_passwd=/^[A-Za-z0-9]{8,12}$/;
        var userpasswd=document.getElementById("userpasswd").value;
        var newpasswd=document.getElementById("newpasswd").value;
        var passwd=document.getElementById("passwd").value;

        if(!regex_passwd.test(newpasswd)){
            alert("密碼格式錯誤");
            checkOK=false;
        }
        if(passwd!=newpasswd){
            alert("兩次密碼輸入不同");
            checkOK=false;
        }
        if(checkOK){
    		document.textpasswd.submit();
    	}
        return false;

    }

</script>

</body>
</html>