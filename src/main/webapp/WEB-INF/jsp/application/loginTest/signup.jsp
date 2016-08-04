<%@page info="signup"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="ko-kr" id="extr-page">
    <head>
    	<title>IssueKing 회원가입</title>
    	<meta charset="utf-8">
    	<meta name="description" content="">
    	<meta name="author" content="">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    	<!-- #CSS Links -->
    	<jsp:include page="/WEB-INF/jsp/include/inc_common_style.jsp" flush="false"/>
    	<!-- #COMMON SCRIPT -->
    	<jsp:include page="/WEB-INF/jsp/include/inc_common_script.jsp" flush="false"/>
    	<script src="${pageContext.request.contextPath}/resources/js/application/login/login.js"></script>
    </head>
  	<body class="animated fadeInDown">
		<header id="header">
			<div id="logo-group">
<%-- 				<span id="logo"> <img src="${pageContext.request.contextPath}/resources/img/logo.png" alt=""> </span> --%>
			</div>
		</header>
        <div id="signUp" class="signUpMain">
        	<div id="content" class="container">
        		<div class="row">
        			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
        				<h1 class="txt-color-red login-header-big"></h1>
        			</div>
        		</div>
        		<div class="row">
        			<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-md-offset-3">
        				<div class="well no-padding">
        					<%-- <form id="frmSignUp" class="smart-form client-form" action="<c:url value="/apis/user/signup"/>" method="post"> --%>
                  <form id="frmSignUp" class="smart-form client-form">
        						<header>회원가입</header>
        						<fieldset>
        							<div class="row">
        								<section class="col col-md-12">
        									<label class="label">이름</label>
        									<label class="input"><i class="icon-append fa fa-user"></i>
        										<input type="text" name="userName" autocomplete="off">
        										<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i>닉네임 또는 이름를 입력하세요.</b></label>
        								</section>
        							</div>
        							<div class="row">
        								<section class="col col-md-12">
        									<label class="label">아이디(Email)</label>
         									<label class="input"> <i class="icon-append fa fa-envelope-o"></i>
        										<input type="text" name="userId" autocomplete="off">
        										<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i> 이메일를 입력하세요.</b></label>
        								</section>
        							</div>
        							<div class="row">
        								<section class="col col-md-12">
        									<label class="label">비밀번호</label>
        									<label class="input"> <i class="icon-append fa fa-lock"></i>
        										<input type="password" name="password" autocomplete="off">
        										<b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i> 비밀번호를 입력하세요.</b> </label>
        								</section>
        							</div>
        							<div class="row">
        								<section class="col col-md-12">
        									<label class="label">비밀번호확인</label>
        									<label class="input"> <i class="icon-append fa fa-lock"></i>
        										<input type="password" name="password_confirm" autocomplete="off">
        										<b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i> 비밀번호를 한번더 입력하세요.</b> </label>
        								</section>
        							</div>
        						</fieldset>
        						<footer>
                      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                      <!-- <button type="submit" class="btn btn-primary">Sign up</button>  -->
                      <button type="submit" class="btn btn-primary">Sign up</button>
        							<a href="javascript:void(0);" onclick="f_signUpCancel();" class="btn btn-default" id="btn-">취소</a>
        						</footer>
        					</form>
        				</div>
        			</div>
        		</div>
        	</div>
        </div>

        <!--[if IE 8]>
            <h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
        <![endif]-->
        
        <!-- #PLUGINS -->
        <jsp:include page="/WEB-INF/jsp/include/inc_plugins_script.jsp" flush="false"/>
        
        <script type="text/javascript">
        </script>
    </body>
</html>