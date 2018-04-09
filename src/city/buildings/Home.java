package city.buildings;

import java.util.InputMismatchException;
import java.util.Scanner;

import characters.Character;
import characters.Hero;
import characters.HeroesSquad;
import city.City;
import collectables.CollectableID;
import collectables.heroesMap.HeroesMap;

public class Home extends Building {

		
	public Home(String name, TypeBuildings buildType) {
		super(name, buildType);		
	}	
		
	public void interact(HeroesSquad heroesSquad) {
		
		boolean atHome = true;
		System.out.println("Welcome in your Home Base!");
		while (atHome) {
			Scanner input = new Scanner(System.in);
			System.out.println("Type:\n"
					+ " 0 to see the map\n"
					+ " 1 to check the heroes status\n"
					+ " 2 to exit\n");
			try {
				Integer valueTyped = input.nextInt();
			
				switch(valueTyped) {
				case 0:
					showMap(heroesSquad);//TODO modify this method
					break;
				case 1:
					showHeroesStatus(heroesSquad);
					break;
				case 2:
					input.close();
					atHome = false;
					System.out.println("Come back soon");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please press a key corresponding to one of the three options");
			} finally {
				input.reset();
			}
		}
	}
	
	//THIS ONE NEEDS TO MODIFY
	public String showMap(HeroesSquad heroesSquad) {
		String showMapMessage = new String();
		if (heroesSquad.isHaveMap()) {
			HeroesMap map = new HeroesMap(CollectableID.HeroesMap);
			System.out.println(heroesSquad.getCurrentCity());
			showMapMessage += map.toString();
		} else {
			System.out.println("No map available at this stage");
			showMapMessage += "No map available at this stage";
		}
		return showMapMessage;
	}

	
	public String showHeroesStatus(HeroesSquad heroSquad) {
		String heroesDescription = new String();
		for (Character character : heroSquad.getHeroSquad()) {
			heroesDescription += character.toString() + "\n";
		}
		System.out.println(heroesDescription);
		return heroesDescription;
	}


	
	public static void main(String[] args) {
		HeroesSquad heros = new HeroesSquad();
		heros.addHero(new Hero("Lorenzo", "c", "C"));
		heros.setCurrentCity(new City());
		heros.setHaveMap(true);
		Home home = new Home("Home", TypeBuildings.Home);
		home.interact(heros);
	
	}


}
