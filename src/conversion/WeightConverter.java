package conversion;

import java.util.Arrays;
import java.util.Scanner;

public class WeightConverter implements Converter {

	final private double LB_TO_KG = 0.453592;
	final private double OZ_TO_KG = 0.0283495;
	final private double G_TO_KG = 0.001;
	final private double MG_TO_KG = 0.000001;
	final private double KG_TO_KG = 1;
	private static final String[] WEIGHT_UNIT_OPTIONS = {"LB","OZ","G","MG","KG"};
	
	private double factor;
	
	private String unit;
	
	public WeightConverter(String TO_FROM) {
		getInput(TO_FROM);
		setFactor();
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setFactor() {
		
		switch (unit) {
		case "LB" :		factor = LB_TO_KG;
						break;
		case "OZ" :		factor = OZ_TO_KG;
						break;
		case "G" :		factor = G_TO_KG;
						break;
		case "MG" :		factor = MG_TO_KG;
						break;
		case "KG" :		factor = KG_TO_KG;
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
		
		while(!Arrays.asList(WEIGHT_UNIT_OPTIONS).contains(unit)) {
			System.out.println("Invalid Unit. Available options are " + Arrays.toString(WEIGHT_UNIT_OPTIONS));
			System.out.print("Convert " + TO_FROM + ": ");
			unit = in.nextLine();
			setUnit();
		}
	}
	
	public void setUnit() {
		unit = unit.toUpperCase();
		switch(unit) {
		case "LBS" :
		case "POUND" :
		case "POUNDS" :
			unit = "LB";
			break;
		case "OZS" :
		case "OUNCE" :
		case "OUNCES" :
			unit = "OZ";
			break;
		case "GM" :
		case "GRAM" :
		case "GRAMS" :
			unit = "G";
			break;
		case "MILIGRAM" :
		case "MILIGRAMS" :
			unit = "MG";
			break;
		case "KILOGRAM" :
		case "KILOGRAMS" :
			unit = "KG";
			break;
		}
	}

}