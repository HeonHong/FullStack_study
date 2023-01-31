package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class GetBoardUpdateService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO boardDTO = new BoardDTO();
		boardDTO = boardDAO.getBoard(seq);
		
		JSONObject json = new JSONObject();
		json.put("seq", boardDTO.getSeq());
	    json.put("subject", boardDTO.getSubject());
	    json.put("content", boardDTO.getContent());
	    
	    request.setAttribute("json", json);
		return "/board/getBoardUpdate.jsp";
	}

}
