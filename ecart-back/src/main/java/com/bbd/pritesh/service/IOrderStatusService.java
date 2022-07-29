package com.bbd.pritesh.service;

import java.util.List;

import com.bbd.pritesh.model.OrderStatus;

public interface IOrderStatusService {
     OrderStatus saveOrderStatus(OrderStatus orderStatus);
     OrderStatus updateOrderStatus(OrderStatus orderStatus);
     OrderStatus getOrderStatusById(Integer id);
     OrderStatus deleteOrderStatusById(Integer id);
     List<OrderStatus> getAll();
}
