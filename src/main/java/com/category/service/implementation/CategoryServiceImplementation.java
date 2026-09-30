package com.category.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.category.model.Categories;
import com.category.repository.CategoryRepository;
import com.category.service.CategoryService;

@Service
public class CategoryServiceImplementation implements CategoryService
{
	@Autowired
    private CategoryRepository categoryRepository;

	@Override
	public List<Categories> getCategory()
	{
		return categoryRepository.findAll();
	}

	@Override
	public Categories getCategoryById(int id)
	{
		return categoryRepository.findById(id).orElse(null);
	}

	@Override
	public Categories addCategory(Categories category)
	{
		return categoryRepository.save(category);
	}

	@Override
	public Categories updateCategory(Categories category)
	{
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(int id)
	{
		Categories entity = categoryRepository.getOne((int) id);
		categoryRepository.delete(entity);
	}
}
