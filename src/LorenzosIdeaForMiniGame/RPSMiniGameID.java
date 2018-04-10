package LorenzosIdeaForMiniGame;

import engine.Utilities;

public enum RPSMiniGameID {

	Paper, Scissor, Rock;
	
	
	public static RPSMiniGameID getRandom() {
        return values()[Utilities.getRandInt(3)];
//                        (int) (Math.random() * values().length)];
    }
}
