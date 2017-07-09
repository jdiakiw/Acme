package com.acme.utils;

public class MyDate {
	public int month;
	public int day;
	public int year;
	
	{
		month = 1;
		day = 1;
		year = 2000;
	}
	
	
	public MyDate(){
		
	}
	
	public MyDate(int m, int d, int y){
		setDate(m,d,y);
	}
	
	public void setDate(int m, int d, int y){
		month = m;
		day = d;
		year = y;
	}
	public String toString(){
		return month + "/" + day + "/" + year;
	}

}
