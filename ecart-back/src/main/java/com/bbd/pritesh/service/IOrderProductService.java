package com.bbd.pritesh.service;

import java.util.List;

import com.bbd.pritesh.model.IOrderProduct;
import com.bbd.pritesh.model.OrderProduct;

public interface IOrderProductService {
      OrderProduct saveOrderProduct(OrderProduct orderProduct);
      OrderProduct updateOrderProduct(OrderProduct orderProduct);
      OrderProduct getOrderProductById(Integer id);
      void deleteOrderProductById(Integer id);
      List<IOrderProduct> getOrderProductByOrderId(Integer id);
      void updateRating(Integer id,Integer rating);
      Integer getRating(Integer id);
      Integer getUserCount(Integer id);
}
