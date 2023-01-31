package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardUpdateService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		System.out.println(seq);
		System.out.println(subject);
		System.out.println(content);
		
		
		
		Map<String, String> map = new HashMap<String,String>();
		map.put("seq", seq+"");
		//seq가 integer라서 문자형으로 바꿔주지 않으면 오류남. 자동 형변환 불가
		map.put("subject", subject);
		map.put("content", content);

		//DB 
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardUpdate(map);
		
		
		
		return "/board/boardUpdate.jsp";
	}

}
