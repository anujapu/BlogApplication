package com.app.service;

import com.app.entity.Comment;
import com.app.payloads.CommentDTO;

public interface CommentService {

	CommentDTO createComment(CommentDTO comment,long postId);
	CommentDTO updateComment(CommentDTO comment,long id);
	void deleteComment(long id);
}
