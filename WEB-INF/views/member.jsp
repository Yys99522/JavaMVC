<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>  
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員中心</title>
<link rel="stylesheet" href="css/style-member.css">
<link rel="stylesheet" href="css/bootstrap-5.3.1/css/bootstrap.min.css">
<script src="js/bootstrap-5.3.1-dist/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
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
	                <a href="logout">登出</a>
	            </div>
	        </div>  
	    </div>
	    <div class="navbar">
	        <div class="navbar1">公開課</div>
	        <div class="navbar2"><a id="link" href="menu">私教課程</a></div>
	        <div class="navbar3">預約體驗</div>
	    </div>
	    <div class="container-all">
	        <div class="container-left">
	            <!-- 導覽列-->
	            <nav id="sidebar">
	                <!-- 展開/縮小按鈕-->
	                <button type="button" id="collapse" class="collapse-btn">
	                    <i class="fas fa-align-left"></i>
	                </button>
	                
	                <!-- List-->
	                <ul class="list-unstyled" id="navlist">
	                    <li>
	                        <a href="#" onclick="changeinfo()">基本資料維護</a>
	                    </li>
	                    <li>
	                        <a href="#" onclick="changepasswd()">密碼修改</a>
	                    </li>
	                    <li>
	                        <a href="#" onclick="order()">課程管理</a>
	                    </li>
	                </ul>
	            </nav>
	        </div>
	        <div class="container-right">
	            <div class="article">
	                <div class="sections">
	                    <div class="section-top">
	                        <div class="section-left">
	                            <div class="sectionphoto">
	                                <form action="photo" method="post" enctype="multipart/form-data" id='photo'>
									    <!-- 隱藏的檔案上傳按鈕 -->
									    <input type="file" name="file" id="file" accept="image/jpeg," style="display: none;">
									    <!-- 自定義大頭貼按鈕 -->
									    <img src="${path != null ? path : imgpath}?timestamp=<%= new Date().getTime() %>" id="pre-img" alt="選擇大頭貼" style="height: 80px;width: 80px;">
									    <input type="button" id='submitbtn' value="上傳" onclick='filecheck()'>
									</form>  
	                            </div>
	                        </div>
	                        <div class="section-side">
	                            <p>姓名：<span><c:out value="${member.getMembername() }"/></span></p>
	                            <p>UID：<span><c:out value="${member.getId() }"/></span></p>
	                        </div>
	                    </div>
	                    <div class="sectiontext">  
					        <iframe src="memberinfo"name="memberinfo" width="100%"marginwidth="0" height="100%"marginheight="0" scrolling="No" frameborder="0" id="memberinfo" title="banner"></iframe>
						</div>
	                </div>
	            </div>
	        </div>   
	     </div>
	</div>
	
	<script src="js/member.js"></script>
    <script src="js/cities.js"></script>
	<script>
	    document.getElementById('pre-img').addEventListener('click', function() {
	        document.getElementById('file').click();
	    });
	    $('#file').change(function() {
		  var file = $('#file')[0].files[0];
		  var reader = new FileReader;
		  reader.onload = function(e) {
		    $('#pre-img').attr('src', e.target.result);
		  };
		  reader.readAsDataURL(file);
		});
	    
	    function filecheck(){
	    	var fileinput=document.getElementById("file");
	    	if(fileinput.files.length==0){
	    		alert("未選擇大頭貼");
	    	}else{
	    		photo.submit();
	    	}
	    }

	</script>

</body>
</html>