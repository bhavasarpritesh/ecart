package com.bbd.pritesh.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Entity
@Table(name="user_tab")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
	
	 @Id
     @GeneratedValue(generator = "user")
	 @SequenceGenerator(name = "user",sequenceName = "user_seq")
	 @Column(name="user_id_col")
     private Integer id;
	 @Column(name="user_name_col")
	 @NotBlank(message = "Name is mandatory")
	 private String name;
	 @Column(name="user_email_col")
	 @NotBlank(message = "Email is mandatory")
	 private String email;
	 @Column(name="user_password_col")
	 @NotBlank(message = "Paaword is mandatory")
	 @JsonBackReference
	 private String password;
	 @ElementCollection(fetch = FetchType.EAGER)
	 private List<String> roles;
	 @Column(name="user_mobile_col")
     private Long mobile;
	 

}