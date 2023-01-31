<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
div{
color : red;
font-size : 8pt;
font-weight : bold;
}
</style>

</head>
<form name = "WriteF" method = "post" action = "http://localhost:8080/memberJSP/member/write.jsp">
<body>
<table border="1" cellpadding="5" cellspacing="0">
<tr> 
     <th width="100">이름</th>
     <td width="350"><input type = "text" name = "name" id = "name" placeholder="이름 입력"/>
     <div id="nameDIV"></div>
<tr> 
     <th width="100">아이디</th>
      <td><input type = "text" name = "id" id="id" placeholder="아이디 입력" 
      onclick = "recheck()">
      <input type="button" value ="중복체크" onclick="checkId()">
      <input type ="hidden" name = "duplication" value = "n">
      <div id="idDIV" name="idDIV"></div>
      </td>
</tr>
<tr> 
     <th width="100">비밀번호</th>
     <td><input type = "password" name= "pwd" id="pwd"  size = "20"/>
     </td>
</tr>

<tr> 
     <th width="100">재확인</th>
     <td><input type = "password" name= "repwd" id="repwd" size = "20"/>
      <div id="pwdDIV"></div>
     </td>
</tr>

<tr> 
     <th width="100">성별</th>
     <td>
     	<input type="radio" name="gender" id="gender" value="0" checked />
     	<label for="gender_m">남</label>
     	<input type="radio" name="gender" id="gender" value="1"/>
     	<label for="gender_f">여</label>
     </td>
</tr>

<tr> 
     <th width="100">이메일</th>
     <td><input type="email" name = "email1" id ="email1" style ="width:120px"/>@
   
     <input type="email" name = "email2" id ="email2" style ="width:120px"/>
     <select name="email3" onchange = "change()" style ="width:120px">
     				<option value="">직접입력</option>
     				<option value="gmail.com">gmail.com</option>
					<option value="naver.com">naver.ocm</option>
					<option value="hanmail.net">hanmail.net</option></select>

     </td>
</tr>

<!-- onclick해보기 -->



<tr> 
     <th width="100">핸드폰</th>
     		<td><select name="tel1">
					<option value="010" selected>010</option>
					<option value="011">011</option>
					<option value="019">019</option></select>-
					<input type = "text" name = "tel2" id="tel2" size= "2"/>-
					<input type = "text" name = "tel3" id="tel3" size= "2"/>
					</td>
	</tr>

<tr> 
     <th width="100">주소</th>
     <td><input type="text" name="zipcode" id="zipcode" size="6"  readonly />
     <input type="button" value = "우편번호 검색" onclick = "checkPost()"><br>
     <input type="text" name="addr1" id="addr1" /><br>
     <input type="text" name="addr2" id="addr2" /><br>
     </td>
</tr>

<tr> 
     <th width="100" colspan="2">
     <input type="button" value = "회원가입" onclick = "check()">
     <!-- 유효성 검사 안날라가게 하려면 submit 타입 말고 꼭 button타입으로 할것!!!!!  -->
     <input type="reset" value="다시 작성"/>
     </th>
     
</tr>
</table>

</form>


<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../js/post.js"></script>
<script src="../js/member.js"></script> <!-- 이런 걸 '상대주소' 라고 한다. -->
<!-- <script src="../js/member.js"/> 이렇게 단일로 바로 막으면 안된다. 그럼 함수 못찾는다. -->
</body>
</html>