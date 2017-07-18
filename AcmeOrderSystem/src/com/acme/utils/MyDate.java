package com.acme.utils;

public class MyDate {
	private byte month;
	private byte day;
	private short year;

	{
		month = 1;
		day = 1;
		year = 2000;
	}

	public MyDate() {

	}

	public MyDate(int m, int d, int y) {
		setDate(m, d, y);

	}

	public void setDate(int m, int d, int y) {
		if (valid(m, d, y)) {
			month = (byte) m;
			day = (byte) d;
			year = (short) y;
		}

	}

	public static void leapYears() {
		for (int i = 1752; i <= 2020; i = i + 4) {
			if (((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0))
				System.out.println("The year " + i + " is a leap year");
		}
	}

	public boolean valid(int month, int day, int year) {
		if (month > 12 || month < 1 || day > 31 || day < 1 || year < 1900 || year > 2017) {
			System.out.println(("attempting to create a non-valid date " + month + "/" + day + "/" + year));
			return false;
		}
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			return (day <= 30);
		case 2:
			return day <= 28 || (day == 29 && year % 4 == 0);

		}
		return true;
	}
	
	public boolean equals(Object o){
		if (o instanceof MyDate) {
			MyDate d = (MyDate) o;
			if ((d.day == day) && (d.month == month) && (d.year == year)){
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return month + "/" + day + "/" + year;

	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (valid(month, day, year)) {
			this.month = (byte) month;
		}

	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if (valid(month, day, year)) {
			this.day = (byte) day;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (valid(month, day, year)) {
			this.year = (short) year;
		}

	}

}
