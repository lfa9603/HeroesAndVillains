package city.buildings.shop;

import java.util.Random;

public enum NamesForInnkeeper {

	/**
	 * Random names for the innkeeper of the shop.
	 */
	
	Gustavo,
	
	Guendalina,
	
	PierAntonio,
	
	Barbara,
	
	Gerry,
	
	Steve,
	
	Gareth,
	
	Gavin,
	
	Richard,
	
	Albert,
	
	Alexander,
	
	Gengis,
	
	Cratos,
	
	Guillermo,
	
	Vladimiro,
	
	Donald;
	
	
	/**
	 * 
	 * @return a random name for the innkeeper of the shop.
	 */
	public static NamesForInnkeeper returnRendomNameOutOfThePool() {	
		NamesForInnkeeper[] namesForInkeeper = values();
		Random random = new Random();
		Integer randInt = random.nextInt(namesForInkeeper.length);
		
		return namesForInkeeper[randInt];
	}
}
