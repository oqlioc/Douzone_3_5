package com.example.board.model;

import java.util.List;

public class PageModel {

	private List<BbsModel> list;
    private int maxpage;
    private int currpage;
    private int size;
    
	public PageModel(List<BbsModel> list, int maxpage, int currpage, int size) {
		super();
		this.list = list;
		this.maxpage = maxpage;
		this.currpage = currpage;
		this.size = size;
	}
	
	public List<BbsModel> getList() {
		return list;
	}
	public void setList(List<BbsModel> list) {
		this.list = list;
	}
	public int getMaxpage() {
		return maxpage;
	}
	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}
	public int getCurrpage() {
		return currpage;
	}
	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "PageModel [list=" + list + ", maxpage=" + maxpage + ", currpage=" + currpage + ", size=" + size + "]";
	}
	
}
