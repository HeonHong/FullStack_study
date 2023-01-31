package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		//데이터
		String seq =request.getParameter("seq");
		String pg =request.getParameter("pg");
		
		//응답
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
	
		request.setAttribute("display", "/board/boardView.jsp");
		return "/index.jsp";
	}

}
