package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.DAO.UserDAO;
import user.bean.UserDTO;

public class UserUpdateService implements UserService {

	@Override
	public void execute() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("수정할 아이디 입력 : ");
		String id = scanner.next();
		
		//db
		UserDAO userDAO = UserDAO.getInstance();//싱글톤
		UserDTO userDTO = userDAO.getUser(id);	
		
	 
		//응답
		
		if(userDTO==null) {
			System.out.println("찾고자 하는 아이디가 없습니다.");
			return;
		}
		
		System.out.println(userDTO.getName() + "\t" + 
				 userDTO.getId()+ "\t" + 
				 userDTO.getPwd());
		
		System.out.println();
		System.out.print("수정할 이름 입력 : ");
		String name = scanner.next();
		System.out.print("수정할 비밀번호 입력 : ");
		String pwd = scanner.next(); 
		
		Map<String, String> map = new HashMap<String,String>();
		map.put("name", name);
		map.put("id", id);
		map.put("pwd", pwd);
		int su = userDAO.update(map);
		//insert, update, delete는 리턴값을 수로 넘긴다.
		
		System.out.println("데이터를 수정하였습니다.");
		 
		 
		 
		
		
		
		
		
		/*UserDTO userDTO = new UserDTO();
		Scanner scanner = new Scanner(System.in);
		System.out.print("수정할 아이디 입력 : ");
		String id = scanner.next();
		userDTO.setId(id);
		
		UserDAO userDAO = UserDAO.getInstance();
		String idCheck = userDAO.check();	
			
		if(idCheck==null) {
			System.out.println("찾고자 하는 아이디가 없습니다.");
		}else {
			System.out.print("수정할 이름 입력 : ");
			String name = scanner.next();
			System.out.print("수정할 비밀번호 입력 : ");
			String pwd = scanner.next();
			userDTO.setName(name);
			userDTO.setPwd(pwd);
			userDAO.update();
			System.out.println("데이터를 수정했습니다.");*/
		
	}

}
