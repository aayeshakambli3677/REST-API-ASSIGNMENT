package com.category.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.category.model.Product;
import com.category.repository.ProductRepository;
import com.category.service.ProductService;

@Service
public class ProductServiceImplementation implements ProductService
{
	 @Autowired
	    private ProductRepository productRepository;

	    @Override
	    public Page<Product> getProducts(int page)
	    {
	        return productRepository.findAll(PageRequest.of(page, 5));
	    }

	    @Override
	    public Product getProductById(int id)
	    {
	        return productRepository.findById(id).orElse(null);
	    }

	    @Override
	    public Product addProduct(Product product)
	    {
	        return productRepository.save(product);
	    }

	    @Override
	    public Product updateProduct(Product product)
	    {
	        return productRepository.save(product);
	    }

	    @Override
	    public void deleteProduct(int id)
	    {
	        productRepository.deleteById(id);
	    }
}