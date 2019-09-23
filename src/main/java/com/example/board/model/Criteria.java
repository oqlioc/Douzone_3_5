package com.example.board.model;

import java.util.List;

public class Criteria {

	private int page;  // 현재 페이지 번호
	private int perPageNum;  // 페이지 당 출력되는 게시글의 갯수
	
	public Criteria() {  // 기본 현재 페이지 : 1, 페이지 당 출력 게시글의 갯수 : 10
		this.page = 1;
		this.perPageNum = 10;
	}
	
	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPerPageNum() {
		return this.perPageNum;
	}
	
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}
}
