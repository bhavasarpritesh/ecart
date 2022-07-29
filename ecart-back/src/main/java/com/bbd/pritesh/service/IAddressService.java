package com.bbd.pritesh.service;

import java.util.List;

import com.bbd.pritesh.model.Address;

public interface IAddressService {
	Address saveAddress(Address address);
	Address updateAddress(Address address);
	void deleteAddress(Integer id);
	List<Address> getAddressByUserId(Integer id);
	Address getAddressByUserIdAndType(Integer id,String type);

}
