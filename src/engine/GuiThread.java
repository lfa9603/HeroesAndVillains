package engine;

import java.util.ArrayList;

import characters.HeroesSquad;
import city.City;
import setupGui.SetupManager;

public class GuiThread extends Thread {
	private  HeroesSquad squad;
	private  ArrayList<City> world;
	
	
	public void run() {
		synchronized (this) {
				SetupManager setup = new SetupManager();

				setWorld(setup.getWorld());
				setSquad(setup.getSquad());

		}
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


	/**
	 * @return the world
	 */
	public ArrayList<City> getWorld() {
		return world;
	}


	/**
	 * @param world the world to set
	 */
	public void setWorld(ArrayList<City> world) {
		this.world = world;
	}

}
