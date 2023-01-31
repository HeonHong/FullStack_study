/*$(function(){
	
	
});
이거랑 아래 방법 둘 다 사용 가능. 둘 다 onload형식
*/

$(document).ready(function(){
	//DB에서 1페이지당 5개씩 가져오기
	$.ajax({
		url: '/miniProject_MVC/board/getBoardList.do',
		type: 'post',
		data: 'pg='+$('#pg').val(),
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			//alert(data.list[0].id)
			
			//jquery For문
			$.each(data.list,function(index, items){
			//	java형식 for(BoardDTO items : data.list)
			// jstl형식 <c:forEach var="items" items="${data.list}"
			//console.log(index, itmes.seq, items.id, items.name, items.subject);
				$('<tr/>').append($('<td/>',{
					align : 'center',//태그들 뒤에 달리는 건 속성들이다
					id : items.seq,
					text : items.seq
				})).append($('<td/>',{
					}).append($('<a/>',{
					//href:'/miniProject_MVC/board/boardView.do?seq='+items.seq+"&pg="+$('#pg').val(),
					text : items.subject,
					class : 'subjectA'
					//중요 : id속성은 하나의 데이터를 넘길 때 좋고, class는 똑같은 태그가 여러 개가 있을 때 사용. 여긴 $.each문이기 class 여러 개 나온다
					}))//subject td태그의 자식
				).append($('<td/>',{
					align : 'center',
					text : items.id
				})).append($('<td/>',{
					align : 'center',
					text : items.hit
				})).append($('<td/>',{
					align : 'center',
					text : items.logtime
				})).appendTo($('#boardListTable'));
				//append는 바로 뒤에 붙여라. appendTo는 해당 이름 뒤에 모든 걸 가져다 붙여라.
				//메소드 chain방식
				
			});//$.each
			
			
			//로그인 여부
				$('.subjectA').click(function(){
						if($('#memId').val()=='')
							//json에 담았으면 data.memId
							alert('먼저 로그인하세요');
						else{ //alert($(this).parent().prev().prop('tagName'));
							//alert($(this).parent().prev().text());
							var seq =$(this).parent().prev().text();
							location.href = '/miniProject_MVC/board/boardView.do?seq=' + seq+"&pg="+$('#pg').val();
							}
				});
					
			
			//페이징처리
			$('#pagingDiv').html(data.pagingHTML);
			//.html로 해야한다. .text로 하면 글자 그대로 나옴.
			
		},
		error:function(err){
			console.log(err);
		}
	});
	
	
});