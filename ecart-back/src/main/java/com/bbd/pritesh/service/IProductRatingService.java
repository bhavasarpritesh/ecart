package com.bbd.pritesh.service;

import com.bbd.pritesh.model.ProductRating;

public interface IProductRatingService {
    ProductRating saveProductRating(ProductRating productRating);
    ProductRating updateProductRating(ProductRating productRating);
    ProductRating getProductRatingById(Integer id);
    void deleteProductRatingById(Integer id);
}
