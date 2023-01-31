package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.DAO.UserDAO;
import user.bean.UserDTO;

public class UserSearchService implements UserService {

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		UserDAO userDAO = UserDAO.getInstance();
		System.out.println("1.이름으로 검색");
		System.out.println("2.아이디로 검색");
		System.out.println("***********");
		System.out.print("번호를 입력하세요");
		int select = scanner.nextInt();
		
		String name, id;
		Map<String, String> map = new HashMap<String,String>();
		
		if(select == 1) {
			System.out.print("찾고자 하는 이름을 입력하세요 : ");
			name = "%" + scanner.next() + "%";
			id = "";
		}else if(select==2) {
			System.out.print("찾고자 하는 아이디를 입력하세요 : ");
			name = "";
			id = "%" + scanner.next() + "%";
		}else {
			System.out.println("겟 아웃!!!!!");
			return;
		}
	map.put("name", name);
	map.put("id", id);

	
	
	
	List<UserDTO> list = userDAO.search(map);

	
	for(UserDTO userDTO:list) {
		System.out.println(userDTO.getName() + "\t" +
				userDTO.getId()+ "\t" +
				userDTO.getPwd());
	}//for
	}
}

/* mapper에 보낼때 아예 %%를 더해서 보내기 */
/*
 * 1. 이름으로 검색 2. 아이디 검색
 * 
 * 번호선택 : 1 찾고자 하는 이름 입력하세요 : 동
 * 
 * 홍길동 hong 111 희동이 baby 123
 * 
 * 번호선택 : 2 찾고자 하는 이름 입력하세요 : n
 * 
 * 홍길동 hong 111 conan conan 111
 * 
 * 전제조건 > userDAO.search 메소드 1개로 해결 > userMapper.xml에서 select id = "search" 태그
 * 하나로 해결, %#{}은 같이 사용할 수 없다.
 * select*from usertable where name like null or id like '%n%';

 */