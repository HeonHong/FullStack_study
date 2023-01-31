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
import="java.net.URLEncoder"%>


<!DOCTYPE html>

<%
//데이터
		//request.setCharacterEncoding("UTF-8");//한글 안쓰니까 필요없다
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//DB
		MemberDAO memberDAO = MemberDAO.getInstance();//싱글톤 방식
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		String name = memberDAO.memberLogin(id,pwd);
		
		//String name = memeberDAO.memberLongin(id, pwd); 
		
		//응답
		response.setContentType("text/html;charset=UTF-8");
		%>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
		<%
		//페이지 이동
		//jsp만들면 servlet 자동생성 > response자동 생성
		if(name!=null) {
			//response.sendRedirect("longinOk.jsp?namerara=" + URLEncoder.encode(name,"UTF-8"));//STATIC
/* 			//이건 겟방식임!!!!
 */			//checkId()이거랑 똑같은 개념
 		/* HttpSession session = request.getSession(); */
		//세션 생성. 이미 session은 내장객체로 존재.mvc에서 만들줄 알아야함.
 		
		/* session.setAttribute("memName", name); *///30분간 살아있는다. 
		/* response.sendRedirect("longinOk.jsp"); *///페이지 이동. 그냥 페이지를 이동하는 것이다. 세션관련x
	
		//쿠키
		Cookie cookie = new Cookie("memName", name);
		cookie.setMaxAge(30*60);//초
		response.addCookie(cookie);//클라이언트에게 보내기
		
		//쿠키
		Cookie cookie2 = new Cookie("memId", id);
		cookie2.setMaxAge(30*60);//초
		response.addCookie(cookie2);//클라이언트에게 보내기
		response.sendRedirect("loginOk.jsp");
		}else{
			response.sendRedirect("loginFail.jsp");
			}%>


</body>
</html>