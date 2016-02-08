package edu.iit.monopoly.square;

import edu.iit.monopoly.player.Player;

public class PropertySquare extends Square{
	private int credits;
	
	public PropertySquare(String name, int credits){
		this(name);
		this.credits = credits;
	}
	
	public PropertySquare(String name) {
		super(name);
	}
	
	public int getCredits(){
		return this.credits;
	}

	@Override
	public void takeAction(Player player) {
		System.out.printf("%s awards %d credits\n",name,credits);
		player.addCredits(credits);
	}

}
