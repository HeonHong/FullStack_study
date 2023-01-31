package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import guestbook.bean.GuestbookDTO;

public class GuestbookDAO {
	private Connection conn;//jar파일 꼭 넣어라 제발.......
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userName = "c##java";
	private String password = "bit";
	
	
	private static GuestbookDAO guestbookDAO = new GuestbookDAO();
	
	
	public static GuestbookDAO getInstance() {
		System.out.println("getInstance함수");
		return guestbookDAO;
	}	
	
	public GuestbookDAO(){
		try {
			Class.forName(driver);//driver파일을 class 타입으로 생성
			System.out.println("드라이버가 연결되었습니다.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("커넥션");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int guestbookWrite(GuestbookDTO guestbookDTO) {
		
		int su =0;
		getConnection();//접속
		
		String sql = "insert into guestbook values(SEQ_GUESTBOOK.nextval,?,?,?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, guestbookDTO.getName());
			pstmt.setString(2, guestbookDTO.getEmail());
			pstmt.setString(3, guestbookDTO.getHomepage());
			pstmt.setString(4, guestbookDTO.getSubject());
			pstmt.setString(5, guestbookDTO.getContents());
			
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
	
	public ArrayList<GuestbookDTO> guestbooklist(Map<String, Integer> map) {
		
		
		getConnection();//접속
		ArrayList<GuestbookDTO> list = new ArrayList<GuestbookDTO>();//생성
		
		String sql = "select * from"
				+ " (select rownum rn, tt.*from"
				+ " (select seq, name, email,homepage, subject, content, to_char(logtime,'YY-MM-DD') AS logtime"
				+ " from guestbook order by seq desc) tt)"
				+ " where rn>=? and rn<=?";
				
				
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, map.get("startNum"));
			pstmt.setInt(2, map.get("endNum"));
			rs = pstmt.executeQuery();//실행 - ResultSet형태 리턴
			
			while(rs.next()) {
				if(rs.getString("name")!=null) {
			GuestbookDTO guestbookDTO 
			= new GuestbookDTO(rs.getString("name"),rs.getString("email"),rs.getString("homepage"), rs.getString("subject"), rs.getString("content"), rs.getString("logtime"));
			list.add(guestbookDTO);
				}else break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			list=null;//이상이 있을때 데이터가 더 이상 이동하지 않게 해줘야한다.
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
		
		return list;
	}

	
	public int getTotalA() {
		int totalA = 0;
		
		String sql =  "select count(*) from guestbook";
		
		getConnection();
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalA = rs.getInt(1);
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
		}//finally
		
		return totalA;
	}
}