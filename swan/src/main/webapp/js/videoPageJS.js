//화면 open시 로드될 데이터
$(function(){
	$("#movie-Contents").load("./movie/basic_Contents.html");
	$("#tv-Contents").load("./tv_Program/basic_Contents.html");
	addBanner();
	
	console.log("여기 왔냐?")
});


//화면 open시 화면 사이즈에 따라 로드될 배너 개수
function addBanner(){
	var image = [];
	var titleSpan = ['TOP 100', 
				'왓챠 익스클루시브', 
				'왓챠 익스클루시브', 
				'추천 리스트',
				'NEW!',
				'스테디셀러',
				'베스트 셀렉션'
				];
	var titleH3 = ['애니메이션 BEST', 
				'아메리칸 러스트', 
				'완벽한 도쿄의 맛',
				'연말까지 완주 도전!',
				'새로운 에피소드',
				'왓챠 최고 인기작',
				'오직 왓챠에서!'
				];
	var titleP = ['4분기 인기작부터 추억 소환 탑골 애니까지!',
		'녹슬어 버린 꿈과 희망', 
		'도쿄 맛집 추천! 완벽을 추구하는 셰프들',
		'정주행 욕구를 자극하는 해외 시리즈 모음',
		'다음 화를 기다렸다면? 지금 확인하기!',
		'뭘 볼지 모르겠다면 여기서 골라보세요!',
		'왓챠 독점 오리지널 & 익스클루시브 콘텐츠'
		];
	
	
	
	image.push($('<img>',{
				'src':"https://an2-img.amz.wtchn.net/image/v2/lE2orIrrKp2bE-PiLqTA1A.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1KbklsMHNJbkFpT2lJdmRqSXZjM1J2Y21VdmFXMWhaMlV2TVRZMk1qVTBPRE0yTURreU1EQXdOVFE0TmlJc0luRWlPamd3ZlEubWJBangzc0ZYMXBNRUFWbjZDLW5IaWJJSFZnUWtYa3c4dmRNY2RDSHo1QQ",
				'alt':'banner1'		
	})
	)
	
	image.push($('<img>',{
				'src':'https://an2-img.amz.wtchn.net/image/v2/_P8sh_raT155ajmziLZtwg.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1KbklsMHNJbkFpT2lJdmRqSXZjM1J2Y21VdmFXMWhaMlV2TVRZMk9EUTVNRGN5T0RjME9ETTVNVEUxTnlJc0luRWlPamd3ZlEuU2tTQU9RaUZnTXVkSDZ1b3pYZC1fSE01SXJlYng5V2EwUkplODFSRnFGYw',
				'alt':'banner2'		
	})
	)
	image.push($('<img>',{
				'src':'https://an2-img.amz.wtchn.net/image/v2/FOesZZU9fNrfvLoaj7lgyw.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1KbklsMHNJbkFpT2lJdmRqSXZjM1J2Y21VdmFXMWhaMlV2TVRZMk9EUTVNRGd5TURFeU1UWXhORFV6TkNJc0luRWlPamd3ZlEuMVdOY1RQTlFsaHB4c19Kc1QtNkFuRWxiemhVbC1KRmZpaWZvUS1sSlFRUQ',
				'alt':'banner3'		
	})
	)
	image.push($('<img>',{
				'src':'https://an2-img.amz.wtchn.net/image/v2/4V9x9LpV4i4ICMjS_K1l9Q.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1KbklsMHNJbkFpT2lJdmRqSXZjM1J2Y21VdmFXMWhaMlV2TVRZMk9EUTVNRGMzTkRneU1EUXdPREV5TWlJc0luRWlPamd3ZlEuaDRoTmhYRGhBeHZCUnBpMFZXVzROYnFMNmttYjJJekktZl92VnhfdzdlUQ',
				'alt':'banner4'		
	})
	)
	image.push($('<img>',{
				'src':'https://an2-img.amz.wtchn.net/image/v2/mkx_Z82Yqc5aSF3tzb3-rg.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1KbklsMHNJbkFpT2lJdmRqSXZjM1J2Y21VdmFXMWhaMlV2TVRZMk9EUTVNRFUyTURFeU5qTTNPVFk1TlNJc0luRWlPamd3ZlEuR1dMaUlGQ2pSUEFNcFBYX2pXRkZ2Nmlya0hzMi1sNE44dzhvWXF2N0ttOA',
				'alt':'banner5	'		
	})
	)
	image.push($('<img>',{
				'src':'https://an2-img.amz.wtchn.net/image/v2/xPIQO-vUIyOHCTBVj6rzsw.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1KbklsMHNJbkFpT2lJdmRqSXZjM1J2Y21VdmFXMWhaMlV2TVRZMk5qVTNPRFF6TlRjd05UQTVNemsyTUNJc0luRWlPamd3ZlEuX0s0NTFIUDdYWEFkU1BsRTJOUEZoMlJ2cWs2OFMzYllCYTdyTzJnRldYTQ',
				'alt':'banner6'		
	})
	)		
	image.push($('<img>',{
				'src':'https://an2-img.amz.wtchn.net/image/v2/GT97LfTQqs_zm5Tc_ZEgXg.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1KbklsMHNJbkFpT2lJdmRqSXZjM1J2Y21VdmFXMWhaMlV2TVRZMk56VTFPREEzT0RJM01USTVNamszTWlJc0luRWlPamd3ZlEueTJlcXhzbzNDOEpzNkxBRDFmZnBCaWVPd3d0NmpyeVQtTXVWRnZKd1pIOA',
				'alt':'banner7'		
	})
	)
	
	$('.bannerbox').empty();
	if($(window).width()<900){
	for(i=0;i<7;i++){
		var input=$('<input>');
		input.attr({
					'type':'radio',
					'name':'banner',
					'id':'banner0'+(i+1)
		})
		
		if(i==0){
			input.attr('checked',true);
		}
		$('.bannerbox').append(input);
	}
		
	$('.bannerbox').append($('<ul>').addClass("bannerlist"));
	
	
	for(i=0;i<7;i++){
		
		var div=$('<div>');
		div.css({"align-items": "left"})
		var div2=$('<div>');
		div2.addClass('banneritemDiv');
		div2.css({"width" : "100%"});
		var a=$('<a>');
		var li=$('<li>');
		li.addClass("banneritem");
		
		
		
		div.append($('<span>').html(titleSpan[i])).append($('<h3>').html(titleH3[i])).append($('<p>').html(titleP[i]));
		a.append(image[i]);
		div2.append(div).append(a);
		li.append(div2);
		$('.bannerlist').append(li);
	}
	$('.bannerbox').append($('<div>').addClass("banner-control"));
	
	for(i=0;i<7;i++){
		var label1=$('<label>');
		var label2=$('<label>');
		
		label1.addClass("prev");
		label2.addClass("next");
		
		if(i==0){
			label1.attr('for','banner0'+7);
		}else{
			label1.attr('for','banner0'+(i));
		}
		
		if(i==6){
			label2.attr('for','banner0'+1);
		}else{
			label2.attr('for','banner0'+(i+2));
		}
		
		var div=$('<div>');
		div.addClass("control0"+(i+1));
		
		div.append(label1).append(label2);
		$('.banner-control').append(div);
	}
	
	}else if($(window).width()<1500){
	      

	for(i=0;i<4;i++){
		var input=$('<input>');
		input.attr({
					'type':'radio',
					'name':'banner',
					'id':'banner0'+(i+1)
		})
		
		if(i==0){
			input.attr('checked',true);
		}
		$('.bannerbox').append(input);
	}
		
	$('.bannerbox').append($('<ul>').addClass("bannerlist"));
	
	
	for(i=0;i<4;i++){
		
		var li=$('<li>');
		li.addClass("banneritem");
		
		for(k=0;k<2;k++){
		var div=$('<div>');
		div.css({"align-items": "left"})
		var div2=$('<div>');
		div2.addClass('banneritemDiv');
		div2.css({"width" : "50%"});
		var a=$('<a>');
		
		if(((k)+(i*2))!=7){

			div.append($('<span>').html(titleSpan[((k)+(i*2))])).append($('<h3>').html(titleH3[((k)+(i*2))])).append($('<p>').html(titleP[((k)+(i*2))]));
			a.append(image[((k)+(i*2))]);
			div2.append(div).append(a);
			li.append(div2);
			}
		}
		$('.bannerlist').append(li);
	}
	
	
	$('.bannerbox').append($('<div>').addClass("banner-control"));
	
	for(i=0;i<4;i++){
		var label1=$('<label>');
		var label2=$('<label>');
		
		label1.addClass("prev");
		label2.addClass("next");
		
		if(i==0){
			label1.attr('for','banner0'+4);
		}else{
			label1.attr('for','banner0'+(i));
		}
		
		if(i==3){
			label2.attr('for','banner0'+1);
		}else{
			label2.attr('for','banner0'+(i+2));
		}
		
		var div=$('<div>');
		div.addClass("control0"+(i+1));
		
		div.append(label1).append(label2);
		$('.banner-control').append(div);
	}
	
	var position=document.querySelector(':root');
	position.style.setProperty('--bannerSize4p','-250%'); 
}else{
	      

	for(i=0;i<3;i++){
		var input=$('<input>');
		input.attr({
					'type':'radio',
					'name':'banner',
					'id':'banner0'+(i+1)
		})
		
		if(i==0){
			input.attr('checked',true);
		}
		$('.bannerbox').append(input);
	}
		
	$('.bannerbox').append($('<ul>').addClass("bannerlist"));
	
	
	for(i=0;i<3;i++){
		
		var li=$('<li>');
		li.addClass("banneritem");
		
		for(k=0;k<3;k++){
		var div=$('<div>');
		div.css({"align-items": "left"})
		var div2=$('<div>');
		div2.addClass('banneritemDiv');
		div2.css({"width" : "33%"});
		var a=$('<a>');
		
		if((((k)+(i*3))!=7) && (((k)+(i*3))!=8)){

			div.append($('<span>').html(titleSpan[((k)+(i*3))])).append($('<h3>').html(titleH3[((k)+(i*3))])).append($('<p>').html(titleP[((k)+(i*3))]));
			a.append(image[((k)+(i*3))]);
			div2.append(div).append(a);
			li.append(div2);
			}
		}
		$('.bannerlist').append(li);
	}
	
	
	$('.bannerbox').append($('<div>').addClass("banner-control"));
	
	for(i=0;i<3;i++){
		var label1=$('<label>');
		var label2=$('<label>');
		
		label1.addClass("prev");
		label2.addClass("next");
		
		if(i==0){
			label1.attr('for','banner0'+3);
		}else{
			label1.attr('for','banner0'+(i));
		}
		
		if(i==2){
			label2.attr('for','banner0'+1);
		}else{
			label2.attr('for','banner0'+(i+2));
		}
		
		var div=$('<div>');
		div.addClass("control0"+(i+1));
		
		div.append(label1).append(label2);
		$('.banner-control').append(div);
	}
	
	var p3=document.querySelector(':root');
	p3.style.setProperty('--size','-133%')
	
}
	
	
	
}


