package com.bbd.pritesh.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.pritesh.exception.AddresNotFoundException;
import com.bbd.pritesh.model.Address;
import com.bbd.pritesh.repo.IAddressRepo;
import com.bbd.pritesh.service.IAddressService;
@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
	private IAddressRepo repo;
	
	
	@Override
	public Address saveAddress(Address address) {
		//Address add=repo.getAddressByUserIdAndType(address.getUser().getId(), address.getAddresstype()).get(0);
		//System.out.println(add);
		//if(add==null) {
			return repo.save(address);
		//}
		//else {
		//	address.setId(add.getId());
		//	return repo.save(address);
		//}

	}

	@Override
	public Address updateAddress(Address address) {
		Integer id=address.getId();
		Address add=repo.findById(id).get();
		BeanUtils.copyProperties(address,add);
		return repo.save(add);
	}

	@Override
	public void deleteAddress(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public List<Address> getAddressByUserId(Integer id) {
		return repo.getAddressByUserId(id);
				
	}

	@Override
	public Address getAddressByUserIdAndType(Integer id, String type) {
		return repo.getAddressByUserIdAndType(id, type).get(0);
	}

}
