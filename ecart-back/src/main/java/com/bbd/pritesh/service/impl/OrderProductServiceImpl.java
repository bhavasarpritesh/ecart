package com.bbd.pritesh.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.pritesh.exception.OrderProductNotFound;
import com.bbd.pritesh.model.IOrderProduct;
import com.bbd.pritesh.model.OrderProduct;
import com.bbd.pritesh.repo.IOrderProductRepo;
import com.bbd.pritesh.repo.IOrderRepo;
import com.bbd.pritesh.service.IOrderProductService;

@Service
public class OrderProductServiceImpl implements IOrderProductService {

	@Autowired
	private IOrderProductRepo repo;
	@Override
	public OrderProduct saveOrderProduct(OrderProduct orderProduct) {
	   return repo.save(orderProduct);
	}

	@Override
	public OrderProduct updateOrderProduct(OrderProduct orderProduct) {
		OrderProduct op=getOrderProductById(orderProduct.getId());
		BeanUtils.copyProperties(orderProduct, op);
		return repo.save(op);
	}

	@Override
	public OrderProduct getOrderProductById(Integer id) {
		return repo.findById(id).orElseThrow(()-> new OrderProductNotFound());
	}

	@Override
	public void deleteOrderProductById(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<IOrderProduct> getOrderProductByOrderId(Integer id) {
		//return repo.getOrderProductsbyOrderId(id);
		return repo.findByOrderId(id);
	}

	@Transactional
	@Override
	public void updateRating(Integer id, Integer rating) {
		repo.updateRating(id, rating);
		
	}

	@Override
	public Integer getRating(Integer id) {
		
		return repo.getRatingByProduct(id);
	}

	@Override
	public Integer getUserCount(Integer id) {
		// TODO Auto-generated method stub
		return repo.getUserCount(id);
	}

	

	

}
