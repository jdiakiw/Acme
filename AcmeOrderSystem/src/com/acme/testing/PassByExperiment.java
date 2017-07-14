package com.acme.testing;

import com.acme.utils.MyDate;

public class PassByExperiment {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		MyDate date = new MyDate(1, 20, 2008);
		MyDate date2 = new MyDate(2, 5, 2008);
		System.out.println("Before passing an object " + date);
		passObject(date);
		System.out.println("After passing an object " + date);
		System.out.println("Before passing a primative " + date.getYear());
		passPrimitive(date.getYear());
		System.out.println("After passing a primitive " + date.getYear());
		String x = date.toString();
		System.out.println("Before passing a String " + x);
		passString(x);
		System.out.println("After passing a String " + x);
		sb.append(date2.toString());
		System.out.println("Before passing a StringBuilder " + sb);
		passStringBuilder(sb);
		System.out.println("After passing a StringBuilder " + sb);

	}

	public static void passObject(MyDate d) {
		d.setYear(2009);
	}

	public static void passPrimitive(int i) {
		i = 2010;
	}

	public static void passString(String s) {
		int yearSlash = s.lastIndexOf('/');
		s = s.substring(0, yearSlash + 1);
		s += "2012";
		System.out.println("New date string: " + s);

	}

	public static void passStringBuilder(StringBuilder sb) {
		int yearSlash = sb.lastIndexOf("/");
		sb = sb.replace(yearSlash + 1, sb.length(), "2012");

	}
}
