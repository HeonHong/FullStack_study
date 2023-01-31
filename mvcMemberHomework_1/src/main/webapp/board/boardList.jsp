<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.bean.BoardPaging"%>
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


<c:if test ="${list!=null }">
	<table id = "table" border="1" cellpadding="5" frame="hsides" rules="rows">
		<tr>
			<th style="width: 100px">글번호</th>
			<th style="width: 400px">제목</th>
			<th style="width: 100px">작성자</th>
			<th style="width: 100px">조회수</th>
			<th style="width: 200px">작성일</th>
		</tr>
	
	<c:forEach var="boardDTO" items="${list}">
		<tr>
				<td align="center">${ boardDTO.getSeq()}</td>
				<td onclick = "isLogin(${ boardDTO.getSeq()}, ${boardPaging.getCurrentPage()} )">
									${ boardDTO.getSubject()}
				<!-- 여기서 ''를 해야하나? -->
				</td>
				<td align="center">${ boardDTO.getId() }</td>
				<td align="center">${ boardDTO.getHit()}</td>
				<td align="center">${ boardDTO.getLogtime()}</td>
			</tr>
	</c:forEach>
	</table>
</c:if>

<div id="pagingDiv"><button id="link" onclick = "location.href = '../index.jsp'">홈페이지</button>${ boardPaging.getPagingHTML()}</div>


<script type="text/javascript">

function boardPaging(pg) {
	location.href = "boardList.jsp?pg=" + pg;
}

function isLogin(seqNum, pg){
	
	<%
	String name = (String)session.getAttribute("memName");
	if(name==null){%> /* 만약에 선생님처럼 이미지 태그에서 id 세션을 보내주고 스크립트형식으로 작성했으면 'null'값을 비교해야한다. */
	alert("먼저 로그인 하세요");
	<%}else{%>
		location.href = 'boardView.jsp?seq=' + seqNum +'&pg=' + pg;
	
	<%}%>
}
</script>
</body>
</html>


<!-- onclick isLogin에 그냥 getSeq넘버를 보내는건 안되나?  된다.-->













