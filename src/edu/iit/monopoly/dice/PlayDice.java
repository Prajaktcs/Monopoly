package edu.iit.monopoly.dice;

import edu.iit.monopoly.player.Player;

public interface PlayDice {
	int min = 1;
	int max = 6;
	public abstract int rollDice(Player player);
}
