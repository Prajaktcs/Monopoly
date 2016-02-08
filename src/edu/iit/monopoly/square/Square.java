package edu.iit.monopoly.square;

import edu.iit.monopoly.player.Player;

/**
 * 
 * @author Prajakt
 *
 */
public abstract class Square {
	String name;
	
	public Square(String name) {
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public abstract void takeAction(Player player);
	
}
