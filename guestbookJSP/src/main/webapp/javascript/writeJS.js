function checkwrite(){
	
	
	document.getElementById("subjectDIV").innerText="";
	document.getElementById("contentsDIV").innerText="";
	
	if(document.getElementById("subject").value == ""){
		document.getElementById("subjectDIV").innerText="제목을 입력하세요.";
		document.guestbookWrite.subject.focus();
		}
	else if(document.guestbookWrite.contents.value == ""){
		document.getElementById("contentsDIV").innerText="내용을 입력하세요.";
		document.guestbookWrite.contents.focus();}
	else 
		document.guestbookWrite.submit();
		
		
		//document.loginForm.id.value?? >> 이건 네임 솏성을 이용한다는 뜻이다. 
		//네임속성을 사용할때는 form이름 사용해서 쓴다.
}

