package com.blog.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.Service.UserService;
import com.blog.payload.UserDto;

@RestController
@RequestMapping("/api/users")
public class UserController {

		@Autowired
		private UserService userService;
		
		@PostMapping("/")
		public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
			UserDto createdUser = this.userService.createUser(userDto);
			return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable Integer id){
			UserDto updatedUser = this.userService.updateteUser(userDto, id);
			return ResponseEntity.ok(updatedUser);
		}
		
		@PreAuthorize("hasRole('ADMIN')")
		@DeleteMapping("/{id}")
		public ResponseEntity<?> DeleteUser(@PathVariable Integer id){
			this.userService.deleteUser(id);
			return new ResponseEntity<>(Map.of("message","deleted"),HttpStatus.OK);
		}
		
		@GetMapping("/")
		public ResponseEntity<List<UserDto>> getAllUsers(){
			return ResponseEntity.ok(this.userService.getAllUsers());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<UserDto> getUser(@PathVariable Integer id){
			return ResponseEntity.ok(this.userService.getUserById(id));
		}
		
		
}
