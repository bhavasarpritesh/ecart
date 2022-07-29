package com.bbd.pritesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name="product_tab")
@Data
public class Product {
	 @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
	// @SequenceGenerator(name = "product",sequenceName = "product_seq")
	 @Column(name="product_id_col")
     private Integer id;
	 @Column(name="product_name_col")
	 @NotBlank(message = "Name is mandatory")
	 private String productname;
	 @Column(name="product_img_col")
	 private String image;
	 @Column(name="product_disc_col")
	 private String description;
	 @Column(name="product_avl_quanity_col")
	 private Integer quantity;
	 @Column(name="product_price_col")
	 private Float price;
	 @ManyToOne
	 @JoinColumn(name="cat_id")
	 private ProductCategory category;
	 @Column(name="product_status")
	 private Integer status;
	 @Transient
	 private Integer rating;
	 @Transient
	 private Integer count;
	 

}
