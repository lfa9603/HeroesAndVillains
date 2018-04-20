/**
 * @author Lorenzo Fasano
 * 
 * This package contains the abstract class Collectable.java which is the class that both HealingItem.java and PowerUp.java extend.
 * It contains CollectableID.java, an enumerator used to associate each Collectable item with an ID.
 * It also contains Inventory and the helper class InventoryTools which are used to store and classify CollectableItems in ArrayList 
 * objects or HashMaps objects for different purposes such as implementing the HeroesSquad objects backpack or implement the Merchandise.java 
 * class to give Shop.java items to sell.
 * Finally it contains Money.java, used to accomplish trading and looting instead of using Integer or int data-type.
 * 
 * This package also contains healingItem and powerUp packages where the items that extend Collectable are grouped.
 * 
 */
package collectables;