package com.bbd.pritesh.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Entity
@Table(name="order_tab")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {

	 @Id
     @GeneratedValue(generator = "order")
 	 @SequenceGenerator(name = "order",sequenceName = "order_seq")
 	 @Column(name="order_id_col")
     private Integer id;
	 @Column(name="order_quanity_col")
	 private Float price;
	 @Temporal(TemporalType.TIMESTAMP)
     private Date orderDate=new Date();
	 @ManyToOne
	 @JoinColumn(name="mode_id")
	 private PaymentMode paymentMode;
	 @ManyToOne
	 @JoinColumn(name="status_id")
	 private OrderStatus orderStatus;
	 @ManyToOne
	 @JoinColumn(name="user_id")
	 private User user;
	 @OneToMany(mappedBy = "order",fetch = FetchType.LAZY)
	 @Transient
	// @JsonBackReference
	 private List<OrderProduct> products;
	 @ManyToOne
	 private Address address;
	 private String paymentId;
}
