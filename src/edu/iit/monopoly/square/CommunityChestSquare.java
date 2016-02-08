package edu.iit.monopoly.square;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import edu.iit.monopoly.constants.CommunityChestCards;
import edu.iit.monopoly.constants.Constants;
import edu.iit.monopoly.player.Player;

public class CommunityChestSquare extends Square{
	private static List<CommunityChestCards> communityChestCards;
	
	static{
		communityChestCards = new ArrayList<>();
		loadChanceConstants();
	}
	
	private static void loadChanceConstants() {
		for(CommunityChestCards communityChestCard: CommunityChestCards.values()){
			communityChestCards.add(communityChestCard);
		}
	}
	
	public CommunityChestSquare(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void takeAction(Player player) {
		int random = ThreadLocalRandom.current().nextInt(0, communityChestCards.size());
		if(communityChestCards.get(random).equals(CommunityChestCards.Go_TO_JAIL)){
			player.setPosition(Constants.JAIL_LOCATION);
			System.out.printf("Go to jail. Do not pass Go, do not collect 200 credits\n");
		}else{
			System.out.printf("%s awards %d credits\n",communityChestCards.get(random).toString(),communityChestCards.get(random).getCredits());
			player.addCredits(communityChestCards.get(random).getCredits());
		}
	}

}
