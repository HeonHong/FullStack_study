package user.service;

import java.util.List;

import user.DAO.UserDAO;
import user.bean.UserDTO;

public class UserSelectService implements UserService{

	@Override
	public void execute() {
		
		
		//DB
		UserDAO userDAO = UserDAO.getInstance();//싱글톤
		List<UserDTO> list = userDAO.getList();
		
		//응답
		for(UserDTO userDTO:list) {
			System.out.println(userDTO.getName() + "\t" +
					userDTO.getId()+ "\t" +
					userDTO.getPwd());
		}//for
		
	}

}

//dao에서 누락되는 부분이 생기는데 부분적인 데이터를 가지고 오려면 어떻게해야하나?
