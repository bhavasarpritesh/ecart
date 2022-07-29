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

import com.bbd.pritesh.model.IOrderProduct;
import com.bbd.pritesh.model.OrderProduct;
import com.bbd.pritesh.response.Response;
import com.bbd.pritesh.service.IOrderProductService;

@RestController
@CrossOrigin("${cross}")
@RequestMapping("/orderproduct")
public class OrderProductController {

	@Autowired
	private IOrderProductService service;
	
	@PostMapping("/save")
	public ResponseEntity<Response> saveOrderProduct(@RequestBody OrderProduct orderProdcut){
		OrderProduct op=service.saveOrderProduct(orderProdcut);
		return ResponseEntity.ok(Response.send("order prodcut save with id="+op.getId(), true));
		
	}
	@GetMapping("/getone/{id}")
	public ResponseEntity<OrderProduct> getOneOrderProdcut(@PathVariable Integer id){
		OrderProduct orderProduct=service.getOrderProductById(id);
		return ResponseEntity.ok(orderProduct);
	}
	@PutMapping("/update")
	public ResponseEntity<OrderProduct> updateOrderProduct(@RequestBody OrderProduct orderProduct){
		OrderProduct op=service.updateOrderProduct(orderProduct);
		return ResponseEntity.ok(op);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deleteOneOrderProduct(@PathVariable Integer id){
		service.deleteOrderProductById(id);
		return ResponseEntity.ok(Response.send("orderproduct deleted with id="+id, true));
	}
	@GetMapping("/getbyorder/{id}")
	public ResponseEntity<List<IOrderProduct>> getOrderProdcutByOrderId(@PathVariable Integer id){
		List<IOrderProduct> orderProducts=service.getOrderProductByOrderId(id);
		return ResponseEntity.ok(orderProducts);
	}
	@PutMapping("/rate")
	public ResponseEntity<Response> updateProductRate(@RequestBody OrderProduct orderProduct){
		service.updateRating(orderProduct.getId(), orderProduct.getRating());
		return ResponseEntity.ok(Response.send("Rate Succsefully", true));
	}

}
