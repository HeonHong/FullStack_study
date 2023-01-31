package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.bean.MemberDTO;

public class MemberDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userName = "c##java";
	private String password = "bit";
	
	private static MemberDAO memberDAO = new MemberDAO();
	public static MemberDAO getInstance() {
		
		return memberDAO;
	}	
	
	public MemberDAO(){
		try {
			Class.forName(driver);//driver파일을 class 타입으로 생성
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int memberWrite(MemberDTO memberDTO) {
		int su =0;
		
		getConnection();//접속
		
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getZipcode());
			pstmt.setString(11, memberDTO.getAddress1());
			pstmt.setString(12, memberDTO.getAddress2());
			
			su= pstmt.executeUpdate();//실행

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return su;
	}
	
	public String memberLongin(MemberDTO memberDTO) {
		String name =null;
		
		getConnection();//접속
		
		String sql = "select name from member where id = ? and pwd = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getId());
			pstmt.setString(2, memberDTO.getPwd());
		
			rs = pstmt.executeQuery();//실행 - ResultSet형태 리턴
			if(rs.next())
			name = rs.getString("name");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)pstmt.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return name;
	}
	


	
	
}
