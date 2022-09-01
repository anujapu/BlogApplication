package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.annotations.SortType;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.config.AppConstants;
import com.app.entity.Post;
import com.app.payloads.ApiResponse;
import com.app.payloads.PostDTO;
import com.app.payloads.PostResponse;
import com.app.service.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDTO> createPost(@Valid @RequestBody PostDTO postDTO,@PathVariable long userId,@PathVariable long categoryId)
	{
		PostDTO createPost = this.postService.createPost(postDTO, userId, categoryId);
		return new ResponseEntity<PostDTO>(createPost, HttpStatus.CREATED);
	}
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDTO>> getPostsByCategory(@PathVariable long categoryId)
	{
		List<PostDTO> postsByCategory = this.postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDTO>>(postsByCategory,HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDTO>> getPostsByUser(@PathVariable long userId)
	{
		List<PostDTO> postByUser=this.postService.getPostsByUser(userId);
		return new ResponseEntity<List<PostDTO>>(postByUser, HttpStatus.OK);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPosts( @RequestParam(value="pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false)Integer pageNumber,
													@RequestParam (value="pageSize",defaultValue = AppConstants.PAGE_SIZE,required = false)Integer pageSize,
													@RequestParam( value="sortBy",defaultValue = AppConstants.sortBy,required = false)String sortBy,
													@RequestParam(value="sortType",defaultValue = AppConstants.sortType,required = false)String sortType)
	{
		return new ResponseEntity<PostResponse>(this.postService.getAllPosts(pageNumber,pageSize,sortBy,sortType), HttpStatus.OK);
	}

	@GetMapping("/posts/{id}")
	 public ResponseEntity<PostDTO>getPostById(@PathVariable long id) 
	 {
		PostDTO postByID = this.postService.getPostByID(id);
		return new ResponseEntity<PostDTO>(postByID, HttpStatus.OK);
	 }

	@DeleteMapping("/posts/{id}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable long id)
	{
		this.postService.deletePost(id);
		ApiResponse apiResponse=new ApiResponse("Post successfully deleted", true);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
	}
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable long postId)
	{
		PostDTO updatePost = this.postService.UpdatePost(postDTO, postId);
		return new ResponseEntity<PostDTO>(updatePost, HttpStatus.OK);
	}
	
	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<PostDTO>> searchByTitle(@PathVariable String keyword)
	{
		List<PostDTO> searchPost = this.postService.searchPost(keyword);
		return new ResponseEntity<List<PostDTO>>(searchPost, HttpStatus.OK);
	}
	
}
