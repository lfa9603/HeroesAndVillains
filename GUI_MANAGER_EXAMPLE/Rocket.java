
public class Rocket {

	
	private String name;
	private String fuel;
	private boolean isClean;
	
	public Rocket(String name, String fuel, boolean isClean) {
		super();
		this.name = name;
		this.fuel = fuel;
		this.isClean = isClean;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the fuel
	 */
	public String getFuel() {
		return fuel;
	}
	
	/**
	 * @param fuel the fuel to set
	 */
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	
	/**
	 * @return the isClean
	 */
	public boolean isClean() {
		return isClean;
	}
	
	/**
	 * @param isClean the isClean to set
	 */
	public void setClean(boolean isClean) {
		this.isClean = isClean;
	}
	
	
}
