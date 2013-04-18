package caeser;
import java.util.Scanner;

import classes.Alphabet;
public class Caesar {

	public String caesarEncrypt(String plainText){

		int offset = 3;
		String plainTextLowerCase = plainText.toLowerCase();
		//String alphabet = "abcdefghijklmnopqrstuvwxyz";

		return caesarLoop(plainTextLowerCase, offset);
	}
	public String caesarLoop(String plainTextLowerCase, int offset){

		String encryption = new String();

		char[] alphabet = Alphabet.GetAlphabet(); 
		
		for (int i = 0; i < plainTextLowerCase.length(); i++){
			char t = plainTextLowerCase.charAt(i);
			int index = Alphabet.GetIndexOf(t);
			index += offset % 26;
			String add = null;
			if(index > 25)
			{
				add = Character.toString(alphabet[index - 26]);
			}
			else{ 
				add = Character.toString(alphabet[index]);
			}
			encryption += add;
		}

		return encryption;
	}

}