package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardWriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		//데이터
		HttpSession session = request.getSession(); //세션 생성.jsp와 다르게 내장객체x
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		String id = "ghdgjs0621";
		String name = "홍헌";
		String email = "ghdgjs0621@naver.com";
		
		/*
		 * String id = (String)request.getAttribute("memId"); String name =
		 * (String)request.getAttribute("memName"); String email =
		 * (String)request.getAttribute("memEmail");
		 */
		


		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		map.put("subject", subject);
		map.put("content", content);

		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardWrite(map);
		
		//응답		
		return "/board/boardWrite.jsp";
	}

}
