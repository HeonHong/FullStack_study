package user.DAO;


import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {

	private SqlSessionFactory sqlSessionFactory;
	private static UserDAO userDAO = new UserDAO();
	
	public static UserDAO getInstance() {
		
		
		return userDAO;
	}
	public UserDAO() {
		//환경설정 파일(mybatis-config)를 읽어온다.
		
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");//환경설정파일
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//factory 생성.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* Reader reader = new Reader(); 불가*//*문자단위*/
		/*bytestream아니니까 바이트 단위*/
	}
	
	public void write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();//생성
		sqlSession.insert("userSQL.write",userDTO);
		sqlSession.commit();//여긴 자동 커밋 불가능하다.
		sqlSession.close();
		
		//xml을 아예 springdmfh 넣어주는 방법과 자바랑 이런식으로 연결하는 방법이 있다.
	}
	
	public List<UserDTO> getList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/* sqlSession.selectone 이렇게하면 한 줄만 가지고 온다*/
		List<UserDTO> list = sqlSession.selectList("userSQL.getList");
		sqlSession.close();
		//insert update delete가 아니니까 commit할 필요x
		return list;
	}
	
	public UserDTO getUser(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDTO userDTO = sqlSession.selectOne("userSQL.getUser",id);
		System.out.println("userDTO = " + userDTO);
		sqlSession.close();
		return userDTO;
	}//getUser
	
	public int update(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su = sqlSession.update("userSQL.update",map);
		sqlSession.commit();
		sqlSession.close();
		return su;
	}//update
	
	public int delete(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su = sqlSession.update("userSQL.delete",id);
		sqlSession.commit();
		sqlSession.close();
		return su;
	}//delete
	
	public List<UserDTO> search(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.search", map);
		sqlSession.close();
		return list;
		
	}//search
}

