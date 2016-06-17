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
		//��ü ������ ��
		totalPage = (int)Math.ceil(totalArticles/(double)pagePerBlock);
		
		//��û�� ������
		int currentPage = criteria.getPage();
		
		//��������ȣ�� ������ ���� 10,20,30,
		endPage = (int)(Math.ceil(currentPage/(double)pagePerBlock) * pagePerBlock);
				
		//��������ȣ�� ���۵Ǵ� ���� 1,11,21
		startPage = endPage - pagePerBlock + 1;
		
		if(endPage > totalPage){
			endPage = totalPage;
		}
		
		//���� ���������� ����
		if(startPage>1){
			prev = true;
		}
		
		//���� ���������� ���� 10,20
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