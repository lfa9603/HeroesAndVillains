package city.buildings.hospital;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import characters.Abilities;
import characters.Hero;
import characters.Types;
import collectables.CollectableID;
import collectables.healingItem.HealingItem;
import engine.Icons;
import engine.VisualUtilities;

public class HealingWard {

	private HashMap<Hero, Integer> patientsAndHealingTime;
	
	public HealingWard() {
		patientsAndHealingTime = new HashMap<Hero, Integer>();
	}
	
	public void addPatientAndUpdateHealingTime(HealingItem healingItem, Hero hero) {
		Integer heroMissingHP = hero.getMaxHealth() - hero.getHealth();
		if (heroMissingHP < healingItem.getRecoverableHP()) {
			patientsAndHealingTime.put(hero, heroMissingHP);

		} else {
			patientsAndHealingTime.put(hero, healingItem.getRecoverableHP());
		}
		new Thread( new Runnable() {
			public void run() {
				startCountDownAndTimeUpdate(healingItem, hero);
			}
		}).start();
	}
	
	
	private void startCountDownAndTimeUpdate(HealingItem healingItem, Hero hero) {
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
	
	public String toString() {
		if (!patientsAndHealingTime.isEmpty()) {
			Iterator<Map.Entry<Hero, Integer>> entries = patientsAndHealingTime.entrySet().iterator();
			String string = new String();
			string += "\n" + VisualUtilities.getIcon(Icons.bar) + "\n";
			string += "HEALING WARD\n";
			
			while (entries.hasNext()) {
			    Map.Entry<Hero, Integer> entry = entries.next();
			    
			    int currentSecondsLeft = (int) (entry.getValue() * 3.6);
			    
			    string += "\nThe hero " + entry.getKey().getCharacterName() 
			    		+ "is going to be dismissed in " + currentSecondsLeft + " seconds.";
			    string += "\nIts current health is " + entry.getKey().getHealth();
			   
			}
			
			string += "\n" + VisualUtilities.getIcon(Icons.bar) + "\n";
			return string;
		} else {
			return "You currently have no hero in the healing ward!";
		}
	}
	
	
//	public static void main(String[] args) {
//		Hero hero1 = new Hero("Ciao", Types.level_2, Abilities.arrogance);
//		Hero hero2 = new Hero("Bye", Types.level_2, Abilities.badDay);
//		hero1.setHealth(20);
//		hero2.setHealth(30);
//		HealingWard hw = new HealingWard();
//		HealingItem healingItem = new HealingItem(CollectableID.BestHealingItem);
//		healingItem.apply(hero1);
//		healingItem.apply(hero2);
//		hw.addPatientAndUpdateHealingTime(healingItem, hero1);
//		hw.addPatientAndUpdateHealingTime(healingItem, hero2);
//		int i = 1;
//		while (i > 0) {
//			System.out.println(hw.toString());
//			try {
//				Thread.sleep(9000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			i++;
//		}
//	}
	
	//TODO latch this class to hospital, 
//	add a private property called healingWard to Hospital and in the constructor 
//	instantiate an element of it as soon as an hospital is constructed
	
}