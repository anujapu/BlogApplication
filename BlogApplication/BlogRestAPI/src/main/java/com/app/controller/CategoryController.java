package com.app.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.app.payloads.ApiResponse;
import com.app.payloads.CategoryDTO;
import com.app.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/createCategory")
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO)
	{
		return new ResponseEntity<CategoryDTO>(categoryService.createCategory(categoryDTO),HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<CategoryDTO> updatecategory(@RequestBody CategoryDTO categoryDTO,@PathVariable long id)
	{
		return new ResponseEntity<CategoryDTO>(categoryService.updateCategpry(categoryDTO, id),HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable long id)
	{
		return new ResponseEntity<CategoryDTO>(this.categoryService.getCategory(id),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDTO>> getAllCategories()
	{
		return new ResponseEntity<List<CategoryDTO>>(this.categoryService.getAllCategories(),HttpStatus.OK);
				
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable long id)
	{	categoryService.deleteCategory(id);
		ApiResponse apiResponse=new ApiResponse("Category deleted successfully", true);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
	}
}
