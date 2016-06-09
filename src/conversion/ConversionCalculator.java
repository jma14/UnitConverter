package conversion;

import java.util.Arrays;
import java.util.Scanner;

public class ConversionCalculator {
	
	private static final String[] UNIT_TYPES = {"LENGTH","WEIGHT"};

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String type = "";
		Converter from;
		Converter to;
		double converted;
		
		
		String fromUnit = "";
		do {
			if(fromUnit!="") System.out.println("Invalid entry.");
			System.out.print("Convert from: ");
			fromUnit = in.next();
			from = new Converter(fromUnit);
		}while(!from.getFactors().containsKey(from.getUnit()));
		
		
		String toUnit = "";
		do {
			if(toUnit!="") System.out.println("Invalid entry.");
			System.out.print("Convert to: ");
			toUnit = in.next();
			to = new Converter(toUnit);
		}while(!to.getFactors().containsKey(to.getUnit()) || !to.getType().equals(from.getType()));
		
		
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
	
		double commonUnit = from.toCommonUnit(val);
		converted = to.fromCommonUnit(commonUnit);
		

		
		System.out.print(val + " " + from.getUnit() + " equals " + converted + " " + to.getUnit());

	}
	
	public static String checkInput(String Length_Or_Weight) {
		Length_Or_Weight = Length_Or_Weight.toUpperCase();
		switch(Length_Or_Weight) {
		case "L" :
		case "LEN" :
		case "LENGTH" :
			return "LENGTH";
		case "W" :
		case "WEIGHT" :
			return "WEIGHT";
		default :
			return "error";
		}
	}
	

}