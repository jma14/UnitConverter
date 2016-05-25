package conversion;

public interface Converter {
	public String getUnit();
	public void setFactor();
	public double getFactor();
	public void getInput(String TO_FROM);
	public void setUnit();
	public double toCommonUnit(double val);
	public double fromCommonUnit(double val);

}