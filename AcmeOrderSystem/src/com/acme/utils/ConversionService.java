package com.acme.utils;

public class ConversionService {

	/**
	 * WEIGHT CONVERSION RATES
	 */
	// CONVERSION RATE FOR 1 KILOGRAM TO POUNDS
	public static Double kilogramToPounds = 2.2046;

	// CONVERSION RATE FOR 1 KILOGRAM TO GRAMS
	public static int kilogramToGrams = 1000;

	// CONVERSION RATE FOR 1 KILOGRAM TO WEIGHT OUNCES
	public static double kilogramToOunces = 35.274;

	/**
	 * VOLUME CONVERSION RATES
	 */
	// CONVERSION RATE FOR 1 LITER TO FLUID OUNCES
	public static float literToFluidOunce = 33.814f;

	// CONVERSION RATE FOR 1 LITER TO GALLONS
	public static float literToGallon = 0.2642f;

	// CONVERSION RATE FOR 1 LITER TO PINTS
	public static float literToPints = 2.1134f;

	// CONVERSION RATE FOR 1 LITER TO MILLILITERS
	public static short literToMilliliters = 1_000;

	/**
	 * METHODS
	 */

	public static Double pounds(Double kilograms) {
		return kilograms * kilogramToPounds;
	}

	public static int grams(int kilograms) {
		return kilograms * kilogramToGrams;
	}

	public static double ounces(double kilograms) {
		return kilograms * kilogramToOunces;
	}

	public static float fluidOunces(Float liters) {
		return liters * literToFluidOunce;
	}

	public static float gallons(float liters) {
		return liters * literToGallon;
	}

	public static float pints(float liters) {
		return liters * literToPints;
	}

	public static int milliliters(int liters) {
		return liters * literToMilliliters;
	}

	public static double[][] allKgToPounds(double...kilogramValues ) {
		double[][] newArr = new double [kilogramValues.length][2];
		
			for (int i = 0; i < kilogramValues.length; i++){
				
				newArr[i][0] = kilogramValues[i];
				newArr[i][1] = pounds(kilogramValues[i]);
		}
	
		return newArr;

	}

}
