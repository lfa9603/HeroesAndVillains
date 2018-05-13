package engine;

import java.awt.Point;
import java.util.ArrayList;

import GUIPOC.GameWindowManager;
import characters.HeroesSquad;
import characters.TeamBuilder;
import characters.Villain;
import characters.Villains;
import city.City;
import city.WorldBuilder;
import setupGui.SetupManager;

public class Engine_v2 {

	protected static Villains villains;	
	
	
	private TeamBuilder builtTeam;
	private  HeroesSquad squad;
	private static boolean hasTalkitive = false;
	
	private  ArrayList<City> world;
	private static int currentIndex = 0;
	private City currentCity;
	private static boolean guiActive = false;
	
	
	
	public Engine_v2() {
		
//		currentIndex = 0;
		int choice = Utilities.getChoice("Choose 1 for CLI and 2 for GUI", 1, 2);
		if (choice == 1) {
			builtTeam = new TeamBuilder();
			squad = builtTeam.getTeam(); //Gets the squad object from team builder
			
			WorldBuilder worldBuilder = new WorldBuilder();
			world = worldBuilder.getWorld();
		}
		
		else {
			guiActive = true;
			Thread main = Thread.currentThread();
//			SetupManager setup = new SetupManager();
//
//			world = setup.getWorld();
//			squad = setup.getSquad();
			
			GuiThread guiThread = new GuiThread();
			guiThread.start();
			synchronized (guiThread) {
				try {
					System.out.println("Wait till Guithread dies...");
					main.wait();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

			System.out.println("Main Thread active");
			squad = guiThread.getSquad();
			world = guiThread.getWorld();
			
		}
		
		
		villains = new Villains(world.size()); 
//		choosePartsUsingIndex(currentIndex);
	}
	
	private void choosePartsUsingIndex(int index) {
		currentCity = world.get(currentIndex);
		squad.setCurrentCity(currentCity);
	}
	
	public void startTui() {
//		HeroesSquad squad = new TeamBuilder();
		
//		WorldBuilder worldBuilder = new WorldBuilder();
//		ArrayList<City> world = worldBuilder.getWorld();
		
		
//		villains = new Villains(world.size());
		// for random tests
//		getCurrentVillain().setBeaten(true);
		
		
		boolean playingGame = true;
		
		while (playingGame) {
			SquadMover mover = new SquadMover(currentCity, squad);
			mover.startMoving();
			
			if (nextCityExists()) {
				setUpgameForNextCity();
			} else {
		
				for (int i = 0; i < 100; i++) {
					System.out.println("MMMMMMMAAAAAAAAAAAAATEEEEEEEEEEEEEEEEE! YOU WON THE GAME!");
					System.out.println("\n");
					VisualUtilities.getIcon(Icons.youWin);
					
				}
				
				playingGame = false;
			}
		}
		
	}
	
	private void startGui() {
		
		boolean playingGame = true;
			
			while (playingGame) {
//				SquadMover mover = new SquadMover(currentCity, squad);
//				mover.startMoving();
				
				GameWindowManager manager = new GameWindowManager(currentCity, squad);
				manager.launchMainGameScreen();
				
				if (nextCityExists()) {
					setUpgameForNextCity();
				} else {
			
					for (int i = 0; i < 100; i++) {
						System.out.println("MMMMMMMAAAAAAAAAAAAATEEEEEEEEEEEEEEEEE! YOU WON THE GAME!");
						System.out.println("\n");
						VisualUtilities.getIcon(Icons.youWin);
						
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
	
	public static int getCurrentIndex() {
		return currentIndex;
	}
	
	public static Villains getVillains() {
		return villains;
	}
	
	public static Villain getCurrentVillain() {
		return villains.getCurrentVillain(currentIndex);
	}
	
	/**
	 * @return the hasTalkitive
	 */
	public static boolean getHasTalkitive() {
		return hasTalkitive;
	}

	/**
	 * @param hasTalkitive the hasTalkitive to set
	 */
	public static void setHasTalkitive(boolean hasaTalkitive) {
		hasTalkitive = hasaTalkitive;
	}

	public static void main(String[] args) {
//		VisualUtilities.getIcon(Icons.youWin); Just a test of icons
		Engine_v2 engine = new Engine_v2();
		// for random tests
		if (guiActive) {
			engine.startGui();
		}
		else {
			engine.startTui();
		}

	}


	
}