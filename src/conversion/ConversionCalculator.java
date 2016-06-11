package conversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConversionCalculator {
	
	private static final String[] UNIT_TYPES = {"LENGTH","WEIGHT"};
	private static boolean isTop = true;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String type = "";
		Converter from = null;
		Converter to;
		double converted;
		Queue<String> topUnits = new LinkedList<String>();
		Queue<String> bottomUnits = new LinkedList<String>();
		Queue<Double> topNums = new LinkedList<Double>();
		Queue<Double> bottomNums=new LinkedList<Double>();
		Queue<Character> operator = new LinkedList<Character>();
		double nums = 0;
		String userInput;
		//do {
			System.out.println("Whatcha wanna do?");
			userInput = in.nextLine();
			String num = "";
			String unit = "";
			while(userInput.length() > 0) {
				char nextChar = userInput.charAt(0);
				if(Character.isDigit(nextChar) || nextChar == '.') {
					num += nextChar;
				} else if(Character.isLetter(nextChar)) {
					unit += nextChar;
				} else if(isSymbol(nextChar)){
					System.out.print(isSymbol(nextChar) + " " + nextChar + " " + isTop);
					if(nextChar != '/') isTop = true;
					operator.add(nextChar);
					nums = Double.parseDouble(num);
					from = new Converter(unit);
					System.out.print(" " + isTop);
					if(isTop) {
						topNums.add(from.toCommonUnit(nums));
						topUnits.add(unit);
						if(nextChar == '/') isTop = false;
					} else {
						bottomNums.add(from.toCommonUnit(nums));
						bottomUnits.add(unit);
						if(nextChar == '/') isTop = true;
					}
					System.out.println(" " + isTop);
					num = "";
					unit = "";
				}
				if(userInput.length() >= 1) {
					userInput = userInput.substring(1);
				} else {
					userInput = "";
				}
			}
			nums = Double.parseDouble(num);
			from = new Converter(unit);
			if(isTop) {
				topNums.add(from.toCommonUnit(nums));
				topUnits.add(unit);
			} else {
				bottomNums.add(from.toCommonUnit(nums));
				bottomUnits.add(unit);
			}
			
			double total = 0;
			System.out.println(topNums.toString() + " " + topUnits.toString());
			System.out.println(bottomNums.toString() + " " + bottomUnits.toString());
			while(!topNums.isEmpty()) {
				String outUnit = from.getType().equals("LENGTH") ? "m" : "lb";
				if(!operator.isEmpty()) {
					char checkOperator = operator.remove();
					if(checkOperator == '+') {
						total += topNums.remove() / bottomNums.remove() + topNums.remove() / bottomNums.remove();
					} else if(checkOperator == '-') {
						total -= topNums.remove() / bottomNums.remove() - topNums.remove() / bottomNums.remove();
					} else if(checkOperator == '*') {
						total *= topNums.remove() / bottomNums.remove() * topNums.remove() / bottomNums.remove();
					} else {
						total /= topNums.remove() / bottomNums.remove() / topNums.remove() / bottomNums.remove();
					}
				}
				System.out.println(total + " " + outUnit);
			}
		//}
		/*nums = Double.parseDouble(num);
		from = new Converter(unit);
		System.out.println(from.getType());*/
		//to = new Converter("mm");
		
		/*String fromUnit = "";
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
		*/
	
		//double commonUnit = from.toCommonUnit(nums);
		//converted = to.fromCommonUnit(commonUnit);
		

		
		//System.out.print(nums + " " + from.getUnit() + " equals " + converted + " " + to.getUnit());

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
	
	public static boolean isSymbol(char checkChar) {
		char[] operators = {'/','+','-','*'};
		for(char c : operators) {
			if(checkChar == c) {
				return true;
			}
		}
		return false;
	}
	

}