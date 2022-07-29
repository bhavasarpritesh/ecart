package com.bbd.pritesh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bbd.pritesh.model.IOrderProduct;
import com.bbd.pritesh.model.OrderProduct;
import com.bbd.pritesh.model.Product;

public interface IOrderProductRepo extends JpaRepository<OrderProduct, Integer> {
	    @Query("select oprd.id,oprd.product,oprd.quantity,oprd.price,oprd.rating from OrderProduct oprd where oprd.order.id=:id")
	    public List<IOrderProduct> getOrderProductsbyOrderId(Integer id);
	    public List<IOrderProduct> findByOrderId(Integer id);
	    @Modifying
		@Query("UPDATE OrderProduct SET rating=:rating WHERE id=:id")
		public void updateRating(Integer id,Integer rating);
	    @Query("select AVG(oprd.rating) from OrderProduct oprd where oprd.product.id=:id")
        public Integer getRatingByProduct(Integer id);
	    @Query("select COUNT(oprd.rating) from OrderProduct oprd where oprd.product.id=:id")
        public Integer getUserCount(Integer id);
}
