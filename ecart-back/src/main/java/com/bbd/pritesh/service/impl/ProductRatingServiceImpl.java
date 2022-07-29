package com.bbd.pritesh.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.pritesh.exception.ProductRatingNotFound;
import com.bbd.pritesh.model.ProductRating;
import com.bbd.pritesh.repo.IProductRatingRepo;
import com.bbd.pritesh.service.IProductRatingService;
@Service
public class ProductRatingServiceImpl implements IProductRatingService {

	@Autowired
	private IProductRatingRepo repo;
	@Override
	public ProductRating saveProductRating(ProductRating productRating) {
		return repo.save(productRating);
	}

	@Override
	public ProductRating updateProductRating(ProductRating productRating) {
		ProductRating pr=getProductRatingById(productRating.getId());
		BeanUtils.copyProperties(productRating, pr);
		return repo.save(pr);
	}

	@Override
	public ProductRating getProductRatingById(Integer id) {
		return repo.findById(id).orElseThrow(()->new ProductRatingNotFound("product rating not found id="+id));
	}

	@Override
	public void deleteProductRatingById(Integer id) {
		repo.deleteById(id);

	}

}
