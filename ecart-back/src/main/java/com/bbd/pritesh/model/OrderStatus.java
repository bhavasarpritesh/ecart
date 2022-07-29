package com.bbd.pritesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="order_status_tab")
@Data
public class OrderStatus {
	 @Id
     @GeneratedValue(generator = "orderstatus")
 	 @SequenceGenerator(name = "orderstatus",sequenceName = "orderstatus_seq")
 	 @Column(name="orderstatus_id_col")
     private Integer id;
	 @Column(name="order_status_col")
	 private String orderStatus;

}
