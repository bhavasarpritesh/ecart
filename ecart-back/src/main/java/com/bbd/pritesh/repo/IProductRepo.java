package com.bbd.pritesh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bbd.pritesh.model.Product;

public interface IProductRepo extends JpaRepository<Product, Integer> {

	@Query("select prd from Product prd where prd.category.category=:type")
	  public List<Product> getProductsbyType(String type);
	@Modifying
	@Query("UPDATE Product SET quantity=:quantity WHERE id=:id")
	public void updateQuanity(Integer quantity,Integer id);
	@Query("SELECT COUNT(*) FROM Product")
	public Integer getProductCount();
	List<Product> findByproductnameContaining(String name);
	@Modifying
	@Query("UPDATE Product SET status=:sid WHERE id=:id")
	public void updateProductStatus(Integer sid,Integer id);
}
