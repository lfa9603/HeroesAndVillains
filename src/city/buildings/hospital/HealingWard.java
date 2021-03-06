package city.buildings.hospital;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import characters.Abilities;
import characters.Hero;
import characters.Types;
import collectables.CollectableID;
import collectables.healingItem.HealingItem;
import engine.Icons;

import engine.VisualUtilities;

/**
 * 
 * HealingWard is treated as a sector of the Hospital, this class helps show the status of each Hero object after applying a HealingItem. 
 * This is achieved starting a timer that keeps track of the Hero health and of the remaining time before the HealingItem effect has completed on the Hero.
 * In order to keep the process smooth, the use of a very basic multi-threading programming implementation was chosen.  
 * 
 */
public class HealingWard implements java.io.Serializable{

	
	private static final long serialVersionUID = -5681478820425195894L;
	/**
	 * 
	 * This property contains the Hero objects that are under HealingItem cure (key) 
	 * and an integer that corresponds to the HP the Hero will recover during time (value),
	 * from this value is easily possible to compute the time remaining to the Hero to complete the healing process. 
	 * 
	 */
	private HashMap<Hero, Integer> patientsAndHealingTime;
	
	
	public HealingWard() {
		patientsAndHealingTime = new HashMap<Hero, Integer>();
	}
	
	/**
	 * 
	 * @param healingItem (HealingItem object)
	 * @param hero (Hero object)
	 * 
	 * This method checks the current Hero currentHealth with respect to its maxHealth if the HealingItem HPRecoverable 
	 * is lower or equal to the difference between maxHealth and currentHealth then the hero will recover all the HealingItem recoverable HP, 
	 * otherwise it recovers just enough to gain maxHealth.
	 *  
	 * Once the Hero is added to @param patientsAndHealingTime the helper method @startCountDownAndTimeUpdate(...) 
	 * is started on a different thread to keep regularly updating the Integer value related to each Hero key to 
	 * reflect the missing time to full HealingItem effect.
	 * 
	 */
	public void addPatientAndUpdateHealingTime(HealingItem healingItem, Hero hero) {
		Integer heroMissingHP = hero.getMaxHealth() - hero.getHealth();
		if (heroMissingHP < healingItem.getRecoverableHP()) {
			patientsAndHealingTime.put(hero, heroMissingHP);

		} else {
			patientsAndHealingTime.put(hero, healingItem.getRecoverableHP());
		}
		new Thread( new Runnable() {
			public void run() {
				startCountDownAndTimeUpdate(hero);
			}
		}).start();
	}
	
	
	/**
	 * 
	 * @param hero (Hero object)
	 * 
	 * This method is used to keep updating the value of the passed @param hero in the HashMap object patientsAndHealingTime.
	 * This is done regularly with a period of 3600 ms. Once the Integer value corresponding to the Hero object key is equal to 0,
	 * the entry is automatically removed from patientsAndHealingTime.
	 * 
	 */
	private void startCountDownAndTimeUpdate(Hero hero) {
		Integer currentRecoveryTime = patientsAndHealingTime.get(hero);

		while (hero.getHealth() < hero.getMaxHealth() && currentRecoveryTime > 0) {
			Integer newRecoveryTime = currentRecoveryTime - 1;
			patientsAndHealingTime.replace(hero
					, currentRecoveryTime
					, newRecoveryTime);
			currentRecoveryTime--;
			try {
				Thread.sleep(3600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		patientsAndHealingTime.remove(hero);
	}
	
	/**
	 * Overridden toString() method.
	 * @return The Hero objects names in patientsAndHealingTime and the corresponding Integer value converted to seconds.
	 */
	@Override
	public String toString() {
		HashMap<Hero, Integer> copyPatientsAndHealingTime = (HashMap<Hero, Integer>) patientsAndHealingTime.clone();
		if (!copyPatientsAndHealingTime.isEmpty()) {
			Iterator<Map.Entry<Hero, Integer>> entries = copyPatientsAndHealingTime.entrySet().iterator();
			String string = new String();
//			string += "\n" + VisualUtilities.getIcon(Icons.bar) + "\n";
//			string += "HEALING WARD\n";
			
			while (entries.hasNext()) {
			    Map.Entry<Hero, Integer> entry = entries.next();
			    
			    int currentSecondsLeft = (int) (entry.getValue() * 3.6);
			    
			    string += "\nThe hero " + entry.getKey().getCharacterName() 
			    		+ " is going to be dismissed in " + currentSecondsLeft + " seconds.";
			    string += "\nTheir current health is " + entry.getKey().getHealth();
			   
			}
			
//			string += "\n" + VisualUtilities.getIcon(Icons.bar) + "\n";
			return string;
		} else {
			return "You currently have no hero in the healing ward!";
		}
	}
	
	/**
	 * 
	 * Takes a @Collectable object and checks if the @inventory already has the same type of item in it. 
	 * This is achieved by comparing the CollectableID of the @param item and of each Collectable item in the inventory property.
	 * @param item
	 * @return the Collectable object if the item is in the inventory property or @null if the item is not in it.
	 * 
	 */
	public boolean isInHealingWard(Hero hero) {
		
		HashMap<Hero, Integer> copyPatientsAndHealingTime = (HashMap<Hero, Integer>) patientsAndHealingTime.clone();
		
		Iterator<Entry<Hero, Integer>> iterator = copyPatientsAndHealingTime.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Hero, Integer> collectable = (Entry<Hero, Integer>) iterator.next();
			if ((collectable.getKey().getCharacterName()).equals(hero.getCharacterName())) {
				return true;
			}
		}
		return false;
	}
	
	

	
	
}
