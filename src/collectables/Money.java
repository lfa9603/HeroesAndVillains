package collectables;

/**
 * 
 * @author LorenzoFasano
 * This class wants to be created to enforce a coin-like behaviour to the int data-type.
 * It implements methods to add or remove money from a HeroesSquad object, such that the 
 * property amount will never go negative.
 * Used in Shop, HeroesSquad and VillainLair. 
 * 
 */
//(TODO:check with jay where the money gets taken away from one Villain.)
public class Money implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2968833793257796392L;
	
	private int amount;
	
	public Money(int money) {
		amount = money;
	}

	/**
	 * 
	 * Getter method for amount property.
	 * @return amount (type int)
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * 
	 * Setter method for amount property.
	 * @param amount (type int)
	 * 
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/**
	 * 
	 * Overridden method toString(), it returns a String object containing the amount property in form of String. 
	 * (eg. amount = 6, to String() returns "6").
	 * 
	 */
	public String toString() {
		String string = new String();
		string += amount;
		return string;
	}
	
	/**
	 * 
	 * @param costItem (type Money)
	 * @return boolean value
	 * This method updates the property amount subtracting the amount of @param costItem and returning true 
	 * or denies the transaction returning false. 
	 *  
	 */
	public boolean minus(Money costItem) {
		Integer afterTransactionAmount = amount - costItem.getAmount();
		if (afterTransactionAmount >= 0) {
			amount = amount - costItem.getAmount();
			return true;
		} else {
			System.out.println("Sorry transaction cannot happen");
			return false;
		}
		
	}
	
	/**
	 * 
	 * @param moneyToAdd
	 * Updates the amount property to the current value plus the moneyToAdd.getAmount() int value.
	 * 
	 */
	public void addMoney(Money moneyToAdd) {
		amount = amount + moneyToAdd.getAmount();
	}
	
//	/**
//	 * 
//	 * @param percentage (type int)
//	 * @return
//	 */
//	public int takePercentage(int percentage) {
//		if (0 >= percentage && percentage <= 100) {
//			return (amount * percentage) / 100; 
//		} else {
//			return amount;
//		}
//	}
}
