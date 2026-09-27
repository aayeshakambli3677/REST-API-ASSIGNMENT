package com.category.service;

import java.util.List;

import com.category.model.Categories;

public interface CategoryService
{
	public List<Categories> getCategory();
	
	public Categories getCategoryById(int id);
	
	public Categories addCategory(Categories category);
	
	public Categories updateCategory(Categories category);
	
	public void deleteCategory(int id);
}