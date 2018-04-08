package engine;

import java.util.ArrayList;

import characters.HeroesSquad;
import characters.TeamBuilder;
import city.City;
import city.WorldBuilder;

public class Engine {

	private HeroesSquad heroesSquad;
	private ArrayList<City> world;
	
	public Engine() {
		heroesSquad = createSquad();
		world = createWorld();
		
		
	}
	
	
	private HeroesSquad createSquad() {
		
		TeamBuilder teamBuilder = new TeamBuilder();
		HeroesSquad squad = teamBuilder.getNewTeam();
		return squad;
		
	}
	
	private ArrayList<City> createWorld() {
		WorldBuilder worldBuilder = new WorldBuilder();
		return worldBuilder.getWorld();
	}
	
	public void run() {
		
	}
	
}
