<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="angel" uri="tld" %>
<!-- 커스텀 태그. body태그처럼 나만의 태그를 만들어 준거다. -->    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>자바클래스의 메소드를 이용</h3>

<%-- ${param['x'] } + ${param['y'] } = ${ 자바클래스의 메소드를 이용하여 합을 구하겠당 } <br> --%>
${param['x'] } + ${param['y'] } = ${ angel:sum(param['x'], param['y']) } <br>

</body>
</html>