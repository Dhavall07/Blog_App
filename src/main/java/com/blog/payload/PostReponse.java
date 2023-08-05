package com.blog.payload;

import java.util.List;

public class PostReponse {
	private List<PostDto> content;
	private Integer PageNumber;
	private Integer pageSize;
	private long totalElements;
	private Integer totalPages;
	private boolean lastPage;
	public PostReponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostReponse(List<PostDto> content, Integer pageNumber, Integer pageSize, long totalElements,
			Integer totalPages, boolean lastPage) {
		super();
		this.content = content;
		this.PageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.lastPage = lastPage;
	}
	public List<PostDto> getContent() {
		return content;
	}
	public void setContent(List<PostDto> content) {
		this.content = content;
	}
	public Integer getPageNumber() {
		return PageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		PageNumber = pageNumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long l) {
		this.totalElements = l;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public boolean getLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean b) {
		this.lastPage = b;
	}
	
	
}
