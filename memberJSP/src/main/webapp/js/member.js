function checkId(){
	var sId = document.getElementById("id").value;
	if(document.getElementById("id").value == "")
		document.getElementById("idDIV").innerHTML="<font color ='magenta'>먼저 아이디를 입력하세요</font>";
	else
		window.open("checkId.jsp?id="+sId,"checkId","width = 500 height = 150 left=200, top =200");
		//요즘엔 윈도우 잘 안쓰고 부트스트랩 이용해서 다이얼로그 이용한다.
}//HTML인 거 조심할 것!!! 이건 인라인 방식이라 1순위. 우선순위 잘 생각해서 작성해야 한다.
//window.open("파일명",)
//스크립트 변수는 var, let, const
//windowName 지정안하면 무제한으로 계속 뜬다.

  function change(){
	document.WriteF.email2.value = document.WriteF.email3.value;
}

    function check(){
	if(document.WriteF.duplication.value=="n"){
		document.getElementById("idDIV").innerText="중복을 확인하세요.";
	}else{
	document.getElementById("nameDIV").innerText="";
	document.getElementById("idDIV").innerText="";
	document.getElementById("pwdDIV").innerText="";
	if(document.getElementById("name").value == "")
		document.getElementById("nameDIV").innerText="이름을 입력하세요.";
	else if(document.getElementById("id").value == "")
		document.getElementById("idDIV").innerText="아이디을 입력하세요.";
	else if(document.getElementById("pwd").value == "")
		document.getElementById("pwdDIV").innerText="비밀번호를 입력하세요.";
	else if(document.getElementById("pwd").value != document.getElementById("repwd").value)
		document.getElementById("pwdDIV").innerText="동일한 비밀번호를 입력하세요.";
	else{
		document.WriteF.submit();
		}
		}
	}
	
function recheck(){
	document.WriteF.duplication.value="n";
	
}

