<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div{
color : red;
font-size : 8pt;
font-weight : bold;
}
</style>
</head>
<body>
<form  name = "loginForm" method = "post" action = "http://localhost:8080/memberJSP/member/longin.jsp">
<table border="1" cellpadding = "3">
<tr>
<th>아이디</th>
<td><input type = "text" name = "id" id="id" placeholder = "아이디 입력">
 <div id="idDIV"></div>

</tr>

<tr>
<th>비밀번호</th>
<td><input type = "password" name = "pwd" id="pwd" placeholder = "비밀번호 입력">
 <div id="pwdDIV"></div>
</tr>

<tr>
<td colspan ="2" align = "center">
<input type = "button" value = "로그인" onclick="checkLogin()">
<input type = "button" value = "회원가입" onclick="writeForm()" > <!-- "location.href=''" -->
<!-- button type = "button" onclick = "checkLogin()" -->
<!-- button type = "button" onclick = "" -->
</td>
</tr>

</table>
</form>

<script src="../js/login.js"></script>


</body>
</html>