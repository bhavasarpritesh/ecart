package com.bbd.pritesh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bbd.pritesh.model.Address;



public interface IAddressRepo extends JpaRepository<Address, Integer> {

	@Query("select addrs from Address addrs where addrs.user.id=:id")
	  public List<Address> getAddressByUserId(Integer id);
	@Query("select  addrs from Address addrs where addrs.user.id=:id AND addrs.addresstype=:type")
	  public List<Address> getAddressByUserIdAndType(Integer id,String type);
}
