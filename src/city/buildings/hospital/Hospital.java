package city.buildings.hospital;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import characters.Hero;
import characters.HeroesSquad;

import city.buildings.Building;
import city.buildings.TypeBuildings;

import collectables.Collectable;
import collectables.CollectableID;
import collectables.InventoryTools;
import collectables.healingItem.HealingItem;

import engine.Utilities;


public class Hospital extends Building {

	private HealingWard healingWard;
	
	public Hospital(String name, TypeBuildings buildType) {
		super(name, buildType);
		healingWard = new HealingWard();
	}

	@Override
	public void interact(HeroesSquad heroesSquad) {

		boolean atHospital = true;
		while (atHospital) {
			
			System.out.println(healingWard.toString());
			
			ArrayList<Collectable> healingItems = InventoryTools.healingItems(heroesSquad);
			
			System.out.println("You are inside the hospital, here is you available Healing potions:\n");
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
					 		System.out.println("\n\nSee ya later alligator!!!\n\n");
//					 		input.close();
					 		atHospital = false;
					 		continue;
					 	default:
						extracted();
					}
					
					if (heroesSquad.getBackPack().isInInventory(healingItem) != null) {
						System.out.println(heroesSquad);
						int choice = Utilities.getChoice("Choose hero by typing its index value!\n"
								+ "You will apply the selected healing item to this memeber of your team\n"
								+ "Type 0 to exit", 0, heroesSquad.getLength());
						if (choice == 0) {
							continue;
						} else {
							Hero hero = heroesSquad.getHero(choice - 1);	 	
							healingItem.apply(hero);
							heroesSquad.getBackPack().removeItemFromInventory(healingItem);
							healingWard.addPatientAndUpdateHealingTime(healingItem, hero);
						}
					} else {
						System.out.println("MATE! I TOLD YA NOT TO BE CHEECKY! YOU AIN'T GOT NONE OF THAT!");
					}
					 		
				
				} catch (InputMismatchException e) {
					System.out.println("Please type a valid integer\n\n");
				} finally {
					input.reset();
				}
				
			} else {
				noHealingItems(input);
//				input.close();
				atHospital = false;
			}	
		}
	}

	private void extracted() {
		throw new InputMismatchException();
	}
	
	
	private void noHealingItems(Scanner input) {
		boolean deciding = true;
		while (deciding) {
			System.out.println("Looks like you have no Healing items in the backpack! "
					+ "\nPress 0 for exiting the game");
			try {
				Integer exiting = input.nextInt();
				if (exiting.equals(0)) {
					deciding = false;
//					input.close();
					System.out.println("Come back later, maybe after a visit to the shop!!");
				} 
			} catch (InputMismatchException e) {
					System.out.println("Please press 0, to exit.");
			} finally {
				input.reset();
			}
		}
	}
	


//	public static void main(String[] args) {
//		Hospital hospital = new Hospital("Ciao", TypeBuildings.Hospital);
//		HeroesSquad heroes = new HeroesSquad();
//		heroes.addHero(new Hero("Lorenzo", Types.level_1, "C"));
//
//		heroes.getBackPack().addItemToInventory(new HealingItem(CollectableID.BestHealingItem));
//		hospital.interact(heroes);
//	}

}
