package com.blog.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class category {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String desc;
	@OneToMany(mappedBy= "Category",cascade=CascadeType.ALL)
	private List<Post> posts = new ArrayList<>();
	public category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public category(Integer id, String title, String desc) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
	}
	
	
	public category(Integer id, String title, String desc, List<Post> posts) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.posts = posts;
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
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
	
}
