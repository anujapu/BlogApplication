package com.app.service;

import java.util.List;

import com.app.entity.User;
import com.app.payloads.UserDTO;

public interface UserService {

	UserDTO createuser(UserDTO userDTO);
	UserDTO updateUser(UserDTO userDTO,long id);
	UserDTO getUserByID(long id);
	List<UserDTO> getAllusers();
	void deleteUser(long id);
}
