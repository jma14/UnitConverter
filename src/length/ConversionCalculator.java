package length;

import java.util.Arrays;
import java.util.Scanner;

public class ConversionCalculator {
	
	private static final String[] UNIT_OPTIONS = {"IN","FEET","MILE","MM","CM","KM","YARD"};

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Convert from: ");
		String fromUnit = in.nextLine();
		fromUnit = fixUnit(fromUnit);
		
		while(!Arrays.asList(UNIT_OPTIONS).contains(fromUnit)) {
			System.out.println("Invalid Unit. Available options are " + Arrays.toString(UNIT_OPTIONS));
			System.out.print("Convert from: ");
			fromUnit = in.nextLine();
			fromUnit = fixUnit(fromUnit);
		}
		
		
		System.out.print("Convert to: ");
		String toUnit = in.nextLine();
		toUnit = fixUnit(toUnit);
		
		while(!Arrays.asList(UNIT_OPTIONS).contains(toUnit)) {
			System.out.println("Invalid Unit. Available options are " + Arrays.toString(UNIT_OPTIONS));
			System.out.print("Convert to: ");
			toUnit = in.nextLine();
			toUnit = fixUnit(toUnit);
		}
		
		LengthConverter from = new LengthConverter(fromUnit);
		LengthConverter to = new LengthConverter(toUnit);
		
		double val;
		while (true) {
		    System.out.print("Value: ");
		    try {
		        val = Double.parseDouble(in.next());
		        break; // will only get to here if input was a double
		    } catch (NumberFormatException ignore) {
		        System.out.println("Invalid input.  Please enter a valid number.");
		    }
		}
		
		
		double meters = from.toMeters(val);
		double converted = to.fromMeters(meters);
		
		System.out.print("converted to " + converted);
		

	}
	
	
	public static String fixUnit(String unit) {
		unit = unit.toUpperCase();
		switch(unit) {
		case "INCH" :
		case "INCHES" :
			return "IN";
		case "FT" :
		case "FOOT" :
			return "FEET";
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
		}
		return unit;
	}

}
