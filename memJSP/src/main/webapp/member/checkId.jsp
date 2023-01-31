<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.dao.MemberDAO"%>
<%
//데이터

String id = request.getParameter("id");

//DB
MemberDAO memberDAO = MemberDAO.getInstance();//싱글톤
boolean exist = memberDAO.isExistId(id); //아이디가 있으면 true > 사용불가능
 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="" action="checkId.jsp"><!-- 재귀 파일 -->
<%if(exist){%>
<%=id%>는 사용 불가합니다.
<br>
<input type = "text" name = "id">
<input type = "submit" name = "id" value = "중복체크">

<%}else{%>
<%=id%>는 사용 가능합니다.
<input type = "button" value="사용하기" onclick = "checkIdClose('<%=id%>')">

<%}%>
</form>
<!-- 자바스크립트 쪽으로 옮길 때 스크립트에 자료형이 없어서 문자면 꼭 ""해줘야한다. -->
<script type = "text/javascript">
function checkIdClose(id){
	/* 여기서는 document를 사용하면 안된다. 왜냐면 document는 내 body태그 안에 있는 자밥스크립트의 객체이기때문이다. */
	/* document.writForm.id.value */
	var count = 1;
	opener.WriteF.id.value = id;
	opener.WriteF.pwd.focus();
	opener.WriteF.duplication.value = "y";
	window.close();
}
</script>
</body>
</html>