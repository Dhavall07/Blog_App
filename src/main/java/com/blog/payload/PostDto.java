package com.blog.payload;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.blog.entity.Comment;
import com.blog.entity.User;
import com.blog.entity.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
	
	private Integer id;
	
	private String title;
	private String content;
	private String imagename;
	private Date addedDate;
	private CategoryDto Category;
	private UserDto user;
	private Set<CommentDto> comments = new HashSet<>();
//	public PostDto(Integer id, String title, String content, String imagename, Date addedDate, CategoryDto category,
//			UserDto user) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.content = content;
//		this.imagename = imagename;
//		this.addedDate = addedDate;
//		Category = category;
//		this.user = user;
//	}
//	
//
//	public PostDto(Integer id, String title, String content, String imagename, Date addedDate, CategoryDto category,
//			UserDto user, Set<CommentDto> comments) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.content = content;
//		this.imagename = imagename;
//		this.addedDate = addedDate;
//		Category = category;
//		this.user = user;
//		this.comments = comments;
//	}
//
//
//	public Set<CommentDto> getComments() {
//		return comments;
//	}
//
//
//	public void setComments(CommentDto comments) {
//		this.comments.add(comments);
//	}
//
//
//	public Integer getId() {
//		return id;
//	}
//
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//
//	public PostDto() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public PostDto(String title, String content, String imagename, Date addedDate, CategoryDto category, UserDto user) {
//		super();
//		this.title = title;
//		this.content = content;
//		this.imagename = imagename;
//		this.addedDate = addedDate;
//		this.Category = category;
//		this.user = user;
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
//	public String getImagename() {
//		return imagename;
//	}
//	public void setImagename(String imagename) {
//		this.imagename = imagename;
//	}
//	public Date getAddedDate() {
//		return addedDate;
//	}
//	public void setAddedDate(Date addedDate) {
//		this.addedDate = addedDate;
//	}
//	public CategoryDto getCategory() {
//		return Category;
//	}
//	public void setCategory(CategoryDto category) {
//		Category = category;
//	}
//	public UserDto getUser() {
//		return user;
//	}
//	public void setUser(UserDto user) {
//		this.user = user;
//	}
//	
//	
//	
	
	
}
