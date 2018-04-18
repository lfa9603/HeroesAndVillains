package city.buildings;

/**
 * 
 * @author LorenzoFasano
 *Enumerator to store the different type the buildings can be.
 *As the disposition of all the buildings (a part from Home objects) is random, it helps understanding which building is located in each coordinates point.
 *Useful also for testing purposes. 
 */
public enum TypeBuildings {
	Home,         /** The type passed to Home objects */
	Hospital,     /** The type passed to Hospital objects */
	PowerUpDen,   /** The type passed to PowerUpDen objects */
	VillainsLair, /** The type passed to VillainsLair objects */
	Shop          /** The type passed to Shop objects */
}
