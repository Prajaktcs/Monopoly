package edu.iit.monopoly.square;

import edu.iit.monopoly.player.Player;

public class TaxSquare extends Square{
	private int credits;

	public TaxSquare(String name,int credits) {
		super(name);
		this.credits = credits;
	}

	@Override
	public void takeAction(Player player) {
		System.out.printf("%s awards %d credits\n",name,credits);
		player.addCredits(credits);
	}
	
	

}
