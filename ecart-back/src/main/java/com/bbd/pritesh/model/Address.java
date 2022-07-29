package com.bbd.pritesh.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Entity
@Table(name="address_tab")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address {
	 @Id
     @GeneratedValue(generator = "add")
     @SequenceGenerator(name = "add",sequenceName = "add_seq")
     @Column(name="add_id_col")
     private Integer id;
	 @Column(name="user_landmark_col")
	 private String landmark;
	 @Column(name="user_street_col")
	 private String streetname;
	 @Column(name="user_city_col")
	 private String city;
	 @Column(name="user_pincode_col")
	 private Integer pincode;
	 @Column(name="add_type_col")
	 private String addresstype;
	 @ManyToOne
	 @JsonBackReference
     @JoinColumn(name="user_id")
	 private User user;
}
