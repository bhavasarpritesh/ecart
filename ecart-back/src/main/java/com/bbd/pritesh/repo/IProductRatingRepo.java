package com.bbd.pritesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbd.pritesh.model.ProductRating;

public interface IProductRatingRepo extends JpaRepository<ProductRating, Integer> {

}
