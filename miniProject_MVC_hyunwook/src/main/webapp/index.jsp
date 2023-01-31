<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mini Project MVC index.jsp</title>
<style>
body {
   margin: 0;
   padding: 0;
   height: 100%;
   width: auto;
}

#header {
   width: 1700px;
   height: 10%;
   text-align: center;
}

#container {
   margin: auto;
   width: 1700px;
   height: 500px;
}

#container:after {
   content: '';
   display: block;
   clear: both;
   float: none;
}

#nav {
   margin-left: 10px;
   /* width: 400px; */
   width: 25%;
   height: 100%;
   float: left;
}

#section {
   width: 70%;
   height: 100%;
   float: left;
}

#footer {
   width: 1700px;
   height: 10%;
}

</style>

</head>
<body>
	<div id="header">
        <h1>
            <img src="https://emoticonstudio.kakao.com/images/thumb_start3.gif" 
            style="cursor: pointer;" width="250" height="70"
            onclick="location.href='/miniProject_MVC/index.jsp'">MVC를 이용한 미니 프로젝트
            <img alt="" src="/miniProject_MVC/img/img2.png" 
            width="70" height="70"
            onclick="location.href='/miniProject_MVC/index.jsp'">
        </h1>
        <jsp:include page="./main/menu.jsp"/>
	</div>

    <div id="container">
        <div id="nav">
            <jsp:include page="./main/nav.jsp"/>
        </div>
        <div id="section">
        	<c:if test="${empty display}">
	            <h1>
	                홈페이지를 방문 해주셔서 감사합니다.<br>
	                Have a nice day!!<br>
	                <img src="https://cdn.class101.net/images/da83309f-dda9-404d-9d12-93e9a4046a3b" 
	                    width= "300px" height="200px" alt="">
	            </h1>
            </c:if>
            <c:if test="${not empty display }">
            	<jsp:include page="${display }"/>
            </c:if>
        </div>
    </div>
    

    <div id="footer">
    </div>
</body>
</html>













