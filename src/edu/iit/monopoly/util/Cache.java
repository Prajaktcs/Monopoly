package edu.iit.monopoly.util;

import java.util.ArrayList;
import java.util.List;

import edu.iit.monopoly.square.JailSquare;
import edu.iit.monopoly.square.PropertySquare;
import edu.iit.monopoly.square.RailRoadSquare;
import edu.iit.monopoly.square.TaxSquare;
import edu.iit.monopoly.square.UtilityCompanySquare;

public class Cache {
	private List<PropertySquare> propertySquares;
	private List<RailRoadSquare> railRoads;
	private List<TaxSquare> taxs;
	private List<UtilityCompanySquare> utilityCompanySquares;
	private List<JailSquare> jails;
	
	
	public Cache() {
		propertySquares = new ArrayList<>();
		railRoads = new ArrayList<>();
		taxs = new ArrayList<>();
		utilityCompanySquares = new ArrayList<>();
		jails = new ArrayList<>();
	}
	
	public void addPropertySquare(PropertySquare propertySquare){
		propertySquares.add(propertySquare);
	}
	
	public PropertySquare getProperty(){
		return propertySquares.remove(0);
	}
	
	public void addRailRoadSquare(RailRoadSquare railRoadSquare){
		railRoads.add(railRoadSquare);
	}
	
	public RailRoadSquare getRailRoadSquare(){
		return railRoads.remove(0);
	}
	
	public void addUtilityCompanySquare(UtilityCompanySquare utilityCompanySquare){
		utilityCompanySquares.add(utilityCompanySquare);
	}
	
	public UtilityCompanySquare getUtilityCompanySquare(){
		return utilityCompanySquares.remove(0);
	}
	
	public void addTaxSquare(TaxSquare taxSquare){
		taxs.add(taxSquare);
	}
	
	public TaxSquare getTaxSquare(){
		return taxs.remove(0);
	}
	
	public void addJailsSquare(JailSquare jailSquare){
		jails.add(jailSquare);
	}
	
	public JailSquare getJailSquare(){
		return jails.remove(0);
	}
}
