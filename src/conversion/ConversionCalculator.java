package conversion;

import java.util.Arrays;
import java.util.Scanner;

public class ConversionCalculator {
	
	private static final String[] WEIGHT_UNIT_OPTIONS = {"LB","OZ","G","MG"};
	private static final String[] UNIT_TYPES = {"LENGTH","WEIGHT"};

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		LengthConverter from = new LengthConverter("from");
		LengthConverter to = new LengthConverter("to");
		
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
		
		System.out.print("The answer is: " + converted);

	}
	

}
