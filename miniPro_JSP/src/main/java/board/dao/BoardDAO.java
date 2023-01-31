package board.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;

public class BoardDAO {

	private SqlSessionFactory sqlSessionFactory;
	private static BoardDAO boardDAO = new BoardDAO();
	public static BoardDAO getInstance(){
		return boardDAO;
	}
	
	public BoardDAO() {
		
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");// 환경설정파일
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);// factory 생성.
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int boardWrite(BoardDTO boardDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su = sqlSession.insert("boardSQL.boardWrite", boardDTO);
		sqlSession.commit();
		sqlSession.close();
		return su;
	}
	
	public List<BoardDTO> boardList(Map<String, Integer> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardDTO> list = sqlSession.selectList("boardSQL.boardList", map);
		sqlSession.close();
		return list;
	}
	
	public int getTotalA() {
		int totalA = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		totalA = sqlSession.selectOne("boardSQL.getTotalA");
		sqlSession.close();
		return totalA;
	}
	
	public List<BoardDTO> boardlist() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardDTO> list = sqlSession.selectList("boardSQL.board");
		sqlSession.close();
		return list;
	}
	
	public List<BoardDTO> openBoard() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardDTO> list = sqlSession.selectList("boardSQL.openBoard");
		sqlSession.close();
		return list;
	}



	
}
