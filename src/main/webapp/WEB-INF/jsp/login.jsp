<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자 정보</title>

<%--
<script src="${pageContext.request.contextPath}/resources/js/libs/jquery-2.1.1.min.js"></script>
 --%>
<script src=<c:url value="/resources/js/libs/jquery-2.1.1.min.js" />></script>
<script src="http://malsup.github.com/jquery.form.js"></script> 

</head>
<body>
    <h2>로그인</h2>
    <form id="frmLogin" method="post">
        <label>아이디</label>
            <input type="text" id="userId" name="userId"/>
        <label>패스워드</label>
            <input type="password" id="userPwd" name="userPwd"/>
            
       <input type="submit" value="login..." />
    </form>
    <a href="javascript:void(0);" type="button" class="btn" onclick="f_login();">Log in</a>
</body>

<script type="text/javascript">

//$(document).ready(function() {
	$("#frmLogin").on('submit', function() {
		console.debug(this)
		$(this).ajaxSubmit({
			url: '<c:url value="/apis/user/login"/>',
			success:function(response) {
				console.debug(response);
			}
		});
		return false;
	});
//});

function f_login() {
	$("#frmLogin").get(0).submit();
	//document.getElementById("frmLogin").submit();
/*
	$("#frmLogin").on('submit', function() {

	});
*/
	/*
   	var frm = $("#frmLogin");
   	
    var send_data = frm.serializeObject();
    
    $.ajax({
        url: '<c:url value="/apis/user/login"/>',
        type: 'POST',
       	async: true,
        cache: false,
        datatype: 'json',
        headers: {'AJAX':true},
        contentType: 'application/json;charset=utf-8',
        data: send_data,
    		success: function(obj) {
    			alert("환영합니다.");
    		},
    		error: function(obj) {
    			alert("로그인실패");
      	},
    });
    */
}
</script>
</html>