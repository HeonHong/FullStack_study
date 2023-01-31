function change(){
	document.writeForm.email2.value = document.writeForm.email3.value;
}

function checkWrite(){
	document.getElementById("nameDiv").innerText = "";
	document.getElementById("idDiv").innerText = "";
	document.getElementById("pwdDiv").innerText="";
	
	if(document.getElementById("name").value == "")
		document.getElementById("nameDiv").innerText="이름을 입력하세요";
	
	else if(document.getElementById("id").value == "")
		document.getElementById("idDiv").innerText="아이디를 입력하세요";
	
	else if(document.getElementById("pwd").value == "")
		document.getElementById("pwdDiv").innerText="비밀번호를 입력하세요";
	
	else if(document.getElementById("pwd").value != document.getElementById("repwd").value)
		document.getElementById("pwdDiv").innerText="비밀번호가 맞지 않습니다.";
		
	else if( document.writeForm.id.value != document.writeForm.check.value)
		document.getElementById("idDiv").innerText="아이디 중복체크 하세요";
		
	else
		document.writeForm.submit();
}

// 중복 아이디 체크
// 제이쿼리 세미콜론 반드시 찍어야함
// 제이쿼리는 페이지 이동함 그자리에서 뿌려버림
// alert() 쓰면 평소와 다르게 페이지 이동 안하고 뜸
// focus가 들어갔다가 나올때 문제가 되는거임
$('#id').focusout(function(){
	/* 자바스크립트 문법 
	if(document.getElementById("id").value == "")
		document.getElementById("idDiv").innerText="아이디를 입력하세요";
	제이 쿼리 문법 / 위 아래는 같은 거임*/
	if($('#id').val() == ''){
		$('#idDiv').text('아이디를 입력하세요');
		$('#idDiv').css('color', 'magenta');
	} else {
		// 서버로 요청하고 제자리로 돌아와라 jquery랑 ajax는 화면 이동 하지마라
		// jquery.ajax();
		// 위아래는 같은거임
		$.ajax({
			
			url:'http://localhost:8080/miniProject_MVC/member/checkId.do',
			type: 'post',
			data: 'id='+ $('#id').val(),
			dataType: 'text', // 네가지 밖에 없음text, html, xml, json
			success: function(result){
				result = result.trim();
				if (result == 'exist') { // 사용 불가능
					$('#idDiv').text('사용 불가능');
					$('#idDiv').css('color', 'red');
									
				} else if (result =='non_exist') { // 사용 가능
					$('#idDiv').text('사용 가능');
					$('#idDiv').css('color', 'blue');
					$('input[name="check"]').val($('#id').val());
				}
			},
			// 1 text 안뜨고 ok
			// 2 유효성 검사에 값이 안들어감 ok
			
			// 3 jquery는 함수 선언해놓고 무조건 실행되는건지 ?..
			// 3 보통 함수는 만들어놓고 호출해서 사용 하는 건데 
			
			error: function(){}
			/*
			url:'서버로 요청할 url' 적기 / css랑 형식이 같음 
			type: 'get' or 'post' 이걸쓰면 action 이랑 post 지워도됨
			이제 submit 안해도됨 
			data: '서버로 보낼 데이터'
			dataType: '서버로 부터 받은 데이터 자료형' // 돌아 오는 데이터 
			success: function(){} 성공 했을때
			error: function(){} 실패 했을때 
			*/
		}); // $.ajax
	}
}); // focus out function













