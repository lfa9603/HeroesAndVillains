package characters;

import java.util.InputMismatchException;

import engine.Icons;
import engine.VisualUtilities;

import static engine.HelperScanner.*;


public class TeamBuilder {
	private HeroesSquad Team;
	private String finalteamName;
	
	
	private static String characterTypes = "1. Talkitive : Has the ability to Charm people (Gets 25% better prices at shops) \n"
			+ "2. Smart : Mystery Ability, which could help or hinder your team (Minigame dependant) \n"
			+ "3. Practical : Gets better odds at rock, paper Scissors \n"
			+ "4. Strong : Takes 30% less damage \n"
			+ "5. Sly : Wins all match draws unless the Villain has this abilty \n"
			+ "6. Dog : Is a good boy (Grants all team member extra 25HP Max Health)";
	
//	private String characterTypesArray[] = {"ability1", "ability2", "ability3", "ability4", "ability5", "ability6"};
	
	public HeroesSquad getTeam() {
		return Team;
	}

	public TeamBuilder() { 
		createTeam();
		addTeamMembers();
	}
	
	private void createTeam() {
		boolean run = true;
		
		/* Asks if the user wants to create a new team, takes Y/N or y/n as a input. 
		 * TODO the User can quit at any time with an input Q or q.
		 */
		
//		Scanner input = HelperScanner.getScanner();
		
		while (run == true) {
			System.out.print("Do you want to create a New Team? Y/N \n");
			String createTeam = next();
			
			if (createTeam.equals("Y") || createTeam.equals("y")) {
				
				
				/* If input is accepted then it asks the user what the name of the team will be, 
				* character limit is 2-10 characters.
				*/
				
				while (run == true) {
					
//					Scanner newinput = new Scanner(System.in);
					System.out.println("Team name: ");
					String teamName = next();
					
				
					if ((teamName.length() >= 2) && (teamName.length() <= 10)) {
						
						
						
//						Scanner secondNewinput = new Scanner(System.in);
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
								System.out.println("invalid input, please answer Y/N or y/n");
							}
						}
					}
						
					else {
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
					System.out.println("invalid input, please answer Y/N or y/n");
				}
			
		}

		}
	}
	
	private void addTeamMembers() {
		boolean run = true;
		boolean runInner = true;
		while (run == true) {
			System.out.println(VisualUtilities.getIcon(Icons.bar));
			System.out.println("Avaliable Heros (A Max of 3 x Heros allowed):");
			System.out.println(characterTypes + "\n");
			System.out.println(VisualUtilities.getIcon(Icons.bar));
			System.out.println("Please enter 1-6 to select a character (Press \'Q\' when done selecting):");
			System.out.println(VisualUtilities.getIcon(Icons.bar));
//			Scanner userinput_1 = new Scanner(System.in);
			
			try {
				Integer selectedCharacter = nextInt();
				if (selectedCharacter >= 1 && selectedCharacter <= 6) {
					switch(selectedCharacter) {
					case 1: createHero(Types.talkitive, Abilities.charm); break;
					case 2: createHero(Types.smart, Abilities.mystery); break;
					case 3: createHero(Types.practical, Abilities.betterOdds); break;
					case 4: createHero(Types.strong, Abilities.lessDamage); break;
					case 5: createHero(Types.sly, Abilities.winDraws); break;
					case 6: createHero(Types.dog, Abilities.goodBoy); break;
					default: 
						throw new InputMismatchException();
					}
				}
					
				else {
						System.out.println("Invalid integer, please type a value betwen (and including) 1 and 6 \n");
						next();
					}
				
			} catch (InputMismatchException error) {
				System.out.println("Invalid input, have you typed a valid integer?");
				System.out.println("Please Try again \n");
				next();
			}
			
			finally {
				reset();
			}
			
			while (runInner == true) {
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
						runInner = false;
						
					}
					else {
						if (confirmation.equals("Y") || confirmation.equals("y")) {
							run = false;
							runInner = false;
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
									runInner = false;
								}
								else {
									System.out.println("invalid input, please answer Y/N/R or y/n/r");
								}
							}
				
							
						}
					}
				}
			}
			runInner = true;
		}
		}
	
	private void createHero(Types type, Abilities abilty) {
//		Scanner userinput_2 = HelperScanner.getScanner();
		System.out.println("What will your Hero's name be?");
		String characterName = next();
		
		Hero hero = new Hero(characterName, type, abilty);  
		Team.addHero(hero);
		
		
		System.out.println(VisualUtilities.getIcon(Icons.bar));
		System.out.println("Current Team: " + Team.toString());
		
	}
	
	
	
	public static void main(String[] args) {
		TeamBuilder team = new TeamBuilder();
		System.out.println(team.getTeam());
	}
}
