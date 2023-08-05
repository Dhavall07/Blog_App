package com.blog.Service.Impl;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.blog.Service.PostService;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.entity.category;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payload.CategoryDto;
import com.blog.payload.PostDto;
import com.blog.payload.PostReponse;
import com.blog.repositries.CategoryRepo;
import com.blog.repositries.PostRepo;
import com.blog.repositries.UserRepo;

@Service
@Component
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId) {
		category cat  = this.categoryRepo.findById(categoryId).orElseThrow((()-> new ResourceNotFoundException("category","id",categoryId))) ;
		User user  = this.userRepo.findById(userId).orElseThrow((()-> new ResourceNotFoundException("User","id",userId))) ;
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(cat);
		Post postSaved = this.postRepo.save(post);
		return this.modelMapper.map(postSaved,  PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow((()-> new ResourceNotFoundException("post","id",postId)));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImagename());
		Post updatedPost = this.postRepo.save(post);
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow((()-> new ResourceNotFoundException("post","id",postId)));
		this.postRepo.delete(post);
	}

	@Override
	public PostReponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy) {
		
		Pageable p = PageRequest.of(pageNumber, pageSize,  Sort.by(sortBy).descending());
		Page<Post> pagePost = this.postRepo.findAll(p);
		
		List<Post> allPosts = pagePost.getContent();
		List<PostDto> c = allPosts.stream().map(post->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		PostReponse postReponse = new PostReponse(); 
		postReponse.setContent(c);
		postReponse.setPageNumber(pagePost.getNumber());
		postReponse.setPageSize(pagePost.getSize());
		postReponse.setTotalElements(pagePost.getTotalElements());
		postReponse.setTotalPages(pagePost.getTotalPages());
		postReponse.setLastPage(pagePost.isLast());
		return postReponse;
	}

	@Override
	public PostDto getPostByid(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow((()-> new ResourceNotFoundException("post","id",postId)));
		return this.modelMapper.map(post, PostDto.class);
	}

//	@Override
//	public List<PostDto> getpostsByCategory(Integer categoryId) {
//		category cat  = this.categoryRepo.findById(categoryId).orElseThrow((()-> new ResourceNotFoundException("category","id",categoryId))) ;
//		List<Post> posts = this.postRepo.findByCategory(cat);
//		List<PostDto> c=posts.stream().map(post-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
//		return c;
//	}

//	@Override
//	public List<PostDto> getpostsByuser(Integer userId) {
//		
//		return null;
//	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		List<Post> posts=this.postRepo.searchByTitle("%"+keyword+"%");
		List<PostDto> c=posts.stream().map(post-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return c;
	}

}
