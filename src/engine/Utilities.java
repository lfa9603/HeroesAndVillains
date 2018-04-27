package engine;

import java.util.InputMismatchException;
import java.util.Random;


import static engine.HelperScanner.*;


public class Utilities {
	
	public static int getChoice(String message, int setlowerLimit, int setupperLimt) {
		boolean validInput = false;
		
		int upperLimit = setupperLimt;
		int lowerLimit = setlowerLimit;
		int choice = -1;
		int userchoice = -1;
		
		while (validInput == false) {
			System.out.println(message);
			
			try {
				
				userchoice = nextInt();
				if (userchoice >= lowerLimit && userchoice <= upperLimit) {
					validInput = true;
					choice = userchoice;
//					return choice;
				} else {
					System.out.println("Please choose an interger between " + lowerLimit + "-" + upperLimit);
//					next();
				}

			} catch (InputMismatchException error) {
				System.out.println("Invalid input, have you typed a valid integer?");
				System.out.println("Please Try again \n");
				next();
				
			} finally {
				reset(); 
				
			}
		}
		
		return choice;
	}
	
//	@SuppressWarnings({ "resource" })
	public static YesNo getStringChoice(String userQuestion) {
		boolean validInput = false;
		YesNo resultToReturn = null;
		
		while (validInput == false) {
			System.out.print(userQuestion + " Y/N \n");
			
//			String userInput = next().toLowerCase();
			
			try {
				String userInput = next().toLowerCase();
				switch (userInput) {
					case "y":
						resultToReturn = YesNo.yes;
						validInput = true;
						break;
					case  "n":
						resultToReturn = YesNo.no;
						validInput = true;
						break;
					default:
						throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("invalid input, please answer Y/N or y/n");
			} finally {
				reset();
			}
		}
		
		return resultToReturn;
		
	}

	public static int getRandInt(int upperLimit) {
		Random random = new Random();
		int choice = random.nextInt(upperLimit);
		return (choice+1);
	}

}
