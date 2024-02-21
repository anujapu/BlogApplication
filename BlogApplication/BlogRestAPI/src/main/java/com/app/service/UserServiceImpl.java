package com.app.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.websocket.server.ServerEndpoint;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.exception.ResourceNotFoundException;
import com.app.payloads.UserDTO;
import com.app.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDTO createuser(UserDTO userDTO) {
		User u=this.DTOToUser(userDTO);
		User savedUser=this.userRepository.save(u);
		return this.UserToDTO(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO, long id) {
		User user=this.userRepository.findById(id)
				.orElseThrow( () ->new ResourceNotFoundException("User","id",id));
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setAbout(userDTO.getAbout());
		
		User updatedUser=this.userRepository.save(user);
		UserDTO userDTO1=this.UserToDTO(updatedUser);
		return userDTO1;
	}

	@Override
	public UserDTO getUserByID(long id) {
		User u= this.userRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("User", "id",id));
		return this.UserToDTO(u);
	}

	@Override
	public List<UserDTO> getAllusers() {
		
		List<User> users=this.userRepository.findAll();
		List<UserDTO> userDTOs=users.stream().map(user->this.UserToDTO(user)).collect(Collectors.toList());
		return userDTOs;
	}
	
	@Override
	public void deleteUser(long id) {
		User u=this.userRepository.findById(id)
		.orElseThrow(()->new ResourceNotFoundException("User", "id", id));
		this.userRepository.delete(u);
	}
	
	private User DTOToUser(UserDTO userDTO)
	{
		User u = this.modelMapper.map(userDTO, User.class);
		return u;
	}
	
	private UserDTO UserToDTO(User user)
	{
		UserDTO userDTO = this.modelMapper.map(user, UserDTO.class);
		return userDTO;
	}
	
}
