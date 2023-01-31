function writeForm(){
	
	location.href= '/memberServlet/member/writeForm.html';
	}
	
	
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
		
		
		//document.loginForm.id.value?? >> 이건 네임 솏성을 이용한다는 뜻이다. 
		//네임속성을 사용할때는 form이름 사용해서 쓴다.
}