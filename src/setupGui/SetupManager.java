/**
 * 
 */
package setupGui;


import java.util.ArrayList;

import GUIPOC.SetupAddHeros;
import GUIPOC.setupTeamAndWorld;
import characters.Abilities;
import characters.HeroTypes;
import characters.HeroesSquad;
import characters.Types;
import city.City;

/**
 * @author JayHamilton
 *
 */
public class SetupManager {
	private final String characterTypes = "1. Talkitive : Has the ability to Charm people \n"
			+ "    (Gets 25% better prices at shops) \n"
			+ "2. Smart : Mystery Ability, which could help or hinder \n"
			+ "    your team (Minigame dependant) \n"
			+ "3. Practical : Gets better odds at rock, paper Scissors \n"
			+ "4. Strong : Takes 30% less damage \n"
			+ "5. Sly : Wins all match draws unless the Villain \n"
			+ "    has this abilty \n"
			+ "6. Dog : Is a good boy (Grants all team member\n"
			+ "    extra 25HP Max Health)";
//	private HeroesSquad squad = new HeroesSquad();
//	private ArrayList<City> world = new ArrayList<City>();
	private HeroesSquad squad;
	private ArrayList<City> world;
	
	

//Obserlette
	
	public SetupManager() {
//		super();
		squad = new HeroesSquad();
		world = new ArrayList<City>();
		launchSetupTeamAndWorld();
	}
	
	public void launchSetupTeamAndWorld() {
		setupTeamAndWorld setupWindow = new setupTeamAndWorld(this);
	}
	
	public void closeSetupTeamAndWorld(setupTeamAndWorld setupTeamAndWorld) {
		setupTeamAndWorld.closeWindow();
		launchsetupAddHeros(this);
		
	}
	
	public void launchsetupAddHeros(SetupManager setupManager) {
		SetupAddHeros setupWindow = new SetupAddHeros(this);
	}
	
	public void closeSetupAddHeros(SetupAddHeros setupWindow) {
		setupWindow.closeWindow();
		launchSetupTeamAndWorld();
		
	}
	
	public void finalcloseSetupAddHeros(SetupAddHeros setupWindow) {
		setupWindow.closeWindow();
	}

	
//	public static void main(String[] args) {
//		SetupManager manager = new SetupManager();
////		manager.launchSetupTeamAndWorld();
//	}

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
	 * @return the characterTypes
	 */
	public String getCharacterTypes() {
		return characterTypes;
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

	public Types typeConversion (HeroTypes heroType) {
		switch (heroType) {
		case Talkitive: return Types.talkitive;
		case Smart: return Types.smart;
		case Practical: return Types.practical;
		case Strong: return Types.strong;
		case Sly: return Types.sly;
		case Dog: return Types.dog;
		}
		
		return null;
		
	}
	
	public Abilities getHeroAbility (Types heroType) {
		switch (heroType) {
		case talkitive: return Abilities.charm;
		case smart: return Abilities.mystery;
		case practical: return Abilities.betterOdds;
		case strong: return Abilities.lessDamage;
		case sly: return Abilities.winDraws;
		case dog: return Abilities.goodBoy;
		default:
			break;
		}
		
		return null;
		
	}

}
