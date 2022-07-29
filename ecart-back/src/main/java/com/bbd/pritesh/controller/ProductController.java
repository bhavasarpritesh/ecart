package com.bbd.pritesh.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bbd.pritesh.model.Product;
import com.bbd.pritesh.response.Response;
import com.bbd.pritesh.service.IProductService;
import com.bbd.pritesh.service.impl.AmazonS3BucketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/product")
@CrossOrigin("${cross}")
public class ProductController {
	@Autowired
	private IProductService service;
	@Autowired
	private  AmazonS3BucketService amazonS3BucketService;
	
	 private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@PostMapping(path="/save",consumes = "multipart/form-data")
	public ResponseEntity<Response> saveProduct(@RequestParam("product") String data,@RequestParam("image") MultipartFile file) throws JsonMappingException, JsonProcessingException{
		String url =this.amazonS3BucketService.uploadFile(file);
		 Product product = new ObjectMapper().readValue(data, Product.class);
		product.setImage(url);
		Product saveproduct=service.saveProduct(product);
		logger.info("product saved successfully id="+saveproduct.getId());
		return ResponseEntity.ok(Response.send("product saved successfully id="+saveproduct.getId(), true));
	}
    @PutMapping(path="/update",consumes = "multipart/form-data")
	public ResponseEntity<Response> updateProduct(@RequestParam("product") String data,@RequestParam("image") MultipartFile file)throws JsonMappingException, JsonProcessingException{
    	String url =this.amazonS3BucketService.uploadFile(file);
    	Product product = new ObjectMapper().readValue(data, Product.class);
    	product.setImage(url);
		Product pd=service.updateProduct(product);
		logger.info("product update with id="+pd.getId());
		return ResponseEntity.ok(Response.send("product update with id="+pd.getId(), true));
    }
    @GetMapping("/getone/{id}")
    public ResponseEntity<Product> getOneProduct(@PathVariable Integer id){
    	Product product=service.getProductById(id);
    	return ResponseEntity.ok(product);
    }
    @DeleteMapping("/deleteone/{id}")
    public ResponseEntity<Response> deleteOneProduct(@PathVariable Integer id){
    	service.deleteProductById(id);
    	return ResponseEntity.ok(Response.send("product delete with id="+id, true));
    }
    @PatchMapping("/update/{sid}/{id}")
    public ResponseEntity<Response> updateProductStatus(@PathVariable Integer sid,@PathVariable Integer id){
    	System.out.println(sid+" "+id);
    	service.updateProductStatus(sid, id);
    	logger.info("Product Status Updated");
    	return ResponseEntity.ok(Response.send("Product Status Updated", true));
    }
    @GetMapping("/getbytype/{type}")
    public ResponseEntity<List<Product>> getOneProductByType(@PathVariable String type){
    	return ResponseEntity.ok(service.getProductByType(type));
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Product>> getAllProduct(){
    	
    	List<Product> products=service.getAllProduct();
    	System.out.println(products);
    	return ResponseEntity.ok(products);
    }
    @GetMapping("/getcount")
    public ResponseEntity<Integer> getProductCount(){
    	return ResponseEntity.ok(service.getProductCount());
    }
    @GetMapping("/getbyname/{name}")
    public ResponseEntity<List<Product>> getProductByName(@PathVariable String name){
    	return ResponseEntity.ok(service.getAllProductByName(name));
    }
}
