package length;

import java.util.Scanner;

public class ConversionCalculator {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Convert from: ");;
		String fromUnit = in.nextLine();
		
		System.out.print("Convert to: ");;
		String toUnit = in.nextLine();
		
		LengthConverter from = new LengthConverter(fromUnit);
		LengthConverter to = new LengthConverter(toUnit);
		
		System.out.print("Value: ");
		double val = in.nextDouble();
		
		double meters = from.toMeters(val);
		double converted = to.fromMeters(meters);
		
		System.out.print("converted to " + converted);
		

	}

}
