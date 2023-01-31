<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="guestbook.bean.GuestbookDTO" 
import="guestbook.dao.GuestbookDAO"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<%

//데이터
request.setCharacterEncoding("UTF-8");//한글처리 꼭하기!!!
String name = request.getParameter("name");
String email = request.getParameter("email");
String homepage = request.getParameter("homepage");
String subject = request.getParameter("subject");
String contents = request.getParameter("contents");

GuestbookDTO guestbookDTO = new GuestbookDTO();//데이터를 옮기기에 용이
guestbookDTO.setName(name);
guestbookDTO.setEmail(email);
guestbookDTO.setHomepage(homepage);
guestbookDTO.setSubject(subject);
guestbookDTO.setContents(contents);

//db
GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();

int su = guestbookDAO.guestbookWrite(guestbookDTO);//guestbookDTO를 보내줘야하니까 매개변수 꼭 작성!!

//응답
%><img src="../img/네이버.png" width="50" height ="50" 
onclick = "location.href= 'guestbookList.jsp';" style ="cursor :pointer">
<%if(su==1){%>
	작성하신 글을 저장하였습니다.<%
}else{%>
	저장된 내용이 없습니다.<%
}
%> 
<br>
<input type ="button" value = "뒤로가기" onclick = "history.go(-1)">
<!-- 큰따옴표면 안에 따옴표, 작은따옴표면 큰따옴표로 내부 설정 --> 
<!-- history.go(-1) -->
<button type = "button" onclick = "location.href= 'guestbookList.jsp';">글목록</button>
<!-- "location.href= '/guestJSP/guestbook/guestbookList.jsp';" -->

</body>
</html>