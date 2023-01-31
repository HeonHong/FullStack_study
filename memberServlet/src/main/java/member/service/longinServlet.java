package member.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

@WebServlet("/longinServlet")
public class longinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;//객체 직렬화?
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터
		//request.setCharacterEncoding("UTF-8");//한글 안쓰니까 필요없다
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//DB
		MemberDAO memberDAO = MemberDAO.getInstance();//싱글톤 방식
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		String name = memberDAO.memberLongin(memberDTO);
		
		//String name = memeberDAO.memberLongin(id, pwd); 
		
		//응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(name!=null) {
			
			out.println(name + "  로그인 성공");
		}else
			out.println("아이디 또는 비밀번호가 틀렸습니다.");
		out.println("</body>");
		out.println("</html>");
		
	}

}
