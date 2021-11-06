/**
 * LootTile Class
 * <p>A tile with coins
 */
public class LootTile extends Tile{
	private int coins;
	
	/**
	 * Constructor for LootTile
	 * @param tt Tile type of tile
	 * @param coins Number of coins on the tile
	 */
	public LootTile(TileType tt, int coins) {
		super(tt);
		this.coins = coins;
	}

	/**
	 * Gets the number of coins on the tile
	 * @return An integer representing the number of coins
	 */
	public int getCoins() {
		return coins;
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
					   + "-       | $ |      -\n"
					   + "-_______|   |______-\n"
					   + "-                  -\n"
					   + "-_______     ______-\n"
					   + "-       |   |      -\n"
					   + "--------------------\n";
				dirs = new char[]{'n','e','s','w'};
				break;
			case NS_SINGLE:
				s_tile = "--------------------\n"
					   + "-       | $ |      -\n"
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
					   + "-              $   -\n"
					   + "-__________________-\n"
					   + "-                  -\n"
					   + "--------------------\n";
				dirs = new char[]{'e','w'};
				break;
			case N_TRI:
				s_tile = "--------------------\n"
					   + "-       | $ |      -\n"
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
					   + "-       |   $      -\n"
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
					   + "-       | $ |      -\n"
					   + "--------------------\n";
				dirs = new char[]{'e','s','w'};
				break;
			case W_TRI:
				s_tile = "--------------------\n"
					   + "-       |   |      -\n"
					   + "-_______|   |      -\n"
					   + "-       $   |      -\n"
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
					   + "-       | $ |      -\n"
					   + "--------------------\n";
				dirs = new char[]{'s','w'};
				break;
			case SE_CORNER:
				s_tile = "--------------------\n"
					   + "-                  -\n"
					   + "-        __________-\n"
					   + "-       |          -\n"
					   + "-       |    ______-\n"
					   + "-       | $ |      -\n"
					   + "--------------------\n";
				dirs = new char[]{'e','s'};
				break;
			case NW_CORNER:
				s_tile = "--------------------\n"
					   + "-       | $ |      -\n"
					   + "-_______|   |      -\n"
					   + "-           |      -\n"
					   + "-___________|      -\n"
					   + "-                  -\n"
					   + "--------------------\n";
				dirs = new char[]{'n','w'};
				break;
			case NE_CORNER:
				s_tile = "--------------------\n"
					   + "-       | $ |      -\n"
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
					   + "-       | $ |      -\n"
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
					   + "-             $ |  -\n"
					   + "-_______________|  -\n"
					   + "-                  -\n"
					   + "--------------------\n";
				dirs = new char[]{'w'};
				break;
			case S_CUL:
				s_tile = "--------------------\n"
					   + "-       | $ |      -\n"
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
					   + "-  |$              -\n"
					   + "-  |_______________-\n"
					   + "-                  -\n"
					   + "--------------------\n";
				dirs = new char[]{'e'};
				break;
			default:
				System.out.println("Error: TileType does not exist!");
		}
	}
}
