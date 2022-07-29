package com.bbd.pritesh.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.pritesh.exception.OrderSatusNotFound;
import com.bbd.pritesh.model.OrderStatus;
import com.bbd.pritesh.repo.IOrderStatusRepo;
import com.bbd.pritesh.service.IOrderStatusService;
@Service
public class OrderStatusServiceImpl implements IOrderStatusService {

	@Autowired
	private IOrderStatusRepo repo;
	@Override
	public OrderStatus saveOrderStatus(OrderStatus orderStatus) {
		
		return repo.save(orderStatus);
	}

	@Override
	public OrderStatus updateOrderStatus(OrderStatus orderStatus) {
		OrderStatus os=getOrderStatusById(orderStatus.getId());
		BeanUtils.copyProperties(orderStatus, os);
		return repo.save(os);
	}

	@Override
	public OrderStatus getOrderStatusById(Integer id) {
		return repo.findById(id).orElseThrow(()->new OrderSatusNotFound());
	}

	@Override
	public OrderStatus deleteOrderStatusById(Integer id) {
		repo.deleteById(id);
		return null;
	}

	@Override
	public List<OrderStatus> getAll() {
		return repo.findAll();
	}

}
