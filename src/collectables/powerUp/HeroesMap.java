package collectables.powerUp;

import characters.Hero;
import characters.HeroesSquad;
import city.City;
import collectables.Collectable;
import collectables.CollectableID;
import collectables.Money;

public class HeroesMap extends Collectable {

	private City city;


	public HeroesMap(CollectableID collectableID) {
		super(collectableID);
		setCost(new Money(20));
	}
	

	public void apply(HeroesSquad heroSquad) {
		heroSquad.setHaveMap(true);
	}

	public void apply(Hero hero) {		
	}
	
	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}
	
	
	public String toString() {
		return "This is a map of the current city you are in, "
				+ "you can buy it at the shop and use it ONLY inside your HomeBase";
	}
	

}
