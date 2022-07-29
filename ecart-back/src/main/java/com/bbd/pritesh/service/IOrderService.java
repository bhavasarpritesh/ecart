package com.bbd.pritesh.service;

import java.util.List;

import com.bbd.pritesh.model.Order;

public interface IOrderService {
       Order saveOrder(Order Order);
       Order updateOrder(Order order);
       Order getOrderById(Integer id);
       void deleteOrderById(Integer id);
       List<Order> getByUserId(Integer id);
       void updateOrderStatus(Integer sid,Integer id);
       List<Order> getAllOrder();
       Integer getOrderCount();
}
