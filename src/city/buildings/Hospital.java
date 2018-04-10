package city.buildings;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import characters.Hero;
import characters.HeroesSquad;
import collectables.Collectable;
import collectables.CollectableID;
import collectables.Inventory;
import collectables.InventoryTools;
import collectables.healingItem.HealingItem;

public class Hospital extends Building {

	public Hospital(String name, TypeBuildings buildType) {
		super(name, buildType);
	}

	@Override
	public void interact(HeroesSquad heroesSquad) {

		boolean atHospital = true;
		while (atHospital) {
			ArrayList<Collectable> healingItems = InventoryTools.healingItems(heroesSquad);
			System.out.println(InventoryTools.showTypeItemsInInventory(heroesSquad, healingItems));
//			Returns the number of heroes that are healing and how long it will be before potion has finished healing hero
//			System.out.println(HospitalTools.getHeroesAndHealingTime());TODO: hard stuff, gotta find a smart way to do it
			Scanner input = new Scanner(System.in);
			if (InventoryTools.getTotTypeItems(heroesSquad, healingItems) > 0) {
				
				
				System.out.println("Press: "
						+ "\n0 to use a good healing item"
						+ "\n1 to use a better healing item"
						+ "\n2 to use a best healing item"
						+ "\n3 to exit"
						+ "\n\nCAUTION! YOU CANNOT USE AN ITEM IF YOU DO NOT OWN IT "
						+ "DON'T TRY TO BE CHEECKY ;) ");
				try {
					Integer intInput = input.nextInt();
					HealingItem healingItem = null; 
					switch (intInput) {
					 	case 0:
					 		healingItem = new HealingItem(CollectableID.GoodHealingItem);
					 		break;
					 	case 1:
					 		healingItem = new HealingItem(CollectableID.BetterHealingItem);
					 		break;
					 	case 2:
					 		healingItem = new HealingItem(CollectableID.BestHealingItem);
					 		break;
					 	case 3:
					 		input.close();
					 		atHospital = false;
					 	default:
					 		throw new InputMismatchException();
//					 Hero heroToRecover = selectHero();TODO:ask jay if he has something I can use;
//					 healingItem.apply(hero);
						 	
						 	
					 		
					 		
						
					}
					
				} catch (InputMismatchException e) {
					System.out.println("Please type a valid integer");
				} finally {
					input.reset();
				}
				
			} else {
				notEnoughMoney(input);
				input.close();
				atHospital = false;
			}	
		}
	}
	
	
	private void notEnoughMoney(Scanner input) {
		boolean deciding = true;
		while (deciding) {
			System.out.println("Looks like you have no Healing items in the backpack! "
					+ "\nPress 0 for exiting the game");
			try {
				Integer exiting = input.nextInt();
				if (exiting.equals(0)) {
					deciding = false;
					input.close();
					System.out.println("Come back later, maybe after a visit to the shop!!");
				} 
			} catch (InputMismatchException e) {
					System.out.println("Please press 0, to exit.");
			} finally {
				input.reset();
			}
		}
	}
	


	public static void main(String[] args) {
		Hospital hospital = new Hospital("Ciao", TypeBuildings.Hospital);
		HeroesSquad heroes = new HeroesSquad();
	
		
		hospital.interact(heroes);
		
		
	}

}
