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
}
