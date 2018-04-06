package city.buildings;

import java.util.Scanner;

import characters.Character;
import characters.HeroesSquad;
import collectables.heroesMap.HeroesMap;

public class Home extends Building{

	public Home(String name, TypeBuildings buildType) {
		super(name, buildType);
		// TODO Auto-generated constructor stub
	}	
		
	public void interact(HeroesSquad heroesSquad) {
		
//		System.out.println("Welcome in your ");
//		while (atHome) {
//			Scanner input = new Scanner(System.in);
//			System.out.println("Type:\n"
//					+ " 0 to see the map\n"
//					+ " 1 to check the heroes status");
//			Integer valueTyped = input.nextInt();
//			input.close();
//			
//			if (valueTyped.equals(0)) {
//				showMap(heroesSquad);
//			} else {
//				showHeroesStatus(heroesSquad);
//			}
//		}
	}
	
	
//	public String showMap(HeroesSquad heroesSquad) {
//		String showMapMessage = new String();
//		if (heroesSquad.isHaveMap()) {
//			HeroesMap map = heroesSquad.getMap();
//			System.out.println(map.toString());
//			showMapMessage += map.toString();
//		} else {
//			System.out.println("No map available at this stage");
//			showMapMessage += "No map available at this stage";
//		}
//		return showMapMessage;
//	}
//
//	
//	public String showHeroesStatus(HeroesSquad heroSquad) {
//		String heroesDescription = new String();
//		for (Character character : heroSquad.getHeroes()) {
//			heroesDescription += character.toString() + "\n";
//		}
//		System.out.println(heroesDescription);
//		return heroesDescription;
//	}




}
