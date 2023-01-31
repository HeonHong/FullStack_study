package student;

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
	}
	
	
	public void menu(){//static이 있으면 MemService를 호출할 필요 없지만 그게 아니라면 필요.
		
		
		
		Scanner scan = new Scanner(System.in);
		int num;
		while(true) {
			System.out.println("*************");
			System.out.println("****1.입력****");
			System.out.println("****2.검색****");
			System.out.println("****3.삭제****");
			System.out.println("****4.종료****");
			System.out.println("*************");
			System.out.print("번호 : ");
			num = scan.nextInt();
			System.out.println();
			
			if(num==4) break;//while을 벗어나라
			if(num==1) insert();
			else if(num==2) search();
			else if(num==3) delete();
			else System.out.println("1~4사이의 숫자만 입력해주세요.");
			
		}//while
		System.out.println();
		System.out.println("프로그램을 종료합니다.");
	}//menu
	
	public void insert() {
		this.getConnection();
		Scanner scan = new Scanner(System.in);
		System.out.println("*************");
		System.out.println("****1.학생****");
		System.out.println("****2.교수****");
		System.out.println("****3.관리자****");
		System.out.println("***4.이전메뉴***");
		System.out.println("*************");
		System.out.print("번호입력 : ");
		String name;
		String type;
		int num = scan.nextInt();
		if(num==1) {
			System.out.print("이름 입력 : ");
			name = scan.next();
			System.out.print("학번 입력 : ");
			type = scan.next();
		}else if(num==2) {
			System.out.print("이름 입력 : ");
			name = scan.next();
			System.out.print("과목 입력 : ");
			type = scan.next();
		}else if(num==3) {
			System.out.print("이름 입력 : ");
			name = scan.next();
			System.out.print("부서 입력 : ");
			type = scan.next();
		}else return;
		
		
		try {
			pstmt = conn.prepareStatement("insert into student values(?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, type);
			pstmt.setInt(3, num);
			
			int su = pstmt.executeUpdate();
			System.out.println(su + "개의 행이(가) 삽입되었습니다.");
		} catch (SQLException e) {
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
	public void search() {
		this.getConnection();
		Scanner scan = new Scanner(System.in);

		System.out.println("1. 이름 검색");
		System.out.println("2. 전체 검색");
		System.out.println("3. 이전 메뉴");
		System.out.print("번호입력 : ");
		int num = scan.nextInt();
		
		
		if(num==1) {
			sql = "select * from student where name like ?";
			System.out.print("검색할 이름을 입력하세요");
			String name = scan.next();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + name + "%");
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					if(rs.getInt("code") == 1) {
						System.out.println("이름 : " + rs.getString("name") + "\t학번 : " + rs.getString("value"));
					}else if(rs.getInt("code") == 2) {
						System.out.println("이름 : " + rs.getString("name") + "\t과목 : "+ rs.getString("value"));
					}else if(rs.getInt("code") == 3) {
						System.out.println("이름 : " + rs.getString("name") + "\t부서 : "+ rs.getString("value"));
					}
				}//while
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
			
		}else if(num==2) {
			sql = "select * from student";
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					if(rs.getInt("code") == 1) {
						System.out.println("이름 : " + rs.getString("name") + "\t학번 : " + rs.getString("value"));
					}else if(rs.getInt("code") == 2) {
						System.out.println("이름 : " + rs.getString("name") + "\t과목 : "+ rs.getString("value"));
					}else if(rs.getInt("code") == 3) {
						System.out.println("이름 : " + rs.getString("name") + "\t부서 : "+ rs.getString("value"));
					}
				}//while
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
		}else return;
		
		
		
		
	}//search()
	
	public void delete() {
		this.getConnection();
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력");
		String name = scan.next();
		
		sql = "delete student where name = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int su = pstmt.executeUpdate();
			System.out.println(su + "개의 행이(가) 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}//delete
	
	public static void main(String[] args) {

		Student student = new Student();
		student.menu();
	}

}
