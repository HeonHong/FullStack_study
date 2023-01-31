package dbtestPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMain {

	private Connection connection;
	private PreparedStatement pstmt;
	
	public InsertMain() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##java","bit");
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertArticle() {
		getConnection();
		
		try {
			String name = "지준태";
			int age = 30;
			double height = 183.5;
			pstmt = connection.prepareStatement("insert into dbtedst values(?,?,?,sysdate)");
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(pstmt!=null) pstmt.close();
					if(connection!=null) connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
	}
	
	public static void main(String[] args) {

		InsertMain insertMain = new InsertMain();
		insertMain.insertArticle();
		
	}

}
