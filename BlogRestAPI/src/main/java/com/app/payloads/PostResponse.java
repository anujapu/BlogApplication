package com.app.payloads;

import java.util.List;

public class PostResponse {

private List<PostDTO> posts;
private int pageNumver;
private int pageSize;
private long totalElements;
private int totalPages;
private boolean isLast;

public PostResponse() {
	super();
	// TODO Auto-generated constructor stub
}

public List<PostDTO> getPosts() {
	return posts;
}

public void setPosts(List<PostDTO> posts) {
	this.posts = posts;
}

public int getPageNumver() {
	return pageNumver;
}

public void setPageNumver(int pageNumver) {
	this.pageNumver = pageNumver;
}

public int getPageSize() {
	return pageSize;
}

public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}

public long getTotalElements() {
	return totalElements;
}

public void setTotalElements(long totalElements) {
	this.totalElements = totalElements;
}

public int getTotalPages() {
	return totalPages;
}

public void setTotalPages(int totalPages) {
	this.totalPages = totalPages;
}

public boolean isLast() {
	return isLast;
}

public void setLast(boolean isLast) {
	this.isLast = isLast;
}



}
