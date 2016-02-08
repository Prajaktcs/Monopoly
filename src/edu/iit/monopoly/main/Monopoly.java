package edu.iit.monopoly.main;

import java.io.IOException;
import java.util.Scanner;

import edu.iit.monopoly.board.Board;
import edu.iit.monopoly.board.FillBoard;
import edu.iit.monopoly.board.FillBoardFromFiles;
import edu.iit.monopoly.dice.PlayDice;
import edu.iit.monopoly.dice.PlayDiceFromConsole;
import edu.iit.monopoly.dice.PlayDiceRandomly;
import edu.iit.monopoly.player.Player;
import edu.iit.monopoly.square.Square;
import edu.iit.monopoly.square.UtilityCompanySquare;
import edu.iit.monopoly.util.PropertyHolder;

public class Monopoly {

	public static void main(String[] args) {
		loadProperties();
		FillBoard fillBoard = new FillBoardFromFiles();
		if(!fillBoard.fillBoard()){
			System.out.println("Error while creating the board. Please check the properties file");
		}
		System.out.println("Please enter your name");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		Player player = new Player(name);
		
		PlayDice playDice = null;
		if(args.length!=0 && "-dice".equals(args[0])){
			playDice = new PlayDiceFromConsole(in);
		}else{
			playDice = new PlayDiceRandomly();
		}
		while(player.checkPosition()<40){
			nextMove(player,playDice);
		}
		in.close();
	}

	
	/**
	 * 
	 * @param player
	 * @param playDice
	 */
	private static void nextMove(Player player, PlayDice playDice) {
		int diceValue = playDice.rollDice(player);
		int playersNewPostion = player.movePostition(diceValue);
		Board board = Board.getInstance();
		Square square = board.getSquare(playersNewPostion);
		System.out.printf("%s landed on %s\n",player.getName(),square.getName());
		if(square instanceof UtilityCompanySquare){
			((UtilityCompanySquare) square).takeAction(player, diceValue);
		}else{
			square.takeAction(player);
		}
		System.out.println("Total Credits won: " + player.getCredits());
		System.out.println("----------------------------------------------------------------");
	}



	/**
	 * Method that will call the load properties and the properties will be stored in a shared resource
	 */
	private static void loadProperties(){
		try {
			PropertyHolder.loadProperties();
		} catch (IOException e) {
			System.out.println("There was an error while reading from the properties file");
			System.exit(0);
		}
		
	}
	
	
}
