/**
 * ==================================================================================
 * 메인공통 다이얼 로그 설정
 * ----------------------------------------------------------------------------------
 * 다이얼 로그 오픈클릭 이벤트와 다이얼 로그 정보로 구성 함
 * ==================================================================================
 */
function f_commonUserRD(url, frmTarget) {
	// dialog clear
	var $target = $('#login_rd');
	$target.empty();
	
	var send_data = {
		frm_target : frmTarget
	}
	
	$.ajax({
		url: 'view/main/'+url,
		type: 'GET',
		headers: {'AJAX':true},
		data : send_data,
		success: function(data) {
			$target.html(data);
		},
		error: function(obj) {
			cf_errViewDialog(obj, $target);
	    }
	});
	$('#login_rd').dialog('open');
	return false;
}


/**
 * ==================================================================================
 * 로그인 다이얼 로그 설정
 * ----------------------------------------------------------------------------------
 * 다이얼 로그 오픈클릭 이벤트와 다이얼 로그 정보로 구성 함
 * ==================================================================================
 */
function f_openLoginRD(frmTarget) {
	
	// dialog clear
	var $target = $('#login_rd');
	$target.empty();
	
	var send_data = {
		frm_target : frmTarget
	}
	
	$.ajax({
		url: 'view/main/loginRD',
		type: 'GET',
		headers: {'AJAX':true},
		data : send_data,
		success: function(data) {
			$target.html(data);
		},
		error: function(obj) {
			cf_errViewDialog(obj, $target);
	    }
	});
	$('#login_rd').dialog('open');
	return false;
}
/**
 * ==================================================================================
 * 로그인 실행---------------------------------------------------------------
 * ==================================================================================
 */
function f_login(){
	$("#frmLogin").ajaxSubmit({
		type: 'POST',
		url: '/loginProcess',
		success:function(response) {
			alert("로그인완료");
			location.href = "/";
		},
		error: function(xhr, textStatus, errorThrown){
			if (xhr.status == 403) {
				alert("아이디와 비밀번호를 확인해주세요");
	        }
		}
	});
}
/**
 * ==================================================================================
 * 로그아웃 실행---------------------------------------------------------------
 * ==================================================================================
 */
function f_logout(){
	//e.preventDefault();
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    
    $.ajax({
       url : 'logout',
       type : 'POST',
       data: token,
       beforeSend:function(xhr){
            xhr.setRequestHeader(header, token);
       },
       success : function(data) { 
           window.location ="/";
       }, 
       error : function(data) {
           console.log(data);
       }
    });

}
/**
 * ==================================================================================
 * 회원가입 다이얼 로그 설정
 * ----------------------------------------------------------------------------------
 * 다이얼 로그 오픈클릭 이벤트와 다이얼 로그 정보로 구성 함
 * ==================================================================================
 */
function f_openSignupRD(frmTarget) {
	// dialog clear
	var $target = $('#signup_rd');
	$target.empty();
	
	var send_data = {
		frm_target : frmTarget
	}
	
	$.ajax({
		url: 'view/main/signupRD',
		type: 'GET',
		headers: {'AJAX':true},
		data : send_data,
		success: function(data) {
			$target.html(data);
		},
		error: function(obj) {
			cf_errViewDialog(obj, $target);
	    }
	});
	$('#signup_rd').dialog('open');
	return false;
}

/**
 * ==================================================================================
 * 회원가입
 * ==================================================================================
 */

$(document).ready(function() {
	$("#frmSignUp").on('submit', function() {
		console.log(this)
		$(this).ajaxSubmit({
			type: 'POST',
			url: '/apis/user/signup',
			success:function(response) {
				console.log(response);
				alert("회원가입완료");
				location.href = "/";
			}
		});
		return false;
	}); 
});

/*function f_signUp(){
	
	var frm = $("#frmSignUp");
	var send_data = frm.serializeObject();
	
	//frm.find('.btn-primary').addClass('disabled');
	console.log(send_data);
	$.ajax({
		url: 'apis/user/signup',
		type: 'POST',
		async: true,
	    cache: false,
	    datatype: 'json',
	    headers: {'AJAX':true},
	    contentType: 'application/json;charset=utf-8',
		data: cf_bizPostEncode(send_data),
		success: function(obj) {
			if(obj.data.fst_conn_msg) {
				alert(cf_cvtMsg(obj.data.fst_conn_msg));
			}
			location.href = obj.data.redirect_url;
		},
		error: function(obj) {
			cf_errMsg(obj);
			frm.find('.btn-primary').removeClass('disabled');
	    },
	});
	
}*/

