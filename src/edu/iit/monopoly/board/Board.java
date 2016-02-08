package edu.iit.monopoly.board;

import java.util.ArrayList;
import java.util.List;

import edu.iit.monopoly.square.Square;

/**
 * 
 * @author Prajakt
 *
 */
public class Board {
	//Array to hold the board. The board contains 40 Squares
	private List<Square> squares;
	
	private static Board board;
	//lazy initialization
	private Board() {
		squares = new ArrayList<Square>();
	}
	/**
	 * 
	 * @return a singleton instance of the board
	 */
	public static Board getInstance(){
		if(board!=null){
			return board;
		}else{
			return board = new Board();
		}
	}
	
	public void addToSquare(Square square){
		squares.add(square);
	}
	
	public Square getSquare(int index){
		if(index>40){
			index = index - 40;
			return squares.get(index);
		}
		return squares.get(index-1);
	}

}
