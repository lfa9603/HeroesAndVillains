package city.buildings.shop;

import java.util.InputMismatchException;
import java.util.Scanner;

import characters.Abilities;
import characters.Hero;
//import characters.Abilities;
//import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
//import characters.Types;
import city.buildings.Building;
import city.buildings.TypeBuildings;

import collectables.Collectable;
import collectables.CollectableID;
import collectables.Inventory;
import collectables.Money;
//import collectables.Money;
import collectables.healingItem.HealingItem;
import collectables.heroesMap.HeroesMap;
import collectables.powerUp.Armor;
import collectables.powerUp.GameChooser;
import collectables.powerUp.IncreaseMaxLife;

import static engine.HelperScanner.*;


/**
 * 
 * @author LorenzoFasano
 * This class extends Building.java and, therefore it has to implement interact(HeroesSquad heroSquad).
 * 
 * This class allows the HeroesSquad object to purchase any Collectable object needed. If the HeroesSquad object does 
 * not have enough to purchase the item, the Shop will not allow you to purchase it, if your HeroesSquad object already
 * has a map of the City object it will suggest you not to buy the HeroesMap object again.
 *
 * This class uses Merchandise.java as an helper class to store a random amount (between 0 and 2) of each Collectable object present in the game. 
 * 
 */
/**
 * @author LorenzoFasano
 *
 */
public class Shop extends Building{

	private Merchandise merchandise;
	
	/**
	 * 
	 * @param name (type String)
	 * @param buildType (type TypeBuildings)
	 * 
	 * The Shop constructor uses Building.java constructor, it also
	 * instantiate the merchandise property to a new Merchandise object.
	 * 
	 */
	public Shop(String name, TypeBuildings buildType) {
		super(name, buildType);
		merchandise = new Merchandise();
	}	
	
	
	

	/**
	 * 
	 * Method to implement as Shop.java extends Building.java.
	 * 
	 * In this method the HeroesSquad can buy any Collectable object, given that its quantity in the merchandise property is not 0.
	 * If the HeroesSquad object cannot afford to buy a Collectable object then it will not be allowed to, 
	 * and if it wants to buy a HeroesMap and it already has a HeroesMap object for that level it will suggest you not to buy it again.
	 * 
	 * Uses buyMap(HeroesSquad heros, Scanner confirm), buyHealingPotion(HeroesSquad heros, Scanner confirm), buyPowerUp(HeroesSquad heros, Scanner confirm)
	 * and confirmPurchase(HeroesSquad heroSquad, Collectable collectable) as helper methods.
	 */
	public void interact(HeroesSquad heroesSquad) {
		System.out.println("(Seller, guess can be created as an NPC or just in game element) "
				+ "\nHey mate! What can I get ya");
		boolean inShop = true;
		while (inShop) {
//			Scanner input = new Scanner(System.in);
//			Scanner confirmation = new Scanner(System.in);
			
			System.out.println("Current Available items:");
			System.out.println(merchandise.getInventory().toString());
			System.out.println("HEROES WALLET:    " + heroesSquad.getWallet());
			System.out.println("Type:\n"
					+ " 0 buy a map\n"
					+ " 1 to buy a Healing Potion\n"
					+ " 2 to buy a powerUp\n"
					+ " 3 to get outta here!");
			try {
				Integer valueTyped = nextInt();
				
				switch(valueTyped) {
			
				case 0:
					buyMap(heroesSquad);				
					break;
				
				case 1:
					buyHealingPotion(heroesSquad);
					break;
				
				case 2:
					buyPowerUp(heroesSquad);
					break;
				
				case 3:
//					input.close();
//					confirmation.close();
					inShop = false;
					System.out.println("Come back soon!");
					break;
				default:
					System.out.println("Please press a key corresponding to one of the three options");
					break;
				} 
			} catch (InputMismatchException e) {
				System.out.println("Please press a key corresponding to one of the three options");
				next();
				
			} finally {
				reset();
			}
		}
	}	


