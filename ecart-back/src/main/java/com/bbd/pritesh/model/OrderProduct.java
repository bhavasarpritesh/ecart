package com.bbd.pritesh.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
@Entity
@Table(name="order_prod_tab")
@Data
public class OrderProduct {

	 @Id
     @GeneratedValue(generator = "order")
	 @SequenceGenerator(name = "order",sequenceName = "order_seq")
	 @Column(name="order_id_col")
     private Integer id;
	 @Column(name="price")
	 private Float price;
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JsonBackReference
	 private Order order;
	 @Column(name="quantity")
	 private Integer quantity;
	 @ManyToOne(fetch = FetchType.EAGER)
	 private Product product;
	 @Column(name="rating")
	 private Integer rating;
	 
}
