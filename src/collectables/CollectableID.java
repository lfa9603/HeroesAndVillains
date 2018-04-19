package collectables;

public enum CollectableID {

	GoodHealingItem,    /** ID for HealingItem objects, HealingItem objects with this ID have HPRecoverable of 25 
							@see collectables/HealingItem.java */
	
	BetterHealingItem,  /** ID for HealingItem objects, HealingItem objects with this ID HPRecoverable of 50 
							@see collectables/HealingItem.java */
	
	BestHealingItem,    /** ID for HealingItem objects, HealingItem objects with this ID have HPRecoverable of 75 
							@see collectables/HealingItem.java */
	
	Armor,              /** ID for Armor objects,
							@see collectables/powerUp/Armor.java */
	
	GameChooser,        /** ID for Armor objects
							@see collectables/powerUp/GameChooser.java */
	
	IncreaseMaxLife,	/** ID for IncreaseMaxLife objects, 
							@see collectables/powerUp/IncreaseMaxLife.java */    
	
	HeroesMap			/** ID for HeroesMap objects, 
							@see collectables/powerUp/GameChooser.java */
	
}
