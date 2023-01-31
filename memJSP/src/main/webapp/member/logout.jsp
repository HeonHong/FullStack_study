<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
/* session.removeAttribute("memName"); */
/* session.invalidate(); */ /* - 세션이 여러개일 때 한꺼번에 없애는 것임. */ 
Cookie[] ar = request.getCookies();
if(ar!=null){
	for(int i=0;i<ar.length;i++){
		if(ar[i].getName().equals("memName")){
			ar[i].setMaxAge(0);
			response.addCookie(ar[i]);
		}
		
		if(ar[i].getName().equals("memId")){
			ar[i].setMaxAge(0);
			response.addCookie(ar[i]);
		}
		
	}

}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그아웃
<input type = "button" value = "로그인 페이지로" onclick = "location.href='loginForm.jsp'">
</body>
</html>