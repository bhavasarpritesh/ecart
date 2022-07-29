package com.bbd.pritesh.service;

import java.util.List;

import com.bbd.pritesh.model.PaymentMode;

public interface IPaymentModeService {
    PaymentMode savePaymentMode(PaymentMode paymentMode);
    PaymentMode updatePaymentMode(PaymentMode paymentMode);
    PaymentMode getPaymentModeById(Integer id);
    void deletePaymentModeById(Integer id);
    List<PaymentMode> getAll();
}
