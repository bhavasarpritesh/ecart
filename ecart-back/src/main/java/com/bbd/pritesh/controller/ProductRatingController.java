package com.bbd.pritesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbd.pritesh.model.ProductRating;
import com.bbd.pritesh.response.Response;
import com.bbd.pritesh.service.IProductRatingService;

@RestController
@RequestMapping("/productrating")
public class ProductRatingController {
	@Autowired
	private IProductRatingService service;
	@PostMapping("/save")
	public ResponseEntity<Response> saveProductRating(@RequestBody ProductRating productRating){
		ProductRating pr=service.saveProductRating(productRating);
		return ResponseEntity.ok(Response.send("product rating saved with id="+pr.getId(), true));
	}
	@PutMapping("/update")
	public ResponseEntity<Response> updateProductRating(@RequestBody ProductRating productRating){
		ProductRating pr=service.updateProductRating(productRating);
		return ResponseEntity.ok(Response.send("product rating updated with id="+pr.getId(), true));
	}
	@GetMapping("/getone/{id}")
	public ResponseEntity<ProductRating> getOneProductRating(@PathVariable Integer id){
		ProductRating pr=service.getProductRatingById(id);
		return ResponseEntity.ok(pr);
	}
	@DeleteMapping("/deleteone/{id}")
	public ResponseEntity<Response> deleteOneProductRating(@PathVariable Integer id){
		service.deleteProductRatingById(id);
		return ResponseEntity.ok(Response.send("product rating updated with id="+id, true));
	}

}
