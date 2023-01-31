<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
	<input type="text" id="seq" value="${seq }"/>
	<input type="text" id="pg" value="${pg }"/>
	<input type="text" id="memId" value="${memId }"/>
	<table width ="450" border="1" cellpadding="5" frame="hsides" rules="rows">
		<!-- 길이 안잡으면 450 줄글로 나온다. -->
		<tr>
			<td colspan="3" >
				<h2><span id="subjectSpan"></span></h2>
			</td>
		</tr>
		
		<tr>
			<td width="150">글번호 : <span id="seqSpan"></span></td>
			<td width="150">작성자 : <span id="idSpan"></span></td>
			<td width="150">조회수 : <span id="hitSpan"></span></td>
		</tr>
		
		<tr>
			<td colspan="3" height="250" valign="top">
				<div style="width:100%; height:100%; overflow:auto">
				<!-- overflow는 세로로 긴 글일 때 스크롤바 뜨게 -->
				<pre style="white-space:pre-line;word-break:break-all;">
					<span id="contentSpan"></span>
				</pre>
				</div>
			</td>
		</tr>
	</table>
	
	<div style="margin-top:3px;">
	<input type="button" value="목록" onclick="location.href='/miniProject_MVC/board/boardList.do?pg=${pg}'"/>
	
	<span id="boardViewSpan">
		<input type="button" value="글수정" onclick="location.href='/miniProject_MVC/board/boardUpdateForm.do?seq=${seq}&memId=${memId }&pg=${pg }'">
		<input type="button" value="글삭제" onclick="location.href='/miniProject_MVC/board/boardDelete.do?seq=${seq}'"/>
	</span>
	</div>
	</form>
	
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script type="text/javascript">
	//script는 뒤에 죽어도 다 죽는다.
	$(function(){
		//alert("여기오냐?");
		$.ajax({
			url:'/miniProject_MVC/board/getBoard.do',
			type:'post',
			data:'seq='+$('#seq').val(),
			dataType: 'json',
			success : function(data){
				//alert(JSON.stringify(data));
				$('#subjectSpan').text(data.subject);
				$('#seqSpan').text(data.seq);
				$('#idSpan').text(data.id);
				$('#hitSpan').text(data.hit);
				$('#contentSpan').text(data.content);
				
				if($('#memId').val()==data.id){
					$('#boardViewSpan').show()
				}else{
					$('#boardViewSpan').hide()
				}
			},
			error : function(err){
				console.log(err);
			}
		});
	});
	</script>

</body>
</html>
