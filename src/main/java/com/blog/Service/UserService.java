package com.blog.Service;
import java.util.List;
import com.blog.payload.UserDto;


public interface UserService {
	
	UserDto createUser(UserDto user);
	
	UserDto updateteUser(UserDto user, Integer userId );
	
	UserDto getUserById( Integer userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId );
}
