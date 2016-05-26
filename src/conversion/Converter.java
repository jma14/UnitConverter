package conversion;

import java.util.HashMap;
import java.util.Map;

public class Converter {
	private String unit;
	private String unit_type;
	final private Map<String,Double> factors = new HashMap<String,Double>();
	
	public Converter(String inputUnit) {
		factors.put("IN", 0.0254);
		factors.put("FT", 0.3048);
		factors.put("MILE", 1609.344);
		factors.put("MM", 0.001);
		factors.put("CM", 0.01);
		factors.put("KM", 1000.0);
		factors.put("YD", 0.9144);
		factors.put("M", 1.0);
		factors.put("LB", 0.453592);
		factors.put("OZ", 0.283495);
		factors.put("G", 0.001);
		factors.put("MG", 0.000001);
		factors.put("KG", 1.0);
		setUnit(inputUnit);
	}
	
	public double toCommonUnit(double measurement) {
		return (measurement * factors.get(unit));
	}

	public double fromCommonUnit(double measurement) {
		return (measurement / factors.get(unit));
	}
	
	public String getUnit() {
		return unit;
	}
	
	public String getType() {
		return unit_type;
	}
	
	public void setUnit(String inputUnit) {
		unit = inputUnit.toUpperCase();
		
		switch(unit) {
		case "IN" :
		case "INCH" :
		case "INCHES" :
			unit = "IN";
			unit_type = "LENGTH";
			break;
		case "FT" :
		case "FEET" :
		case "FOOT" :
			unit = "FT";
			unit_type = "LENGTH";
			break;
		case "MI" :
		case "MILE" :
		case "MILES" :
			unit = "MILE";
			unit_type = "LENGTH";
			break;
		case "MM" :
		case "MILIMETER" :
		case "MILIMETERS" :
			unit_type = "LENGTH";
			unit = "MM";
			break;
		case "CM" :
		case "CENTIMETER" :
		case "CENTIMETERS" :
			unit = "CM";
			unit_type = "LENGTH";
			break;
		case "KM" :
		case "KILOMETER" :
		case "KILOMETERS" :
			unit = "KM" ;
			unit_type = "LENGTH";
			break;
		case "YD" :
		case "YARD" :
		case "YARDS" :
			unit = "YARD";
			unit_type = "LENGTH";
			break;
		case "M" :
		case "METER" :
		case "METERS" :
			unit = "M";
			unit_type = "LENGTH";
			break;
		case "LB" :
		case "LBS" :
		case "POUND" :
		case "POUNDS" :
			unit = "LB";
			unit_type = "WEIGHT";
			break;
		case "OZ" :
		case "OZS" :
		case "OUNCE" :
		case "OUNCES" :
			unit = "OZ";
			unit_type = "WEIGHT";
			break;
		case "G" :
		case "GM" :
		case "GRAM" :
		case "GRAMS" :
			unit = "G";
			unit_type = "WEIGHT";
			break;
		case "MG" :
		case "MILIGRAM" :
		case "MILIGRAMS" :
			unit = "MG";
			unit_type = "WEIGHT";
			break;
		case "KG" :
		case "KILOGRAM" :
		case "KILOGRAMS" :
			unit = "KG";
			unit_type = "WEIGHT";
			break;
		}
	}

}
