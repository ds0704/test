package com.study.springrest.domain;

public class PageMaker {
	
	int totalArticles;
	int startPage;
	int endPage;
	int totalPage;
	
	int pagePerBlock = 10;
	
	boolean next = false;
	boolean prev = false;
	
	Criteria criteria;
	
	public PageMaker(Criteria cri,int total){
		criteria = cri;
		totalArticles = total;
		process();
	}
	
	private void process(){
		//전체 페이지 수
		totalPage = (int)Math.ceil(totalArticles/(double)pagePerBlock);
		
		//요청한 페이지
		int currentPage = criteria.getPage();
		
		//페이지번호가 끝나는 숫자 10,20,30,
		endPage = (int)(Math.ceil(currentPage/(double)pagePerBlock) * pagePerBlock);
				
		//페이지번호가 시작되는 숫자 1,11,21
		startPage = endPage - pagePerBlock + 1;
		
		if(endPage > totalPage){
			endPage = totalPage;
		}
		
		//이전 페이지블럭 유무
		if(startPage>1){
			prev = true;
		}
		
		//다음 페이지블럭 유무 10,20
		if(endPage<totalPage){
			next = true;
		}
		
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalArticles() {
		return totalArticles;
	}

	public void setTotalArticles(int totalArticles) {
		this.totalArticles = totalArticles;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	
	
}
