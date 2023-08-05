package com.blog.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blog.Service.FileService;
import com.blog.Service.PostService;
import com.blog.entity.Post;
import com.blog.payload.CategoryDto;
import com.blog.payload.PostDto;
import com.blog.payload.PostReponse;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createCategory(@RequestBody PostDto postDto,@PathVariable Integer userId,@PathVariable Integer categoryId){
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<?> DeleteUser(@PathVariable Integer id){
		this.postService.deletePost(id);
		return new ResponseEntity<>(Map.of("message","deleted"),HttpStatus.OK);
	}
	
	@PutMapping("/posts/{id}")
	public ResponseEntity<PostDto> updatepost(@Valid @RequestBody PostDto postDto,@PathVariable Integer id){
		PostDto updatedpost = this.postService.updatePost(postDto, id);
		return new ResponseEntity<>(updatedpost,HttpStatus.CREATED);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<PostReponse> getAllposts(@RequestParam(value="pageNumber",defaultValue="1",required=false) Integer pageNumber,
													@RequestParam(value="pageSize",defaultValue="1",required=false)Integer pageSize,
												    @RequestParam(value="sortBy",defaultValue="id",required=false)String sortBy){
		return ResponseEntity.ok(this.postService.getAllPost(pageNumber,pageSize,sortBy));
	}
	
	@GetMapping("/posts/{id}")
	public ResponseEntity<PostDto> getCategory(@PathVariable Integer id){
		return ResponseEntity.ok(this.postService.getPostByid(id));
	}
	
	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable String keyword){
		List<PostDto> result= this.postService.searchPost(keyword);
		return new ResponseEntity<List<PostDto>> (result,HttpStatus.OK);
	}
	
	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadPostImage(@RequestParam("image") MultipartFile image ,
				@PathVariable Integer postId
			) throws IOException{
		
		PostDto postDto = this.postService.getPostByid(postId);
			String fileName = this.fileService.UploadImage(path, image); 
			
			postDto.setImagename(fileName);
			
			PostDto updatedPost = this.postService.updatePost(postDto, postId); 
			return new ResponseEntity<PostDto> (updatedPost,HttpStatus.OK);
	}
	
	@GetMapping(value="/post/image/{imageName}",produces=MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable String imageName, HttpServletResponse response) throws IOException {
		InputStream resource = this.fileService.getResources(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource,response.getOutputStream());
	}
	
	
}
