package conversion;

import java.util.*;

public class WeightConverter implements Converter{
	final private Map<String,Double> Weight_Factors = new HashMap<String,Double>();
	private String unit;
	
	public WeightConverter(String TO_FROM) {
		Weight_Factors.put("LB", 0.453592);
		Weight_Factors.put("OZ", 0.283495);
		Weight_Factors.put("G", 0.001);
		Weight_Factors.put("MG", 0.000001);
		Weight_Factors.put("KG", 1.0);
		getInput(TO_FROM);
	}
	
	public String getUnit() {
		return unit;
	}
	
	
	public double toCommonUnit(double measurement) {
		return (measurement * Weight_Factors.get(unit));
	}
	
	public double fromCommonUnit(double measurement) {
		return (measurement / Weight_Factors.get(unit));
	}
	
	public void getInput(String TO_FROM) {
		Scanner in = new Scanner(System.in);
		System.out.print("Convert " + TO_FROM + ": ");
		unit = in.nextLine();
		setUnit();
		
		while(!Weight_Factors.containsKey(unit)) {
			System.out.print("Invalid Unit. Available options are ");
			for (Map.Entry<String,Double> entry : Weight_Factors.entrySet()) {
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