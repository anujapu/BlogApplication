package com.app.payloads;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CategoryDTO {
	private long categoryID;
	@NotEmpty
	@Size(min=4,message="categoryName should be min 4 chars")
	private String categoryName;
	@NotEmpty
	@Size(min=15,message="categoryDescription should be min 15 chars")
	private String categoryDescription;
	
	
	
	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CategoryDTO(long categoryID, String categoryName, String categoryDescription) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}



	public long getCategoryID() {
		return categoryID;
	}



	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	public String getCategoryDescription() {
		return categoryDescription;
	}



	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	
}
