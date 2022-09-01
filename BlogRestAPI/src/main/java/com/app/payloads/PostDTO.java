package com.app.payloads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDTO {
	
	private long postid;
	
	private String title;

	private String content;
	
	private String image;
	
	private Date creationDate;
	
	private CategoryDTO category;
	
	private UserDTO user;
	
	private List<CommentDTO> comments=new ArrayList<>();
	

	public PostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostDTO(long postid, String title, String content, String image, Date creationDate, CategoryDTO category,
			UserDTO user) {
		super();
		this.postid = postid;
		this.title = title;
		this.content = content;
		this.image = image;
		this.creationDate = creationDate;
		this.category = category;
		this.user = user;
	}

	public long getPostid() {
		return postid;
	}

	public void setPostid(long postid) {
		this.postid = postid;
	}


	public String getTitle() {
		return title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}
	
	
}
