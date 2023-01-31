package board.bean;

import lombok.Data;

@Data
public class BoardPaging {

	private int currentPage;//현재페이지
	private int pageBlock;//[이전] 1 2 3 [다음]
	private int pageSize;//페이지당 게시글 수
	private int totalA;//총글수
	private StringBuffer pagingHTML;//StringBuilder도 가능. 블락 만들어주려고 하는 거임
	
	public void makePagingHTML() {
		pagingHTML = new StringBuffer();
		
		int totalP = (totalA + pageSize -1)/pageSize;
		
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		int endPage = startPage + pageBlock - 1;
		if(endPage>totalP) endPage = totalP;
		if(startPage != 1)pagingHTML.append("<span id='paging' onclick='boardPaging(" + (startPage-1)+")'>[이전]</span>");
		//if(startPage != pageBlock)pagingHTML.append("[이전]");
		
		for(int i=startPage;i<=endPage;i++) {
			if(i==currentPage)
				pagingHTML.append("<span id='currentPaging' onclick='boardPaging(" + i+")'>[" + i + "]</span>");
			else
				pagingHTML.append("<span id='paging' onclick='boardPaging(" + i +")'>[" + i + "]</span>");
		}//for
		if(endPage<totalP) pagingHTML.append("<span id='paging' onclick='boardPaging(" + (endPage+1)+")'>[다음]</span>");
	}
}
