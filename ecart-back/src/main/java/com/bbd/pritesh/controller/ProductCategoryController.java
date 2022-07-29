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

import com.bbd.pritesh.model.ProductCategory;
import com.bbd.pritesh.response.Response;
import com.bbd.pritesh.service.IProductCategoryService;

@RestController
@RequestMapping("/productcategory")
@CrossOrigin("${cross}")
public class ProductCategoryController {

	@Autowired
	private IProductCategoryService service;
	
	@PostMapping("/save")
	public ResponseEntity<Response> saveProductCategory(@RequestBody ProductCategory productCategory){
		ProductCategory pc=service.saveProductCategory(productCategory);
		return ResponseEntity.ok(Response.send("product category saved with id="+pc.getId(), true));
	}
	@PutMapping("/update")
	public ResponseEntity<Response> updateProductCategory(@RequestBody ProductCategory productCategory){
		ProductCategory pc=service.updateProductCategory(productCategory);
		return ResponseEntity.ok(Response.send("product category updated successfully", true));
	}
	@GetMapping("/getone/{id}")
	public ResponseEntity<ProductCategory> getOneCategory(@PathVariable Integer id){
		ProductCategory productCategory=service.getProductCategoryById(id);
		return ResponseEntity.ok(productCategory);
	}
	@DeleteMapping("/deleteone/{id}")
	public ResponseEntity<Response> deleteOneCategory(@PathVariable Integer id){
		service.deleteProductCategoryById(id);
		return ResponseEntity.ok(Response.send("product category deleted id="+id, true));
	}
	@GetMapping("/getall")
	public ResponseEntity<List<ProductCategory>> getAllCategory(){
		List<ProductCategory> productCategorys=service.getAll();
		return ResponseEntity.ok(productCategorys);
	}
}
