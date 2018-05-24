/**
 * @author Lorenzo Fasano
 * 
 * This package contains HealingWard.java and Hospital.java.
 * Hospital.java is one of the 5 classes that extend Building an therefore it implements an interact() method 
 * ( @see Building.java in city/builidngs/Building.java and @see Hospital.java in city/buildings/hospital/Hospital.java).
 * HealingWard.java takes care of keeping track of the Hero objects which are currently under the effect of an 
 * HealingItem apply(Hero) method, showing how long before the effect will finish ( @see HealingWard.java in city/buildings/hospital/HealingWard.java ).
 * 
 * The package has been created to add more clarity in the project structure, separating the class HealingWard.java 
 * (which is specific to the Hospital.java class) from the rest of the objects that extend Builidng.
 * 
 */
package city.buildings.hospital;