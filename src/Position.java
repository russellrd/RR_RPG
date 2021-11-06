/**
 * Position Class
 * <p>A position with 2d coordinates
 */
public class Position {
	private int x, y;
	
	/**
	 * Constructor for Position
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Sets the x and y coordinates
	 * @param x An integer representing x coordinate
	 * @param y An integer representing y coordinate
	 */
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets the x coordinate
	 * @return An integer representing x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x coordinate
	 * @param x An integer representing x coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y coordinate
	 * @return An integer representing y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y coordinate
	 * @param y An integer representing y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}
}
