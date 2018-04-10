package LorenzosIdeaForMiniGame;

import characters.Hero;
import characters.HeroesSquad;
import characters.Villain;

public class RockPaperScissor extends RandomMiniGameLorenzoRandomlyImplemented {

	
	
	public RockPaperScissor(Hero h, HeroesSquad theSquad, Villain v) {
		super(h, theSquad, v);
		// TODO Auto-generated constructor stub
	}

	private void whoWins(RPSMiniGameID heroChoice, RPSMiniGameID villainChoice) {
		switch(heroChoice) {
		
			case Rock: 
				switch(villainChoice) {
					case Rock: battleDraw(); break;
					case Paper: villainWins(); break;
					case Scissor: heroWins(); break;
					}; break;
				
			case Paper:
				switch(villainChoice) {
					case Rock: battleDraw(); break;
					case Paper: villainWins(); break;
					case Scissor: heroWins(); break;
					}; break;
				
			case Scissor: 
				switch(villainChoice) {
					case Rock: battleDraw(); break;
					case Paper: villainWins(); break;
					case Scissor: heroWins(); break;
					}; break;
		}
	}
	
	private RPSMiniGameID getVillainChoice() {
		return RPSMiniGameID.getRandom();
	}
	
	
	
	public void start() {
//		collect hero's abilities
//		takePersonInput make this equal to id 1;
//		chooseVillainInput 
//		see who wins
//		keep going until something goes differently
	}
	

	
	
	
}
