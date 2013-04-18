package playfair;

import java.util.ArrayList;
import java.util.List;

import classes.Alphabet;
import classes.Location;

public class PopulateArray {

	char[][] playfairArray = new char[5][5];
	FormatString formatString = new FormatString();
	
	/**
	 * Populates a 2D array with both the keyword and the alphabet remaining afterwards.
	 * 
	 * @param keyword The keyword for the array
	 * @return A 2D char array containing the items
	 * @throws Exception If the keyword is too short or contains both I and J.
	 */
	public char[][] PopulatePlayfairArray(String keyword) throws Exception {
		
		keyword = keyword.toLowerCase();
		
		CheckKeyword(keyword);
		
		String forKeyword = formatString.RemoveDuplicates(keyword);
		forKeyword = AddAlphabet(forKeyword);
			
		int column = 0;
		int row = 0;
		
		for(int i = 0; i<forKeyword.length(); i++) {
			
			if((row%4!=0) || (row==0)) {
				playfairArray[row][column] = forKeyword.charAt(i);
				row++;
			} else {
				playfairArray[row][column] = forKeyword.charAt(i);
				column++;
				row = 0;
			}
		}
		return playfairArray;
	}
	
	/**
	 * Adds the rest of the alphabet to the keyword.
	 * 
	 * @param keyword The keyword to which the alphabet is to be added
	 * @return A string containing the keyword at the front and then the rest of the alphabet appended afterwards.
	 */
	public String AddAlphabet(String keyword) {
		
		char[] alphabet = Alphabet.GetPlayfairAlphabet();
		//Need to add escape character at the end or else the string may not split correctly.
		keyword += "_";
		
		for(int i = 0; i < alphabet.length; i++) {
			String[] split = keyword.split(new String(new char [] {alphabet[i]}));
			
			if(split.length <= 1) {
				if(keyword.contains("_")) {
					String[] secondSplit = keyword.split("_");
					keyword = secondSplit[0];
				}
			
				keyword+=alphabet[i];
				
			} else {
				if(keyword.contains("_")) {
					String[] secondSplit = keyword.split("_");
					keyword = secondSplit[0];
				}
			}
		}
		
		return keyword;
	}
	
	/**
	 * Checks the keyword to make sure it is not to short, or that it contains spaces, i AND j together.
	 * 
	 * @param keyword The keyword to be used
	 * @throws Exception Throws a generic exception if any of the failure conditions are met.
	 */
	private void CheckKeyword(String keyword) throws Exception {
		if(keyword.length() <=0) {
			throw new Exception("Keyword too short!");
		}
		
		if(formatString.CheckKeyword(keyword)) {
			throw new Exception("Keyword contains both I and J!");
		}
		
		if(formatString.CheckForSpace(keyword)) {
			throw new Exception("Keyword cannot be more than one word");
		}
	}
	
	/**
	 * Returns the co-ordinates of the char specified in the specified array.
	 * 
	 * @param Char The character being searched for. 
	 * @param array The array being searched for
	 * @return A list of two integers. The first is the column and the second is the row.
	 * @throws Exception If the char cannot be found then an exception is thrown.
	 */
	public Location FindChar(char Char, char[][] array) throws Exception {
		
		Location loc = null;
		boolean check = false;
		
		for(int i = 0; i<array[0].length; i++) {
					
			for(int j = 0; j<array[1].length; j++) {
				
				char test = array[j][i]; 
				
				if(array[j][i] == Char) {
					loc = new Location(j, i);
					check = true;
					break;
				} else if(array[j][i] == 'i') {
					if(Char == 'j') {
						loc = new Location(j, i);
						check = true;
						break;
					}
				}
			}
			if(check) {
				break;
			}
			
		}
		if(loc == null) {
			throw new Exception ("Unable to find char: " + Char);
		} else {
			return loc;
		}
	}
}
