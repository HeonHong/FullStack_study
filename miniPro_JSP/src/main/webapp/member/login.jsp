<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import= "member.bean.MemberDTO"
import= "member.dao.MemberDAO"
import= "java.util.List"
import="java.net.URLEncoder"
%>



<%
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			MemberDAO memberDAO = MemberDAO.getInstance();//싱글톤 방식
			MemberDTO memberDTO = memberDAO.memberLogin(id, pwd);
			
			response.setContentType("text/html;charset=UTF-8");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%

		if(memberDTO!=null) {

		session.setAttribute("memName", memberDTO.getName());
		session.setAttribute("memId", memberDTO.getId());
		session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+ memberDTO.getEmail2());
		response.sendRedirect("loginOk.jsp");
	
		}else{
			response.sendRedirect("loginFail.jsp");
	
			}%>

</body>
</html>