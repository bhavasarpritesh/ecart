package com.bbd.pritesh.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.pritesh.exception.PaymentModeNotFound;
import com.bbd.pritesh.model.PaymentMode;
import com.bbd.pritesh.repo.IPaymentModeRepo;
import com.bbd.pritesh.service.IPaymentModeService;
@Service
public class PaymentModeServiceImpl implements IPaymentModeService {
    
	@Autowired
     private IPaymentModeRepo repo;
	@Override
	public PaymentMode savePaymentMode(PaymentMode paymentMode) {
		return repo.save(paymentMode);
	}

	@Override
	public PaymentMode updatePaymentMode(PaymentMode paymentMode) {
		PaymentMode pm=getPaymentModeById(paymentMode.getId());
		BeanUtils.copyProperties(paymentMode, pm);
		return repo.save(pm);
	}

	@Override
	public PaymentMode getPaymentModeById(Integer id) {
		return repo.findById(id).orElseThrow(()->new PaymentModeNotFound());
		
	}

	@Override
	public void deletePaymentModeById(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<PaymentMode> getAll() {
		return repo.findAll();
	}

}
