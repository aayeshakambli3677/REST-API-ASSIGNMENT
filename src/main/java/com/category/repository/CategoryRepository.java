package com.category.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.category.model.Categories;

@Repository
public interface CategoryRepository extends JpaRepository<Categories,Integer>
{
    List<Categories> findById(int id);
}