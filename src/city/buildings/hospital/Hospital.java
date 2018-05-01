package city.buildings.hospital;

import java.util.ArrayList;
import java.util.InputMismatchException;

import characters.Abilities;
import characters.Hero;
import characters.HeroesSquad;
import characters.Types;
import city.buildings.Building;
import city.buildings.TypeBuildings;

import collectables.Collectable;
import collectables.CollectableID;
import collectables.InventoryTools;
import collectables.healingItem.HealingItem;

import engine.Utilities;
import static engine.HelperScanner.*;

/**
 * 
 * @author LorenzoFasano
 * This class extends Building and, therefore it has to implement interact(HeroesSquad heroSquad).
 * This class allows the HeroesSquad object to use the HealingItem objects they accumulated in the backpack property. 
 * It also allows the HeroesSquad to see the quantities of the HealingItems in the backpack and all the Hero objects that are under 
 * recover after having applied a HealingItem using a HealingWard object ( @see HealingWard.java at city/buildings/hospital/HealingWard.java ).
 * 
 * 
 */
public class Hospital extends Building {

	private HealingWard healingWard;
	
	/**
	 * 
	 * @param name (type String)
	 * @param buildType (type TypeBuilidngs which is set to Hospital for Hospital objects)
	 * The Hospital constructor also instantiates a HealingWorld object healingWard.
	 */
	public Hospital(String name, TypeBuildings buildType) {
		super(name, buildType);
		healingWard = new HealingWard();
	}

	/**
	 * 
	 * Method to implement as Hospital extends Builidng.java.
	 * This method shows the Hero objects that are recovering after applying a HealingItem to it 
	 * ( @see HealingWard.java at city/buildings/hospital/HealingWard.java ).
	 * 
	 * It also allows the player to select a HealingItem object present in the HeroesSquad object 
	 * backpack property and apply it to one of the alive Hero objects,
	 * if the player wants to use an item which the HeroesSquad object does not have, 
	 * the player will not be allowed to use the selected HealingItem object.
	 * 
	 */
	@Override
	public void interact(HeroesSquad heroesSquad) {
		Integer intInput = -1;

		boolean atHospital = true;
		while (atHospital) {
			System.out.println(healingWard.toString());//TODO:THERE IS A PROBLEM HERE WHEN RUNNING THE GIVEN C0NFIGURATION
			
			ArrayList<Collectable> healingItems = InventoryTools.healingItems();
			
			System.out.println("You are inside the hospital, here is you available Healing potions:\n");
			System.out.println(InventoryTools.showTypeItemsInInventory(heroesSquad, healingItems));
//			Returns the number of heroes that are healing and how long it will be before potion has finished healing hero
//			System.out.println(HospitalTools.getHeroesAndHealingTime());TODO: hard stuff, gotta find a smart way to do it
//			Scanner input = new Scanner(System.in);
//			Integer input = nextInt();
			if (InventoryTools.getTotTypeItems(heroesSquad, healingItems) > 0) {
				
				System.out.println("Press: "
						+ "\n0 to use a good healing item"
						+ "\n1 to use a better healing item"
						+ "\n2 to use a best healing item"
						+ "\n3 to exit"
						+ "\n\nCAUTION! YOU CANNOT USE AN ITEM IF YOU DO NOT OWN IT "
						+ "DON'T TRY TO BE CHEECKY ;) ");
				try {
//					Integer intInput = input.nextInt();
					intInput = nextInt();
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
//					input.reset();
					reset();
				}
				
			} 
			else {
				noHealingItems(intInput);
//				input.close();
				atHospital = false;
			}	
		}
	}

	/**
	 * Helper method for good coding practice created to throw a new InputMismatchError.
	 */
	private void extracted() {
		throw new InputMismatchException(); 
	}
	
	
	/**
	 * 
	 * @param input (type Scanner)
	 * 
	 * Helper method for interact(HeroesSquad heroesSquad), it is 
	 * called if the HeroesSquad object has no HealingItem objects in their backpack property.
	 * 
	/**
	 * @param input
	 */
	private void noHealingItems(Integer input) {
		boolean deciding = true;
		while (deciding) {
			System.out.println("Looks like you have no Healing items in the backpack! "
					+ "\nPress 0 for exiting the game");
			try {
				String exiting = next();
				if (exiting.equals("0")) {//TODO:Check all nextInt() readings and possibly convert them to next or nextLine because nextInt is shit
					deciding = false;
//					input.close();
					System.out.println("Come back later, maybe after a visit to the shop!!");
				} else {
					System.out.println("Please press 0, to exit.");
				}
			} catch (InputMismatchException e) {
					System.out.println("Please press 0, to exit.");
					reset();
					
			} finally {
				reset();
			}
		}
	}
	


<<<<<<< HEAD
<<<<<<< HEAD
	public static void main(String[] args) {
		Hospital hospital = new Hospital("Ciao", TypeBuildings.Hospital);
		HeroesSquad heroes = new HeroesSquad();
		Hero hero = new Hero("Lorenzo", Types.dog, Abilities.badDay);
		heroes.addHero(hero);

		heroes.getBackPack().addItemToInventory(new HealingItem(CollectableID.BestHealingItem));
		hospital.interact(heroes);
	}
=======
=======
>>>>>>> da9e01f3ce76f02044db755c10a8b55711d62731
//	public static void main(String[] args) {
//		Hospital hospital = new Hospital("Ciao", TypeBuildings.Hospital);
//		HeroesSquad heroes = new HeroesSquad();
//		Hero hero1 = new Hero("Hero1test", Types.dog, Abilities.badDay);
//		hero1.setHealth(98);
//		heroes.addHero(hero1);
// 
//		heroes.getBackPack().addItemToInventory(new HealingItem(CollectableID.BestHealingItem));
//		hospital.interact(heroes);
//	}
<<<<<<< HEAD
>>>>>>> da9e01f3ce76f02044db755c10a8b55711d62731
=======
>>>>>>> da9e01f3ce76f02044db755c10a8b55711d62731

}
