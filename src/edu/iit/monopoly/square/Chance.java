package edu.iit.monopoly.square;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import edu.iit.monopoly.constants.ChanceCards;
import edu.iit.monopoly.player.Player;

public class Chance extends Square{
	private static List<ChanceCards> chanceCards;
	
	static{
		chanceCards = new ArrayList<ChanceCards>();
		loadChanceConstants();
	}
	
	public Chance(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	private static void loadChanceConstants() {
		for(ChanceCards chanceCard : ChanceCards.values()){
			chanceCards.add(chanceCard);
		}
	}

	@Override
	public void takeAction(Player player) {
		int random = ThreadLocalRandom.current().nextInt(0, chanceCards.size());
		if(chanceCards.get(random).equals(ChanceCards.GO_BACK)){
			player.setPosition(player.checkPosition()-3);
			System.out.printf("%s go back three spaces\n",player.getName());
		}else{
			System.out.printf("%s awards %d credits\n",chanceCards.get(random).toString(),chanceCards.get(random).getCredits());
			player.addCredits(chanceCards.get(random).getCredits());
		}
	}

}
