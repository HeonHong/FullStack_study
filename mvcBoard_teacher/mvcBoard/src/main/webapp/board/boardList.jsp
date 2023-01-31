<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#pagingDiv {
	text-align: center;
	width: 900px;
	margin-top: 10px;
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
	cursor: pointer;
	padding: 5px 10px;
	margin: 2px;
}

.subjectA:link { color: black; text-decoration: none; }
.subjectA:visited { color: black; text-decoration: none; }
.subjectA:hover { color: green; text-decoration: underline; }
.subjectA:active { color: black; text-decoration: none; }
</style>
</head>
<body>
<c:if test="${requestScope.list != null }">
	<table border="1" cellpadding="5" frame="hsides" rules="rows">
		<tr>
			<th style="width: 100px">글번호</th>
			<th style="width: 400px">제목</th>
			<th style="width: 100px">작성자</th>
			<th style="width: 100px">조회수</th>
			<th style="width: 200px">작성일</th>
		</tr>
		
		<c:forEach var="boardDTO" items="${list }">
			<tr>
				<td align="center">${boardDTO.seq }</td>
				<td>
					<a href="#" class="subjectA" onclick="isLogin('${id }', ${boardDTO.seq }, ${pg })">${boardDTO.subject }</a>
				</td>
				<td align="center">${boardDTO.id }</td>
				<td align="center">${boardDTO.hit }</td>
				<td align="center"><fmt:formatDate value="${boardDTO.logtime }" pattern="yyyy.MM.dd"/></td>
			</tr>
		</c:forEach>
	</table>
	
	<div style="display: inline-block;">
		<div id="pagingDiv">${boardPaging.pagingHTML }</div>
	</div>
</c:if>

<script type="text/javascript">
function boardPaging(pg) {
	location.href = "boardList.do?pg=" + pg;
}

function isLogin(id, seq, pg){
	if(id == 'null') 
		alert("먼저 로그인하세요");
	//else
		//location.href="boardView.jsp?seq=" + seq + "&pg="+pg;
}
</script>
</body>
</html>



















