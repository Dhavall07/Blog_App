package com.blog.payload;

import javax.validation.constraints.NotBlank;

public class CategoryDto {
	private Integer id;
	@NotBlank
	private String title;
	@NotBlank
	private String desc;
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryDto(Integer id, String title, String desc) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
