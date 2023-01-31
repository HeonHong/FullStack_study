<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="guestbook.bean.GuestbookDTO" 
import="guestbook.dao.GuestbookDAO"
import = "java.util.ArrayList"
import = "java.util.HashMap"
import = "java.util.Map"
%>    
    
<%
//데이터
int pg;
if(request.getParameter("pg") != null){
pg = Integer.parseInt(request.getParameter("pg"));
}else pg=1;

//페이징 처리 - 1페이지당 3개씩
int endNum = pg*3;
int startNum = endNum-2;

//DB
GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();

Map<String, Integer> map = new HashMap<String, Integer>();
//map은 인터페이스이다. hashmap이 전체 오버라이드 되어있어서 이걸로 객체 생성해야한다.
map.put("startNum",startNum);
map.put("endNum",endNum);

ArrayList<GuestbookDTO> list = guestbookDAO.guestbooklist(map);


int totalA = guestbookDAO.getTotalA();
int totalPage = (totalA + 2)/3;
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
if(list!= null){
for(int i=0; i<list.size();i++){
%>
<!-- 확장 for문 사용하면 list.get(i)대신 guestbookDTO로 바꿔줘야한다. -->
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
<td colspan = "3"><%=list.get(i).getHomepage()%></td>
</tr>

<tr>
<th>제목</th>
<td colspan = "3"><%=list.get(i).getSubject()%></td>
</tr>

<tr>
<td colspan = "4"><pre><%=list.get(i).getContents()%></pre></td>
<!-- pre태그를 이용하여 출력 시 줄바꿈을 반영하여 보여줘야한다. -->
</tr>
</table>
<hr border = "1">
<%} //for
}//if%>

<!-- 페이지 번호 -->
<%for(int i=1;i<=totalPage;i++){ %>

	<%if(i==pg){ %>
	<span style="border:1px solid"><a id = "currentPaging" href ="guestbooklist.jsp?pg=<%=i%>"><%=i %></a></span>
	
	<%}else {%>
	<a href ="guestbookList.jsp?pg=<%=i%>"><%=i %></a>
	&emsp;
<%} 
} %>

</body>
</html>