package conversion;

public class WeightConverter {

	final private double LB_TO_KG = 0.453592;
	final private double OZ_TO_KG = 0.0283495;
	final private double G_TO_KG = 0.001;
	final private double MG_TO_KG = 0.000001;
	
	private double factor;
	
	public WeightConverter(String unit) {
		switch (unit) {
		case "LB" :		factor = LB_TO_KG;
						break;
		case "OZ" :		factor = OZ_TO_KG;
						break;
		case "G" :		factor = G_TO_KG;
						break;
		case "MG" :		factor = MG_TO_KG;
						break;
		}
	}
	
	public double toKilogram(double measurement) {
		return (measurement * factor);
	}
	
	public double fromKilogram(double measurement) {
		return (measurement / factor);
	}

}