package com.proxifile.search.searchapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="creditor")
public class Creditor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="creditor_name")
	private String creditorName;
	
	@Column(name="attention")
	private String attention;
	
	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="postal_zip")
	private String postalZip;

	public Creditor() {
	}

	public Creditor(String creditorName, String attention, String address1, String address2, String city, String state,
			String postalZip) {
		this.creditorName = creditorName;
		this.attention = attention;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.postalZip = postalZip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreditorName() {
		return creditorName;
	}

	public void setCreditorName(String creditorName) {
		this.creditorName = creditorName;
	}

	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalZip() {
		return postalZip;
	}

	public void setPostalZip(String postalZip) {
		this.postalZip = postalZip;
	}

	@Override
	public String toString() {
		return "Creditor [id=" + id + ", creditorName=" + creditorName + ", attention=" + attention + ", address1="
				+ address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state + ", postalZip="
				+ postalZip + "]";
	}
	  
}
