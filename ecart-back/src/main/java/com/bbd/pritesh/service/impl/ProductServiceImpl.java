package com.bbd.pritesh.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.pritesh.exception.ProductNotFoundException;
import com.bbd.pritesh.model.Product;
import com.bbd.pritesh.repo.IProductRepo;
import com.bbd.pritesh.service.IOrderProductService;
import com.bbd.pritesh.service.IProductService;
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepo repo;
	@Autowired
	private IOrderProductService iprepo;
	
	@Override
	 @Transactional
	public Product saveProduct(Product product) {
		
		return repo.save(product);
		
	}

	@Override
	public Product updateProduct(Product product) {
		Product p=getProductById(product.getId());
		BeanUtils.copyProperties(product, p);
		 return repo.save(p);
	}

	@Override
	public Product getProductById(Integer id) {
	  return repo.findById(id).orElseThrow(()->new ProductNotFoundException("product not found id="+id));
	
	}

	@Override
	public void deleteProductById(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public List<Product> getProductByType(String type) {
		List<Product> products=repo.getProductsbyType(type);
		for(Product p:products) {
			p.setRating(iprepo.getRating(p.getId()));
			p.setCount(iprepo.getUserCount(p.getId()));
		}
		return products;
	}

	@Override
	@Transactional
	public void updateQuantity(Integer quantity, Integer id) {
		repo.updateQuanity(quantity, id);
		
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> products=repo.findAll();
		for(Product p:products) {
			p.setRating(iprepo.getRating(p.getId()));
			p.setCount(iprepo.getUserCount(p.getId()));
		}
		return products;
	}

	@Override
	public Integer getProductCount() {
		return repo.getProductCount();
	}

	@Override
	public List<Product> getAllProductByName(String name) {
		List<Product> products=repo.findByproductnameContaining(name);
		for(Product p:products) {
			p.setRating(iprepo.getRating(p.getId()));
			p.setCount(iprepo.getUserCount(p.getId()));
		}
		return products;
	}

	@Override
    @Transactional
	public void updateProductStatus(Integer sid, Integer id) {
		repo.updateProductStatus(sid, id);
		
	}

}
