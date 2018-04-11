package collectables.heroesMap;

import characters.Hero;
import characters.HeroesSquad;
import city.City;
import collectables.Collectable;
import collectables.CollectableID;
import collectables.Money;

public class HeroesMap implements Collectable {

	private Money cost;
	private CollectableID collectableID;
	private City city;


	public HeroesMap(CollectableID collectId) {
		collectableID = collectId;
		cost = new Money(20);
	}
	
	/**
	 * @return the currentCity
	 */

	/**
	 * @param currentCity the currentCity to set
	 */


	/**
	 * @param cost the cost to set
	 */
	public void setCost(Money cost) {
		this.cost = cost;
	}
	
	public Money getCost() {
		return cost;
	}
	public void apply(HeroesSquad heroSquad) {
		heroSquad.setHaveMap(true);
	}

	public void apply(Hero hero) {
		// TODO Auto-generated method stub
		
	}

	public CollectableID getCollectableID() {
		// TODO Auto-generated method stub
		return collectableID;
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
