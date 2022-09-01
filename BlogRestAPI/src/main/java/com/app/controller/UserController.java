package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.User;
import com.app.payloads.ApiResponse;
import com.app.payloads.UserDTO;
import com.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

		@Autowired
		private UserService userService;
		
		@PostMapping("/addUser")
		public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO)
		{
			System.out.println(userDTO.getName());
			UserDTO createUserDTO=this.userService.createuser(userDTO);
			return new ResponseEntity<UserDTO>(createUserDTO, HttpStatus.CREATED);
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDto,@PathVariable long id)
		{
			UserDTO updatedUser=this.userService.updateUser(userDto, id);
			return new ResponseEntity<UserDTO>(updatedUser,HttpStatus.OK);
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<ApiResponse> deleteUser(@PathVariable long id)
		{
			this.userService.deleteUser(id);
			return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted succesfully",true),HttpStatus.OK);
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<UserDTO> getuser(@PathVariable long id)
		{
			UserDTO userByID = this.userService.getUserByID(id);
			return new ResponseEntity<UserDTO>(userByID,HttpStatus.OK);
		}
		
		@GetMapping("/")
		public ResponseEntity<List<UserDTO>> getAllUsers()
		{
			List<UserDTO> allusers = this.userService.getAllusers();
			return new ResponseEntity<List<UserDTO>>(allusers,HttpStatus.OK);
		}
}
