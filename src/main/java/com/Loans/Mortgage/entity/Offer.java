package com.loans.mortgage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="offer")

public class Offer {
	
	private static final long SerialVersionUID =1l;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public int getSqFt() {
		return sqFt;
	}

	public void setSqFt(int sqFt) {
		this.sqFt = sqFt;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Column(name="property_type")
	private String propertyType;
	
	@Column(name="square_feet")
	private int sqFt;
	
	@Column(name="pincode")
	private int pincode;

}
