package com.bbd.pritesh.service;

import java.util.List;

import com.bbd.pritesh.model.ProductCategory;

public interface IProductCategoryService {
     ProductCategory saveProductCategory(ProductCategory productCategory);
     ProductCategory updateProductCategory(ProductCategory productCategory);
     ProductCategory getProductCategoryById(Integer id);
     void deleteProductCategoryById(Integer id);
     List<ProductCategory> getAll();
}
