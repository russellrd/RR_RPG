/**
 * Tile Class
 * <p>A tile that can be added to a map
 */
public class Tile {
	protected boolean discovered;
	protected TileType tt;
	protected String s_tile;
	protected String[] sa;
	protected char[] dirs;
	
	/**
	 * Constructor for Tile (1 Parameter)
	 * @param tt Tile type of tile
	 */
	public Tile(TileType tt) {
		this.tt = tt;
		discovered = false;
		setupTile();
		sa = s_tile.split("\n");
	}
	
	/**
	 * Constructor for Tile (2 Parameters)
	 * @param tt Tile type of tile
	 * @param discovered If tile is discovered
	 */
	public Tile(TileType tt, boolean discovered) {
		this.tt = tt;
		this.discovered = discovered;
		setupTile();
		sa = s_tile.split("\n");
	}
	
	protected void setupTile() {
		switch(tt) {
			case BLANK:
				s_tile = "                    \n"
					   + "                    \n"
					   + "                    \n"
					   + "                    \n"
					   + "                    \n"
					   + "                    \n"
					   + "                    \n";
				dirs = new char[]{};
				break;
			case QUAD:
				s_tile = "--------------------\n"
					   + "-       |   |      -\n"
					   + "-_______|   |______-\n"
					   + "-                  -\n"
					   + "-_______     ______-\n"
					   + "-       |   |      -\n"
					   + "--------------------\n";
				dirs = new char[]{'n','e','s','w'};
				break;
			case NS_SINGLE:
				s_tile = "--------------------\n"
					   + "-       |   |      -\n"
					   + "-       |   |      -\n"
					   + "-       |   |      -\n"
					   + "-       |   |      -\n"
					   + "-       |   |      -\n"
					   + "--------------------\n";
				dirs = new char[]{'n','s',};
				break;
			case EW_SINGLE:
				s_tile = "--------------------\n"
					   + "-                  -\n"
					   + "-__________________-\n"
					   + "-                  -\n"
					   + "-__________________-\n"
					   + "-                  -\n"
					   + "--------------------\n";
				dirs = new char[]{'e','w'};
				break;
			case N_TRI:
				s_tile = "--------------------\n"
					   + "-       |   |      -\n"
					   + "-_______|   |______-\n"
					   + "-                  -\n"
					   + "-__________________-\n"
					   + "-                  -\n"
					   + "--------------------\n";
				dirs = new char[]{'n','e','w'};
				break;
			case E_TRI:
				s_tile = "--------------------\n"
					   + "-       |   |      -\n"
					   + "-       |   |______-\n"
					   + "-       |          -\n"
					   + "-       |    ______-\n"
					   + "-       |   |      -\n"
					   + "--------------------\n";
				dirs = new char[]{'n','e','s'};
				break;
			case S_TRI:
				s_tile = "--------------------\n"
					   + "-                  -\n"
					   + "-__________________-\n"
					   + "-                  -\n"
					   + "-_______     ______-\n"
					   + "-       |   |      -\n"
					   + "--------------------\n";
				dirs = new char[]{'e','s','w'};
				break;
			case W_TRI:
				s_tile = "--------------------\n"
					   + "-       |   |      -\n"
					   + "-_______|   |      -\n"
					   + "-           |      -\n"
					   + "-_______    |      -\n"
					   + "-       |   |      -\n"
					   + "--------------------\n";
				dirs = new char[]{'n','s','w'};
				break;
			case SW_CORNER:
				s_tile = "--------------------\n"
					   + "-                  -\n"
					   + "-___________       -\n"
					   + "-           |      -\n"
					   + "-_______    |      -\n"
					   + "-       |   |      -\n"
					   + "--------------------\n";
				dirs = new char[]{'s','w'};
				break;
			case SE_CORNER:
				s_tile = "--------------------\n"
					   + "-                  -\n"
					   + "-        __________-\n"
					   + "-       |          -\n"
					   + "-       |    ______-\n"
					   + "-       |   |      -\n"
					   + "--------------------\n";
				dirs = new char[]{'e','s'};
				break;
			case NW_CORNER:
				s_tile = "--------------------\n"
					   + "-       |   |      -\n"
					   + "-_______|   |      -\n"
					   + "-           |      -\n"
					   + "-___________|      -\n"
					   + "-                  -\n"
					   + "--------------------\n";
				dirs = new char[]{'n','w'};
				break;
			case NE_CORNER:
				s_tile = "--------------------\n"
					   + "-       |   |      -\n"
					   + "-       |   |______-\n"
					   + "-       |          -\n"
					   + "-       |__________-\n"
					   + "-                  -\n"
					   + "--------------------\n";
				dirs = new char[]{'n','e'};
				break;
			case N_CUL:
				s_tile = "--------------------\n"
					   + "-        ___       -\n"
					   + "-       |   |      -\n"
					   + "-       |   |      -\n"
					   + "-       |   |      -\n"
					   + "-       |   |      -\n"
					   + "--------------------\n";
				dirs = new char[]{'s'};
				break;
			case E_CUL:
				s_tile = "--------------------\n"
					   + "-                  -\n"
					   + "-_______________   -\n"
					   + "-               |  -\n"
					   + "-_______________|  -\n"
					   + "-                  -\n"
					   + "--------------------\n";
				dirs = new char[]{'w'};
				break;
			case S_CUL:
				s_tile = "--------------------\n"
					   + "-       |   |      -\n"
					   + "-       |   |      -\n"
					   + "-       |   |      -\n"
					   + "-       |___|      -\n"
					   + "-                  -\n"
					   + "--------------------\n";
				dirs = new char[]{'n'};
				break;
			case W_CUL:
				s_tile = "--------------------\n"
					   + "-                  -\n"
					   + "-   _______________-\n"
					   + "-  |               -\n"
					   + "-  |_______________-\n"
					   + "-                  -\n"
					   + "--------------------\n";
				dirs = new char[]{'e'};
				break;
			default:
				System.out.println("Error: TileType does not exist!");
		}
	}
	
	/**
	 * Gets a blank tile in the form of an array
	 * @return A string array of a blank tile
	 */
	public static String[] getBlankTileArray() {
		String s = "                    \n"
				 + "                    \n"
				 + "                    \n"
				 + "                    \n"
			 	 + "                    \n"
			 	 + "                    \n"
			 	 + "                    \n";
		return s.split("\n");
	}
	
	/**
	 * Discovers tile
	 * @param p A boolean representing if discovered message should be printed
	 */
	public void discover(boolean p) {
		if(p)
			System.out.println("Tile has been discovered!");
		discovered = true;
	}
	
	/**
	 * Determine if tile has been discovered
	 * @return A boolean representing if tile has been discovered
	 */
	public boolean discovered() {
		return discovered;
	}
	
	/**
	 * Draw tile
	 * @param p A player 
	 */
	public void drawSingle(Player p) {
		System.out.print(s_tile);
	}
	
	/**
	 * Lists possible directions for player to move
	 */
	public void listDirections() {
		for(char c: dirs) {
			System.out.print(c + ", ");
		}
	}

	/**
	 * Gets the string array of tile
	 * @return A string array of tile
	 */
	public String[] getSa() {
		return sa;
	}

	/**
	 * Gets the possible movement directions
	 * @return A character array of possible movement directions
	 */
	public char[] getDirs() {
		return dirs;
	}
}
