package collectables.powerUp;

public enum PowerUpType {
	/**
	 * These 3 types are the type of PowerUp possible to be bought in Shop and applied inside PowerUpDen elements:
	 * 1 - Shield: cheapest, it absorbs the 1st hit the Villain throws to the character without making
	 * 	   the character loose HP.
	 * 2 - IncreaseMaxLife: increases the total HP of the player of 25 HP, each Hero can have applied this type of PowerUp only once,
	 * 	   which means an hero can never have MAX HP of more than 125.
	 * 3 - GameChooser: if an Hero with GameChooser power-up challenges the boss, instead of letting the boss choose 
	 *     the game to play it will be the hero to choose.
	 */
	Armor, IncreaseMaxLife, GameChooser
	
}
