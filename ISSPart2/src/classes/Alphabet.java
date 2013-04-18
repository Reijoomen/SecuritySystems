package classes;

/**
 * The class which stores punctuation and the alphabet for the system
 * 
 * @author 40009037
 *
 */
public class Alphabet {
	private static char[] playFairAlphabet = {'a','b','c', 'd', 'e','f','g', 'h', 'i', 'k', 'l', 
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
	private static char[] alphabet = {'a','b','c', 'd', 'e','f','g', 'h', 'i', 'j', 'k', 'l', 
		'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
	private static char[] punctuationArray = {' ', '@', ';',':','\'','#','~','?','/','>','.','<',',','\\','|',
			'!','\"','£','$','%','^','&','*','(',')','-','+','0','1','2','3','4','5','6','7','8','9',
			'`','¬','=','_','/','}','{','}', '[', ']'};
	
	/**
	 * Returns the alphabet
	 * @return A char[26] array with the alphabet
	 */
	public static char[] GetAlphabet() {
		return alphabet;
	}
	
	public static char[] GetPlayfairAlphabet() {
		return playFairAlphabet;
	}
	
	/**
	 * Returns the punctuation on the keyboard
	 * @return A char array with all the characters.
	 */
	public static char[] GetDeadChars() {
		return punctuationArray;
	}
	
	public static int GetIndexOf(char t) {
		for(int i = 0; i < alphabet.length; i++) {
			if(alphabet[i] == t) {
				return i;
			}
		}
		return -1;
	}
}