package com.bbd.pritesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="payment_mode_tab")
@Data
public class PaymentMode {
	 @Id
     @GeneratedValue(generator = "paymentmode")
 	 @SequenceGenerator(name = "paymentmode",sequenceName = "paymentmode_seq")
 	 @Column(name="paymentmode_id_col")
     private Integer id;
	 @Column(name="paymentmode_mode_col")
	 private String paymentMode;
}
