package conversion;

public class Converter {
	private String unit;
	
	public Converter(String inputUnit) {
		setUnit(inputUnit);
	}
	
	public double fromCommonUnit(double measurement) {
		return measurement;
	}
	public double toCommonUnit(double measurement) {
		return measurement;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String inputUnit) {
		unit = inputUnit.toUpperCase();
		
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
