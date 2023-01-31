<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="java.io.IOException"
import="javax.servlet.ServletException"
import= "javax.servlet.annotation.WebServlet"
import= "javax.servlet.http.HttpServlet"
import= "javax.servlet.http.HttpServletRequest"
import= "javax.servlet.http.HttpServletResponse"
import= "member.bean.MemberDTO"
import= "member.dao.MemberDAO"
    %>
<!-- import 윗부분은 선언부라서 가장 위로 두는 게 좋다. -->   
    
<%
//데이터

		request.setCharacterEncoding("UTF-8");
		//post방식일 때는 이렇게 안하면 DB에 한글로 들어간다.
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender"); 
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String zipcode = request.getParameter("zipcode");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName(name);
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		memberDTO.setGender(gender);
		memberDTO.setEmail1(email1);
		memberDTO.setEmail2(email2);
		memberDTO.setTel1(tel1);
		memberDTO.setTel2(tel2);
		memberDTO.setTel3(tel3);
		memberDTO.setZipcode(zipcode);
		memberDTO.setAddr1(addr1);
		memberDTO.setAddr2(addr2);
		
		//DB
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		int su = memberDAO.memberWrite(memberDTO);
		
		//여기에 왜 static처리 하면 안되지?

		//응답
		response.setContentType("text/html;charset=UTF-8");


%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

<%-- <%
if(su==1){%>
<h3>회원가입 성공</h3>
<%}else{ %>
회원가입 실패
<%}%> --%>
<script type = "text/javascript">
window.onload = function(){
	alert("회원가입 성공");
	location.href = "loginForm.jsp";
}
</script>
</body>
</html>