<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
div{
color : red;
font-size : 8pt;
font-weight : bold;
}
</style>
</head>
<body>
<%
String name = (String)session.getAttribute("memName");
String id = (String)session.getAttribute("memId");
String email = (String)session.getAttribute("memEmail");
if(name==null){
%>

<form  name = "loginForm" method = "post" action = "http://localhost:8080/miniPro_JSP/member/login.jsp">
<table border="1" cellpadding = "5" cellspacing ="0">

<tr>
<th>아이디</th>
<td><input type = "text" name = "id" id="id" placeholder = "아이디 입력">
<div id="idDIV"></div>
</td>
</tr>

<tr>
<th>비밀번호</th>
<td><input type = "password" name = "pwd" id="pwd" placeholder = "비밀번호 입력">
 <div id="pwdDIV"></div>
 </td>
</tr>

<tr>
<td colspan ="2" align = "center">
<input type = "button" value = "로그인" onclick="checkLogin()">
<input type = "button" value = "회원가입" onclick="location.href='http://localhost:8080/miniPro_JSP/member/writeForm.jsp'" > 
<input type ="button" value="글 쓰기" onclick="location.href='http://localhost:8080/miniPro_JSP/board/boardWriteForm.jsp'">
<input type ="button" value="글 목록" onclick="location.href='http://localhost:8080/miniPro_JSP/board/boardList.jsp?pg=1'">
</td>
</tr>

</table>
</form>

<script src="./js/member.js"></script>
<%}else{ 
%>
<form>
<table border="1" cellpadding = "5" cellspacing ="0">
<tr>
	<th><%=name %>님<th>
	<td><%=id %></td> 
</tr>
<tr>
	<td colspan ="2"><%=email %></td>
</tr>
<tr>
	<td colspan ="3" align = "center">
	<input type ="button" value="로그아웃" onclick="location.href='./member/logout.jsp'">
	<input type ="button" value="글 쓰기" onclick="location.href='./board/boardWriteForm.jsp'">
	<input type ="button" value="글 목록" onclick="location.href='./board/boardList.jsp'">
	</td>
</tr>
</table>
</form>
<%} %>


</body>
</html>