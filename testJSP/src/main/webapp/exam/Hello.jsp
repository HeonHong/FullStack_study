<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%-- <%@는 설정 잡아주는 역할 --%>
    
    <%! //전역변수, 한 번만 처리된다.
    String name= "홍길동";
    int age = 25;%>
    
    
    
    <%//스크립트릿, 요청시마다 호출된다. age++; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Hello JSP!!<br> 웹까지는 도착하되 외부에 보이지 않는 것이다. -->
<%-- 안녕하세요 JSP!!<br> 이건 아예 페이지 소스에서도 확인 불가능함.--%>
Hello JSP!! <br>
안녕하세요 JSP!!<br>
나의 이름은 <%=name%>입니다.<br>
나의 이름은 <%out.print(name);%>입니다.<br>
<!--내 나이는 <%=age%>살 입니다.<br>  html주석은 수행까지도 한다.-->
<%-- 내 나이는 <%=age%>살 입니다.<br> --%>
</body>
</html>

