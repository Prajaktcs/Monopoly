package edu.iit.monopoly.dice;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.iit.monopoly.player.Player;

public class PlayDiceFromConsole implements PlayDice{
	private Scanner in;
	public PlayDiceFromConsole(Scanner in) {
		this.in = in;
	}
	@Override
	public int rollDice(Player player) {
		System.out.println("Please enter your dice roll : ");
		int dice1 = 0;
		int dice2 = 0;
		try{
			dice1 = in.nextInt();
			dice2 = in.nextInt();
		}catch(InputMismatchException ie){
			System.out.println("Please enter the right values. Game restarting");
		}
		if(dice1<1 || dice1>6 || dice2<1 || dice2>6){
			System.out.println("Please enter the right values. Game restarting");
		}
		return dice1 + dice2;
	}

}
