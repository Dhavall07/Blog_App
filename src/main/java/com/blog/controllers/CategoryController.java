package com.blog.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.Service.CategoryService;
import com.blog.payload.CategoryDto;
import com.blog.payload.UserDto;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService catergoryService;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto createdCategory = this.catergoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createdCategory,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer id){
		CategoryDto updatedCategory = this.catergoryService.updateCategory(categoryDto,id);
		return new ResponseEntity<>(updatedCategory,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> DeleteUser(@PathVariable Integer id){
		this.catergoryService.deleteCategory(id);
		return new ResponseEntity<>(Map.of("message","deleted"),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
		return ResponseEntity.ok(this.catergoryService.getCategories());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer id){
		return ResponseEntity.ok(this.catergoryService.getCategory(id));
	}
	
	
	

}
