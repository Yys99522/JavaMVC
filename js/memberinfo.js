/**
 * 
 */

var checkOK=true;
var regex_phone=/^[0][9][0-9]{8}$/;
var regex_name=/^[\u4E00-\u9FA5]+$/;
var regex_address=/^[\u4E00-\u9FA5]{3,}[\u4E00-\u9FA50-9]+$/;
var regex_passwd=/^[A-Za-z0-9]{8,12}$/;

 function modify(){   
    phone=document.getElementById("phone").disabled=false;
    birthdate=document.getElementById("birthdate").disabled=false;
    document.getElementsByName("sex")[0].disabled=false;
    document.getElementsByName("sex")[1].disabled=false;
    document.getElementById("county_box").disabled=false;
    document.getElementById("district_box").disabled=false;
    address=document.getElementById("address").disabled=false;
    email=document.getElementById("email").disabled=false;
    
    return false;
}

function checkmodify(){
	checkOK=true;
    var phone=document.getElementById("phone").value;
    var birthdate=document.getElementById("birthdate").value;
    var address=document.getElementById("address").value;
    var email=document.getElementById("email");
    var county=document.getElementById("county_box").value;
    var district=document.getElementById("district_box").value;

    if(!regex_phone.test(phone)){
        alert("手機格式錯誤");
        checkOK=false;
    }
    if(!regex_address.test(address)){
        alert("地址格式錯誤");
        checkOK=false;
    }
    if(county==""){
		alert("請選擇縣市");
        checkOK=false;
	}
	if(district==""){
		alert("請選擇鄉鎮市區");
        checkOK=false;
	}
}

function savechange(){
	
	checkmodify();
	if(checkOK){	
		document.info.submit(); 	    
	}

}
