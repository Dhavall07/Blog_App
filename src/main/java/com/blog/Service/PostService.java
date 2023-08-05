package com.blog.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.entity.Post;
import com.blog.payload.PostDto;
import com.blog.payload.PostReponse;

@Service
public interface PostService {

		PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
		PostDto updatePost(PostDto postDto,Integer postId);
		void deletePost(Integer postId);
		PostReponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy);
		PostDto getPostByid(Integer postId);
		
	//	List<PostDto> getpostsByCategory(Integer categoryId);
	//	List<PostDto> getpostsByuser(Integer userId);
		
		List<PostDto> searchPost(String keyword);
		
}
