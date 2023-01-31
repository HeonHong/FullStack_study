package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {
	private Connection conn;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userName = "c##java";
	private String password = "bit";
	private PreparedStatement pstmt;
	
	public UpdateMain() {
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
	
	public void updateArticle() {
		Scanner scan = new Scanner(System.in);
		
		//DB
		this.getConnection();//호출
		System.out.print("수정할 이름 입력하세요");
		String name = scan.next();
		
		String sql="update dbtedst set age=age+1, height = height + 1 where name like ?";//?이랑 %둘 다 와일드카드라 한꺼번에 사용 불가.
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			int su = pstmt.executeUpdate();
			
			System.out.println(su + "개의 행이(가) 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
					try {
						if(pstmt!=null)pstmt.close();
						if(conn!=null)conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			
		}
		
		
		
	}
	
	public static void main(String[] args) {
		UpdateMain updateMain = new UpdateMain();
		
		updateMain.updateArticle();
	}

}
