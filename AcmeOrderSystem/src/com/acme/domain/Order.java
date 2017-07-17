package com.acme.domain;

import com.acme.utils.MyDate;

public class Order {
	MyDate orderDate;
	private double orderAmount = 0.00;
	private String customer;
	private Good product;
	private int quantity;
	public static double taxRate;

	static {
		taxRate = 0.05;
	}

	public Order(MyDate d, double amt, String c, Good p, int q) {
		orderDate = d;
		orderAmount = amt;
		customer = c;
		product = p;
		quantity = q;

	}

	public Order(MyDate d, double amt, String c, Good p) {
		this(d, amt, c, p, 1);

	}

	public String toString() {
		return quantity + " ea. " + product + " for " + customer;
	}

	public static void setTaxRate(double newRate) {
		taxRate = newRate;

	}

	public static void computeTaxOn(double anAmount) {
		System.out.println("The tax for " + anAmount + " is: " + anAmount * taxRate);
	}

	public double computeTax() {
		System.out.println("The tax for this order is: " + orderAmount * taxRate);
		return orderAmount * taxRate;
	}

	public char jobSize() {
		if (quantity <= 25) {
			return 'S';
		} else if (quantity <= 75) {
			return 'M';
		} else if (quantity <= 150) {
			return 'L';
		}
		return 'X';

	}

	public double computeTotal() {
		double orderTotal = orderAmount;
		switch (jobSize()) {
		case 'M':
			orderTotal = orderTotal - (orderAmount * 0.01);
			break;
		case 'L':
			orderTotal = orderTotal - (orderAmount * 0.02);
			break;
		case 'X':
			orderTotal = orderTotal - (orderAmount * 0.03);
			break;
		}
		if (orderAmount <= 1500) {
			orderTotal = orderTotal + computeTax();
		}

		return orderTotal;
	}

	public boolean validOrderAmount(double orderAmount) {
		if (orderAmount < 0) {
			System.out.println("attempting to create a non-valid Order Amount " + orderAmount);
			return false;
		}
		return true;
	}
	
	public boolean validQuantity(int quantity){
		if (quantity < 0) {
			System.out.println("attempting to create a non-valid Quantity " + quantity);
			return false;
		}
		return true;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		if (validOrderAmount(orderAmount)){
			this.orderAmount = orderAmount;
		}
		
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Good getProduct() {
		return product;
	}

	public void setProduct(Good product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (validQuantity(quantity)){
			this.quantity = quantity;
		}
		
	}

}
