package playfair;

public class FormatInput {

	FormatString fString = new FormatString();
	
	public String Format(String input) throws Exception {
		
		if(input.length() <=0) {
			throw new Exception("Input too short!");
		}
		
		input = input.toLowerCase();
		input = fString.RemoveSpaces(input);
		
		input = RemoveSpaces(input);
		
		if(input.length()%2==1) {
			input += "x";
		}
		
		return input;
	}
	
	/**
	 * Removes the spaces from the input string.
	 * 
	 * @param input The input
	 * @return A string with all the spaces removed
	 */
	public String RemoveSpaces(String input) {
		String result = "";
		int k = -1;
		
		for(int i = 0; i<input.length(); i++) {
			if(result.length() >= 1) {
				if(input.charAt(i) == result.charAt(k)) {
					if(i%2==1) {
						result += "x";
						k++;
					}
					
				}
			}
			result += input.charAt(i);
			k++;
		}
		return result;
	}
}
