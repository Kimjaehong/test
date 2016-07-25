<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자 정보</title>
</head>
<body>

<form>
<label>아이디</label>
    <input type="text" id="userId" name="userId"/>
<label>패스워드</label>
    <input type="password" id="password" name="password"/>
</form>
<button type="submit" class="btn">Log in</button>
<%-- <c:url value="/login" var="loginUrl"/>
<form action="${loginUrl}" method="post">       
    <c:if test="${param.error != null}">        
        <p>로그인페이지</p>
    </c:if>
    <c:if test="${param.logout != null}">       
    </c:if>
    <p>
        <label for="username">Username</label>
        <input type="text" id="username" name="username"/>  
    </p>
    <p>
        <label for="password">Password</label>
        <input type="password" id="password" name="password"/>  
    </p>
    <input type="hidden"                        
        name="${_csrf.parameterName}"
        value="${_csrf.token}"/>
    <button type="submit" class="btn">Log in</button> 
</form>--%>

</body>
</html>