package edu.iit.monopoly.square;

import edu.iit.monopoly.player.Player;

public class GoSquare extends Square{
	private int credit;
	
	public GoSquare(String name, int credit) {
		super(name);
		this.credit = credit;
	}

	@Override
	public void takeAction(Player player) {
		System.out.printf("%s passes %s and is awarded %d\n",player.getName(),name,credit);
		player.addCredits(credit);
	}
	
	
}
