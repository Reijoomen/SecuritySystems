package classes;

public class Location {

	private Integer Column;
	private Integer Row;
	
	/**
	 * An object intended to store the column and row number of a single letter.
	 * 
	 * @param c The column number
	 * @param r The row number
	 */
	public Location(int c, int r) {
		Column = c;
		Row = r;
	}
	
	public int GetColumn() {
		return Column;
	}
	
	public int GetRow() {
		return Row;
	}
}
