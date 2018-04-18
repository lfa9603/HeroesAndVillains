package collectables;

public class Money {
	
	private int amount;
	
	public Money(int money) {
		amount = money;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String toString() {
		String string = new String();
		string += amount;
		return string;
	}
	
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
	
	public int takePercentage(int percentage) {
		if (0 >= percentage && percentage <= 100) {
			return (amount * percentage) / 100; 
		} else {
			return amount;
		}
	}
}
