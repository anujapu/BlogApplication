package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.payloads.ApiResponse;
import com.app.payloads.CommentDTO;
import com.app.payloads.PostDTO;
import com.app.service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {
	
	@Autowired
	CommentService commentService;

	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO,@PathVariable long postId)
	{
		CommentDTO createComment = this.commentService.createComment(commentDTO, postId);
		return new ResponseEntity<CommentDTO>(createComment, HttpStatus.CREATED);
	}
	
	@DeleteMapping("posts//comments/{id}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable long postId)
	{
		this.commentService.deleteComment(postId);
		ApiResponse apiResponse=new ApiResponse("comment deleted successfully",true);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
		
	}
	
}
