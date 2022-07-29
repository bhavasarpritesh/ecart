package com.bbd.pritesh.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.pritesh.exception.ProductCategoryNotFound;
import com.bbd.pritesh.model.ProductCategory;
import com.bbd.pritesh.repo.IProductCategoryRepo;
import com.bbd.pritesh.service.IProductCategoryService;
@Service
public class ProductCategoryServiceImpl implements IProductCategoryService {

	@Autowired
	private IProductCategoryRepo repo;
	@Override
	public ProductCategory saveProductCategory(ProductCategory productCategory) {
		return repo.save(productCategory);
	}

	@Override
	public ProductCategory updateProductCategory(ProductCategory productCategory) {
		ProductCategory pc=getProductCategoryById(productCategory.getId());
		BeanUtils.copyProperties(productCategory, pc);
		return repo.save(pc);
	}

	@Override
	public ProductCategory getProductCategoryById(Integer id) {
		return repo.findById(id).orElseThrow(()->new ProductCategoryNotFound("Product Category Not Found id="+id));
		
	}

	@Override
	public void deleteProductCategoryById(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public List<ProductCategory> getAll() {
		return repo.findAll();
	}

}
