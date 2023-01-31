package user.service;

import java.util.Scanner;

import user.DAO.UserDAO;

public class UserDeleteService implements UserService {

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 아이디 입력 :");
		String id = scanner.next();
		//getUser사용하는 방법도 잇다.
		UserDAO userDAO = UserDAO.getInstance();
		int su = userDAO.delete(id);
		if(su==0) {
			System.out.println("삭제할 아이디 없음");
		}else
			System.out.println("삭제 완료");
	}

}

/*
 * 삭제할 아이디: 찾는 아이디 없음
 * 
 * ---------------- 삭제할 아이디: 데이터를 삭제했음
 */