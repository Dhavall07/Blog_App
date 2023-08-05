package com.blog.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Service.CategoryService;
import com.blog.entity.User;
import com.blog.entity.category;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payload.CategoryDto;
import com.blog.payload.UserDto;
import com.blog.repositries.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {
	 
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		category cat = this.modelMapper.map(categoryDto, category.class);
		category saved = this.categoryRepo.save(cat);
		return this.modelMapper.map(saved, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		category cat  = this.categoryRepo.findById(categoryId).orElseThrow((()-> new ResourceNotFoundException("category","id",categoryId))) ;
		cat.setTitle(categoryDto.getTitle());
		cat.setDesc(categoryDto.getDesc());
		category saved = this.categoryRepo.save(cat);
		
		return this.modelMapper.map(saved, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
		category cat  = this.categoryRepo.findById(categoryId).orElseThrow((()-> new ResourceNotFoundException("category","id",categoryId))) ;
		this.categoryRepo.delete(cat);
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		category cat  = this.categoryRepo.findById(categoryId).orElseThrow((()-> new ResourceNotFoundException("category","id",categoryId))) ;
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<category> categories = this.categoryRepo.findAll();
		List<CategoryDto> c=categories.stream().map(cat-> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return c;
	}
	
	

}
