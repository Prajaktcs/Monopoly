package edu.iit.monopoly.dice;

import java.util.concurrent.ThreadLocalRandom;

import edu.iit.monopoly.player.Player;

public class PlayDiceRandomly implements PlayDice {
	 
	@Override
	public int rollDice(Player player) {
		int dice1 = ThreadLocalRandom.current().nextInt(min, max + 1); 
		int dice2 = ThreadLocalRandom.current().nextInt(min, max + 1);
		System.out.printf("Player %s rolled %d and %d = %d \n", player.getName(),dice1,dice2,dice1+dice2);
		return dice1 + dice2;
	}

}
