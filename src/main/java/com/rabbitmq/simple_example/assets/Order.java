package com.rabbitmq.simple_example.assets;

import java.util.Date;
import java.util.List;

public class Order {

	private String customerName;
	private String deliveryAddress;
	private Date date;
	private List<Item> orderItems;

	// Payload for the message that will be transmitted
	public Order(String customerName, String deliveryAddress, Date date, List<Item> orderItems) {
		super();
		this.customerName = customerName;
		this.deliveryAddress = deliveryAddress;
		this.date = date;
		this.orderItems = orderItems;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Item> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<Item> orderItems) {
		this.orderItems = orderItems;
	}

}
