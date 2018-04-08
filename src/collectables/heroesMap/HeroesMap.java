package collectables.heroesMap;

import characters.HeroesSquad;
import city.City;
import collectables.Collectable;
import collectables.Money;

public class HeroesMap  {

	private City currentCity;
	private Money cost;

	
	
	public HeroesMap(City city) {
		currentCity = city;
	}
	
	/**
	 * @return the currentCity
	 */
	public City getCurrentCity() {
		return currentCity;
	}

	/**
	 * @param currentCity the currentCity to set
	 */
	public void setCurrentCity(City currentCity) {
		this.currentCity = currentCity;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(Money cost) {
		this.cost = cost;
	}
	
	public Money getCost() {
		return cost;
	}
	public String toString() {
		return currentCity.toString();
	}
	
	public void apply(HeroesSquad heroSquad) {
		heroSquad.setHaveMap(true);
	}
	
	

}
