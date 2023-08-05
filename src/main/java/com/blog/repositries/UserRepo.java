package com.blog.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

import com.blog.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {
	Optional<User> findByEmail(String email);
}
