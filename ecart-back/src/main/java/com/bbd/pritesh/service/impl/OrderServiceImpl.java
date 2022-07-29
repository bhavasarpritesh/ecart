package com.bbd.pritesh.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.pritesh.exception.OrderNotFound;
import com.bbd.pritesh.model.Order;
import com.bbd.pritesh.model.OrderProduct;
import com.bbd.pritesh.model.Product;
import com.bbd.pritesh.repo.IOrderProductRepo;
import com.bbd.pritesh.repo.IOrderRepo;
import com.bbd.pritesh.service.IOrderService;
import com.bbd.pritesh.service.IOrderStatusService;
import com.bbd.pritesh.service.IProductService;
import com.bbd.pritesh.service.IUserService;
import com.bbd.pritesh.util.EmailUtil;
@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepo repo;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Autowired
	private IOrderStatusService os;
	
	@Autowired
	private IOrderProductRepo ips;
	
	@Autowired
	private IProductService ps;

	@Override
	public Order saveOrder(Order order) {
		Order o=repo.save(order);
		List<OrderProduct> op=order.getProducts();
        for(int i=0;i<op.size();i++) 
      	   op.get(i).setOrder(o);
        for(int i=0;i<op.size();i++) {
       	Product p=ps.getProductById(op.get(i).getProduct().getId()); 
       	int q=p.getQuantity()-op.get(i).getQuantity();
       	ps.updateQuantity(q, op.get(i).getProduct().getId());
        }
       ips.saveAll(op);
       String email=order.getUser().getEmail();
       String text = 
				"Hello User,"
				+ " Your order has succsefully placed!!!";
	    emailUtil.sendEmail(email, "Order Placed!!", text);
        return o;
	}

	@Override
	public Order updateOrder(Order order) {
		Order o=getOrderById(order.getId());
		BeanUtils.copyProperties(order, o);
		return repo.save(o);
	}

	@Override
	public Order getOrderById(Integer id) {
		return repo.findById(id).orElseThrow(()->new OrderNotFound("order not found id="+id));
		
	}

	@Override
	public void deleteOrderById(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<Order> getByUserId(Integer id) {
		return repo.getOrderByUserId(id);
	}

	@Override
	@Transactional
	public void updateOrderStatus(Integer sid, Integer id) {
		String email=repo.findUserById(id).getEmail();
		String status=os.getOrderStatusById(sid).getOrderStatus();
		String text = 
				"Hello User,"
				+ " Your order status has been changed to " + status +"";
	    repo.updateOrderStatus(sid, id);
	    emailUtil.sendEmail(email, "Order Status Updated!!", text);
		
	}

	@Override
	public List<Order> getAllOrder() {
		
		return repo.findAll();
	}

	@Override
	public Integer getOrderCount() {
		return repo.getOrderCount();
	}

}
