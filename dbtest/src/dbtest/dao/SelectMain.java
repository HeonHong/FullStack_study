package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMain {

		private Connection conn;
		private String driver = "oracle.jdbc.driver.OracleDriver";
		private String url = "jdbc:oracle:thin:@localhost:1521:xe";
		private String userName = "c##java";
		private String password = "bit";
		private PreparedStatement pstmt;
		private ResultSet rs;
		
		public SelectMain(){
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
			
		public void selectArticle() {
			String sql = "select * from dbtedst";
			getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();//ResultSet 리턴
				//rs의 크기를 구해오는 함수가 없어 rs.next로 boolean 타입 값을 받는다.
				
				while(rs.next()) {
					System.out.println(rs.getString("name") + "\t"+
										rs.getInt("age") + "\t" +
										rs.getDouble("height") + "\t"+
										rs.getString("logtime") + "\t");
					//rs.getString("name") == rs.getArray(1)이지만 1번 column에 뭐가 있을지 모르니까 전자처럼 쓰는 게 낫다.
					//rs.getString("logTime") == rs.getDate("logTime")
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(rs!=null)pstmt.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				}catch (SQLException e) {
						
						e.printStackTrace();
					}	
				}
			
		
	}
		
		public static void main(String[] args) {
			
			SelectMain selectMain = new SelectMain();
			selectMain.selectArticle();
	}

}
