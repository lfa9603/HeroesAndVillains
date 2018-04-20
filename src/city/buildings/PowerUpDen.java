package city.buildings;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import characters.Hero;
import characters.HeroesSquad;
import collectables.Collectable;
import collectables.CollectableID;
import collectables.InventoryTools;
import collectables.powerUp.Armor;
import collectables.powerUp.GameChooser;
import collectables.powerUp.IncreaseMaxLife;
import collectables.powerUp.PowerUp;
import engine.Utilities;

/**
 * 
 * @author LorenzoFasano
 *PowerUpDen class extends Building, its TypeBuildings type is PowerUpDen and its builidngCoordinates 
 *are always a random value among (4, 0),(-4, 0)(0, 4) or (0, -4) (this last step happens in WorldBuilder class).
 *The method interact is implemented such that it allows the user to use the PowerUp items bought in the Shop.
 *If the team does not own a selected item, it will tell the player that the item is not available to be used.
 */
public class PowerUpDen extends Building {
	

	/**
	 * 
	 * @param name
	 * @param buildType
	 */
	public PowerUpDen(String name, TypeBuildings buildType) {
		super(name, buildType);
	}

	
	/**
	 * Method to implement. It gives the user to see the quantity of each power up the team has in their backpack, 
	 * if no item of a type is owned by the team the quantity displayed is 0.
	 * Once a power up is selected, also the hero to apply the power-up on will be selected. If the team owns at 
	 * least one item of the selected type, the hero wallet will be checked, if the team does not have enough money the transaction will fail, 
	 * if the team has enough money the item will be applied to the selected hero and 1 quantity of the selected power-up will be removed by the team's backpack.
	 * 
	 * The helper method @noPowerUps(...) is used for maintenance and readability purposes.
	 */
	public void interact(HeroesSquad heroesSquad) {
		
		boolean inPowerUpDen = true;
		while (inPowerUpDen) {
			
			ArrayList<Collectable> powerUps = InventoryTools.powerUps();
			
			System.out.println("You are inside the Power-Up Den, here is you available Healing potions:\n");
			System.out.println(InventoryTools.showTypeItemsInInventory(heroesSquad, powerUps));
			
			Scanner input = new Scanner(System.in);
			
			if (InventoryTools.getTotTypeItems(heroesSquad, powerUps) > 0) {
				System.out.println("Press: "
						+ "\n0 to use an Armor"
						+ "\n1 to use a Game Chooser ability"
						+ "\n2 to use a Increase Max Life ability"
						+ "\n3 to exit"
						+ "\n\nCAUTION! YOU CANNOT USE AN ITEM IF YOU DO NOT OWN IT "
						+ "DON'T TRY TO BE CHEECKY ;) ");
				try {
					Integer intInput = input.nextInt();
					PowerUp powerUp = null; 
					
					
					switch (intInput) {
					 	case 0:
					 		powerUp = new Armor(CollectableID.Armor);
					 		break;
					 	case 1:
					 		powerUp = new GameChooser(CollectableID.GameChooser);
					 		break;
					 	case 2:
					 		powerUp = new IncreaseMaxLife(CollectableID.IncreaseMaxLife);
					 		break;
					 	case 3:
					 		System.out.println("\n\nSee ya later alligator!!!\n\n");
//					 		input.close();
					 		inPowerUpDen = false;
					 		continue;
					 	default:
						extracted();
					}
					
					if (heroesSquad.getBackPack().isInInventory(powerUp) != null) {
						System.out.println(heroesSquad);
						int choice = Utilities.getChoice("Choose hero by typing its index value!\n"
								+ "You will apply the selected healing item to this memeber of your team\n"
								+ "Type 0 to exit", 0, heroesSquad.getLength());
						if (choice == 0) {
							continue;
						} else {
							Hero hero = heroesSquad.getHero(choice - 1);	 	
							powerUp.apply(hero);
							heroesSquad.getBackPack().removeItemFromInventory(powerUp);
						}
					} else {
						System.out.println("MATE! I TOLD YA NOT TO BE CHEECKY! YOU AIN'T GOT NONE OF THAT!");
					}
					 		
				
				} catch (InputMismatchException e) {
					System.out.println("Please type a valid integer\n\n");
					input.next();
					
				} finally {
					input.reset();
				}
			} else {
				noPowerUps(input);
//				input.close();
				inPowerUpDen = false;
			}
		}
		
	}
	/**
	 * Method required by Eclipse to follow good coding practice.
	 *TODO: find out why this must be done.
	 */
	private void extracted() {
		throw new InputMismatchException();
	}

	/**
	 * 
	 * @param input
	 * Helper for interact() method, it deals with the case the team has no power-up in their backpack.
	 * If called it suggest the team to visit the Shop.
	 */
	private void noPowerUps(Scanner input) {
		boolean deciding = true;
		while (deciding) {
			System.out.println("Looks like you have no Power-Ups in the backpack! "
					+ "\nPress 0 for exiting the game");
			try {
				Integer exiting = input.nextInt();
				if (exiting.equals(0)) {
					deciding = false;
//					input.close();
					System.out.println("Come back later, maybe after a visit to the shop!!");
				} else {
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
					System.out.println("Please press 0, to exit.");
					input.next();
					
			} finally {
				input.reset();
			}
		}
	}

}
