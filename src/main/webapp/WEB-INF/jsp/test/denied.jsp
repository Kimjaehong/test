<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
     <head>
     <meta charset="utf-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1">
     <title>Spring security</title>
      <script src=<c:url value="/resources/js/libs/jquery-2.1.1.min.js" />></script>
     <script src="http://malsup.github.com/jquery.form.js"></script> 
     </head>

     <body>

     <h1>권한이 없습니다.</h1>
     
     <form action="<c:url value="/login/signin" />" method="post">
        <button type="submit" class="btn">Log in 페이지 이동</button>
        <%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
     </form>

     </body>

</html>