<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO" 
import="board.dao.BoardDAO"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<%


request.setCharacterEncoding("UTF-8");//한글처리 꼭하기!!!
String id = request.getParameter("id");
String name = request.getParameter("name");
String email = request.getParameter("email");
String subject = request.getParameter("subject");
String content = request.getParameter("content");

BoardDTO boardDTO = new BoardDTO();
boardDTO.setId(id);
boardDTO.setName(name);
boardDTO.setEmail(email);
boardDTO.setSubject(subject);
boardDTO.setContent(content);

System.out.println(id);
System.out.println(name);
System.out.println(email);
System.out.println(subject);
System.out.println(content);

BoardDAO boardDAO = BoardDAO.getInstance();
int su = boardDAO.boardWrite(boardDTO);


//응답
if(su==1){%>
	작성하신 글을 저장하였습니다.<%
}else{%>
	저장된 내용이 없습니다.<%
}
%> 
<br>
<input type ="button" value = "뒤로가기" onclick = "history.go(-1)">
<!-- 큰따옴표면 안에 따옴표, 작은따옴표면 큰따옴표로 내부 설정 --> 
<!-- history.go(-1) -->
<button type = "button" onclick = "location.href= 'boardList.jsp?pg=1'">글목록</button>
<!-- "location.href= '/guestJSP/board/boardList.jsp';" -->

</body>
</html>