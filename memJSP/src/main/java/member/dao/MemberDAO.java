package member.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;

public class MemberDAO {

	private SqlSessionFactory sqlSessionFactory;
	private static MemberDAO memberDAO = new MemberDAO();

	public static MemberDAO getInstance() {
		return memberDAO;
	}

	public MemberDAO() {
		// 환경설정 파일(mybatis-config)를 읽어온다.
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");// 환경설정파일
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);// factory 생성.
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int memberWrite(MemberDTO memberDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();// 생성
		int su = sqlSession.insert("memberSQL.memberWrite", memberDTO);
		sqlSession.commit();
		sqlSession.close();
		return su;
	}

	public boolean isExistId(String id) {
		boolean exist = false;
		SqlSession sqlSession = sqlSessionFactory.openSession();// 생성
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.isExistId",id);
		if(memberDTO!=null) {
			exist =true;
		}
		sqlSession.close();

		return exist; 
	}
	
	
	public String memberLogin(String id, String pwd) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		SqlSession sqlSession = sqlSessionFactory.openSession();// 생성
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.memberLogin",map);
		sqlSession.close();
		if(memberDTO != null) return memberDTO.getName();
		else return null;
	}
	
}
