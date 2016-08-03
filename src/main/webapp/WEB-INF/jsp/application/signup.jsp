<%@page info="signup"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

    	<script src="${pageContext.request.contextPath}/resources/js/application/login/login.js"></script>

        <div id="signup" class="signUpMain" style="display: none;">
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
