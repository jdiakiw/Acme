package com.acme.testing;

import com.acme.domain.Order;
import com.acme.utils.MyDate;

public class TestOrders {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyDate date1 = new MyDate(1, 20, 2008);
		Order anvil = new Order(date1, 2000.00, "Wile E Coyote", "Anvil", 10);

		MyDate date2 = new MyDate(4, 10, 2008);
		Order balloons = new Order(date2, 1000.00, "Bugs Bunny", "Balloon", 125);

		MyDate date3 = new MyDate(5, 20, 2008);
		Order anotherAnvil = new Order(date3, 20, "Road Runner");

		System.out.println(anvil);
		System.out.println(balloons);
		System.out.println(anotherAnvil);
		System.out.println("The tax Rate is currently: " + Order.taxRate);
		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();

		Order.setTaxRate(0.06);
		System.out.println("The tax Rate is currently: " + Order.taxRate);
		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();
		balloons.setQuantity(-200);
		balloons.setOrderAmount(-250.00);

		System.out.println("The total bill for: " + anvil + " is " + anvil.computeTotal());
		System.out.println("The total bill for: " + balloons + " is " + balloons.computeTotal());
		System.out.println("The total bill for: " + anotherAnvil + " is " + anotherAnvil.computeTotal());

	}

}
