<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- for(String data:list) -->
<c:forEach var="data" items = "${requestScope.list }">
${data }<br><!-- setAttribute값을 받아오는 것이다.  getParamersms param-->
</c:forEach>
<br><br>


list = ${list }<br> <!-- 위에 forEach랑 다르게 나온다. -->
<!-- 결과값에 나오는 []는 리스트를 의미한다 -->
list[2] = ${list[2] } 
<br>

<!-- pageScope.list에서 찾는다 > list는 pagescope에 없다
> requestScope에서 찾는다. -->
<%-- for(PersonDTO personDTO : list2) --%>
<c:forEach var="personDTO" items="${list2 }">
	이름=${personDTO.getName() }  &emsp; 나이=${personDTO.getAge() }<br> 
	이름=${personDTO.name }  &emsp; 나이=${personDTO.age }<br> 
<!-- 	이건 절대 메소드거나 웹에서는 직접 접근 가능한게 아니다.
	그냥 메소드를 변수명 처럼 만들어 놓아서 쉽게 사용할 수 있게 만들어 놓은 것이다. -->
</c:forEach>
</body>
</html>