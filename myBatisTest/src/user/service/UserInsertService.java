package user.service;

import java.util.Scanner;

import user.DAO.UserDAO;
import user.bean.UserDTO;

public class UserInsertService implements UserService{

	@Override
	public void execute() {
			
			//데이터
			Scanner scanner = new Scanner(System.in);
			System.out.print("이름 입력 : ");
			String name = scanner.next();
			System.out.print("아이디입력 : ");
			String id = scanner.next();
			System.out.print("비밀번호입력 : ");
			String pwd = scanner.next();
			
			UserDTO userDTO = new UserDTO();
			userDTO.setName(name);
			userDTO.setId(id);
			userDTO.setPwd(pwd);
			
			//DB
			UserDAO userDAO = UserDAO.getInstance();//싱글톤
			userDAO.write(userDTO);
			//응답
			System.out.println("데이터를 DB에 저장하셨습니다.");
	}

}
