package com.category.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.category.model.Product;

public interface ProductService
{
	Page<Product> getProducts(int page);

    Product getProductById(int id);

    Product addProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(int id);
}