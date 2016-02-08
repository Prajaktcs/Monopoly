package edu.iit.monopoly.square;

import edu.iit.monopoly.constants.Constants;
import edu.iit.monopoly.player.Player;

public class GoToJail extends Square{

	public GoToJail(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void takeAction(Player player) {
		player.setPosition(Constants.JAIL_LOCATION);
		System.out.printf("Go to jail. Do not pass Go, do not collect 200 credits\n");
		
	}

}
