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

public class PowerUpDen extends Building {
	

	public PowerUpDen(String name, TypeBuildings buildType) {
		super(name, buildType);
	}

	@Override
	public void interact(HeroesSquad heroesSquad) {
		
		boolean inPowerUpDen = true;
		while (inPowerUpDen) {
			
			ArrayList<Collectable> powerUps = InventoryTools.powerUps(heroesSquad);
			
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
					 		input.close();
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
				} finally {
					input.reset();
				}
			} else {
				noPowerUps(input);
				input.close();
				inPowerUpDen = false;
			}
		}
		
	}
	
	private void extracted() {
		throw new InputMismatchException();
	}

	private void noPowerUps(Scanner input) {
		boolean deciding = true;
		while (deciding) {
			System.out.println("Looks like you have no Power-Ups in the backpack! "
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

}
