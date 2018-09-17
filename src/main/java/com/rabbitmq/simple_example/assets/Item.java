package com.rabbitmq.simple_example.assets;

// Additional static assets to be added to message payload
public class Item {

	private String name;
	private double price;
	private int quantity;

	public Item(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
		this.price = quantity * generatePrice();
	}

	public Item() {
		this.name = null;
		this.quantity = 0;
		this.price = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// random unit price of goods
	private double generatePrice() {
		double randomValue = 1 + Math.random() * 20;
		double tempRes = Math.floor(randomValue * 10);
		double finalRes = tempRes / 10;
		return finalRes;
	}

	@Override
	public String toString() {
		return "Item{" +
				"name='" + name + '\'' +
				", quantity=" + quantity +
				'}';
	}
}
