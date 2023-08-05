package com.blog.Service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Service.CommentService;
import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payload.CommentDto;
import com.blog.repositries.CommentRepo;
import com.blog.repositries.PostRepo;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow((()-> new ResourceNotFoundException("post","id",postId)));
		Comment comment=this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment = this.commentRepo.save(comment);
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer id) {
		Comment comm = this.commentRepo.findById(id).orElseThrow((()-> new ResourceNotFoundException("comment","id",id)));
		this.commentRepo.delete(comm);

	}

}