//사이즈에 따른 배너 갯수 조절	
$(window).resize(function(){
		//상단 버튼 삭제
		$(".headcategory-copy").empty();
		
		//배너 개수 설정	
		$(".banneritemDiv").remove();
		
		addBanner();
		setTopTen_SlideNum();
		addTopTenSlide();
		
});


//카테고리 구분 버튼(전체, 영화, TV프로그램)
$(function(){
	$('.head-category > button:eq(0)').click(function(){
		$('.head-category > button').not(this).removeClass("category");
		$(this).addClass("category"); 	
		$("#movie-Contents").load("./movie/basic_Contents.html");
		$("#tv-Contents").load("./tv_Program/basic_Contents.html");
	})
	$('.head-category > button:eq(1)').click(function(){
		$('.head-category > button').not(this).removeClass("category");
		$(this).addClass("category"); 	
		$("#movie-Contents").load("./movie/category_Contents.html");
		$("#tv-Contents").load("empty.html");
	})
	$('.head-category > button:eq(2)').click(function(){
		$('.head-category > button').not(this).removeClass("category");
		$(this).addClass("category"); 	
		$("#movie-Contents").load("empty.html");
		$("#tv-Contents").load("./tv_Program/category_Contents.html");
	})
});


//topTen슬라이드 추가
function addTopTenSlide(){
	
	
	$(".topTen_slidelist").remove();
	
	var image =[];
	image.push($('<img>',{
				'src':'https://an2-img.amz.wtchn.net/image/v2/cfWLI51EKgCdLkM89wNX1w.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk56STVlREV3T0RCeE9EQWlYU3dpY0NJNklpOTJNaTl6ZEc5eVpTOXBiV0ZuWlM4eE5qWTFNVEk1TlRVM09UUXdOelk1TnpVMkluMC5sY0N5RXI1elhHQi12RnVuQXlNVjlxRXB5Qk0wcDhVXzFCMmJrZmZqWjJv',
				'alt':'top1'		
	})
	)
	
	image.push($('<img>',{
				'src':'https://an2-img.amz.wtchn.net/image/v2/yKtqMeCsuKXDOZhXJNp1sA.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk56STVlREV3T0RCeE9EQWlYU3dpY0NJNklpOTJNaTl6ZEc5eVpTOXBiV0ZuWlM4eE5qWTRNVFUzTkRReU1EVXlOakU1T1RRMEluMC51NXRKOTA1Y0MtTE93QzFySlFPRXpaQUJReFdHZFVBTWdEUEZlRko2emxr',
				'alt':'top2'		
	})
	)
	
	image.push($('<img>',{
				'src':'https://an2-img.amz.wtchn.net/image/v2/M9HpmW9R6pEAr-lIh77n4A.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk56STVlREV3T0RCeE9EQWlYU3dpY0NJNklpOTJNaTl6ZEc5eVpTOXBiV0ZuWlM4eE5qTXhNREUwTkRjNE16VTVOREUyTnpnMkluMC5NOXk1dXJlV1JpSEpVRlBuc204REltYW1TZURmNnBleVpNcHVudDNpT1Aw',
				'alt':'top3'		
	})
	)
	
	image.push($('<img>',{
				'src':'https://an2-img.amz.wtchn.net/image/v2/vah6nKsEC9zwAZ7GQpVrbw.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk56STVlREV3T0RCeE9EQWlYU3dpY0NJNklpOTJNaTl6ZEc5eVpTOXBiV0ZuWlM4eE5qUTVPVGcyTkRFM05ETTJNRGd6TkRJMUluMC5SWlRJNEJUZXVBTWpiZG4tbHhoNUE2eFZlZU90TEpMM1kzb1ByaHAtVWtJ',
				'alt':'top4'		
	})
	)
	image.push($('<img>',{
				'src':'https://an2-img.amz.wtchn.net/image/v2/SdBKhTpdydb3VphmhAotIA.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk56STVlREV3T0RCeE9EQWlYU3dpY0NJNklpOTJNaTl6ZEc5eVpTOXBiV0ZuWlM4eE5qTTRNelEzT1RnNU1UTTVOVEF4TVRrM0luMC5XVDZQa3AzU0VPSmZSdXpST0FXZkFvWDNRX2tUb2IwZEhjWVIyUzhOQjQ0',
				'alt':'top5'		
	})
	)
	image.push($('<img>',{
				'src':'https://an2-img.amz.wtchn.net/image/v2/fHTDXfJrd_OulnpxVBXRCg.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk56STVlREV3T0RCeE9EQWlYU3dpY0NJNklpOTJNaTl6ZEc5eVpTOXBiV0ZuWlM4eE5qWTJOemMwTlRneU16azNNREV5TWpNNUluMC5QQWdPYnBsNmtabU1WcHZFMUR0VWpUdC0tQ0c4eXFXT0VzNGJmLXdCUDFJ',
				'alt':'top6'		
	})
	)
	image.push($('<img>',{
				'src':'https://an2-img.amz.wtchn.net/image/v2/VD4FUROE8xEafLgjEPu17Q.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk56STVlREV3T0RCeE9EQWlYU3dpY0NJNklpOTJNaTl6ZEc5eVpTOXBiV0ZuWlM4eE5qTXhNek16TVRFMk5qTTBOek01TVRnekluMC5VS2VUeUh0R3NTNkRCU29wdVVXb0ZGLVBUUVRQTXIxLWtsWC0yZnEyQlVF',
				'alt':'top7'		
	})
	)
	image.push($('<img>',{
				'src':'https://an2-img.amz.wtchn.net/image/v2/zZJwDOb2-nmi4rGCE8Z9QA.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk56STVlREV3T0RCeE9EQWlYU3dpY0NJNklpOTJNaTl6ZEc5eVpTOXBiV0ZuWlM4eE5qWTRNVFEwTnpjNE5qQXdPRFU0TXpJd0luMC4yT0hNSjczbUF5c2t6UUh0YmNSYVNMalVpejFUOFhwandrMjhBQjlyUnVj',
				'alt':'top8'		
	})
	)
	image.push($('<img>',{
				'src':'https://an2-img.amz.wtchn.net/image/v2/M9HpmW9R6pEAr-lIh77n4A.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk56STVlREV3T0RCeE9EQWlYU3dpY0NJNklpOTJNaTl6ZEc5eVpTOXBiV0ZuWlM4eE5qTXhNREUwTkRjNE16VTVOREUyTnpnMkluMC5NOXk1dXJlV1JpSEpVRlBuc204REltYW1TZURmNnBleVpNcHVudDNpT1Aw',
				'alt':'top9'		
	})
	)
	image.push($('<img>',{
				'src':'https://an2-img.amz.wtchn.net/image/v2/zeBVQVcInd1-dt31RYDJEg.jpg?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk56STVlREV3T0RCeE9EQWlYU3dpY0NJNklpOTJNaTl6ZEc5eVpTOXBiV0ZuWlM4eE5qWTFPVGM1TmpVMU1qRTFOVFl4TnpJeEluMC5Fd3hpdXlaaEw4bkgySVV4empCMnlkalFFa05KMHlDTDdtMUpSX0FCcl9j',
				'alt':'top10'		
	})
	)
	
	if($(window).width() < 1000){
	
	var ul = $('<ul>')
	ul.addClass('topTen_slidelist');
	
	for(k=1;k<4;k++){
		var topTen_slideitem = $('<li>');
		topTen_slideitem.addClass("topTen_slideitem");
		var topTen_slideDiv_arr=[]; 
		
		for(i=0;i<4;i++){
			var topTen_slideDiv = $('<div>');
			var topTen_a = $('<a>');
			var topTen_Rank = $('<div>');
			
			if((i+(k*4-3))<=10){
			topTen_Rank.addClass("topTen_Rank");
			topTen_Rank.text(i+(k*4-3));
			topTen_a.append(topTen_Rank).append(image[i+(k*4-4)]);
			
			
			topTen_slideDiv.append(topTen_a);
			topTen_slideDiv.addClass("topTen_slideDiv");
			topTen_slideDiv.css("width","25%");
			topTen_slideDiv_arr.push(topTen_slideDiv);
			}
	}
		
	for(i=0;i<4;i++){
		topTen_slideitem.append(topTen_slideDiv_arr[i]);
	}
	
	ul.append(topTen_slideitem);
	
	}
	$('.topTen_slidebox').append(ul);
	$('#topTen_slide03:checked','.topTen_slidelist .topTen_slideitem').css(
		"left","-150%"
	)
	
	var theme=document.querySelector(':root');
	theme.style.setProperty('--size','-150%');       
	
	}else if($(window).width() < 1600){
	
	var ul = $('<ul>')
	ul.addClass('topTen_slidelist');
	
	for(k=1;k<3;k++){
		var topTen_slideitem = $('<li>');
		topTen_slideitem.addClass("topTen_slideitem");
		var topTen_slideDiv_arr=[]; 
	
	for(i=0;i<5;i++){
		var topTen_slideDiv = $('<div>');
		var topTen_a = $('<a>');
		var topTen_Rank = $('<div>');
		
		topTen_Rank.addClass("topTen_Rank");
		topTen_Rank.text(i+(k*5-4));
		topTen_a.append(topTen_Rank).append(image[i+(k*5-5)]);
		topTen_slideDiv.append(topTen_a);
		topTen_slideDiv.addClass("topTen_slideDiv");
		topTen_slideDiv_arr.push(topTen_slideDiv);
	}
		
	for(i=0;i<5;i++){
		topTen_slideitem.append(topTen_slideDiv_arr[i]);
	}
	
	ul.append(topTen_slideitem);
	}
	$('.topTen_slidebox').append(ul);
	var theme=document.querySelector(':root');
	theme.style.setProperty('--size2','-100%');  
	
	}else{
	
	var ul = $('<ul>')
	ul.addClass('topTen_slidelist');
	
	for(k=1;k<3;k++){
		var topTen_slideitem = $('<li>');
		topTen_slideitem.addClass("topTen_slideitem");
		var topTen_slideDiv_arr=[]; 
	
	for(i=0;i<7;i++){
		var topTen_slideDiv = $('<div>');
		var topTen_a = $('<a>');
		var topTen_Rank = $('<div>');
		if((i+(k*7-6))<=10){
		topTen_Rank.addClass("topTen_Rank");
		topTen_Rank.text(i+(k*7-6));
		topTen_a.append(topTen_Rank).append(image[i+(k*7-7)]);
		topTen_slideDiv.append(topTen_a);
		topTen_slideDiv.addClass("topTen_slideDiv");
		topTen_slideDiv.css("width","14%");
		topTen_slideDiv_arr.push(topTen_slideDiv);
		}
	}
		
	for(i=0;i<7;i++){
		topTen_slideitem.append(topTen_slideDiv_arr[i]);
	}
	
	ul.append(topTen_slideitem);
	}
	$('.topTen_slidebox').append(ul);
	
	
	var theme=document.querySelector(':root');
	theme.style.setProperty('--size2','-42%');  
	}

}

