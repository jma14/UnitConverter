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
		
		
		do {
			if(type.equals("error")) System.out.println("Invalid Unit Type.  Options are " + Arrays.toString(UNIT_TYPES));
			System.out.print("Would you like to make a length conversion or a weight conversion? ");
			String Length_Or_Weight = in.nextLine();
			type = checkInput(Length_Or_Weight);
		}while((type.equals("error")));
		
		if(type.equals("LENGTH")) {
			from = new LengthConverter("from");
			to = new LengthConverter("to");
		} else {
			from = new WeightConverter("from");
			to = new WeightConverter("to");
		}
		
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
		if(type.equals("LENGTH")) {
			double meters = from.toCommonUnit(val);
			converted = to.fromCommonUnit(meters);
		} else {
			double kilometers = from.toCommonUnit(val);
			converted = to.fromCommonUnit(kilometers);
		}
		
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
