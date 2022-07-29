package com.bbd.pritesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="prodcat_tab")
@Data
public class ProductCategory {
	@Id
    @GeneratedValue(generator = "prodcat")
    @SequenceGenerator(name = "prodcat",sequenceName = "prodcat_seq")
    @Column(name="prodcat_id_col")
    private Integer id;
	@Column(name="prodcat_category_col")
	private String category;

}
