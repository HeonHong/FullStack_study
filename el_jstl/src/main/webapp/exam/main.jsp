<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>** include directive**</h3>
<%@include file = "today.jsp" %> <!-- today의 모든 소스를 가지고 온다. -->
<!-- 포함 후 컴파일. 변수 같은 것들 안 섞이게 잘 선택해야한다.-->

<h3>** include JSP tag**</h3>
<jsp:include page="image.jsp"/> <!-- 안막아주면 페이지 뻗는다! 조심할 것 -->
<!-- 각각 컴파일 후 포함. 이걸 더 선호. -->

<%String name = "홍길동";%>
main.jsp의 name = <%=name %>

</body>
</html>