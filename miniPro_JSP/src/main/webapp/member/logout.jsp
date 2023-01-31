<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
session.removeAttribute("memName");
/* session.invalidate(); */ /* - 세션이 여러개일 때 한꺼번에 없애는 것임. */ 
response.sendRedirect("../index.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>