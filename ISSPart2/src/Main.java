import java.util.Scanner;
import caeser.Caesar;
import playfair.*;

public class Main {

	public static void main(String[] args){

		Caesar caesar = new Caesar();
		EncryptPlayFair fairplay = new EncryptPlayFair();
		
		Scanner plainTextInput = new Scanner(System.in);
		System.out.println("Please enter your plaintext to be encrypted: ");

		String plainText = plainTextInput.nextLine();

		String output = caesar.caesarEncrypt(plainText);
		System.out.println("\nThe plaintext " + plainText + " has been encrypted to: " + output);
		
		try {
			System.out.println(fairplay.FindEncryption("Hello there Craig. I hope today finds you well my man", "Trivial"));
			System.out.println(fairplay.FindDecryption("mccubnifbalditrhcppqlaqbvzhtqlqznwzbffkzsepu", "Trivial"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}