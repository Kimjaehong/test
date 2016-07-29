<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
     <head>
     <meta charset="utf-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1">
     <title>Spring security</title>

     <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
     <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
     </head>

     <body>

     <h1>${user_name} 로그인 성공!!</h1>
     
     <form action="<c:url value="/logout" />" method="post">
<%--      <a href="<c:url value="/logout" />">Logout</a> --%>
        <button type="submit" class="btn">Log out</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
     </form>
     </body>

</html>