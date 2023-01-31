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
		
		System.out.println("1.이름으로 검색");
		System.out.println("2.아이디로 검색");
		System.out.println("***********");
		System.out.print("번호를 입력하세요");
		int num = scanner.nextInt();
		
		String columnName = null;
		String value = null;
		
		if(num==1) {
			System.out.println("이름 입력 : ");
			value = scanner.next();
			columnName="name";
		}else if(num==2) {
			System.out.println("아이디 입력 : ");
			value = scanner.next();
			columnName="id";
		}

		//DB
		Map<String, String> map = new HashMap<String, String>();
		map.put("columnName", columnName);
		map.put("value", value);
		
		UserDAO userDAO = UserDAO.getInstance();
		List<UserDTO> list = userDAO.search(map);
		/*
		 * 만약에 userDAO.UserSearchService(columnName, value)로 보내면 어차피 DAO에서 mapper에 보낼 때
		 * 두 개의 매개변수를 보내지 못해 map처리를 해서 보내야하기 때문에 여기서는 map처리해주는 게 맞다.
		 */
		
		if(list.size() ==0) {
			System.out.println("찾으시는 값이 없습니다.");
			return;
		}
	
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