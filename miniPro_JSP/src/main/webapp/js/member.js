//로그인 유효성 검사
function checkLogin(){
	
	
	document.getElementById("idDIV").innerText="";
	document.getElementById("pwdDIV").innerText="";
	
	if(document.getElementById("id").value == ""){
		document.getElementById("idDIV").innerText="아이디을 입력하세요.";
		document.loginForm.id.focus();
		}
	else if(document.getElementById("pwd").value == ""){
		document.getElementById("pwdDIV").innerText="비밀번호를 입력하세요.";
		document.loginForm.pwd.focus();}
	else 
		document.loginForm.submit();	
}

//회원가입 유효성 검사
 function check(){
	
	if(document.writeForm.duplication.value == "n"){
		document.getElementById("idDIV").innerText="중복검사를 하세요";
	}else{
	document.getElementById("nameDIV").innerText="";
	document.getElementById("idDIV").innerText="";
	document.getElementById("pwdDIV").innerText="";
	if(document.getElementById("name").value == "")
		document.getElementById("nameDIV").innerText="이름을 입력하세요.";
	else if(document.getElementById("id").value == "")
		document.getElementById("idDIV").innerText="아이디를 입력하세요.";
	else if(document.getElementById("pwd").value == "")
		document.getElementById("pwdDIV").innerText="비밀번호를 입력하세요.";
	else if(document.getElementById("pwd").value != document.getElementById("repwd").value)
		document.getElementById("pwdDIV").innerText="동일한 비밀번호를 입력하세요.";
	else
		document.writeForm.submit();
	}
}
	
	
//회원가입 메일 주소 입력
function emailchange(){
	document.writeForm.email2.value=document.writeForm.email3.value
}

//아이디 중복체크
//function checkId(){
	//document.getElementById("idDIV").innerText="";
	//if(document.getElementById("id").value == "")
	//	document.getElementById("idDIV").innerText="아이디를 입력하세요.";
//}
function checkId(){
	var sId = document.getElementById("id").value;
	if(document.getElementById("id").value == "")
		document.getElementById("idDIV").innerHTML="<font color ='magenta'>먼저 아이디를 입력하세요</font>";
	else
		window.open("checkId.jsp?id="+sId,"checkId","width = 500 height = 150 left=200, top =200");
		//요즘엔 윈도우 잘 안쓰고 부트스트랩 이용해서 다이얼로그 이용한다.
}

//아이디 변경시 재중복체크
function recheck(){
	document.writeForm.duplication.value="n";
}
