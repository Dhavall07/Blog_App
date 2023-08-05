package com.blog.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Post {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String title;
	@Column(length=1000)
	private String content;
	private String imageName;
	private Date addedDate;
	@ManyToOne
	private category Category;
	@ManyToOne
	private User user;
	@OneToMany(mappedBy="post",cascade = CascadeType.ALL)
	private Set<Comment> comments = new HashSet<>();
//	public Post() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//	public Post(int id, String title, String content, String imageName, Date addedDate, category category, User user) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.content = content;
//		this.imageName = imageName;
//		this.addedDate = addedDate;
//		this.Category = category;
//		this.user = user;
//	}
//	
//	
//	public Post(int id, String title, String content, String imageName, Date addedDate, category category, User user,
//			Set<Comment> comments) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.content = content;
//		this.imageName = imageName;
//		this.addedDate = addedDate;
//		Category = category;
//		this.user = user;
//		this.comments = comments;
//	}
//
//	public Set<Comment> getComments() {
//		return comments;
//	}
//
//	public void setComments(Comment comments) {
//		this.comments.add(comments);
//	}
//
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getContent() {
//		return content;
//	}
//	public void setContent(String content) {
//		this.content = content;
//	}
//	public String getImageName() {
//		return imageName;
//	}
//	public void setImageName(String imageName) {
//		this.imageName = imageName;
//	}
//	public Date getAddedDate() {
//		return addedDate;
//	}
//	public void setAddedDate(Date addedDate) {
//		this.addedDate = addedDate;
//	}
//	public category getCategory() {
//		return Category;
//	}
//	public void setCategory(category category) {
//		Category = category;
//	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	
	
}

