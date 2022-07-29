package com.bbd.pritesh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bbd.pritesh.model.Order;
import com.bbd.pritesh.model.User;

public interface IOrderRepo extends JpaRepository<Order, Integer> {

	
	@Query("Select o From Order o WHERE o.user.id=:id")
	public List<Order> getOrderByUserId(Integer id);
	@Modifying
	@Query("UPDATE Order SET orderStatus.id=:sid WHERE id=:id")
	public void updateOrderStatus(Integer sid,Integer id);
    @Query("SELECT count(*) FROM Order")
	public Integer getOrderCount();
    @Query("Select o.user From Order o WHERE o.id=:id")
    public User findUserById(Integer id);
}
