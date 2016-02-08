package edu.iit.monopoly.board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import edu.iit.monopoly.constants.Constants;
import edu.iit.monopoly.constants.SquareType;
import edu.iit.monopoly.square.Chance;
import edu.iit.monopoly.square.CommunityChestSquare;
import edu.iit.monopoly.square.GoSquare;
import edu.iit.monopoly.square.GoToJail;
import edu.iit.monopoly.square.JailSquare;
import edu.iit.monopoly.square.PropertySquare;
import edu.iit.monopoly.square.RailRoadSquare;
import edu.iit.monopoly.square.TaxSquare;
import edu.iit.monopoly.square.UtilityCompanySquare;
import edu.iit.monopoly.util.Cache;
import edu.iit.monopoly.util.PropertyHolder;


/**
 * Class to fill the board by reading a properties file
 * @author Prajakt
 *
 */
public class FillBoardFromFiles implements FillBoard{

	private Board board;
	private Cache cache;
	
	public FillBoardFromFiles() {
		board = Board.getInstance();
	}
	/**
	 * Method that will read the values from the file and fill the board
	 */
	public boolean fillBoard() {
		PropertyHolder propertyHolder = new PropertyHolder();
		String path = propertyHolder.getProperty("boardpath");
		boolean result = false;
		File file = new File(path);
		try(BufferedReader in = new BufferedReader(new FileReader(file));) {
			
			String line = null;
			int count = 0;
			fillCache();
			while((line = in.readLine()) != null && count < 40){
				if(line!=" ")
					decideSquareAndAdd(line);
				count++;
			}
			if(count<39){
				System.out.println("The board is not complete");
			}
			result = true;
			
		} catch (FileNotFoundException e) {
			System.out.println("File was not found, please enter the correct path");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There was some problem while reading the file");
			e.printStackTrace();
		}
		return result;
	}
	
	private boolean fillCache() throws IOException {
		boolean result = false;
		cache = new Cache();
		fillPropertySpaceInCache();
		fillRailRoadsInCache();
		fillTaxInCache();
		fillUtilityInCache();
		fillJailInCache();
		return result;
		
	}
	
	/**
	 * Fill the rail roads from file
	 * @return
	 * @throws IOException
	 */
	private boolean fillJailInCache() throws IOException {
		boolean result = false;
		PropertyHolder propertyHolder = new PropertyHolder();
		String path = propertyHolder.getProperty("jailpath");
		File file = new File(path);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = null;
		while((line = in.readLine())!=null){
			try{
				JailSquare jailSquare = new JailSquare(line);
				cache.addJailsSquare(jailSquare);
				result = true;
			}catch(Exception e){
				System.out.println("Error while parsing the string");
			}
		}
		in.close();
		return result;
		
	}
	
	
	private boolean fillUtilityInCache() throws IOException {
		boolean result = false;
		PropertyHolder propertyHolder = new PropertyHolder();
		String path = propertyHolder.getProperty("utilitypath");
		File file = new File(path);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = null;
		while((line = in.readLine())!=null){
			try{
				String[] values = line.split(":");
				UtilityCompanySquare utilityCompanySquare = new UtilityCompanySquare(values[0],Integer.parseInt(values[1]));
				cache.addUtilityCompanySquare(utilityCompanySquare);
				result = true;
			}catch(Exception e){
				System.out.println("Error while parsing the string");
				
			}
		}
		in.close();
		return result;
		
	}
	
	private boolean fillTaxInCache() throws IOException {
		boolean result = false;
		PropertyHolder propertyHolder = new PropertyHolder();
		String path = propertyHolder.getProperty("taxpath");
		File file = new File(path);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = null;
		while((line = in.readLine())!=null){
			try{
				String[] values = line.split(":");
				TaxSquare taxSquare = new TaxSquare(values[0],Integer.parseInt(values[1]));
				cache.addTaxSquare(taxSquare);
				result = true;
			}catch(Exception e){
				System.out.println("Error while parsing the string");
				
			}
		}
		in.close();
		return result;
		
	}
	/**
	 * Fill the rail roads from file
	 * @return
	 * @throws IOException
	 */
	private boolean fillRailRoadsInCache() throws IOException {
		boolean result = false;
		PropertyHolder propertyHolder = new PropertyHolder();
		String path = propertyHolder.getProperty("railroadspath");
		File file = new File(path);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = null;
		while((line = in.readLine())!=null){
			try{
				RailRoadSquare railRoadSquare = new RailRoadSquare(line);
				cache.addRailRoadSquare(railRoadSquare);
				result = true;
			}catch(Exception e){
				System.out.println("Error while parsing the string");
				
			}
		}
		in.close();
		return result;
		
	}
	
	/**
	 * Load the property spaces
	 * @throws IOException 
	 */
	private boolean fillPropertySpaceInCache() throws IOException {
		boolean result = false;
		PropertyHolder propertyHolder = new PropertyHolder();
		String path = propertyHolder.getProperty("propertyspacepath");
		File file = new File(path);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = null;
		while((line = in.readLine())!=null){
			try{
				String[] values = line.trim().split(":");
				PropertySquare propertySquare = new PropertySquare(values[0], Integer.parseInt(values[1]));
				cache.addPropertySquare(propertySquare);
				result = true;
			}catch(Exception e){
				System.out.println("Error while parsing the property string");
			}
		}
		in.close();
		return result;
	}
	
	
	
	/**
	 * 
	 * @param line
	 * @return
	 */
	private boolean decideSquareAndAdd(String line) {
		try{
			SquareType squareType = SquareType.valueOf(line.trim().toUpperCase());
			switch (squareType) {
			//If we get a property space, read the property with its credits and add it to the file
			case PROPERTY_SPACE:
				PropertySquare property = cache.getProperty();
				board.addToSquare(property);
				break;
			case RAILROAD:
				RailRoadSquare railRoadSquare = cache.getRailRoadSquare();
				board.addToSquare(railRoadSquare);
				break;
			case TAX:
				TaxSquare taxSquare = cache.getTaxSquare();
				board.addToSquare(taxSquare);
				break;
			case UTILITY_COMPANY:
				UtilityCompanySquare utilityCompanySquare = cache.getUtilityCompanySquare();
				board.addToSquare(utilityCompanySquare);
				break;
			case GO_TO_JAIL:
				GoToJail goToJail = new GoToJail(line);
				board.addToSquare(goToJail);
				break;
			case JAIL:
				JailSquare jailSquare = cache.getJailSquare();
				board.addToSquare(jailSquare);
				break;
			case CHANCE:
				Chance chance = new Chance(line);
				board.addToSquare(chance);
				break;
			case COMMUNITY_CHEST:
				CommunityChestSquare communitySquare = new CommunityChestSquare(line);
				board.addToSquare(communitySquare);
				break;
			case GO:
				GoSquare goSquare = new GoSquare(line, Constants.GO_CREDITS);
				board.addToSquare(goSquare);
				break;
			default:
				System.out.println("Unsupported square type");
				break;
			}
		}catch(NullPointerException npe){
			System.out.println("Unsupported square type");
			return false;
		}
		return false;
	}
	
}
