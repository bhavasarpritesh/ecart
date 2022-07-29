package com.bbd.pritesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="product_rating_tab")
@Data
public class ProductRating {
	 @Id
     @GeneratedValue(generator = "prodrat")
 	 @SequenceGenerator(name = "prodrat",sequenceName = "prodrat_seq")
 	 @Column(name="prodrat_id_col")
     private Integer id;
	 @Column(name="prodrat_rate_col")
     private Integer rate;
	 @ManyToOne
	 @JoinColumn(name="user_id")
	 private User user;
	 @ManyToOne
	 @JoinColumn(name="product_id")
	 private Product product;
}
