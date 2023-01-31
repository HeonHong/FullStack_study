package member.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


//@Data
@Setter
@Getter
@NoArgsConstructor//매개변수 없이 기본생성자
@RequiredArgsConstructor
public class MemberDTO {
	
	@NonNull private String name;
	private String id;
	private String pwd;
	private String gender;
	private String email1;
	private String email2;
	private String tel1;
	private String tel2;
	private String tel3;
	private String zipcode;
	private String addr1;
	private String addr2; 
}
