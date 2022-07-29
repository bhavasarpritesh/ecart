package com.bbd.pritesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbd.pritesh.model.PaymentMode;

public interface IPaymentModeRepo extends JpaRepository<PaymentMode, Integer> {

}
