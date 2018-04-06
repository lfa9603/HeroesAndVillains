package collectables;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Thread( new Runnable() {
			public void run() {
				int i = 3;
				while (i-- > 0) {
					try {
						System.out.println("Ciao");
						Thread.sleep(10000);
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Asynchronous behaviour finished");
			}
		}).start();
		
		boolean stillAsking = true;
		Integer integerTyped = null;
		System.out.println("How many cities would you like to explore? (Please type a number between 3 and 6)");
		while (stillAsking) {
			Scanner input = new Scanner(System.in);
			try {
				integerTyped = input.nextInt();
				if (integerTyped >= 3 && integerTyped <= 6) {
					stillAsking = false;
					input.close();
				} else {
					System.out.println("Invalid integer, please type a value betwen (and including) 3 and 6");
				}
			} catch (InputMismatchException error){
				System.out.println("Invalid input, have you typed a valid integer?");
				System.out.println("Try again");
			} finally {
				input.reset();
			}
		}
	}
	
}
