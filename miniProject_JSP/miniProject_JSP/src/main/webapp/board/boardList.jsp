<%@page import="board.bean.BoardPaging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO"%>
<%@ page import="board.dao.BoardDAO"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>

<%
//데이터
int pg;
int seqNum;
if(request.getParameter("pg")==null) pg =1;
else pg = Integer.parseInt(request.getParameter("pg"));

//1페이지당 5개씩
int endNum = pg*5;
int startNum = endNum - 4;

Map<String, Integer> map = new HashMap<String, Integer>();
map.put("startNum", startNum);
map.put("endNum", endNum);

//DB
BoardDAO boardDAO = BoardDAO.getInstance();
List<BoardDTO> list = boardDAO.boardList(map);

//페이징 처리
int totalA = boardDAO.getTotalA(); //총글수

BoardPaging boardPaging = new BoardPaging();
boardPaging.setCurrentPage(pg);
boardPaging.setPageBlock(3);
boardPaging.setPageSize(5);
boardPaging.setTotalA(totalA);
boardPaging.makePagingHTML();

//응답
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#pagingDiv {
	/* border: 1px solid red; */
	text-align: center;
	width: 950px;
	margin-top: 10px;
	display : inline-block;
	/* 그냥 바깥 이미지 태그로 했을 경우 */
	/* 둘 다 float걸기 */
	/* 만약에 밖에 div태그 하나 더 추가할 거면 인라인 블록으로 지정할 것 */
	/* 대신 마지막에 clear both 해줘야함 */
}

#currentPaging {
	border: 1px solid blue;
	padding: 5px 10px;
	margin: 2px;
	color: red;
	text-decoration: underline;
	cursor: pointer;
}

#paging {
	/* border: 1px solid blue; */
	cursor: pointer;
	padding: 5px 10px;
	margin: 2px;
}

#table td{
 color:black;
 text-decoration : none;
}
#table td:hover{
 color:green;
 text-decoration : underline;
}

div > button{
float: left;
}

a.subjectA:link{ color : black; text-decoration : none;}
a.subjectA:visited{color : black; text-decoration : none;}
a.subjectA:hover{color : green; text-decoration : underline;}
a.subjectA:active{color : black; text-decoration : none;}
</style>
</head>
<body>
<% if(list != null){ %>
	<table id = "table" border="1" cellpadding="5" frame="hsides" rules="rows">
		<tr>
			<th style="width: 100px">글번호</th>
			<th style="width: 400px">제목</th>
			<th style="width: 100px">작성자</th>
			<th style="width: 100px">조회수</th>
			<th style="width: 200px">작성일</th>
		</tr>
		
		<%for(BoardDTO boardDTO : list) {
			seqNum = boardDTO.getSeq();%>
			<tr>
				<td align="center"><%= boardDTO.getSeq() %></td>
				<td onclick = "isLogin(<%=seqNum%>)">
				<!-- 	<a href="" class="subjectA" onclick = "isLogin('id')"> -->
					<%= boardDTO.getSubject() %>
				<!-- 	</a> -->
				</td>
				<td align="center"><%= boardDTO.getId() %></td>
				<td align="center"><%= boardDTO.getHit() %></td>
				<td align="center"><%= new SimpleDateFormat("yyyy.MM.dd").format(boardDTO.getLogtime()) %></td>
			</tr>
		<%}//for %>
	</table>
	<div id="pagingDiv"><button id="link" onclick = "location.href = '../index.jsp'">홈페이지</button><%=boardPaging.getPagingHTML() %></div>
<%}//if %>

<script type="text/javascript">

function boardPaging(pg) {
	location.href = "boardList.jsp?pg=" + pg;
}
function isLogin(seqNum){
	
	<%
	String name = (String)session.getAttribute("memName");
	if(name==null){%> /* 만약에 선생님처럼 이미지 태그에서 id 세션을 보내주고 스크립트형식으로 작성했으면 'null'값을 비교해야한다. */
	alert("먼저 로그인 하세요");
	<%}else{%>
		location.href = 'boardView.jsp?seq=' + seqNum +'&pg=' + <%=pg%>;
	
	<%}%>
}
</script>
</body>
</html>


<!-- onclick isLogin에 그냥 getSeq넘버를 보내는건 안되나?  된다.-->













