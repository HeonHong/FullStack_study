package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardUpdateFormService2 implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		String seq =request.getParameter("seq");
		String pg =request.getParameter("pg");
		String memId=request.getParameter("memId");	
		/*
		 * System.out.println(seq); System.out.println(pg); System.out.println(memId);
		 */
		
		
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
		request.setAttribute("memId", memId);
		
		request.setAttribute("display","/board/boardUpdateForm.jsp");
				
		return "/index.jsp";
	}

}
