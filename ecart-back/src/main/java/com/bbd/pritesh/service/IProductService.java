package com.bbd.pritesh.service;

import java.util.List;

import com.bbd.pritesh.model.Product;

public interface IProductService {
   Product saveProduct(Product product);
   Product updateProduct(Product product);
   Product getProductById(Integer id);
   void deleteProductById(Integer id);
   List<Product> getProductByType(String type);
   void updateQuantity(Integer quantity,Integer id);
   List<Product> getAllProduct();
   Integer getProductCount();
   List<Product> getAllProductByName(String name);
   void updateProductStatus(Integer sid,Integer id);

   
}
