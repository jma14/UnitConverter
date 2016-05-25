package conversion;

import java.util.Arrays;
import java.util.Scanner;

public class LengthConverter {

	final private double INCH_TO_METER = 0.0254;
	final private double FOOT_TO_METER = 0.3048;
	final private double MILE_TO_METER = 1609.344;
	final private double MM_TO_METER = 0.001;
	final private double CM_TO_METER = 0.01;
	final private double KM_TO_METER = 1000;
	final private double YARD_TO_METER = 0.9144;
	private static final String[] LENGTH_UNIT_OPTIONS = {"IN","FOOT","MILE","MM","CM","KM","YARD","M"};
	
	private double factor;
	
	public LengthConverter(String TO_FROM) {
		String unit = getInput(TO_FROM);
		setFactor(unit);
	}
	
	public void setFactor(String unit) {
		
		switch (unit) {
		case "IN" :		factor = INCH_TO_METER;
						break;
		case "FOOT" :	factor = FOOT_TO_METER;
						break;
		case "MILE" :	factor = MILE_TO_METER;
						break;
		case "MM" :		factor = MM_TO_METER;
						break;
		case "CM" :		factor = CM_TO_METER;
						break;
		case "KM" :		factor = KM_TO_METER;
						break;
		case "YARD" :	factor = YARD_TO_METER;
						break;
		case "M" :		factor = 1;
						break;
		}
	}
	
	public double getFactor() {
		return factor;
	}
	
	public double toMeters(double measurement) {
		return (measurement * factor);
	}
	
	public double fromMeters(double measurement) {
		return (measurement / factor);
	}
	
	public static String getInput(String TO_FROM) {
		Scanner in = new Scanner(System.in);
		System.out.print("Convert " + TO_FROM + ": ");
		String inputUnit = in.nextLine();
		inputUnit = fixUnit(inputUnit);
		
		while(!Arrays.asList(LENGTH_UNIT_OPTIONS).contains(inputUnit)) {
			System.out.println("Invalid Unit. Available options are " + Arrays.toString(LENGTH_UNIT_OPTIONS));
			System.out.print("Convert " + TO_FROM + ": ");
			inputUnit = in.nextLine();
			inputUnit = fixUnit(inputUnit);
		}
		return inputUnit;
	}
	
	public static String fixUnit(String unit) {
		unit = unit.toUpperCase();
		switch(unit) {
		case "INCH" :
		case "INCHES" :
			return "IN";
		case "FEET" :
		case "FOOT" :
			return "FOOT";
		case "MI" :
		case "MILES" :
			return "MILE";
		case "MILIMETER" :
		case "MILIMETERS" :
			return "MM";
		case "CENTIMETER" :
		case "CENTIMETERS" :
			return "CM";
		case "KILOMETER" :
		case "KILOMETERS" :
			return "KM" ;
		case "YD" :
		case "YARDS" :
			return "YARD";
		case "METER" :
		case "METERS" :
			return "M";
		}
		return unit;
	}

}
