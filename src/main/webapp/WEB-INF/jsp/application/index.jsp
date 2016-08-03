<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>issue_king 메인</title>
		<meta charset="utf-8">
		<meta name="description" content="">
		<meta name="author" content="">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<!-- #CSS Links -->
		<jsp:include page="/WEB-INF/jsp/include/inc_common_style.jsp" flush="false"/>
		<!-- #COMMON SCRIPT -->
		<jsp:include page="/WEB-INF/jsp/include/inc_common_script.jsp" flush="false"/>
	</head>
  <body class="desktop-detected fixed-header fixed-navigation fixed-ribbon">
  
    <!-- #HEADER -->
    <header id="header">
        <div id="logo-group">
            <%-- <span id="logo"> <img src="${pageContext.request.contextPath}/resources/img/logo.png" alt=""> </span> --%>
        </div>
        <!-- pulled right: nav area -->
        <div class="pull-right">
            <!-- collapse menu button -->
            <div id="hide-menu" class="btn-header pull-right">
                <span> <a href="javascript:void(0);" data-action="toggleMenu" title="Collapse Menu"><i class="fa fa-reorder"></i></a> </span>
            </div>
            <!-- end collapse menu -->

            <!-- logout button -->
            <div id="logout" class="btn-header transparent pull-right">
                <!-- <span> <a href="" title="로그아웃" class="fs-13 pd-rl7"> 로그아웃 </a> </span> -->
                <!-- <a type="button" class="btn" id="logout">로그아웃</a> -->
           <%--  <form action="<c:url value="/logout" />" method="post">
                 <a href="<c:url value="/logout" />">Logout</a>
                    <button type="submit" class="btn">Log out</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                 </form> --%>
            </div>
            <!-- end logout button -->
            
            
            <!-- update userInfo button -->
            <!-- <div class="btn-header transparent pull-right">
                <span> <a href="javascript:void(0);" id="btn_myinfo" class="fs-13 pd-rl7" title="정보수정" onclick="f_myInfoUN();"> 정보수정 </a> </span>
            </div> -->
            <div class="btn-header transparent pull-right">
                <span> <a href="javascript:void(0);" id="btn_signup" class="fs-13 pd-rl7 btn-danger" title="회원가입" onclick="f_signupOpen();"> 회원가입 </a> </span>
            </div>
            <!-- login button -->
            <div class="btn-header transparent pull-right">
                <span> <a href="javascript:void(0);" id="btn_login" class="fs-13 pd-rl7 btn-primary" title="로그인" onclick="f_LoginOpen();"> 로그인 </a> </span>
            </div>
        </div>
            <%-- <div class="pull-right">
                <div style="margin-top: 10px; padding: 3px;"><c:out value="${sessionScope.adminNm}" /> 님(<c:out value="${sessionScope.adminConnTime}" />)</div>
            </div> --%>
            <!-- end pulled right: nav area -->
            
    </header>
    <!-- END HEADER -->
        <!-- #NAVIGATION -->
        <aside id="left-panel">
            <!-- User info -->
            <%-- <jsp:include page="/WEB-INF/jsp/include/inc_login_user.jsp" flush="false"/> --%>
            
            <!-- left menu -->
            <%-- <jsp:include page="/WEB-INF/jsp/include/inc_left_menu.jsp" flush="false"/> --%>
        </aside>
        <!-- END NAVIGATION -->
        
        <!-- #MAIN PANEL -->
        <div id="main" role="main">
            <!-- RIBBON -->
            <div id="ribbon">
                <span class="ribbon-button-alignment"> 
                    <span class="btn btn-ribbon" onclick="f_lnkDashBoard();"><i class="fa fa-home"></i></span> 
                </span>
                <ol class="breadcrumb">
                </ol>
            </div>
            <!-- END RIBBON -->
            <!-- 로그인 화면 -->
            <jsp:include page="/WEB-INF/jsp/application/login.jsp" flush="false"/>
            <!-- 회원가입 화면 -->
            <jsp:include page="/WEB-INF/jsp/application/signup.jsp" flush="false"/>
            <!-- 내 정보 수정 -->
           <%--  <jsp:include page="/WEB-INF/jsp/include/inc_myinfo.jsp" flush="false"/> --%>
            
            <!-- #MAIN CONTENT -->
            <div id="content">

            </div>
            <!-- END #MAIN CONTENT -->
        </div>
        <!-- END #MAIN PANEL -->
        
        <!-- #PAGE FOOTER -->
        <div class="page-footer">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <span class="txt-color-white pull-right"> <span class="hidden-xs"> - Copyright</span> © 2016 <span class="hidden-xs">All rights reserved.</span></span>
                </div>
            </div>
        </div>
        <!-- END FOOTER -->
        <!--[if IE 8]>
            <h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
        <![endif]-->
        
        <!-- #LoginView -->
        
        <!-- #PLUGINS -->
        <jsp:include page="/WEB-INF/jsp/include/inc_plugins_script.jsp" flush="false"/>
        
<script type="text/javascript">
/* $('#mcht_search_rd').dialog({
	autoOpen : false,
	resizable : false,
	modal : true,
	width : 1024,
	minHeight : 768,
	title : '<div class="widget-header"><h4><i class="icon-ok"></i> 가맹점검색 </h4></div>',
	buttons : [{
		html : '확인',
		'class' : 'btn btn-primary',
		click : function() {
			$(this).dialog('close');
		}
	}]
}); */
</script>
  </body>

</html>