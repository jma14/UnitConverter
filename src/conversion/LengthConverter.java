package conversion;

import java.util.Arrays;
import java.util.Scanner;

public class LengthConverter implements Converter {

	final private double INCH_TO_METER = 0.0254;
	final private double FOOT_TO_METER = 0.3048;
	final private double MILE_TO_METER = 1609.344;
	final private double MM_TO_METER = 0.001;
	final private double CM_TO_METER = 0.01;
	final private double KM_TO_METER = 1000;
	final private double YARD_TO_METER = 0.9144;
	final private double METER_TO_METER = 1;
	private static final String[] LENGTH_UNIT_OPTIONS = {"IN","FOOT","MILE","MM","CM","KM","YARD","M"};
	
	private double factor;
	
	private String unit;
	
	public LengthConverter(String TO_FROM) {
		getInput(TO_FROM);
		setFactor();
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setFactor() {
		
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
		case "M" :		factor = METER_TO_METER;
						break;
		}
	}
	
	public double getFactor() {
		return factor;
	}
	
	public double toCommonUnit(double measurement) {
		return (measurement * factor);
	}
	
	public double fromCommonUnit(double measurement) {
		return (measurement / factor);
	}
	
	public void getInput(String TO_FROM) {
		Scanner in = new Scanner(System.in);
		System.out.print("Convert " + TO_FROM + ": ");
		unit = in.nextLine();
		setUnit();
		
		while(!Arrays.asList(LENGTH_UNIT_OPTIONS).contains(unit)) {
			System.out.println("Invalid Unit. Available options are " + Arrays.toString(LENGTH_UNIT_OPTIONS));
			System.out.print("Convert " + TO_FROM + ": ");
			unit = in.nextLine();
			setUnit();
		}
	}
	
	public void setUnit() {
		unit = unit.toUpperCase();
		switch(unit) {
		case "INCH" :
		case "INCHES" :
			unit = "IN";
			break;
		case "FEET" :
		case "FOOT" :
			unit = "FOOT";
			break;
		case "MI" :
		case "MILES" :
			unit = "MILE";
			break;
		case "MILIMETER" :
		case "MILIMETERS" :
			unit = "MM";
			break;
		case "CENTIMETER" :
		case "CENTIMETERS" :
			unit = "CM";
			break;
		case "KILOMETER" :
		case "KILOMETERS" :
			unit = "KM" ;
			break;
		case "YD" :
		case "YARDS" :
			unit = "YARD";
			break;
		case "METER" :
		case "METERS" :
			unit = "M";
			break;
		}
	}

}
