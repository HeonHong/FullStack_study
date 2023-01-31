<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/* String name = request.getParameter("namerara");*/
String name = (String)session.getAttribute("memName");
String id = (String)session.getAttribute("memId");
String email = (String)session.getAttribute("memEmail");
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
</head>
<body>
<h2><%=id %></h2>
<h3><%=name %>님 로그인 성공하였습니다.</h3>
<h3>E-mail : <%=email %></h3>
<br>
<input type ="button" value="메인화면" onclick="location.href='../index.jsp'">
<input type ="button" value="로그아웃" onclick="location.href='logout.jsp'">
</body>
</html>