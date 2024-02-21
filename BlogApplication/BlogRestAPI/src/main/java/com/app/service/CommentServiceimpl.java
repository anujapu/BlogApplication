package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Comment;
import com.app.entity.Post;
import com.app.exception.ResourceNotFoundException;
import com.app.payloads.CommentDTO;
import com.app.payloads.PostDTO;
import com.app.repo.CommentRepository;
import com.app.repo.PostRepository;

@Service
public class CommentServiceimpl implements CommentService{

	@Autowired
	PostRepository postRepositoty;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDTO createComment(CommentDTO commentDTO,long postId) {
		Post post=this.postRepositoty.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "PostId", postId));
		Comment comment=this.modelMapper.map(commentDTO, Comment.class);
		comment.setPost(post);
		Comment savedComment = this.commentRepository.save(comment);
		CommentDTO commentDTO2= this.modelMapper.map(savedComment, CommentDTO.class);
		System.out.println(commentDTO2.getContent());
		return commentDTO2;
	}
	
	@Override
	public CommentDTO updateComment(CommentDTO comment, long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteComment(long id) {
		Comment comment=this.commentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Comment", "id", id));
		this.commentRepository.delete(comment);
	}

	
}
