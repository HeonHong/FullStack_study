package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardDeleteService2 implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int seq = Integer.parseInt(request.getParameter("seq"));
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardDelete(seq);
		
		/*
		 * request.setAttribute("display", "/board/boardList.jsp?pg=1"); //이게 안되는 이유. 얘는
		 * ajax에서 불렀기 때문에 ajax로 돌아가야한다. return "/index.jsp";
		 */
		
		
		return "/board/boardDelete.jsp";
	}

}
