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
	private boolean inCity = true;

	
	public SquadMover(City currentCity, HeroesSquad heroesSquad) {
		squad = heroesSquad;
		city = currentCity;
	}

	public void startMoving() {
		squad.setCurrentPosition(new Point(0, 0));
		
//		boolean inCity = true;
		Scanner moveInput = new Scanner(System.in);
		Scanner askToEnter = new Scanner(System.in);
		
		VisualUtilities.getIcon(Icons.bar);
		System.out.println("Welcome to level: " + (Engine.getCurrentIndex() + 1));
		System.out.println("Press w, a, s or d then enter to move your Team.");
		VisualUtilities.getIcon(Icons.bar);

		while (inCity) {
			try {
				String keyPressed = moveInput.next();
				
				Point squadPosition = squad.getCurrentPosition();
				int xValue = squadPosition.x;
				int yValue = squadPosition.y;
				Point currentPosition = null;
				switch (keyPressed) {
					case ("w"):
						currentPosition = new Point(xValue, yValue + 1);
						break;
					case ("a"):
						currentPosition = new Point(xValue - 1, yValue);
						break;
					case ("s"):
						currentPosition = new Point(xValue, yValue - 1);
						break;
					case ("d"):
						currentPosition = new Point(xValue + 1, yValue);
						break;
					default:
					extracted();	
				}
				if (currentPosition != null && outOfMap(currentPosition)) {
					System.out.println("Ehy Ehy Ehy!! You almost fell out of the map!");
				} else {
					squad.setCurrentPosition(currentPosition);
				}
				System.out.println("The heroes are in position: " + squad.getCurrentPosition());
				Building building = city.returnBuildingAtSpecificCoordinates(squad.getCurrentPosition());
				
				ifEncounteringABuilding(building, squad, askToEnter);
				if (Engine.getCurrentVillain().isBeaten()) {
					inCity = false;
					VisualUtilities.getIcon(Icons.bar);
					System.out.println("Moving to the Next Level");
					VisualUtilities.getIcon(Icons.bar);
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Please press w, a, s or d");
			} finally {
				moveInput.reset();
			}
		}
		
//		moveInput.close();
//		askToEnter.close();
	}
	
	private boolean outOfMap(Point point) {
		if (point.x > 4 || point.x < -4 || point.y > 4 || point.y < -4) {
			return true;
		}
		return false;
	}
	
	
	private void ifEncounteringABuilding(Building building, HeroesSquad squad, Scanner askToEnter) {
		if (building != null) {
			boolean deciding = true;
			while (deciding) {
				
				System.out.println("You are now close to the " + building.getBuildingName() 
				+ ".\nDo you want to enter the building?");
				if (building.getBuildingType().equals(TypeBuildings.VillainsLair)) {
					System.out.println("\n" + Engine.getCurrentVillain() + " lives here/n");
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
	
	
	
//	public static void main(String[] args) {
//		HeroesSquad squad = new HeroesSquad();
//		squad.setHaveMap(true);
//		squad.setWallet(new Money(180));
//		City city = new City();
//		squad.setCurrentCity(city);
//		SquadMover mover = new SquadMover(city, squad);
//		mover.startMoving();
//		
//	}
	
}
