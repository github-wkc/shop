package cn.wkc.shop.utils;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	private int currentPage;  	// 当前页
	private int totalPage;   	 // 总页数
	private int record;     	 // 每页记录数
	private int totalRecord; 	 // 总的记录数
	private List<T> list = new ArrayList<T>();
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getRecord() {
		return record;
	}
	public void setRecord(int record) {
		this.record = record;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
