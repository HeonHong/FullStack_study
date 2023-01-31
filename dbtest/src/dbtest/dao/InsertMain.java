package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain {

	private Connection conn;
	private PreparedStatement pstmt;
	//한번만 사용하는 메소드?
	//생성자
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userName = "c##java";
	private String password = "bit";
	
	public InsertMain() {
		//driver loading.
		//모든 클래스는 new를 해줘야 의미있다!!!!
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//static
			System.out.println("driver loading success");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}// >> 파일명만 알고 클래스인지 인터페이스 구분 불가해서 forName으로
		//forName안에는 패키지까지해서 풀 쿼리 네임 작성
		//public class는 명령어.
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("connection sucess");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertArticle() {
		//데이터
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("나이 입력 : ");
		int age = scan.nextInt();
		System.out.print("이름 입력 : ");
		double height = scan.nextDouble();
		
		
		//이 메소드 호출시 커넥션 접속하면 된다.
		this.getConnection();
	
		
		//PreparedStatement pstmt = Connection prepareStatment() 통해서 생성
	try {
		//prepare생성
		pstmt = conn.prepareStatement("insert into dbtedst values(?,?,?,sysdate)");
		pstmt.setString(1, name);
		pstmt.setInt(2, age);
		pstmt.setDouble(3, height);
		
		int su = pstmt.executeUpdate();//실행 - 개수 리턴
		System.out.println(su + "개의 행이(가) 삽입되었습니다.");
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(pstmt!=null)	pstmt.close();//역순으로 끊어준다.
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}
	
	public static void main(String[] args) {

		InsertMain insertMain = new InsertMain();
		//모든 클래스는 new를 해줘야 의미있다!!!!
		insertMain.insertArticle();
		
	}

}
