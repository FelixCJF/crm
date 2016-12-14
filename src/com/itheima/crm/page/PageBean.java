package com.itheima.crm.page;

import java.util.List;

public class PageBean<T> {
	//必须
	private int pageNum;		//当前页（第几页）
	private int pageSize;		//每页显示数据
	private int totalRecord;	//总记录数
	//计算
	private int startIndex;		//开始索引
	private int totalPage;		//总页数
	//分页结果
	private List<T> data;	//分页数据
	
	// 动态显示导航条
	private int start;
	private int end;
	
	
	public PageBean(int pageNum, int pageSize, int totalRecord) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		
		//1 算法：开始索引
		this.startIndex = (this.pageNum - 1) * this.pageSize;
		//2 算法：总页数
		this.totalPage = (this.totalRecord + this.pageSize - 1) / this.pageSize;
		
		//3 处理导航条 (显示10个分页)
		this.start = 1;
		this.end = 10;
		
		// totalPage = 4;
		if(this.totalPage <= 10){
			this.start = 1;
			this.end = this.totalPage;
		} else {
			// totalPage = 38 ,要求：前4后5
			
			this.start = this.pageNum - 4;
			this.end = this.pageNum + 5;
			
			// 第一页
			if(this.start < 1){
				this.start = 1;
				this.end = 10;
			}
			
			// 最后一页
			if(this.end > this.totalPage){
				this.end = this.totalPage;
				this.start = this.totalPage - 9;
			}
			
		}
		
	}
	
	
	
	
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	
	

}
