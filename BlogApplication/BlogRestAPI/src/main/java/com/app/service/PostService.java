package com.app.service;

import java.util.List;

import com.app.entity.Post;
import com.app.payloads.PostDTO;
import com.app.payloads.PostResponse;

public interface PostService {

	PostDTO createPost(PostDTO postDTO,long userUd,long categoryId);
	PostDTO UpdatePost(PostDTO postDTO,long id);
	void deletePost(long id);
	PostDTO getPostByID(long id);
	PostResponse getAllPosts(Integer PageNumber,Integer pageSize,String sortBy,String SortType);
	List<PostDTO> getPostsByCategory(long categoryId);
	List<PostDTO> getPostsByUser(long userId);
	List<PostDTO> searchPost(String keyword);
	
}
