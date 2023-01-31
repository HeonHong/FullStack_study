  function checkPost() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
         

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

           

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('zipcode').value = data.zonecode;
                document.getElementById("addr1").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("addr2").focus();
            }
        }).open();
    }
    
    function change(){
	document.WriteF.email2.value = document.WriteF.email3.value;
}
    function check(){
	
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
	else 
		document.WriteF.submit();
}