//topTen 슬라이드 개수 조절
function setTopTen_SlideNum(){
	$("[id^='topTen_slide0']").remove();
	$('.topTen_slide-control').remove();
	
	
	if($(window).width() < 1300){
		for(i=0;i<3;i++){
		//input태그 생성
		var input_radio = $('<input>');
		input_radio.attr({
					'type':'radio',
					'name':'topTen_slide',
					'id':'topTen_slide0'+(i+1)
		})
	
		$('.topTen_slidebox').append(input_radio);
	}
	$('#topTen_slide01').attr('checked',true);
	
	
	var control = $('<div>');
	control.addClass("topTen_slide-control");
	
	for(i=0;i<3;i++){
		//label생성
		var control_div = $('<div>');
		var label_prev = $('<label>');
		label_prev.addClass("prev");
		var label_next = $('<label>');
		label_next.addClass("next");
		control_div.addClass("control0"+(i+1));
		
		if(i==0){
			label_prev.attr('for','topTen_slide0'+3);
		}else{
			label_prev.attr('for','topTen_slide0'+(i));
		}
		
		if(i==2){
			label_next.attr('for','topTen_slide0'+1);
		}else{
			label_next.attr('for','topTen_slide0'+(i+2));
		}
		
		
		
		
		control_div.append(label_prev).append(label_next);
		
		
		control.append(control_div);
		$('.topTen_slidebox').append(control);
	}//for
		
	}else{
	
	for(i=0;i<2;i++){
		//input태그 생성
		var input_radio = $('<input>');
		input_radio.attr({
					'type':'radio',
					'name':'topTen_slide',
					'id':'topTen_slide0'+(i+1)
		})
	
		$('.topTen_slidebox').append(input_radio);
	}
	$('#topTen_slide01').attr('checked',true);
	
	
	var control = $('<div>');
	control.addClass("topTen_slide-control");
	
	for(i=0;i<2;i++){
		//label생성
		var control_div = $('<div>');
		var label_prev = $('<label>');
		label_prev.addClass("prev");
		var label_next = $('<label>');
		label_next.addClass("next");
		control_div.addClass("control0"+(i+1));
		
		
		
		label_prev.attr('for','topTen_slide0'+(2-i));
		label_next.attr('for','topTen_slide0'+(2-i));
		control_div.append(label_prev).append(label_next);
		
		
		control.append(control_div);
		$('.topTen_slidebox').append(control);
	}//for
	
	}//1500마감

}
