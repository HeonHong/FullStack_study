<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO" 
import="board.dao.BoardDAO"
import = "java.util.List"
import = "java.util.HashMap"
import = "java.util.Map"
import = "board.bean.BoardPaging"
%>    

<%
//데이터
int pg;
if(request.getParameter("pg")!=null) {
	pg=Integer.parseInt(request.getParameter("pg"));
}else pg=1;

int endNum = pg*5;
int startNum = endNum-4;
//DB
BoardDAO boardDAO = BoardDAO.getInstance();

Map<String, Integer> map = new HashMap<String, Integer>();
//map은 인터페이스이다. hashmap이 전체 오버라이드 되어있어서 이걸로 객체 생성해야한다.
map.put("startNum",startNum);
map.put("endNum",endNum);

List<BoardDTO> list = boardDAO.boardList(map);
int totalA = boardDAO.getTotalA();
//int paging = (TotalA + 4)/5;


//페이징 처리
BoardPaging boardPaging = new BoardPaging();
boardPaging.setCurrentPage(pg);
boardPaging.setPageBlock(3);
boardPaging.setPageSize(5);
boardPaging.setTotalA(totalA);
boardPaging.makePagingHTML();

%>
    
<!DOCTYPE html>
<html>
<head>
<style type ="text/css">
#pagingDIV{
/* boreder:1px solid red; */
width : 950px; 
text-align : center;
margin-top : 10px;
}

#currentPaging{
border : 1px solid blue;
text-decoration : underline;
padding : 7px 10px;
margin : 3px;
color : red;
cursor : pointer;
}

#paging{
	/* border : 1px solid blue; */
	cursor : pointer;
	margin : 3px;
}

#currentPaging > span{
	text-align : left;
}

#table td{
 color:black;
 text-decoration : none;
}
#table td:hover{
 color:green;
 text-decoration : underline;
}

span{
float : left;
}

#pagingDIV{
float : center;
}
</style>
<meta charset="UTF-8">
</head>
<body>
<!-- 확장 for문 사용하면 list.get(i)대신 BoardDTO로 바꿔줘야한다. -->
<table id="table" border = "1" cellpadding ="5" frame ="hsides" rules ="rows">
<tr>
<th style="width : 50px">글번호</th>
<th style="width : 250px">제목</th>
<th style="width : 100px">작성자</th>
<th style="width : 50px">조회수</th>
<th style="width : 100px">작성일</th> 
</tr>
<%if(list!=null){for(int i=0;i<list.size();i++){
		
%>
<tr>
<th align = "center"><%=list.get(i).getSeq()%></th>
<td class = "subjectA"><%=list.get(i).getSubject()%></td>
<td align = "center"><%=list.get(i).getName()%></td>
<td align = "center"><%=list.get(i).getHit()%></td>
<td align = "center"><%=list.get(i).getLogtime()%></td>
<!-- new SimpleDateFormat("yyyy.MM.dd").format(boardDTO.getLogtime()) 
이거를 이 페이지에서 처리해서 사용하는 방법도 있다. -->
</tr>
<%}%>
</table>
<div id = "pagingDIV"><span onclick = "location.href = '../index.jsp'">홈페이지</span><%=boardPaging.getPagingHTML()%></div>

<%//for(int i=1;i<=paging;i++){ %>

	<%//if(i==pg){ %>
	<%-- <span style="border:1px solid"><a id = "currentPaging" href ="boardList.jsp?pg=<%=i%>"> <%=i %> </a></span> --%>
	
	<%}//else {%>
	<%-- <a href ="boardList.jsp?pg=<%=i%>"> <%=i %> </a> --%>
	
<%		/* } 
	} 
}else{response.sendRedirect("../index.jsp");} */
%>

<script type="text/javascript">
function boardPaging(pg){
/* 스크립트 형태가 없어서 그냥 pg값 받으면 됨 */
	location.href="boardList.jsp?pg=" + pg; 
}
</script>
</body>
</html>