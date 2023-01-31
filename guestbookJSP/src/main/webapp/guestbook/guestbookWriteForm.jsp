<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
div{
color : red;
font-size : 8pt;
font-weight : bold;
}
</style>
</head>
<body>
<h3>글쓰기</h3>
<form name = "guestbookWrite" method = "get" action ="guestbookWrite.jsp">
<table border = "1" cellpadding = "3" cellspacing="0">
<tr>
<th>작성자</th>
<td><input type = "text" name = "name" id = "name" placeholder = "작성자 입력" size = "20"></td>
</tr>
<tr>
<th>이메일</th>
<td><input type = "text" name = "email" id = "email" placeholder = "작성자 입력" size = " 30"></td>
</tr>
<tr>
<th>홈페이지</th>
<td><input type = "text" name = "homepage" id = "homepage" value = "http://" size = " 40">
</td>
</tr>
<tr>
<th>제목</th>
<td><input type = "text" name = "subject" id = "subject" placeholder = "제목입력" size = "50">
<div id = "subjectDIV"></div>
</td>
</tr>
<tr height = "200">
<th>내용</th>
<td>
<textarea name="contents" id="contents" placeholder="내용입력" rows="18" cols = "50"></textarea>
<!-- textarea에서는 태그 마감할 때 띄어놓고 끝내지 말 것. 그러면 공백값 생겨서 들어감. --> 
<div id = "contentsDIV"></div>
</td>
</tr>
<tr>
<td colspan = "2" align = "center">
<input type = "button" value = "글작성" onclick = "checkwrite()">
<input type = "reset" value = "초기화" >
<button type = "button" onclick = "location.href= 'guestbookList.jsp?pg=1'">글목록</button>
<!-- 페이징처리하기
번호 안써주면 무조건 1페이지로 간다.
예약어가 걸려있어서 page라는 변수명을 사용하면 안된다.
 -->
</td>
</tr>

</table>
</form>

<script src="../javascript/writeJS.js"></script>
<!--  제발 이것도 까먹지 말자.... 적용할려면 어느 스크립트인지 알아야할 거 아냐...... -->  
</body>
</html>