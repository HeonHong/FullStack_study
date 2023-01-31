package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardUpdateService2 implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		System.out.println(seq);
		System.out.println(subject);
		System.out.println(content);
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSeq(seq);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		
		boardDAO.boardUpdate(boardDTO);
		
		request.setAttribute("display", "/board/boardList.jsp");
		
		return "/board/boardUpdate.jsp";
	}

}
