package com.app.service;

import java.util.List;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Category;
import com.app.exception.ResourceNotFoundException;
import com.app.payloads.CategoryDTO;
import com.app.repo.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
	Category category = this.modelMapper.map(categoryDTO, Category.class);
	Category savedCategory = this.categoryRepository.save(category);
	return this.modelMapper.map(savedCategory,CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategpry(CategoryDTO categoryDTO, long id) {
		Category cat=this.categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category","id",id));
				cat.setCategoryName(categoryDTO.getCategoryName());
				cat.setCategoryDescription(categoryDTO.getCategoryDescription());
				Category updatedCategory=this.categoryRepository.save(cat);
			return this.modelMapper.map(updatedCategory, CategoryDTO.class);
	}

	@Override
	public CategoryDTO getCategory(long id) {
		Category category = this.categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Category","id",id));
		return this.modelMapper.map(category, CategoryDTO.class);
		
	}

	@Override
	public List<CategoryDTO> getAllCategories() {
		List<Category> categoryList = this.categoryRepository.findAll();
		List<CategoryDTO> categoryDTOList=categoryList.stream().map((category)->this.modelMapper.map(category,CategoryDTO.class)).collect(Collectors.toList());
		return categoryDTOList;
	}

	@Override
	public void deleteCategory(long id) {
		Category cat = this.categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "id", id));
		this.categoryRepository.delete(cat);
	}
	
	
}
