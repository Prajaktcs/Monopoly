package edu.iit.monopoly.constants;

public enum ChanceCards {

	Go_TO_JAIL(0),BANK_DIVIDEND(50),GO_BACK(0),WON_CROSSWORD_COMPETITION(10),CHAIRMAN(100);
	
	int credits;
	
	private ChanceCards(int credits) {
		this.credits = credits;
	}
	
	public int getCredits(){
		return credits;
	}
}
