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
        <meta name="_csrf" content="${_csrf.token}"/>
        <!-- default header name is X-CSRF-TOKEN -->
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
               <%--  <form action="<c:url value="/logout"/>" method="post">
                   <button type="submit" class="btn">Log out</button>
                </form> --%>
                <span><a href="javascript:void(0);" id="btn_logout" class="fs-13 pd-rl7 btn-danger" title="로그아웃" onclick="f_logout();"> 로그아웃 </a></span>
            </div>
            <div class="pull-right">
                <div style="margin-top: 10px; padding: 3px;"><c:out value="${sessionScope.userName}" /> 님(<c:out value="${sessionScope.adminConnTime}" />)</div>
            </div>
            	</c:otherwise>
            </c:choose>
        </div>
    </header>
    
    <aside id="left-panel">
        <!-- User info -->
        <%-- <jsp:include page="/WEB-INF/jsp/include/inc_login_user.jsp" flush="false"/> --%>
        
        <!-- left menu -->
        <jsp:include page="/WEB-INF/jsp/include/inc_left_menu.jsp" flush="false"/>
    </aside>
        
    <div id="main" role="main">
        <div id="ribbon">
            <span class="ribbon-button-alignment"> 
                <span class="btn btn-ribbon" onclick="f_lnkDashBoard();"><i class="fa fa-home"></i></span> 
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
    
    <jsp:include page="/WEB-INF/jsp/include/inc_plugins_script.jsp" flush="false"/>
    <div id="login_rd"></div>    
    <div id="signup_rd"></div>
    
    <script type="text/javascript">
    
    $('#login_rd').dialog({
    	autoOpen : false,
    	resizable : false,
    	draggable: false,
    	position: ['center', 10],
    	modal : true,
    	title : '<div class="widget-header"><h4><i class="icon-ok"></i>로그인</h4></div>',
    	buttons : [{
    		html : '취소',
    		'id' : 'btn_login_cancel',
    		'class' : 'btn btn-default',
    		click : function() {
    			$(this).dialog('close');
    		}
    	},
    	{
    		html : '확인',
    		'type':"submit",
    		'id' : 'btn_login',
    		'class' : 'btn btn-primary',
    		 click : function() {
    			 f_login();
    				return false;
    		}
    	}]
    });
    
    
    $('#signup_rd').dialog({
    	autoOpen : false,
    	resizable : false,
    	draggable: false,
    	position: ['center', 10],
    	modal : true,
    	title : '<div class="widget-header"><h4><i class="icon-ok"></i>회원가입</h4></div>',
    	buttons : [{
    		html : '취소',
    		'id' : 'btn_login_cancel',
    		'class' : 'btn btn-default',
    		click : function() {
    			$(this).dialog('close');
    		}
    	},
    	{
    		html : '확인',
    		'type':"submit",
    		'id' : 'btn_login',
    		'class' : 'btn btn-primary',
    		 click : function() {
    				
    				return false;
    		}
    	}]
    });
    </script>
    
    </body>

</html>