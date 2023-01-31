<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border ="1">

	<%-- <%=k%>*<%=i%>=<%=k*i%> --%>
	<!-- /t은 왜 안되는지. 이건 그냥 html에서 지원을 안하는거다-->
	<!-- for문같은 것들은 jsp에서 처리를해서 html에 뿌려주는 거다. -->
	
	<%
for(int i=1;i<=9;i++){%>
<tr>
<%for(int k=2;k<=9;k++){
%>
	<td width ="100">&emsp;<%=k+"*"+i +"="+ k*i%></td>
	
	<%}%>
	<tr>
<%}%>
</body>
</html>