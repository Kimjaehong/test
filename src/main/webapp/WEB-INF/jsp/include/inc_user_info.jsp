<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.issueking.test.api.common.utils.LangUtil"%>
<%@page import="com.issueking.test.api.common.constant.CommonConstant"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="login-info">
    <span>
      <c:choose>
    <c:when test="${sessionScope.userId eq null || sessionScope.userId eq ''}">
     <span></span>        
    </c:when>
    <c:otherwise>
    <a href="javascript:void(0);" id="show-shortcut" data-action="toggleShortcut">
        <span>
            <i class="fa fa-user"></i><c:out value="${sessionScope.userName}" /><i class="fa fa-angle-down"></i>
        </span>
    </a>
    </c:otherwise>
    </c:choose>
    </span>
</div>