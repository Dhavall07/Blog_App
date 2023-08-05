package com.blog.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.Comment;
import com.blog.entity.category;

public interface CommentRepo extends JpaRepository<Comment,Integer>{
	

}
