package engine;

import java.awt.Point;
import java.util.InputMismatchException;
import java.util.Scanner;

import characters.HeroesSquad;
import city.City;
import city.buildings.Building;
import city.buildings.TypeBuildings;
import collectables.Money;

public class SquadMover {

	private City city;
	private HeroesSquad squad;
	
	public SquadMover(City currentCity, HeroesSquad heroesSquad) {
		squad = heroesSquad;
		city = currentCity;
	}

	public void startMoving() {
		squad.setCurrentPosition(new Point(0, 0));
		
		boolean inCity = true;
		Scanner moveInput = new Scanner(System.in);
		Scanner askToEnter = new Scanner(System.in);

		while (inCity) {
			try {
				String keyPressed = moveInput.next();
				
				Point squadPosition = squad.getCurrentPosition();
				int xValue = squadPosition.x;
				int yValue = squadPosition.y;
				switch (keyPressed) {
					case ("w"):
						squad.setCurrentPosition(new Point(xValue, yValue + 1));
						break;
					case ("a"):
						squad.setCurrentPosition(new Point(xValue - 1, yValue));
						break;
					case ("s"):
						squad.setCurrentPosition(new Point(xValue, yValue - 1));
						break;
					case ("d"):
						squad.setCurrentPosition(new Point(xValue + 1, yValue));
						break;
					default:
					extracted();	
				}
				System.out.println("The heroes are in potion: " + squad.getCurrentPosition());
				Building building = city.returnBuildingAtSpecificCoordinates(squad.getCurrentPosition());
				
				ifEncounteringABuilding(building, squad, askToEnter);
				
			} catch (InputMismatchException e) {
				System.out.println("Please press w, a, s or d");
			} finally {
				moveInput.reset();
			}
		}
		
//		moveInput.close();
//		askToEnter.close();
	}
	
	
	
	private void ifEncounteringABuilding(Building building, HeroesSquad squad, Scanner askToEnter) {
		if (building != null) {
			boolean deciding = true;
			while (deciding) {
				
				System.out.println("You are now close to the " + building.getBuildingName() 
				+ ".\nDo you want to enter the building?");
				if (building.getBuildingType().equals(TypeBuildings.VillainsLair)) {
					System.out.println("THIS IS AN EXTREMELY DANGEROUS ZONE! CHOOSE CAREFULLY!");
				}
				System.out.println("[Y/N]");
				
				try {
					String entering = askToEnter.next().toLowerCase();
					switch(entering) {
						case ("y"):
							building.interact(squad);
							break;
						case ("n"):
							deciding = false;
							System.out.println("Gonna keep wandering... I see..Not after action I guess");
							break;
						default:
						extracted();
							
					}
				} catch (InputMismatchException e) {
					System.out.println("Please type Y or N...");
				} finally {
					askToEnter.reset();
				}
			}
		}
	}

	private void extracted() {
		throw new InputMismatchException();
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

	/**
	 * @return the squad
	 */
	public HeroesSquad getSquad() {
		return squad;
	}

	/**
	 * @param squad the squad to set
	 */
	public void setSquad(HeroesSquad squad) {
		this.squad = squad;
	}
	
	
	
	public static void main(String[] args) {
		HeroesSquad squad = new HeroesSquad();
		squad.setHaveMap(true);
		squad.setWallet(new Money(180));
		City city = new City();
		squad.setCurrentCity(city);
		SquadMover mover = new SquadMover(city, squad);
		mover.startMoving();
		
	}
	
}
