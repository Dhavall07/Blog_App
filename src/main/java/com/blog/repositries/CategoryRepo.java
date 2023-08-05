package com.blog.repositries;


import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.User;
import com.blog.entity.category;

public interface CategoryRepo extends JpaRepository<category,Integer> {
	

}
