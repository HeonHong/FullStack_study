package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class UpdateFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
		 * // 데이터 수신 HttpSession session = request.getSession(); // session이 다른 페이지에 남아
		 * 있더라도 이건 필요한 건가? // 싱글톤으로 되어 있어서 loginForm에 남은 세션 가져온다. String id = (String)
		 * session.getAttribute("memId");
		 * 
		 * // DB MemberDAO memberDAO = MemberDAO.getInstance(); MemberDTO memberDTO =
		 * memberDAO.getInformation(id); // mapper에 isExistID써도 됨. 똑같은 문장임
		 * request.setAttribute("memberDTO", memberDTO); request.setAttribute("display",
		 * "/member/updateForm2.jsp");
		 * 
		 * return "index.jsp"; }
		 */
		
		request.setAttribute("display", "/member/updateForm.jsp");
	
		return "../index.jsp";
	}

}
