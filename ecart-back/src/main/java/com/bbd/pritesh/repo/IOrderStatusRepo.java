package com.bbd.pritesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbd.pritesh.model.OrderStatus;

public interface IOrderStatusRepo extends JpaRepository<OrderStatus, Integer> {

}
