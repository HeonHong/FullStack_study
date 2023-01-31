function change(){
	document.writeForm.email2.value = document.writeForm.email3.value;
}

//업데이트
$('#updateBtn').click(function(){
	$('#pwdDiv').empty();
	
	if($('#pwd').val()!=$('#repwd').val()){
		$('#pwdDiv').text('비밀번호가 다릅니다.');
		$('#pwd').focus();
	}else{
		$.ajax({
			url:'/miniProject_MVC/member/update.do',
			type:'post',
			data:$('#updateForm').serialize(),
			success: function(){
				//alert("정보 수정 성공");
				//location.href = "/miniProject_MVC/member/index.jsp";
			},
			error: function(err){
				console.log(err);
			}		
			
		});
	}
})

//회원가입
$('#writeBtn').click(function(){
	$('#nameDiv').empty();
	$('#idDiv').empty();
	$('#pwdDiv').empty();
	
	if($('#name').val() == ''){
		$('#nameDiv').text('아이디를 입력하세요');
		$('#name').focus();

	}else if($('#id').val() == ''){
		$('#idDiv').text('아이디를 입력하세요');
		$('#id').focus();
		
	}else if ($('#pwd').val() == ''){
		$('#pwdDiv').text('비밀번호를 입력하세요');
		$('#pwdDiv').focus();
		
	}else if ($('#pwd').val() != $('#repwd').val()){
		$('#pwdDiv').text('비밀번호가 맞지 않습니다.');
		$('#pwdDiv').focus();
		
	}else if($('#id').val() != $('#check').val()){
		$('#idDiv').text('아이디 중복체크 하세요');
		$('#id').focus();
	
	}else{
		$.ajax({
			url: '/miniProject_MVC/member/write.do',
			type: 'post',
			data: $('#writeForm').serialize(),//name속성 이용
			success: function(){
				alert("회원가입 성공");
				location.href = "/miniProject_MVC/index.jsp";
			},
			error: function(err){
				console.log(err);
			}			
		});
	}
});
//console.log($('#writeForm').serialize())//serialize사용하면 데이터를 문자열화함.
//data : 'name='+${'name'} 원래는 데이터마다 다 이렇게 해줘야함.


//중복 아이디 체크

$('#id').focusout(function(){		
	if($('#id').val() == ''){
		$('#idDiv').text('먼저 아이디를 입력하세요');
		$('#idDiv').css('color', 'magenta');
		
	}else{
		//서버로 요청하고 제자리로 돌아와라
		//jquery.ajax 의 축약형
		$.ajax({
			url: 'http://localhost:8080/miniProject_MVC/member/checkId.do',
			type: 'post',
			data: 'id=' + $('#id').val(),
			dataType: 'text', //text, html, xml, json
			//데이터 타입 안정해주면 이용 불가
			success: function(data){//여기 data는 위의 데이터와 다른 임의로 쓴 이름이다.
				data = data.trim();//이건 뭐지?
				
				if(data == 'exist'){ //사용 불가능
					$('#idDiv').text('사용 불가능');
					$('#idDiv').css('color', 'red');
					
				}else if(data == 'non_exist'){//사용 가능
					$('#idDiv').text('사용 가능');
					$('#idDiv').css('color', 'blue');
					
					$('input[name="check"]').val($('#id').val());					
				}
			},
			error: function(){}
		});//$.ajax
	}
});

/*
형식
$.ajax({
	
		type : 'get' or 'post'
		url : 서버주소
		data : 서버로 보낼 데이터
		dataType : 서버로 부터 받는 데이터의 자료형
		객체를 받지 못한다. 그래서 JSON으로 바꿔줘야한다.
		spring에서는 json으로 자동으로 바꿔준다.
})

*/








