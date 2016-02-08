package edu.iit.monopoly.tests;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.iit.monopoly.board.Board;
import edu.iit.monopoly.board.FillBoard;
import edu.iit.monopoly.board.FillBoardFromFiles;
import edu.iit.monopoly.player.Player;
import edu.iit.monopoly.util.PropertyHolder;

public class MonoployTest {

	@Before
	public void loadConfig() {
		try {
			PropertyHolder.loadProperties();
		} catch (IOException e) {
			System.out
					.println("There was an error while reading from the properties file");
			System.exit(0);
		}
		FillBoard fillBoard = new FillBoardFromFiles();
		fillBoard.fillBoard();
	}

	@Test
	public void landingOnStatesAvenuePays140Credits() {
		// Given
		Board board = Board.getInstance();
		Player player = new Player("Prajakt");

		// When
		player.setPosition(13);
		board.getSquare(13).takeAction(player);

		// Then
		Assert.assertEquals("The Value should be 140", 140, player.getCredits());
	}

	@Test
	public void landingOnRailRoadSpacesGives200() {
		// Given
		Board board = Board.getInstance();
		Player player = new Player("Prajakt");

		// When
		player.setPosition(5);
		board.getSquare(5).takeAction(player);

		// Then
		Assert.assertEquals("The Value should be 200", 200, player.getCredits());
	}

	@Test
	public void landingOnRailRoadSpacesThreeTimesGives1200() {
		// reset the board
		loadConfig();

		// Given
		Board board = Board.getInstance();
		Player player = new Player("Prajakt");

		// When
		player.setPosition(5);
		board.getSquare(5).takeAction(player);

		player.setPosition(15);
		board.getSquare(15).takeAction(player);

		player.setPosition(25);
		board.getSquare(25).takeAction(player);

		// Then
		Assert.assertEquals("The Value should be 1200", 1200,
				player.getCredits());
	}

	@Test
	public void landingOnIncomeTaxPays200() {
		// Given
		Board board = Board.getInstance();
		Player player = new Player("Prajakt");

		// When
		player.setPosition(4);
		board.getSquare(4).takeAction(player);

		// Then
		Assert.assertEquals("The Value should be 200", 200, player.getCredits());
	}

	@Test
	public void goToJailSendsYouToJailSquareAndDoesntPay() {
		// Given
		Board board = Board.getInstance();
		Player player = new Player("Prajakt");

		// When
		player.setPosition(30);
		board.getSquare(30).takeAction(player);

		// Then
		//Check current position
		Assert.assertEquals("The Value should be 10", 10, player.checkPosition());
		//Check credit
		Assert.assertEquals("The Value should be 0", 0, player.getCredits());

	}
	
	@Test
	public void landingOnGoPays200Credits(){
		//Given
		Board board = Board.getInstance();
		Player player = new Player("Prajakt");

		// When
		player.setPosition(40);
		board.getSquare(40).takeAction(player);

		// Then
		//Check current position
		Assert.assertEquals("The Value should be 200", 200, player.getCredits());
	}
	
	

}
