<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
int pg = Integer.parseInt(request.getParameter("pg"));
int seq = Integer.parseInt(request.getParameter("seq"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>
페이지 값 : <%=pg%><br>
시퀀스 값 : <%=seq %><br>
</h3>
</body>
</html>