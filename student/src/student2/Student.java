package student2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {

	private Connection conn;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userName = "c##java";
	private String password = "bit";
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	
	
	
	public static void main(String[] args) {
		Student student = new Student();
		student.menu();
		System.out.println("프로그램을 종료합니다.");
	}//main
	
	
	public Student() {
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
	}//getConnection
	
	
	public void menu() {
		Scanner scan = new Scanner(System.in);
		int num;
		
		while(true) {
			System.out.println();
			System.out.println("**************");
			System.out.println("관리");
			System.out.println("1.입력");
			System.out.println("2.검색");
			System.out.println("3.삭제");
			System.out.println("4.종료");
			System.out.println("**************");
			System.out.print("번호 입력 : ");
			num = scan.nextInt();
			if(num==4) break;
			
			if(num==1) insertArticle();
			else if(num==2) selectArticle();
			else if(num==3) deleteArticle();
			
		}//while
	}//menu



	public void insertArticle() {
		Scanner scan = new Scanner(System.in);
		int num;
		String name = null;
		String value = null;
		
			while(true) {
			System.out.println();
			System.out.println("**************");
			System.out.println("관리");
			System.out.println("1.학생");
			System.out.println("2.교수");
			System.out.println("3.관리자");
			System.out.println("4.이전메뉴");
			System.out.println("**************");
			System.out.print("번호 입력 : ");
			num = scan.nextInt();
			if(num==4) break;
			if(num==1) {//학생
				System.out.print("이름 입력 : ");
				name = scan.next();
				System.out.print("학번 입력 : ");
				value = scan.next();	
			}else if(num==2) {//교수
				System.out.print("이름 입력 : ");
				name = scan.next();
				System.out.print("과목입력");
				value = scan.next();
			}else if(num==3) {//관리자
				System.out.print("이름 입력 : ");
				name = scan.next();
				System.out.print("부서 입력 : ");
				value = scan.next();
			}//if종료
			
			//DB Insert
			getConnection();
			
			try {
				pstmt = conn.prepareStatement("insert into student values(?,?,?)");
				pstmt.setString(1, name);
				pstmt.setString(2, value);
				pstmt.setInt(3, num);
				int su = pstmt.executeUpdate();
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
			
	}//while
			

	}//inserArticle
	
	public void selectArticle() {
		Scanner scan = new Scanner(System.in);
		int num;
		
		while(true) {
			System.out.println("1.이름 검색");
			System.out.println("2.전체 검색");
			System.out.println("3.이전 메뉴");
			System.out.println();
			System.out.print("번호 입력 : ");
			num = scan.nextInt();
			
			if(num==3) break;
			
			String name = null;
			if(num==1) {
				System.out.print("검색할 이름 입력 : ");
				name = scan.next();
			}
			
			//DB-select
			getConnection();
			String sql =null;
			if(num==1)
				sql = "select * from student where name like ?";
			else
				sql = "select * from student";
			
			try {
				pstmt = conn.prepareStatement(sql);
				if(num==1) pstmt.setString(1, "%" + name + "%");
				
				rs = pstmt.executeQuery();//ResultSet리턴
				
				while(rs.next()){
					System.out.print("이름 = " + rs.getString("name")+"\t");
					if(rs.getInt("code")==1) {
						System.out.println("학번 = " + rs.getString("value"));
					}else if(rs.getInt("code")==2) {
						System.out.println("과목 = " + rs.getString("value"));
					}else if(rs.getInt("code")==3) {
						System.out.println("부서 = " + rs.getString("value"));
					}
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
			}//finally
			
			
		}//while
		
	}//selectArticle
	
	public void deleteArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("삭제할 이름 입력 : ");
		String name = scan.next();
		
		getConnection();
		
		
		//DB delete
		String sql = " delete student where name = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int su = pstmt.executeUpdate();
			System.out.println(su + "개의 행이(가) 삭제되었습니다.");
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
		}//finally
		
		
	}//deleteArticle()

}
