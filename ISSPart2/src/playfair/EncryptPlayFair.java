package playfair;

import java.util.ArrayList;
import java.util.List;

import classes.Location;

public class EncryptPlayFair {

	PopulateArray pArray = new PopulateArray();
	FormatInput fInput = new FormatInput();
	
	/**
	 * This class does the encrypting and returns an encrypted string.
	 * 
	 * @param phrase the phrase to be encrypted.
	 * @param key The key to be used in encryption
	 * @return An encrypted String
	 * @throws Exception Returns a generic exception
	 */
	public String FindEncryption(String phrase, String key) throws Exception{
		try {
			char[][] array = pArray.PopulatePlayfairArray(key);
			String modPhrase = fInput.Format(phrase);
			String newPhrase = "";
			
			for(int i=0; i<modPhrase.length() - 1; i = i+2) {	
				Location firstItem = pArray.FindChar(modPhrase.charAt(i), array);
				Location secondItem = pArray.FindChar(modPhrase.charAt(i+1), array);
				
				List<Location> newLocs = ReturnEncrpyLoc(firstItem, secondItem);
				
				for(Location loc : newLocs) {
					newPhrase += array[loc.GetColumn()][loc.GetRow()];
				}
			}
			return newPhrase;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String FindDecryption(String phrase, String key) throws Exception{
		try {
			if(phrase.length() <=0) {
				throw new Exception("Phrase is too short!");
			}
			
			char[][] array = pArray.PopulatePlayfairArray(key);
			phrase = phrase.toLowerCase();
			
			String newPhrase = "";
			
			for(int i=0; i<phrase.length() - 1; i = i+2) {	
				Location firstItem = pArray.FindChar(phrase.charAt(i), array);
				Location secondItem = pArray.FindChar(phrase.charAt(i+1), array);
				
				List<Location> newLocs = ReturnDecrpytLoc(firstItem, secondItem);
				
				for(Location loc : newLocs) {
					newPhrase += array[loc.GetColumn()][loc.GetRow()];
				}
			}
			return newPhrase;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	

	/**
	 * Finds the corresponding location of the first and second character.
	 * 
	 * @param first The first item to be located
	 * @param second The second item to be located
	 * @return Returns a pair of locations based on the original characters.
	 */
	public List<Location> ReturnEncrpyLoc (Location first, Location second) {
		
		List<Location> result = new ArrayList<Location>();
		
		if((first.GetColumn() != second.GetColumn()) && (first.GetRow() != second.GetRow())) {
			result.add(new Location(second.GetColumn(), first.GetRow()));
			result.add(new Location(first.GetColumn(), second.GetRow()));
			
			return result;
		}
		
		if((first.GetColumn() == second.GetColumn())) {
			
			if(first.GetRow() == 4) {
				result.add(new Location(first.GetColumn(), 0));
			} else {
				result.add(new Location(first.GetColumn(), first.GetRow() + 1));
			}
			
			if(second.GetRow() == 4) {
				result.add(new Location(second.GetColumn(), 0));
			} else {
				result.add(new Location(second.GetColumn(), second.GetRow() + 1));
			}
			return result;
		}
		
		if((first.GetRow() == second.GetRow())) {
			
			if(first.GetColumn() == 4) {
				result.add(new Location(0, first.GetRow()));
			} else {
				result.add(new Location(first.GetColumn() +1, first.GetRow()));
			}
			
			if(second.GetColumn() == 4) {
				result.add(new Location(0, second.GetRow()));
			} else {
				result.add(new Location(second.GetColumn()+1, second.GetRow()));
			}
			return result;
			}
		
			return null;
		}
	
public List<Location> ReturnDecrpytLoc (Location first, Location second) {
		
		List<Location> result = new ArrayList<Location>();
		
		if((first.GetColumn() != second.GetColumn()) && (first.GetRow() != second.GetRow())) {
			result.add(new Location(second.GetColumn(), first.GetRow()));
			result.add(new Location(first.GetColumn(), second.GetRow()));
			
			return result;
		}
		
		if((first.GetColumn() == second.GetColumn())) {
			
			if(first.GetRow() == 0) {
				result.add(new Location(first.GetColumn(), 4));
			} else {
				result.add(new Location(first.GetColumn(), first.GetRow() - 1));
			}
			
			if(second.GetRow() == 0) {
				result.add(new Location(second.GetColumn(), 4));
			} else {
				result.add(new Location(second.GetColumn(), second.GetRow() - 1));
			}
			return result;
		}
		
		if((first.GetRow() == second.GetRow())) {
			
			if(first.GetColumn() == 0) {
				result.add(new Location(4, first.GetRow()));
			} else {
				result.add(new Location(first.GetColumn() -1, first.GetRow()));
			}
			
			if(second.GetColumn() == 0) {
				result.add(new Location(4, second.GetRow()));
			} else {
				result.add(new Location(second.GetColumn()-1, second.GetRow()));
			}
			return result;
			}
		
			return null;
		}
}
