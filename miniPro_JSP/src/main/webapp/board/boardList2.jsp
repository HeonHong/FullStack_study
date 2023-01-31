<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page 
import="board.bean.BoardDTO" 
import="board.dao.BoardDAO"
import = "java.util.HashMap"
import = "java.util.List"
import = "java.util.Map"
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<style type ="text/css">

#currentPaging{
color : red;
text-decoration : underline;
font-size : 15pt;
}

#paging{
color : black;
text-decoration : none;
}
</style>
<meta charset="UTF-8">
</head>
<body>

<%
//데이터

//DB
BoardDAO boardDAO = BoardDAO.getInstance();
List<BoardDTO> list = boardDAO.boardlist();


if(list!= null){
for(int i=0; i<list.size();i++){
%>
<!-- 확장 for문 사용하면 list.get(i)대신 BoardDTO로 바꿔줘야한다. -->
<table border = '1' width = '600' cellpadding ='5' cellspacing = '0'>
<tr>
<th>작성자</th>
<td width ="200"><%=list.get(i).getName()%></td>
<th>작성일</th> 
<td width ="200"><%=list.get(i).getLogtime()%></td>
</tr>

<tr>
<th>이메일</th>
<td colspan = "3"><%=list.get(i).getEmail()%></td>
</tr>

<tr>
<th>홈페이지</th>
<td colspan = "3"><%=list.get(i).getId()%></td>
</tr>

<tr>
<th>제목</th>
<td colspan = "3"><%=list.get(i).getSubject()%></td>
</tr>

<td colspan = "4"><pre><%=list.get(i).getContent()%></pre></td>
<!-- pre태그를 이용하여 출력 시 줄바꿈을 반영하여 보여줘야한다. -->
</tr>
</table>
<hr border = "1">
<%} //for
}//if%>


</body>
</html>