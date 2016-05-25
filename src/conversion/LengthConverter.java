package conversion;

import java.util.*;

public class LengthConverter implements Converter{
	
	final private Map<String,Double> Length_Factors = new HashMap<String,Double>();
	
	private String unit;
	
	public LengthConverter(String TO_FROM) {
		Length_Factors.put("IN", 0.0254);
		Length_Factors.put("FT", 0.3048);
		Length_Factors.put("MILE", 1609.344);
		Length_Factors.put("MM", 0.001);
		Length_Factors.put("CM", 0.01);
		Length_Factors.put("KM", 1000.0);
		Length_Factors.put("YD", 0.9144);
		Length_Factors.put("M", 1.0);
		getInput(TO_FROM);
	}
	
	public String getUnit() {
		return unit;
	}
	
	public double toCommonUnit(double measurement) {
		return (measurement * Length_Factors.get(unit));
	}
	
	public double fromCommonUnit(double measurement) {
		return (measurement / Length_Factors.get(unit));
	}
	
	public void getInput(String TO_FROM) {
		Scanner in = new Scanner(System.in);
		System.out.print("Convert " + TO_FROM + ": ");
		unit = in.nextLine();
		setUnit();
		
		while(!Length_Factors.containsKey(unit)) {
			System.out.print("Invalid Unit. Available options are ");
			for (Map.Entry<String,Double> entry : Length_Factors.entrySet()) {
				  String key = entry.getKey();
				  System.out.print(key + " ");
			}
			System.out.print("\nConvert " + TO_FROM + ": ");
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
			unit = "FT";
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
