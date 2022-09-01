package com.app.service;

import java.util.List;

import com.app.payloads.CategoryDTO;

public interface CategoryService {

	 CategoryDTO createCategory(CategoryDTO categoryDTO);
	 
	 CategoryDTO updateCategpry(CategoryDTO categoryDTO,long id);
	 
	 CategoryDTO getCategory(long id);
	 
	 List<CategoryDTO>getAllCategories();
	 
	 void deleteCategory(long id);
}
