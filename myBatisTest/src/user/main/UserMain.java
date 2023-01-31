package user.main;

import java.util.Scanner;

import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSearchService;
import user.service.UserSelectService;
import user.service.UserService;
import user.service.UserUpdateService;



public class UserMain {

		public static void main(String[] args) {
			UserMain userMain = new UserMain();
			userMain.menu();
			System.out.println("프로그램을 종료합니다.");
		}
		
		public void menu() {
			int num;
			Scanner scanner = new Scanner(System.in);
			UserService userService = null;
			while(true) {
				System.out.println();		
				
				System.out.println("*************");
				System.out.println("****1.입력****");
				System.out.println("****2.출력****");
				System.out.println("****3.수정****");
				System.out.println("****4.삭제****");
				System.out.println("****5.검색****");
				System.out.println("****6.종료****");
				System.out.println("*************");
				System.out.print("번호 : ");
				num = scanner.nextInt();
				System.out.println();
				if(num==6) break;
				
				if(num==1) userService = new UserInsertService();
				else if(num==2) userService = new UserSelectService();
				else if(num==3) userService = new UserUpdateService();
				else if(num==4) userService = new UserDeleteService();
				else if(num==5) userService = new UserSearchService();
				
				userService.execute();
				/*
				 * UserInsertService userInsertService = new UserInsertService - 생성 1:1관계,
				 * 결합도100% 상속으로 결합도 down
				 * 다형성 : 부모 클래스가 자식 클래스를 참조
				 */
			}//while
			
		}//menu()
}
