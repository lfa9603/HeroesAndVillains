package city.buildings.shop;

import java.util.InputMismatchException;
import java.util.Scanner;

import characters.Hero;
import characters.HeroesSquad;

import city.buildings.Building;
import city.buildings.TypeBuildings;

import collectables.Collectable;
import collectables.CollectableID;
import collectables.Money;
import collectables.healingItem.HealingItem;
import collectables.heroesMap.HeroesMap;
import collectables.powerUp.Armor;
import collectables.powerUp.GameChooser;
import collectables.powerUp.IncreaseMaxLife;

public class Shop extends Building{

	private Merchandise merchandise;
	
	public Shop(String name, TypeBuildings buildType, Merchandise merchand) {
		super(name, buildType);
		merchandise = merchand;
	}	
	
	
	

	public void interact(HeroesSquad heroesSquad) {
		System.out.println("(Seller, guess can be created as an NPC or just in game element) "
				+ "\nHey mate! What can I get ya");
		boolean inShop = true;
		while (inShop) {
			Scanner input = new Scanner(System.in);
			Scanner confirmation = new Scanner(System.in);
			
			System.out.println("Current Available items:");
			System.out.println(merchandise.getInventory());
			System.out.println("HEROES WALLET:    " + heroesSquad.getWallet());
			System.out.println("Type:\n"
					+ " 0 buy a map\n"
					+ " 1 to buy a Healing Potion\n"
					+ " 2 to buy a powerUp\n"
					+ " 3 to get outta here!");
			try {
				Integer valueTyped = input.nextInt();
				
				switch(valueTyped) {
			
				case 0:
					buyMap(heroesSquad, confirmation);//TODO modify this method					
					break;
				
				case 1:
					buyHealingPotion(heroesSquad, confirmation);
					break;
				
				case 2:
					buyPowerUp(heroesSquad, confirmation);
					break;
				
				case 3:
					input.close();
					confirmation.close();
					inShop = false;
					System.out.println("Come back soon!");
					break;
				} 
			} catch (InputMismatchException e) {
				System.out.println("Please press a key corresponding to one of the three options");
			} finally {
				input.reset();
			}
		}
	}	


	private void buyMap(HeroesSquad heros, Scanner confirm) {
		
		boolean notSure = true;
		
		while (notSure) {
			System.out.println("Nearly Done! Press Y to confirm your HeroesMap purchase "
					+ "or N to go back to general menu");
			try {
				String confirmed = confirm.next().toLowerCase();
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
					throw (new InputMismatchException());
				}
			} catch (InputMismatchException e) {
				System.out.println("Please press a key corresponding to one of the two options");
			} finally {
				confirm.reset();
			}
		}
	}
	
	
	
	private void buyHealingPotion(HeroesSquad heros, Scanner confirm) {
		boolean inHealingItemSession = true;
		while (inHealingItemSession) {
			System.out.println("Select: "
					+ "\n  0 for a GoodHealingItem"
					+ "\n  1 for a BetterHealingItem"
					+ "\n  2 for a BestHealingItem"
					+ "\n  3 to exit");
			try {
				Integer confirmed = confirm.nextInt();
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
						throw new InputMismatchException();
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Please press a key corresponding to one of the two options");
			} finally {
				confirm.reset();
			}
		}
	}
	
	private void buyPowerUp(HeroesSquad heros, Scanner confirm) {
		boolean inPowerUpSession = true;
		while (inPowerUpSession) {
			System.out.println("Select: "
					+ "\n  0 for am Armor"
					+ "\n  1 for a ExtraLife"
					+ "\n  2 for a GameChooser"
					+ "\n  3 to exit");
			try {
				Integer confirmed = confirm.nextInt();
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
						throw new InputMismatchException();
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Please press a key corresponding to one of the two options");
			} finally {
				confirm.reset();
			}
		}
	}
	
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
	 * @return the merchandise
	 */
	public Merchandise getMerchandise() {
		return merchandise;
	}




	/**
	 * @param merchandise the merchandise to set
	 */
	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}

	
	public static void main(String[] args) {
		HeroesSquad heroesSquad = new HeroesSquad();
		heroesSquad.addHero(new Hero("Lorenzo", "C","c"));
		heroesSquad.setWallet(new Money(1000000));
		Shop shop = new Shop("Shop", TypeBuildings.Shop, new Merchandise());
		shop.interact(heroesSquad);
	}

	
	
	

}
