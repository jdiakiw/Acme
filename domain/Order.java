package com.acme.domain;
import com.acme.utils.MyDate;

public class Order {
	MyDate orderDate;
	double orderAmount = 0.00;
	String customer;
	String product;
	int quantity;
	public static double taxRate;
	
	static{
		taxRate = 0.05;
	}
	
	
	
	public Order(MyDate d, double amt, String c, String p, int q){
		orderDate=d;
		orderAmount=amt;
		customer=c;
		product=p;
		quantity=q;
	}
	public Order(MyDate d, double amt, String c){
		this(d, amt, c, "Anvil", 1);
		
	}
	
	public String toString(){
		return quantity + " ea. " + product + " for " + customer; 
	}
	
	public static void setTaxRate(double newRate){
		taxRate = newRate;
		
	}
	public static void computeTaxOn(double anAmount){
		System.out.println("The tax for " + anAmount + " is: " + anAmount * taxRate);
	}
	public double computeTax(){
		System.out.println("The tax for this order is: " + orderAmount * taxRate);
		return orderAmount * taxRate;
	}
	public char jobSize(){
		if (quantity <= 25){
			return 'S';
		}
		else if(quantity <=75){
			return 'M';
		}
		else if(quantity <=150){
			return 'L';
		}
		return 'X';
			
	}
	public double computeTotal(){
		double orderTotal = orderAmount;
		switch (jobSize()){
		case 'M' : orderTotal = orderTotal - (orderAmount * 0.01);
		break;
		case 'L' : orderTotal = orderTotal - (orderAmount * 0.02);
		break;
		case 'X' : orderTotal = orderTotal - (orderAmount * 0.03);
		break;
		}
		if (orderAmount <= 1500){
			orderTotal = orderTotal + computeTax();
		}
		
		return orderTotal;
	}
}
