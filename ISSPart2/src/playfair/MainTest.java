package playfair;

public class MainTest {

	public static void main(String[] args) {
		
		EncryptPlayFair fairplay = new EncryptPlayFair();
		
		try {
			System.out.println(fairplay.FindEncryption("Hello there Craig. I hope today finds you well my man", "Trivial"));
			System.out.println(fairplay.FindDecryption("mccubnifbalditrhcppqlaqbvzhtqlqznwzbffkzsepu", "Trivial"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*public static String toBinaryString(String s) {

	    char[] cArray=s.toCharArray();

	    StringBuilder sb=new StringBuilder();
	    sb.append("0");
	    
	    for(char c:cArray)
	    {
	        String cBinaryString=Integer.toBinaryString((int)c);
	        sb.append(cBinaryString);
	    }

	    return sb.toString();
	}
	
	public static String toText(String info) {
		int charCode = Integer.parseInt(info, 2);
		String str = new Character((char)charCode).toString();
		return str;
	}*/
}
