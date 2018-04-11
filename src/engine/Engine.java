package engine;

import java.awt.Point;
import java.util.ArrayList;

import characters.HeroesSquad;
import characters.TeamBuilder;
import characters.Villain;
import characters.Villains;
import city.City;
import city.WorldBuilder;

public class Engine {

	protected static Villains villains;	
	protected TeamBuilder builtTeam;
	protected HeroesSquad squad;
	
	protected ArrayList<City> world;
	City currentCity; 
	
	protected static int currentIndex;
	
	public static int getCurrentIndex() {
		return currentIndex;
	}
	
	public static Villains getVillains() {
		return villains;
	}
	
	public static Villain getCurrentVillain() {
		return villains.getCurrentVillain(currentIndex);
	}
	
	public Engine() {
		
		currentIndex = 0;
		WorldBuilder worldBuilder = new WorldBuilder();
		world = worldBuilder.getWorld();
		
		builtTeam = new TeamBuilder();
		squad = builtTeam.getTeam(); //Gets the squad object from team builder
		villains = new Villains(world.size()); 
		choosePartsUsingIndex(currentIndex);
		
	}
	
	private void choosePartsUsingIndex(int index) {
		currentCity = world.get(currentIndex);
	}
	
	public void start() {
//		HeroesSquad squad = new TeamBuilder();
		
//		WorldBuilder worldBuilder = new WorldBuilder();
//		ArrayList<City> world = worldBuilder.getWorld();
		
		
		villains = new Villains(world.size());
		// for random tests
		getCurrentVillain().setBeaten(true);
		
		
		boolean playingGame = true;
		
		while (playingGame) {
			SquadMover mover = new SquadMover(currentCity, squad);
			mover.startMoving();
			
			if (nextCityExists()) {
				setUpgameForNextCity();
			} else {
		
				for (int i = 0; i < 100; i++) {
					System.out.println("MMMMMMMAAAAAAAAAAAAATEEEEEEEEEEEEEEEEE! YOU WON THE GAME!");
				}
				
				playingGame = false;
			}
		}
		
	}
	
	private boolean nextCityExists() {
		int cityIndex = world.indexOf(currentCity);
		return cityIndex < (world.size() - 1);
	}
	
	private void setUpgameForNextCity() {
		
		currentIndex = currentIndex + 1;
		choosePartsUsingIndex(currentIndex);
		squad.setHaveMap(false);
		squad.setCurrentPosition(new Point(0, 0));
		squad.setCurrentCity(currentCity);
		
	}
	
	public static void main(String[] args) {
		Engine engine = new Engine();
		// for random tests
		engine.start();
		
		
		
	}
	
}
