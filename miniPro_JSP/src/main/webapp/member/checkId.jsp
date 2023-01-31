<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
   import = "member.dao.MemberDAO"
    %>

    
    
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
</head>
<body>
<form method="" action="checkId.jsp">
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
<script type = "text/javascript">
function checkIdClose(id){
	opener.writeForm.id.value = id;
	opener.writeForm.pwd.focus();
	opener.writeForm.duplication.value = "y";
	window.close();
}
</script>

</body>
</html>