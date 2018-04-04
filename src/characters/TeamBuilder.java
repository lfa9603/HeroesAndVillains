package characters;

import java.util.Scanner;

public class TeamBuilder {
	private static boolean run = true;
	
	public static void createTeam() {
		
		while (run == true) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Do you want to create a New Team? Y/N");
		String createTeam = input.next();
		
		if (createTeam.equals("Y") || createTeam.equals("y")) {
			System.out.print("Team Name?: ");
			String teamName = input.next();
			HeroesSquad newTeam = new HeroesSquad();
			newTeam.setTeamName(teamName);
			System.out.println(newTeam.toString());
			input.close();
			run = false;
		}
						
		else {
			if (createTeam.equals("N") || createTeam.equals("n")) {
				run = false;
				System.out.println("Thanks for Playing!");
				input.close();
			}
			
			else {
				System.out.println("invalid input, please answer Y/N or y/n");
			}
			
		}
		
		//System.out.println(createTeam + " " + teamName);
		
		
		
		}
	}
	
	
	public static void main(String[] args) {
		createTeam();
	}
}
