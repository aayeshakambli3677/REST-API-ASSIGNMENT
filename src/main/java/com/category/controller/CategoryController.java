package com.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.category.model.Categories;
import com.category.repository.CategoryRepository;
import com.category.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController
{
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping
	public Page<Categories> getCategory(
	        @RequestParam(defaultValue = "0") int page)
	{
		return categoryRepository.findAll(
	            PageRequest.of(page,5));
	}
	
	@GetMapping("/{id}")
	public Categories getCategoryById(@PathVariable int id)
	{
		return this.categoryService.getCategoryById(id);
	}
	
	@PostMapping("/new")
	public Categories addCategory(@RequestBody Categories category)
	{
		return categoryService.addCategory(category);
	}
	
	@PutMapping("/edit")
	public Categories updateCategory(@RequestBody Categories category)
	{
		return this.categoryService.updateCategory(category);
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable int id)
	{
		try
		{
			categoryService.deleteCategory(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}