<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
    <head>
    		<title>issue_king 메인</title>
    		<meta charset="utf-8">
    		<meta name="description" content="">
    		<meta name="author" content="">
    		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <!-- default header name is X-CSRF-TOKEN -->
        <meta name="_csrf" content="${_csrf.token}"/>
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
        
    		<jsp:include page="/WEB-INF/jsp/include/inc_common_style.jsp" flush="false"/>
    		<jsp:include page="/WEB-INF/jsp/include/inc_common_script.jsp" flush="false"/>
        <script src="${pageContext.request.contextPath}/resources/js/application/login/login.js"></script>  
    </head>
    <body class="desktop-detected fixed-header fixed-navigation fixed-ribbon">
    <header id="header">
        <div id="logo-group">
            <%-- <span id="logo"> <img src="${pageContext.request.contextPath}/resources/img/logo.png" alt=""> </span> --%>
        </div>
        <div class="pull-right">
            <div id="hide-menu" class="btn-header pull-right">
                <span> <a href="javascript:void(0);" data-action="toggleMenu" title="Collapse Menu"><i class="fa fa-reorder"></i></a> </span>
            </div>
            <c:choose>
                <c:when test="${sessionScope.userId eq null || sessionScope.userId eq ''}">
             <div class="btn-header transparent pull-right">
                 <span> <a href="javascript:void(0);" id="btn_signup" class="fs-13 pd-rl7 btn-danger" title="회원가입" onclick="f_openSignupRD();"> 회원가입 </a> </span>
            </div>
            <div class="btn-header transparent pull-right">
                <span> <a href="javascript:void(0);" id="btn_login" class="fs-13 pd-rl7 btn-primary" title="로그인" onclick="f_openLoginRD();"> 로그인 </a> </span>
            </div>
                </c:when>
                <c:otherwise>
            <div class="btn-header transparent pull-right">
                <span> <a href="javascript:void(0);" id="btn_myinfo" class="fs-13 pd-rl7" title="정보수정" onclick="f_myInfoUN();"> 정보수정 </a> </span>
            </div> 
            <div id="logout" class="btn-header transparent pull-right">
                <span><a href="javascript:void(0);" id="btn_logout" class="fs-13 pd-rl7" title="로그아웃" onclick="f_logout();"> 로그아웃 </a></span>
            </div>
            <%-- <div class="pull-right">
                <div style="margin-top: 10px; padding: 3px;"><c:out value="${sessionScope.userName}" /> 님(<c:out value="${sessionScope.adminConnTime}" />)</div>
             </div> --%>
            	</c:otherwise>
            </c:choose>
        </div>
    </header>
    
    <aside id="left-panel">
        <jsp:include page="/WEB-INF/jsp/include/inc_user_info.jsp" flush="false"/>
        <jsp:include page="/WEB-INF/jsp/include/inc_left_menu.jsp" flush="false"/>
    </aside>
        
    <div id="main" role="main">
        <div id="ribbon">
            <span class="ribbon-button-alignment"> 
                <span class="btn btn-ribbon" onclick="f_lnkMain();"><i class="fa fa-home"></i></span> 
            </span>
            <ol class="breadcrumb">
            </ol>
        </div>
        <div id="content">
    
        </div>
    </div>
    <div class="page-footer">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                <span class="txt-color-white pull-right"> <span class="hidden-xs"> - Copyright</span> © 2016 <span class="hidden-xs">All rights reserved.</span></span>
            </div>
        </div>
    </div>
    <!--[if IE 8]>
        <h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
    <![endif]-->
    
    <div style="display: none;" id="shortcut">
        <ul>
            <li>
                <a href="#ajax/inbox.html" class="jarvismetro-tile big-cubes bg-color-blue"> <span class="iconbox"> <i class="fa fa-envelope fa-4x"></i> <span>Mail <span class="label pull-right bg-color-darken">14</span></span> </span> </a>
            </li>
            <li>
                <a href="#ajax/calendar.html" class="jarvismetro-tile big-cubes bg-color-orangeDark"> <span class="iconbox"> <i class="fa fa-calendar fa-4x"></i> <span>Calendar</span> </span> </a>
            </li>
            <li>
                <a href="#ajax/gmap-xml.html" class="jarvismetro-tile big-cubes bg-color-purple"> <span class="iconbox"> <i class="fa fa-map-marker fa-4x"></i> <span>Maps</span> </span> </a>
            </li>
            <li>
                <a href="#ajax/invoice.html" class="jarvismetro-tile big-cubes bg-color-blueDark"> <span class="iconbox"> <i class="fa fa-book fa-4x"></i> <span>Invoice <span class="label pull-right bg-color-darken">99</span></span> </span> </a>
            </li>
            <li>
                <a href="#ajax/gallery.html" class="jarvismetro-tile big-cubes bg-color-greenLight"> <span class="iconbox"> <i class="fa fa-picture-o fa-4x"></i> <span>Gallery </span> </span> </a>
            </li>
            <li>
                <a href="#ajax/profile.html" class="jarvismetro-tile big-cubes selected bg-color-pinkDark"> <span class="iconbox"> <i class="fa fa-user fa-4x"></i> <span>My Profile </span> </span> </a>
            </li>
        </ul>
    </div>
    
    <jsp:include page="/WEB-INF/jsp/include/inc_plugins_script.jsp" flush="false"/>
    <div id="login_rd"></div>    
    <div id="signup_rd"></div>
    
    <script type="text/javascript">
    loginDialogCall();
    signupDialogCall();

    </script>
    
    </body>

</html>