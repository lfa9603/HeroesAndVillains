package characters;

import java.util.InputMismatchException;
import engine.Icons;
import engine.VisualUtilities;

import static engine.HelperScanner.*;

/**
 * 
 * This Class guides the User through the creation of a HeroSquad. It starts by creating the HeroSquad object, then it queries the 
 * user about the name and type of hero the user wants to add to the HeroSquad. Once the user decides the Hero object 
 * is created and added to the HeroSquad. Once the user confirms they are happy with their HeroSquad, the intialAbilitiesEffects class 
 * is called to apply any initial effects to the game.  
 *
 */

public class TeamBuilder {
	private HeroesSquad Team;
	private String finalteamName;
	
	
	private static String characterTypes = "1. Talkitive : Has the ability to Charm people (Gets 25% better prices at shops) \n"
			+ "2. Smart : Mystery Ability, which could help or hinder your team (Minigame dependant) \n"
			+ "3. Practical : Gets better odds at rock, paper Scissors \n"
			+ "4. Strong : Takes 30% less damage \n"
			+ "5. Sly : Wins all match draws unless the Villain has this abilty \n"
			+ "6. Dog : Is a good boy (Grants all team member extra 25HP Max Health)";
	
	public HeroesSquad getTeam() {
		return Team;
	}
	
	/**
	 * The CreateTeam method prompts the user, asking if they want to create a squad. If the user confirms, the method then asks the name of the 
	 * squad, a limit of 2-10 Characters is applied. The method then confirms that the User is happy with the Squad name and 
	 * creates the HeroSquad object.  
	 */

	public TeamBuilder() { 
		createTeam();
		if (Team != null) {
			addTeamMembers();
		//TODO: POSSIBLE FIX TO ONE OF THE BUGS, NOW WE ARE LEFT WITH IMPLEMENTIG THE GAMEOVER;
		} else {
//			Engine.setToGameOver();
		}
	}
	
	public void createTeam() {
		boolean run = true;
		
//		Scanner input = HelperScanner.getScanner();
		
		while (run == true) {
			System.out.print("Do you want to create a New Team? Y/N \n");
			String createTeam = next(); 
			try {
				
				if (createTeam.equals("Y") || createTeam.equals("y")) {
					
					
					/* If input is accepted then it asks the user what the name of the team will be, 
					* character limit is 2-10 characters.
					*/
					
					while (run == true) {
						
						System.out.println("Team name: ");
						String teamName = next();
						
						try {
							if ((teamName.length() >= 2) && (teamName.length() <= 10)) {

								System.out.println("Your Teams name is: " + teamName);
								System.out.println("Are you happy with this? Y/N");
								String confirmation = next();
								
								// Confirms the user is happy with there Team name.
								
								if (confirmation.equals("Y") || confirmation.equals("y")) {
									
									Team = new HeroesSquad();
									Team.setTeamName(teamName); 
									finalteamName = Team.getTeamName();
									run = false;
									System.out.println("Congrads your Team: " + finalteamName + " has been created. \n");
								}
								 
								else {
									
									if (confirmation.equals("N") || confirmation.equals("n")) {
										System.out.println("...Please re-enter");
									}
									
									else {
										throw new IllegalArgumentException();
									}
								}
							}
								
							else {
								throw new InputMismatchException();
							}
						
						} catch (InputMismatchException error) {
							System.out.println("Team Name must be between 2 and 10 characters long");
						}
					}

				}
							
			else {
				if (createTeam.equals("N") || createTeam.equals("n")) {
					run = false;
					System.out.println("Thanks for Playing!");
				}
				
				else {
					throw new IllegalArgumentException();
				}
			}
			
			} catch (IllegalArgumentException error) {
				System.out.println("invalid input, please answer Y/N or y/n");
			}

		}
	}
	
	/**
	 * The addTeamMembers method prompts the user to choose an integer 1-6 to select the type of hero they want to select. 
	 * The method then prompts the user to create a name for this hero. The Hero object is then created and the current 
	 * HeroSquad is then displayed to the user. The user is then asked if they are happy with the current squad, 
	 * if they want to add further members to the squad, or if the want to reset the Squad and start again.
	 * this process is repeated until the user confirms they are happy. Once the User confirms they are happy with there squad, 
	 * the initialAbilityEffects class is called.
	 */
	
