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

import com.bbd.pritesh.model.Address;
import com.bbd.pritesh.model.User;
import com.bbd.pritesh.response.Response;
import com.bbd.pritesh.service.IAddressService;


@RestController
@RequestMapping("/address")
@CrossOrigin("${cross}")
public class AddressController {
	@Autowired
	private IAddressService service;
	
	@PostMapping("/save/{id}")
	public ResponseEntity<Response> saveAddress(@RequestBody Address address,@PathVariable Integer id) {
		User u=new User();
		u.setId(id);
		address.setUser(u);
	
	   Address add=service.saveAddress(address);
	 return ResponseEntity.ok(Response.send("address saved with id="+add.getId(), true));
	}
	@GetMapping("/getone/{id}")
	public ResponseEntity<List<Address>> getAddressByUserId(@PathVariable Integer id) {
	 return ResponseEntity.ok(service.getAddressByUserId(id));
	}
	@GetMapping("/getonebytype/{id}/{type}")
	public ResponseEntity<Address> getOneAddressByUserIdAndType(@PathVariable Integer id,@PathVariable String type) {
	  return ResponseEntity.ok(service.getAddressByUserIdAndType(id, type));
	}
	@DeleteMapping("/deleteone/{id}")
	public ResponseEntity<Response> deleteOneAddress(@PathVariable Integer id){
		service.deleteAddress(id);
		return ResponseEntity.ok(Response.send("Address deleted id="+id, true));
	}
	@PutMapping("/update")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address){
		Address add=service.updateAddress(address);
		return ResponseEntity.ok(add);
	}
}
