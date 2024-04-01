/**
 * 
 */
$(document).ready(function(){

    $("#collapse").on("click",function(){

        $("#sidebar").toggleClass("active");
        $(".fa-align-left").toggleClass("fa-chevron-right");
    })
});
 



function changeinfo(){
    document.querySelector(".sectiontext").innerHTML=
    '<iframe src="memberinfo"name="memberinfo" width="100%"marginwidth="0" height="100%"marginheight="0" scrolling="No" frameborder="0" id="memberinfo" title="banner"></iframe>';
    return false;
}

function changepasswd(){
    document.querySelector(".sectiontext").innerHTML=
    '<iframe src="newpasswd"name="memberinfo" width="100%"marginwidth="0" height="100%"marginheight="0" scrolling="No" frameborder="0" id="memberinfo" title="banner"></iframe>';
    return false;
}

function order(){
    document.querySelector(".sectiontext").innerHTML=
    '<iframe src="memberorder.jsp"name="memberinfo" width="100%"marginwidth="5px" height="100%"marginheight="5px"  frameborder="0" id="memberinfo" title="banner"></iframe>';
    return false;
}