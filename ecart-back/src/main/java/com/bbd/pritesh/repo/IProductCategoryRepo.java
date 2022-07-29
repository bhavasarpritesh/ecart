package com.bbd.pritesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbd.pritesh.model.ProductCategory;

public interface IProductCategoryRepo extends JpaRepository<ProductCategory, Integer> {

}
