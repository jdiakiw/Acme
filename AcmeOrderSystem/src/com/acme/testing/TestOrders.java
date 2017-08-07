package com.acme.testing;


import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.TemporalAmount;

import com.acme.domain.Good;
import com.acme.domain.Good.UnitOfMeasureType;
import com.acme.domain.Liquid;
import com.acme.domain.Order;
import com.acme.utils.MyDate;
import com.acme.domain.Solid;
import com.acme.domain.Service;

public class TestOrders {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyDate date1 = new MyDate(11, 24, 2017);
		Solid s1 = new Solid("Acme Anvil", 1668, 0.3, UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3);
		Order anvil = new Order(date1, 2000.00, "Wile E Coyote", s1, 10);

		MyDate date2 = new MyDate(4, 10, 2008);
		Solid s2 = new Solid("Acme Balloons", 1401, 15, UnitOfMeasureType.CUBIC_FEET, false, 10, 5, 5);
		Order balloons = new Order(date2, 1000.00, "Bugs Bunny", s2, 125);

		MyDate date3 = new MyDate(5, 20, 2008);
		Solid s3 = new Solid("Acme Anvil", 1668, 0.3, UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3);
		Order anotherAnvil = new Order(date3, 20, "Road Runner", s3);
		
		MyDate date4 = new MyDate(4,10,2008);
		Service s4 = new Service("Road Runner Eradication", 14, false);
		Order birdEradication = new Order(date4, 20000, "Daffy Duck", s4, 1);
		System.out.println("The total bill for: " + birdEradication + " is " + birdEradication.computeTotal());
		
		MyDate hammerDate = new MyDate (7,10,2017);
		Solid hammerType = new Solid("Acme Hammer", 281, 0.3, UnitOfMeasureType.CUBIC_METER, false, 100, 0.25, 0.3);
		Order hammer = new Order(hammerDate, 10.00, "Wile E Coyote", hammerType, 10);
		
		MyDate newYear = new MyDate(1,1,2009);
		MyDate fiscalStart = new MyDate(1,1,2009);
		
		if (newYear.equals(fiscalStart)){
			System.out.println("These two dates are equal");
		}
		else
			System.out.println("These two dates are not equal");
		
	

		System.out.println(anvil);
		System.out.println(balloons);
		System.out.println(anotherAnvil);
		System.out.println(hammer);
		System.out.println("The tax Rate is currently: " + Order.taxRate);
		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();

		Order.setTaxRate(0.06);
		System.out.println("The tax Rate is currently: " + Order.taxRate);
		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();
		anotherAnvil.computeTax();
		balloons.setQuantity(-200);
		balloons.setOrderAmount(-250.00);
		

		//System.out.println("The total bill for: " + anvil + " is " + anvil.computeTotal());
		//System.out.println("The total bill for: " + balloons + " is " + balloons.computeTotal());
		//System.out.println("The total bill for: " + anotherAnvil + " is " + anotherAnvil.computeTotal());

		//System.out.println("The volume of the anvil is: " + ((Good) anvil.getProduct()).volume());
		//System.out.println("The length of the anvil is: " + ((Solid) anvil.getProduct()).getLength());
		
		Order.setRushable((orderDate, orderAmount) ->{
			LocalDate now = LocalDate.now();
			LocalDate orderDatePlus30 = LocalDate.of(orderDate.getYear(), orderDate.getMonth(), orderDate.getDay());
			orderDatePlus30 = orderDatePlus30.plusMonths(1);
			return now.isAfter(orderDatePlus30);
		});
				
/*		System.out.println("Anvil isPriorityOrder: " + anvil.isPriorityOrder());
		System.out.println("Balloons isPriorityOrder: " + balloons.isPriorityOrder());
		System.out.println("Hammer isPriorityOrder: " + hammer.isPriorityOrder());*/
		
	
	}

}
