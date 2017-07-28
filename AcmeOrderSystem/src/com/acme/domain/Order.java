package com.acme.domain;

import com.acme.utils.MyDate;

public class Order {
	MyDate orderDate;
	private double orderAmount = 0.00;
	private String customer;
	private Product product;
	private int quantity;
	public static double taxRate;
	private static Rushable rushable;
	
	

	static {
		taxRate = 0.05;
	}

	public Order(MyDate d, double amt, String c, Product p, int q) {
		setOrderDate(d);
		orderAmount = amt;
		customer = c;
		product = p;
		quantity = q;

	}

	public Order(MyDate d, double amt, String c, Product p) {
		this(d, amt, c, p, 1);

	}
	public Order(){
		
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
		if (orderAmount <= 0) {
			System.out.println("Attempting to set the quantity to a value less than or equal to zero " + orderAmount);
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
	
	public boolean isPriorityOrder(){
		boolean priorityOrder = false;
		if (rushable != null){
			priorityOrder = rushable.isRushable(orderDate, orderAmount);
		}
		return priorityOrder;
	}
	private boolean isHoliday(MyDate proposedDate){
		boolean result = false;
		for (MyDate holiday : MyDate.getHolidays()){
			if(holiday.equals(proposedDate)){
				result = true;
			}
		}
		return result;
	}

	public MyDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(MyDate orderDate) {
		if (isHoliday(orderDate)){
			System.out.println("Order date, " + orderDate + ", cannot be set to a holiday!");
			}
		
		else {
			this.orderDate = orderDate;
		}

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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
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
	public static Rushable getRushable(){
		return rushable;
	}
	public static void setRushable(Rushable rushable){
		Order.rushable = rushable;
	}

}
