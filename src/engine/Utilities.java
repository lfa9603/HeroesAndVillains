package engine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilities {
	
	public static int getChoice(String message, int setlowerLimit, int setupperLimt) {
		boolean validInput = false;
		
		int upperLimit = setupperLimt;
		int lowerLimit = setlowerLimit;
		int choice = -1;
		
		while (validInput == false) {
			Scanner input = new Scanner(System.in);
			System.out.println(message);
			
			try {
				int userchoice = input.nextInt();
				if (userchoice >= lowerLimit && userchoice <= upperLimit) {
					validInput = true;
					choice = userchoice;
					input.close();
					return choice;
				}
				
				else {
					System.out.println("Please choose an interger between " + lowerLimit + "-" + upperLimit);
				}

			} catch (InputMismatchException error) {
				System.out.println("Invalid input, have you typed a valid integer?");
				System.out.println("Please Try again \n");
			} finally {
				input.reset();
			}
		}
		
		return choice;
	}
	
//	public static void main(String[] args) {
//		int givenchoice = getChoice("Choose a number between 1-10: ", 10, 1);
//		System.out.println(givenchoice);
//	}

}
