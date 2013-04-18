package playfair;

import java.util.ArrayList;
import java.util.List;

import classes.Alphabet;

/**
 * Formats the String for the cipher array.
 * 
 * @author 40009037
 *
 */
public class FormatString {

	/**
	 * This class will remove all duplicate chars from the keyword and then remove all escaped characters
	 * 
	 * @param keyword This is the keyword to be used for the cipher
	 * @return A string with all duplicates and punctuation removed.
	 * @throws Exception If the keyword is too short
	 */
	public String RemoveDuplicates(String keyword) throws Exception {
		
		if(keyword.length() <=0) {
			throw new Exception("Keyword too short!");
		}
		
		String a = "";
		char[] keywordArray = new char[keyword.length()];
		int k = 0;
		
		for(int i = 0; i<keyword.length(); i++) {
			boolean check = false;
			
			for(int j = 0; j<keywordArray.length; j++) {
				if(keyword.charAt(i) == (keywordArray[j])) {
					check = true;
					break;
				}
			}
			
			if(!check) {
				a += keyword.charAt(i);
				keywordArray[k] = keyword.charAt(i);
				k++;
			}
		}
		
		String result = RemoveSpaces(a);
		
		return result;
	}
	
	/**
	 * Removes all punctuation and spaces from the keyword.
	 * 
	 * @param keyword The keyword to be used by the cipher.
	 * @return A string with no spaces or punctuation.
	 */
	public String RemoveSpaces(String keyword) {
		
		String keywordArray = "";
		char[] punctuationArray = Alphabet.GetDeadChars();
		
		for(int i = 0; i<keyword.length(); i++) {
			boolean check = false;
			
			for(int j = 0; j<punctuationArray.length; j++) {
				if(keyword.charAt(i) == (punctuationArray[j])) {
					check = true;
					break;
				}
			}
			if(!check) {
				keywordArray += keyword.charAt(i);
				
			}
		}
		return keywordArray;
	}
	
	/**
	 * Checks the keyword to make sure it is valid.
	 * 
	 * @param keyword The keyword to be used
	 * @return Returns a boolean based on whether or not the keyword is valid.
	 */
	public boolean CheckKeyword(String keyword) {
		boolean check = false;
		boolean result = false;
		
		for(int i = 0; i < keyword.length(); i++) {
			if (keyword.charAt(i) == 'i') {
				check = true;
				break;
			}
		}
		
		if(check) {
			for(int i = 0; i < keyword.length(); i++) {
				if (keyword.charAt(i) == 'j') {
					result = true;
					break;
				}
			}
		}
		
		return result;
	}
	
	/**
	 * Checks the keyword to see if it is more than one word.
	 * 
	 * @param keyword The keyword being used
	 * @return a boolean depending on whether or not there are spaces in the keyword.
	 */
	public boolean CheckForSpace(String keyword) {
		String[] splitKey = keyword.split(" ");
		
		if(splitKey.length > 1) {
			return true;
		} else {
			return false;
		}
	}
}
