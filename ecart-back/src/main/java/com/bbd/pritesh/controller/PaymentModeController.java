package com.bbd.pritesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbd.pritesh.model.PaymentMode;
import com.bbd.pritesh.response.Response;
import com.bbd.pritesh.service.IPaymentModeService;

@RestController
@RequestMapping("/paymentmode")
public class PaymentModeController {
	
	@Autowired
	private IPaymentModeService service;
	@PostMapping("/save")
	public ResponseEntity<Response> savePaymentMode(@RequestBody PaymentMode paymentMode){
		PaymentMode pm=service.savePaymentMode(paymentMode);
		return ResponseEntity.ok(Response.send("Payment Mode saved id="+pm.getId(), true));
		}
	@GetMapping("/getone/{id}")
	public ResponseEntity<PaymentMode> getOnePaymentMode(@PathVariable Integer id){
		PaymentMode paymentMode=service.getPaymentModeById(id);
		return ResponseEntity.ok(paymentMode);
   }
	@PutMapping("/update")
	public ResponseEntity<Response> updatePaymentMode(@RequestBody PaymentMode paymentMode){
		PaymentMode pm=service.updatePaymentMode(paymentMode);
		return ResponseEntity.ok(Response.send("payment mode is updated", true));
	}
	@GetMapping("/deleteone/{id}")
	public ResponseEntity<Response> deleteOnePaymentMode(@PathVariable Integer id){
		service.deletePaymentModeById(id);
		return ResponseEntity.ok(Response.send("payment mode deleted id="+id, true));
   }
	@GetMapping("/getall")
	public ResponseEntity<List<PaymentMode>> getAllPaymentMode(){
		List<PaymentMode> paymentModes=service.getAll();
		return ResponseEntity.ok(paymentModes);
   }
}
