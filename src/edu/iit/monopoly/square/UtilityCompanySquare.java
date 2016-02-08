package edu.iit.monopoly.square;

import edu.iit.monopoly.player.Player;

public class UtilityCompanySquare extends Square{
	
	private int multipliyer;
	private int credits;
	
	public UtilityCompanySquare(String name,int multipliyer) {
		super(name);
		this.multipliyer = multipliyer;
	}


	@Override
	public void takeAction(Player player) {
		System.out.printf("%s awards %d credits\n",name,credits);
		player.addCredits(credits);
	}
	
	public void takeAction(Player player, int dice){
		credits = dice * multipliyer;
		takeAction(player);
	}

}
