<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/* String name = request.getParameter("namerara");*/
//String name = (String)session.getAttribute("memName"); //자식 = 부모 관계

//쿠키
String name=null;
String id=null;

//특정 쿠키를 얻을 수 없으므로 모든 쿠키를 다 가져온다.
Cookie[] ar = request.getCookies();
if(ar!=null){
	for(int i=0;i<ar.length;i++){
		String cookieName = ar[i].getName();//쿠키명
		String cookieValue = ar[i].getValue();//쿠키값
		
		System.out.println("쿠키명 = " + cookieName);
		System.out.println("쿠키값 = " + cookieValue);
		System.out.println();
		
		if(cookieName.equals("memName")) name = cookieValue;
		if(cookieName.equals("memId")) id = cookieValue;
	}//for
	
	
}
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><%=name %>로그인 성공하였습니다.</h3>
<br>
<input type ="button" value="로그아웃" onclick="location.href='logout.jsp'">
</body>
</html>