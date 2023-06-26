package com.BikkadIT.blog.services;

import java.util.List;

import com.BikkadIT.blog.payloads.CategoryDto;
import com.BikkadIT.blog.payloads.CategoryResponse;

public interface CategoryService {
	//create
		public CategoryDto createCategory(CategoryDto categoryDto);

		// update
		public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	//delete
		public void deleteCategory(Integer categoryId);

	//get
		public CategoryDto getCategory(Integer categoryId);

	//getall
		public CategoryResponse getAllCategories(Integer pageNumber,Integer pageSize);
}
