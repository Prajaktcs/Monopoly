package edu.iit.monopoly.player;

public class Player {
	private int credits;
	private int currentPosition;
	private int visitedRailroads;
	String name;
	public Player(String name) {
		this.name = name;
		visitedRailroads = 0;
	}
	
	public void addCredits(int credits){
		this.credits += credits;
	}
	
	public int getCredits(){
		return credits;
	}
	
	public void setPosition(int value){
		currentPosition = value;
	}
	
	public int movePostition(int diceValue){
		return currentPosition += diceValue;
	}
	
	public int checkPosition(){
		return this.currentPosition;
	}
	
	public String getName(){
		return name;
	}
	
	public void addVisitedRailRoads(){
		visitedRailroads+=1;
	}
	
	public int getVisitedRailRoads(){
		return visitedRailroads;
	}
}