	private void addTeamMembers() {
		boolean runfirstLoop = true;
		boolean runSecondLoop = true;
		boolean runThirdLoop = true;
		while (runfirstLoop == true) {
			System.out.println(VisualUtilities.getIcon(Icons.bar));
			System.out.println("Avaliable Heros (A Max of 3 x Heros allowed):");
			System.out.println(characterTypes + "\n");
			System.out.println(VisualUtilities.getIcon(Icons.bar));
			System.out.println("Please enter 1-6 to select a character (Press \'Q\' when done selecting):");
			System.out.println(VisualUtilities.getIcon(Icons.bar));
			
			//TODO: Done --- PROBLEM AROUND HERE (WHEN I HAVE TO SELECT THE HERO ABILITY) IF I TYPE A WRONG NUMBER IT DOES NOT WORK.(EG. 8 OR jhdfkj)
			while (runSecondLoop) {
				
				try {
					Integer selectedCharacter = nextInt();
					if (selectedCharacter instanceof Integer) {
						switch(selectedCharacter) {
						case 1: createHero(Types.talkitive, Abilities.charm); runSecondLoop = false; break;
						case 2: createHero(Types.smart, Abilities.mystery); runSecondLoop = false; break;
						case 3: createHero(Types.practical, Abilities.betterOdds); runSecondLoop = false; break;
						case 4: createHero(Types.strong, Abilities.lessDamage); runSecondLoop = false; break;
						case 5: createHero(Types.sly, Abilities.winDraws); runSecondLoop = false; break;
						case 6: createHero(Types.dog, Abilities.goodBoy); runSecondLoop = false; break;
						default: throw new IllegalArgumentException();
						}
					}
					
				} catch (InputMismatchException error) {
					System.out.println("Invalid input, have you typed a valid integer?");
					System.out.println("Please Try again:");
					next();
					
				} catch (IllegalArgumentException error) {
					System.out.println("please type a number between (and including) 1 and 6");
					System.out.println("Please Try again:");
				}
				
				finally {
					reset();
				}
				
			}
			
			while (runThirdLoop == true) {
				if (Team.getLength() >= 1) {
//					Scanner userinput_3 = new Scanner(System.in);
					System.out.println(VisualUtilities.getIcon(Icons.bar));
					System.out.println("Are you happy with your team?\n"
							+ "Y : to Proceed to the game.\n"
							+ "N : to add another Hero.\n"
							+ "R : to reset your team.");
					System.out.println(VisualUtilities.getIcon(Icons.bar));
					String confirmation = next();
					
					if (confirmation.equals("R") || confirmation.equals("r")) {
						System.out.println("Team has been reset.");
						Team.squadReset();
						runSecondLoop = true;
						runThirdLoop = false;
						
					}
					else {
						if (confirmation.equals("Y") || confirmation.equals("y")) {
							runfirstLoop = false;
							runSecondLoop = false;
							runThirdLoop = false;
							System.out.println("Congradulations Your team is ready!");
							System.out.println("The initial abilties will be applied if you have them in your squad.");
							InitialAbiltyEffects.applyHeroSquadAbilties(Team.getHeroSquad());
							
						}
						else {
							if (Team.getLength() == 3) {
								if (confirmation.equals("N") || confirmation.equals("n")) {
									System.out.println("You cannot have more than 3 x heros is a team.");
							}
							}
								
							else {
								if (confirmation.equals("N") || confirmation.equals("n")) {
									System.out.println("Please pick another hero.");
									runSecondLoop = true;
									runThirdLoop = false;
								}
								else {
									System.out.println("invalid input, please answer Y/N/R or y/n/r");
								}
							}
				
							
						}
					}
				}
			}
			runThirdLoop = true;
		}
	}
	
	/**
	 * The createHero method is called when the user selects the type of Hero they want. 
	 * The method then prompts the user for a Character name. Once the User has entered a name
	 * the HeroSquad toString is called to display the current squad.
	 * @param type
	 * @param abilty
	 */
	
	private void createHero(Types type, Abilities abilty) {
//		Scanner userinput_2 = HelperScanner.getScanner();
		System.out.println("What will your Hero's name be?");
		String characterName = next();
		
		Hero hero = new Hero(characterName, type, abilty);  
		Team.addHero(hero);
		
		
		System.out.println(VisualUtilities.getIcon(Icons.bar));
		System.out.println("Current Team: " + Team.toString());
		
	}
	
	
//	// For initial testing purposes only.
//	public static void main(String[] args) {
//		TeamBuilder team = new TeamBuilder();
//		System.out.println(team.getTeam());
//	}
}


