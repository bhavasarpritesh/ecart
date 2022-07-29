package com.bbd.pritesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbd.pritesh.model.OrderStatus;
import com.bbd.pritesh.response.Response;
import com.bbd.pritesh.service.IOrderStatusService;

@RestController
@RequestMapping("/orderstatus")
@CrossOrigin("${cross}")
public class OrderStatusController {

	@Autowired
	private IOrderStatusService service;
	@PostMapping("/save")
	public ResponseEntity<Response> saveOrderStatus(@RequestBody OrderStatus orderStatus){
		OrderStatus os=service.saveOrderStatus(orderStatus);
		return ResponseEntity.ok(Response.send("Order Status saved with id="+os.getId(), true));
		
	}
	@GetMapping("/getone/{id}")
	public ResponseEntity<OrderStatus> getOneOrderStatus(@PathVariable Integer id){
		OrderStatus orderStatus=service.getOrderStatusById(id);
		return ResponseEntity.ok(orderStatus);
	}
	@PutMapping("/update")
	public ResponseEntity<Response> updateOrderSatus(@RequestBody OrderStatus orderStatus){
		OrderStatus os=service.updateOrderStatus(orderStatus);
		return ResponseEntity.ok(Response.send("order status is updated", true));
	}
	@DeleteMapping("/deleteone/{id}")
	public ResponseEntity<Response> deleteOneOrderStatus(@PathVariable Integer id){
		service.deleteOrderStatusById(id);
		return ResponseEntity.ok(Response.send("order status deleted id="+id, true));
	}
	@GetMapping("/getall")
	public ResponseEntity<List<OrderStatus>> getAllOrderStatus(){
		List<OrderStatus> orderStatus=service.getAll();
		System.out.println(orderStatus);
		return ResponseEntity.ok(orderStatus);
	}
}
 