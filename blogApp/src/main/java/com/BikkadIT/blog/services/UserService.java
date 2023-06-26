package com.BikkadIT.blog.services;

import java.util.List;

import com.BikkadIT.blog.payloads.UserDto;
import com.BikkadIT.blog.payloads.UserResponse;

public interface UserService {

	
	UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto user,Integer userId);
	UserDto getUserById(Integer userId);
	public UserResponse getAllUser(Integer pageNumber,Integer pageSize);
	public void deleteUser(Integer userId);
}
