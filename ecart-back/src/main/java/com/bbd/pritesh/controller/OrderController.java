package com.bbd.pritesh.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bbd.pritesh.model.Order;
import com.bbd.pritesh.model.OrderProduct;
import com.bbd.pritesh.model.Product;
import com.bbd.pritesh.repo.IOrderProductRepo;
import com.bbd.pritesh.response.Response;
import com.bbd.pritesh.service.IOrderProductService;
import com.bbd.pritesh.service.IOrderService;
import com.bbd.pritesh.service.IProductService;
import com.bbd.pritesh.util.InvoiceDataPdfExport;
import com.lowagie.text.DocumentException;

@RestController
@RequestMapping("/order")
@CrossOrigin("${cross}")
public class OrderController {
	
	@Autowired
	private IOrderService service;
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@PostMapping("/save")
	public ResponseEntity<Response> saveOrder(@RequestBody Order order){
		Order o=service.saveOrder(order);
		logger.info("order saved with id="+o.getId());
		return ResponseEntity.ok(Response.send("order saved with id="+o.getId(), true));
	}
	@PutMapping("/update")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order){
		Order o=service.updateOrder(order);
		logger.info("order updated with id="+o.getId());
		return ResponseEntity.ok(o);
	}
	@GetMapping("/getone/{id}")
	public ResponseEntity<Order> getOneOrder(@PathVariable Integer id){
		Order order=service.getOrderById(id);
		return ResponseEntity.ok(order);
	}
	@DeleteMapping("/deleteone/{id}")
	public ResponseEntity<Response> deleteOneOrder(@PathVariable Integer id){
		service.deleteOrderById(id);
		return ResponseEntity.ok(Response.send("order deleted with id="+id, true));
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<List<Order>> getOrderByUser(@PathVariable Integer id){
		List<Order> o=service.getByUserId(id);
		return ResponseEntity.ok(o);
	}
	@PatchMapping("/updatestatus/{sid}/{oid}")
	public ResponseEntity<Response> updateOrderStatus(@PathVariable Integer sid,@PathVariable Integer oid){
		service.updateOrderStatus(sid, oid);
		logger.info("status updated sucssefully");
		return ResponseEntity.ok(Response.send("status updated sucssefully", true));
		
	}
	@GetMapping("/getall")
	public ResponseEntity<List<Order>> getAllOrder(){
		List<Order> o=service.getAllOrder();
		return ResponseEntity.ok(o);
	}
	@GetMapping("/getcount")
	public ResponseEntity<Integer> getOrderCount(){
		return ResponseEntity.ok(service.getOrderCount());
	}
	 @GetMapping("/export/pdf/{id}")
	    public ModelAndView exportToPDF(HttpServletResponse response,@PathVariable Integer id) throws DocumentException, IOException {
	       // response.setContentType("application/pdf");
	        Order order=service.getOrderById(id);
	        //DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	      //  String currentDateTime = dateFormatter.format(new Date());
	        ModelAndView mav = new ModelAndView();
	        mav.setView(new InvoiceDataPdfExport(order));
	        mav.addObject("list", order);
	        return mav; 
	         
	    }
}