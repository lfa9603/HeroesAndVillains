package collectables.heroesMap;

import characters.Hero;
import characters.HeroesSquad;
import city.City;
import collectables.Collectable;
import collectables.CollectableID;
import collectables.Money;

/**
 * 
 * @author LorenzoFasano
 *This class extends Collectable.java.
 *Differently from the other classes that extend Collectable.java, the apply(Hero hero) 
 *is left empty here and a apply(HeroesSquad heroSquad) is implemented, as the effect of 
 *a HeroesMap object wants to be effective at a higher level (HeroesSquad.java level). 
 *
 */
public class HeroesMap extends Collectable {

	private City city;


	/**
	 * 
	 * @param collectableID (type CollectableID)
	 * The HeroesMap.java constructor. 
	 * It calls Collectable.java constructor and it also set the cost property 
	 * (from Collectable.java) to Money(20), using the dedicated setter method.
	 * 
	 */
	public HeroesMap(CollectableID collectableID) {
		super(collectableID);
		setCost(new Money(20));
	}
	

	/**
	 * 
	 * @param heroSquad (type HeroesSquad)
	 * This method set the haveMap property of @param heroSquad to true; such that the map of the city will now 
	 * be visible when asked to see it in Home.java objects.
	 * 
	 */
	public void apply(HeroesSquad heroSquad) {
		heroSquad.setHaveMap(true);
	}

	/**
	 * 
	 * Method to override as HeroesMap.java extends Collectable.java.
	 * Left blank, never used.
	 * 
	 */
	public void apply(Hero hero) {
		System.out.println("YOU ARE USING THE WRONG METHOD, USE apply(HeroesSquad heroSquad) instead");
	}
	
	/**
	 * 
	 * Getter method for city property.
	 * @return city (type City.java), the city the map has to show.
	 * 
	 */
	public City getCity() {
		return city;
	}

	/**
	 * 
	 * Setter method for city property.
	 * @param city (type City.java)
	 *  
	 */
	public void setCity(City city) {
		this.city = city;
	}
	
	/**
	 * 
	 * Overridden toString() method.
	 * It returns a String object including the description of HeroesMap.java objects and their cost.
	 * 
	 */
	@Override
	public String toString() {
		return "This is a map of the current city you are in, "
				+ "you can buy it at the shop and use it ONLY inside your HomeBase" 
				+ "\nIt costs " + getCost();
	}
	
	
	public String builidngsCoordinatesToString() {
		return city.toString();
	}

}
