<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
form[name="updateForm"]  div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
<h2>회원정보 수정</h2>
<form name="updateForm" id="updateForm">
<!-- 이름이나 아이디를 잘못 작성하면 안들어간다. -->
	<table border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th>이름</th>
			<td>
				<input type="text" name="name" id="name"  readonly>
				<div id="nameDiv"></div>
			</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>
			 	<input type="text" name="id" id="id" size="30" readonly>
<!-- 			 	visibility false로 하면 submit해도 데이터가 넘어가지 않는다.
 -->			 	<!-- 내가 보낸 memberDTO객체를 그대로 받는 것인가? -->
				<div id="idDiv"></div>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="pwd" id="pwd" size="40">
				<div id="pwdDiv"></div>
			</td>
		</tr>
		<tr>
			<th>재확인</th>
			<td><input type="password" id="repwd" size="40" ></td>
		</tr>
	
		<tr>
			<th>성별</th>
			
				<td>
					<input type="radio" name="gender" id="gender_m" value="0"/>
					<label for="gender_m">남자</label>			
					<input type="radio" name="gender" id="gender_f" value="1" />
					<label for="gender_f">여자</label>	
				</td>	
			
			</tr>
		
		<tr>
			<th>이메일</th>
			<td>
				<input type="email" name="email1" id="email1"  style="width: 120px;">
				@
				<input type="email" name="email2" id="email2" style="width: 120px;">
			</td>
		</tr>
		<tr>
			<th>휴대폰</th>
			<td>
				<input type="tel" name="tel1" id="tel1"  style="width: 60px;">
				-
				<input type="tel" name="tel2" id="tel2"  style="width: 50px;">
				-
				<input type="tel" name="tel3" id="tel3" style="width: 50px;">
				</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				<input type="text" name="zipcode" id="zipcode"   readonly>
				<input type="button" value="우편번호검색" onclick="checkPost()"><br>
				<input type="text" name="addr1" id="addr1" style="width: 400px;"><br>
				<input type="text" name="addr2" id="addr2" style="width: 400px;">
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<button type="button" id="updateBtn">정보수정</button>
				<button type="reset">다시작성</button>
			</th>
		</tr>	
	</table>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.1.min.js"></script> 
<!-- CDN 방식으로 서버에 올려놓을 수 있다. -->
<!-- <script type="text/javascript" src="../js/jquery-3.6.1.min.js"></script> -->


<!-- 여기까진 화면에 데이터 값x -->
<script type="text/javascript">
/* window.onload=function(){} 이건 순수 스크립트 언어 */
$(function(){
	$.ajax({
		url:'/miniProject_MVC/member/getInformation.do',
		type:'post',
		dataType:'json',/* text, xml, html,json/ 객체불가 */
		success: function(data){
			//alert(JSON.stringify(data));//json형태로 들어오는 값 확인하기 위해 한 것.
			$('#name').val(data.name);
			$('#id').val(data.id);
			$('#pwd').val(data.pwd);
			$('input[name="gender"]:eq('+data.gender+')').attr("checked", true);//이름 속성 이용
			$('#email1').val(data.email1);
			$('#email2').val(data.email2);
			$('#tel1').val(data.tel1);
			$('#tel2').val(data.tel2);
			$('#tel3').val(data.tel3);
			$('#zipcode').val(data.zipcode);
			$('#addr1').val(data.addr1);
			$('#addr2').val(data.addr2);
		},
		error: function(err){
			console.log(err);
		}
	});
	
});
/* $함수. 제이쿼리 읽자마자 시작하라는 의미. onload랑 동일한 의미 
객체로 못받음
json으로 받아야함.
*/

$('#updateBtn').click(function() {
	   $("#nameDiv").text("")
	   $("#pwdDiv").text("")
	   
	   if($("#name").val() == ""){
	      $("#nameDiv").text("이름을 입력하세요")
	      $("#name").focus()   
	   } 
	   else if($("#pwd").val() == ""){
	      $("#pwdDiv").text("비밀번호를 입력하세요")
	      $("#pwd").focus()
	   }
	   else if($("#pwd").val() != $("#repwd").val()){
	      $("#pwdDiv").text("비밀번호가 맞지 않습니다.")
	      $("#pwd").focus
	   }
	   else{
	      console.log( $('#updateForm').serialize());
		   $.ajax({
	         url: '/miniProject_MVC/member/update.do',
	         type: 'post',
	         data: $('#updateForm').serialize(),//name속성을 가져간다
	         success:function(data){
	            location.href="/miniProject_MVC/member/update.jsp"
	         },
	         error: function(err){
	            console.log(err)
	         }
	      });
	   }
	})


</script>
	
<!-- 우편번호 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../js/post.js"></script>
</body>
</html>










