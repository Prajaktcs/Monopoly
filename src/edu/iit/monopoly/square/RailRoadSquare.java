package edu.iit.monopoly.square;

import edu.iit.monopoly.player.Player;

public class RailRoadSquare extends Square{
	private static final int[] credits = {200,400,600,800};
	
	
	public RailRoadSquare(String name) {
		super(name);
	}

	@Override
	public void takeAction(Player player) {
		int noOfVisits = player.getVisitedRailRoads();
		System.out.printf("%s awards %d credits\n",name,credits[noOfVisits]);
		player.addCredits(credits[noOfVisits]);
		player.addVisitedRailRoads();
	}
	
	
}
