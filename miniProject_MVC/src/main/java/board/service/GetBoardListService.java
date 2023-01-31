package board.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class GetBoardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		System.out.println("여기 안오지?");
		//데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//1페이지당 5개 계산
		int endNum=pg*5;
		int startNum=endNum-4;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		List<BoardDTO> list = boardDAO.boardList(map);
		
		
		//list > json변환
		JSONObject json = new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		
		if(list != null) {
			JSONArray array = new JSONArray();
			
			for(BoardDTO boardDTO : list) {
				JSONObject temp = new JSONObject();
				temp.put("seq", boardDTO.getSeq());
				temp.put("id", boardDTO.getId());
				temp.put("name", boardDTO.getName());
				temp.put("email", boardDTO.getEmail());
				temp.put("subject", boardDTO.getSubject());
				temp.put("content", boardDTO.getContent());
				temp.put("ref", boardDTO.getRef());
				temp.put("lev", boardDTO.getLev());
				temp.put("step", boardDTO.getStep());
				temp.put("pseq", boardDTO.getPseq());
				temp.put("reply", boardDTO.getReply());
				temp.put("hit", boardDTO.getHit());
				//temp.put("logtime", boardDTO.getLogtime()+"");
				temp.put("logtime", sdf.format(boardDTO.getLogtime()));

				array.add(temp);
			}//for
			json.put("list", array);
		}//if
		/*
		 * json은 String타입으로 데이터를 받아서 넣는다. int나 다른 기본 타입들은 자동으로 변형되고 date같은 클래스 타입은
		 * String으로 바꿔줘야한다.
		 */
		
		//페이징처리
		int totalA = boardDAO.getTotalA();
		
		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		
		
		//위 데이터는 다 필요 없고 pagingHTML만 넘기면 됨
		json.put("pagingHTML", boardPaging.getPagingHTML()+"");//
		
		//세션
		HttpSession session = request.getSession();
		String memId=(String)session.getAttribute("memId");
		
		
		
		System.out.println(json);
		request.setAttribute("pg", pg);
		request.setAttribute("memId", memId);
		request.setAttribute("json", json);
		
		return "/board/getBoardList.jsp";
	}

}
