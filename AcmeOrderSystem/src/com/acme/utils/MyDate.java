package com.acme.utils;

public class MyDate {
	private byte month;
	private byte day;
	private short year;
	private static MyDate[] holidays;

	{
		month = 1;
		day = 1;
		year = 2000;
	}
	
	static{
		holidays = new MyDate[6];
		holidays[0] = new MyDate(1, 1, 2017);
		holidays[1] = new MyDate(5, 30, 2017);
		holidays[2] = new MyDate(7, 4, 2017);
		holidays[3] = new MyDate(9, 5, 2017);
		holidays[4] = new MyDate(11, 24, 2017);
		holidays[5] = new MyDate(12, 25, 2017);
		
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
	
	public static void listHolidays(){
		System.out.println("The Holidays Are:");
		for (MyDate holiday : holidays){
			System.out.println(holiday);
			
		}
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
	
	public static MyDate[] getHolidays() {
		return holidays;
	}

}
