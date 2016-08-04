<%@page info="login"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 		<div id=loginView>
			<div id="content" class="container">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
						<h1 class="txt-color-red login-header-big"></h1>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-md-offset-3">
						<div class="well no-padding">
								<header>로그인</header> -->
								<fieldset class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
    						<%-- <c:url value="/loginProcess" var="loginUrl" /> --%>
    							<%-- <form id="frmLogin" class="smart-form client-form" action="${loginUrl}" method="POST"> --%>
                  <form id="frmLogin" class="smart-form client-form">              
									<div class="row">
										<section class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
											<label class="label">아이디</label>
											<label class="input"> <i class="icon-append fa fa-user"></i>
												<input type="text" name="userId" autocomplete="off">
												<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i> 아이디를 입력하세요.</b></label>
										</section>
									</div>
									<div class="row">
										<section class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
											<label class="label">비밀번호</label>
											<label class="input"> <i class="icon-append fa fa-lock"></i>
												<input type="password" name="password" autocomplete="off">
												<b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i> 비밀번호를 입력하세요.</b> </label>
										</section>
									</div>
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    					   </form>
								</fieldset>
								<!-- <footer>
            			<button type="submit" class="btn btn-primary">Log in</button>
								</footer> -->
					<!-- 	</div>
					</div>
				</div>
		</div>
	</div> -->