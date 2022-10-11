package com.courier;

import java.time.LocalDate;
import java.util.Date;

public class CourierDetails {
	
	private Integer id;
	private String customerName;
	private String mobile;
	private String fromCity;
	private String toCity;
	private Double weight;
	private Double price;
	
	private LocalDate shipmentDate;
	private LocalDate deliverDate;
	public LocalDate getShipmentDate() {
		return shipmentDate;
	}
	public void setShipmentDate(LocalDate shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	public LocalDate getDeliverDate() {
		return deliverDate;
	}
	public void setDeliverDate(LocalDate deliverDate) {
		this.deliverDate = deliverDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public CourierDetails(Integer id, String customerName, String mobile, String fromCity, String toCity, Double weight,
			Double price, LocalDate shipmentDate2, LocalDate deliveryDate) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.mobile = mobile;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.weight = weight;
		this.price = price;
		this.shipmentDate = shipmentDate2;
		this.deliverDate = deliveryDate;
	}
	public CourierDetails() {
		super();
	}
	
	
}
