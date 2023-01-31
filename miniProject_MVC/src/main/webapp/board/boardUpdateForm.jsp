<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#boardWriteForm div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
	/* id일 때 #을 쓴다 */
}
</style>
</head>
<body>

<h3>글수정</h3>
<form name="boardUpdateForm" id="boardUpdateForm" method="post">
	<input type="text" name="seq" id="seq" value="${seq }"/>
	<input type="text" id="pg" value="${pg }"/>
	<input type="text" id="memId" value="${memId }"/>
<!-- action="/mvcMember/board/boardWrite.do" jquery에서 타고 갈거니까-->
	<table border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th width="70">제목</th>
			<td>
				<input type="text" name="subject" id="subject" maxlength="500" style="width: 350px;"/>
            	<div id="subjectDiv"></div>	
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea name="content" id="content" cols="50" rows="15" style="white-space: pre-wrap;"></textarea>
				<div id="contentDiv"></div>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="글수정" id="boardUpdateBtn">
            	<input type="reset" value="다시작성" onclick="location.reload()">				
			</td>
		</tr>
	</table>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.1.min.js"></script> 
<script type="text/javascript">
$(function(){
		//alert("여기오나?");
	$.ajax({
		url:'/miniProject_MVC/board/getBoard.do',
		type:'post',
		data:'seq='+$('#seq').val(),
		dataType:'json',
		success:function(data){
			//alert(JSON.stringify(data));
			$('#subject').val(data.subject);
			$('#content').text(data.content);
			$('#seq').val(data.seq);
		},
		error:function(err){
			console.log(err);
		}
	});	
	
});//fuction. 이거 아니면 onload사용.

$('#boardUpdateBtn').click(function(){
	$('#subjectDiv').empty();
	$('#contentDiv').empty();
	
	if($('#subject').val()==''){
		$('#subjectDiv').text('제목을 입력하세요');
		$('#subject').focus();
	}else if($('#content').val()==''){
		$('#contentDiv').text('내용을 입력하세요');
		$('#content').focus();
	}else{
	$.ajax({
		url:'/miniProject_MVC/board/boardUpdate.do',
		type:'post',
		data:$('#boardUpdateForm').serialize(),
		success:function(){
			alert("글 수정 성공");
			location.href='/miniProject_MVC/board/boardList.do?pg=1';
		},
		error:function(err){
			console.log(err);
		}
	});
}//if
});//boardUpdateBtn
</script>


</body>
</html>