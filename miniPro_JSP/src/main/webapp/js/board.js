function checkwrite(){
	
	document.getElementById("subjectDIV").innerText="";
	document.getElementById("contentDIV").innerText="";
	
	if(document.getElementById("subject").value == ""){
		document.getElementById("subjectDIV").innerText="제목을 입력하세요.";
		//document.boardWriteForm.subject.focus();
		}
	else if(document.getElementById("content").value == ""){
		document.getElementById("contentDIV").innerText="내용을 입력하세요.";
		//document.boardWriteForm.content.focus();
		}
	else 
		document.boardWriteForm.submit();
}

