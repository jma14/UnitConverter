package length;

public class LengthConverter {

	final private double INCH_TO_METER = 0.0254;
	final private double FOOT_TO_METER = 0.3048;
	final private double MILE_TO_METER = 1609.344;
	final private double MM_TO_METER = 0.001;
	final private double CM_TO_METER = 0.01;
	final private double KM_TO_METER = 1000;
	final private double YARD_TO_METER = 0.9144;
	
	private double factor;
	
	public LengthConverter(String unit) {
		switch (unit) {
		case "IN" :		factor = INCH_TO_METER;
						break;
		case "FOOT" :	factor = FOOT_TO_METER;
						break;
		case "MILE" :	factor = MILE_TO_METER;
						break;
		case "MM" :		factor = MM_TO_METER;
						break;
		case "CM" :		factor = CM_TO_METER;
						break;
		case "KM" :		factor = KM_TO_METER;
						break;
		case "YARD" :	factor = YARD_TO_METER;
						break;
		}
	}
	
	public double toMeters(double measurement) {
		return (measurement * factor);
	}
	
	public double fromMeters(double measurement) {
		return (measurement / factor);
	}

}