	/**
	 * 
	 * @param heros (type HeroesSquad)
	 * @param confirm (type Scanner)
	 * 
	 * It deals with the purchase of a HeroesMap object.
	 * If @param heros does not already own a map of the level and it has enough money in its wallet property, the purchase will happen.
	 * If the @param heros does not have enough money to buy it or it already has a map of the current city, the purchase will not happen.
	 * 
	 */
	private void buyMap(HeroesSquad heros) {
		
		boolean notSure = true;
		
		while (notSure) {
			System.out.println("Nearly Done! Press Y to confirm your HeroesMap purchase "
					+ "or N to go back to general menu");
			try {
				String confirmed = next().toLowerCase();
				if (confirmed.equals("y")) {
					HeroesMap map = new HeroesMap(CollectableID.HeroesMap);
	
					if (!heros.isHaveMap()) {
						if (heros.getWallet().minus(map.getCost())) {
							map.apply(heros);
							System.out.println("Congrats now you have a map of the city!!");
						} else {
							System.out.println("Not enough money for the purchase");
						}
						notSure = false;
					}
					
					else {
						System.out.println("Your team already has a map for this level!"
								+ " Don't waste your money!");
					}
					
				}
				if (confirmed.equals("n")) {
					notSure = false;
				}
				 
				if (!confirmed.equals("n") && !confirmed.equals("y")) {
					System.out.println("Please press a key corresponding to one of the two options");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Please press a key corresponding to one of the two options");
				next();
				
			} finally {
				reset();
			}
		}
	}
	
	
	/**
	 * 
	 * @param heros (type HeroesSquad)
	 * @param confirm (type Scanner)
	 * 
	 * It deals with the purchase of HealingItem objects.
	 * If @param heros does not have enough to purchase the item or the item is not present
	 * the purchase will not be allowed. 
	 * Uses confirmPurchase(HeroesSquad heroSquad, Collectable collectable) as helper method.
	 * 
	 */
	private void buyHealingPotion(HeroesSquad heros) {
		boolean inHealingItemSession = true;
		while (inHealingItemSession) {
			System.out.println("Select: "
					+ "\n  0 for a GoodHealingItem"
					+ "\n  1 for a BetterHealingItem"
					+ "\n  2 for a BestHealingItem"
					+ "\n  3 to exit");
			try {
				Integer confirmed = nextInt();
				switch (confirmed) {
					case 0:
						confirmPurchase(heros, new HealingItem(CollectableID.GoodHealingItem));
						break;
					case 1:
						confirmPurchase(heros, new HealingItem(CollectableID.BetterHealingItem));
						break;
					case 2:
						confirmPurchase(heros, new HealingItem(CollectableID.BestHealingItem));
						break;
					case 3:
						System.out.println("Thanks!");
						inHealingItemSession = false;
						break;
					default:
						System.out.println("Press a valid integer!");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Please press a key corresponding to one of the two options");
				next();
				
			} finally {
				reset();
			}
		}
	}
	
	/**
	 * 
	 * @param heros (type HeroesSquad)
	 * @param confirm (type Scanner)
	 * 
	 * It deals with the purchase of PowerUp objects.
	 * If @param heros does not have enough to purchase the item or the item is not present
	 * the purchase will not be allowed. 
	 * Uses confirmPurchase(HeroesSquad heroSquad, Collectable collectable) as helper method.
	 * 
	 */
	private void buyPowerUp(HeroesSquad heros) {
		boolean inPowerUpSession = true;
		while (inPowerUpSession) {
			System.out.println("Select: "
					+ "\n  0 for am Armor"
					+ "\n  1 for a ExtraLife"
					+ "\n  2 for a GameChooser"
					+ "\n  3 to exit");
			try {
				Integer confirmed = nextInt();
				switch (confirmed) {
					case 0:
						confirmPurchase(heros, new Armor(CollectableID.Armor));
						break;
					case 1:
						confirmPurchase(heros, new IncreaseMaxLife(CollectableID.IncreaseMaxLife));
						break;
					case 2:
						confirmPurchase(heros, new GameChooser(CollectableID.GameChooser));
						break;
					case 3:
						System.out.println("Thanks!");
						inPowerUpSession = false;
						break;
					default:
						System.out.println("Press a valid integer!");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Please press a key corresponding to one of the two options");
				next();
				
			} finally {
				reset();
			}
		}
	}
	
	/**
	 * 
	 * @param heroSquad (type HeroesSquad)
	 * @param collectable (type Collectable)
	 * 
	 * Helper method for buyPowerUp(HeroesSquad heros, Scanner confirm) and 
	 * buyHealingPotion(HeroesSquad heros, Scanner confirm).
	 * It makes sure the merchandise property has the selected item in it.
	 * If the item is in the inventory and if the @param heros has enough money, 
	 * the @param collectable is added to the heros backpack property. 
	 * 
	 */
	private void confirmPurchase(HeroesSquad heroSquad, Collectable collectable) {
		if (merchandise.getInventory().isInInventory(collectable) != null) {
			if ((heroSquad.getWallet()).minus(collectable.getCost())) {
				heroSquad.getBackPack().addItemToInventory(collectable); 
				merchandise.getInventory().removeItemFromInventory(collectable);
				System.out.println("Great! You bought a " + collectable.getCollectableID());
			} else {
				System.out.println("Sorry not enough money to purchase this item");
				System.out.println("You currently have " + heroSquad.getWallet());
				System.out.println("You need " + collectable.getCost() 
				+ " to purchase a " + collectable.getCollectableID() + " item");
			}
		}
		else {
			System.out.println("Sorry guys we have no " + collectable.getCollectableID());

		}
	}


	/**
	 * 
	 * Getter method for merchandise property.
	 * @return the merchandise (type Merchandise)
	 * 
	 */
	public Merchandise getMerchandise() {
		return merchandise;
	}


	/**
	 * 
	 * Setter method for merchandise property.
	 * @param merchandise (type Merchandise)
	 * 
	 */
	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}

	
//	public static void main(String[] args) {
//		HeroesSquad heroesSquad = new HeroesSquad();
//		heroesSquad.addHero(new Hero("Lorenzo", Types.dog, Abilities.betterOdds));
//		heroesSquad.setWallet(new Money(1000000));
//		Shop shop = new Shop("Shop", TypeBuildings.Shop);
//		shop.getMerchandise().setInventory(new Inventory());
//		shop.interact(heroesSquad);
//	}

	
	
	

}
