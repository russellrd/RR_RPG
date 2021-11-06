/**
 * MobTile Class
 * <p>A tile with a mob
 */
public class MobTile extends Tile{
	private MobType mt;
	private Mob mob;
	private boolean bossTile;
	
	/**
	 * Constructor for MobTile (2 Parameters)
	 * @param tt Tile type of tile
	 * @param mt Type of mob
	 */
	public MobTile(TileType tt, MobType mt) {
		super(tt);
		bossTile = false;
		this.mt = mt;
		mob = new Mob(mt);
	}
	
	/**
	 * Constructor for MobTile (3 Parameters)
	 * @param tt Tile type of tile
	 * @param mt Type of mob
	 * @param bossTile If mob on tile is a boss
	 */
	public MobTile(TileType tt, MobType mt, boolean bossTile) {
		super(tt);
		if(bossTile) {
			StringBuilder sb = new StringBuilder(s_tile);
			sb.replace(1, 19, "==================");
			sb.replace(127, 145, "==================");
			s_tile = sb.toString();
		}
		this.mt = mt;
		mob = new Mob(mt);
		this.bossTile = bossTile;
		
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
					   + "-       | (=|      -\n"
					   + "-_______|   |______-\n"
					   + "-                  -\n"
					   + "-_______     ______-\n"
					   + "-       |   |      -\n"
					   + "--------------------\n";
				dirs = new char[]{'n','e','s','w'};
				break;
			case NS_SINGLE:
				s_tile = "--------------------\n"
					   + "-       | (=|      -\n"
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
					   + "-              (=  -\n"
					   + "-__________________-\n"
					   + "-                  -\n"
					   + "--------------------\n";
				dirs = new char[]{'e','w'};
				break;
			case N_TRI:
				s_tile = "--------------------\n"
					   + "-       | (=|      -\n"
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
					   + "-       |   (=     -\n"
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
					   + "-       | (=|      -\n"
					   + "--------------------\n";
				dirs = new char[]{'e','s','w'};
				break;
			case W_TRI:
				s_tile = "--------------------\n"
					   + "-       |   |      -\n"
					   + "-_______|   |      -\n"
					   + "-      (=   |      -\n"
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
					   + "-       | (=|      -\n"
					   + "--------------------\n";
				dirs = new char[]{'s','w'};
				break;
			case SE_CORNER:
				s_tile = "--------------------\n"
					   + "-                  -\n"
					   + "-        __________-\n"
					   + "-       |          -\n"
					   + "-       |    ______-\n"
					   + "-       | (=|      -\n"
					   + "--------------------\n";
				dirs = new char[]{'e','s'};
				break;
			case NW_CORNER:
				s_tile = "--------------------\n"
					   + "-       | (=|      -\n"
					   + "-_______|   |      -\n"
					   + "-           |      -\n"
					   + "-___________|      -\n"
					   + "-                  -\n"
					   + "--------------------\n";
				dirs = new char[]{'n','w'};
				break;
			case NE_CORNER:
				s_tile = "--------------------\n"
					   + "-       | (=|      -\n"
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
					   + "-       | (=|      -\n"
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
					   + "-             (=|  -\n"
					   + "-_______________|  -\n"
					   + "-                  -\n"
					   + "--------------------\n";
				dirs = new char[]{'w'};
				break;
			case S_CUL:
				s_tile = "--------------------\n"
					   + "-       | (=|      -\n"
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
					   + "-  |(=             -\n"
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
	 * Gets mob object
	 * @return A mob object
	 */
	public Mob getMob() {
		return mob;
	}
	
	/**
	 * Sets mob object
	 * @param mob A mob object
	 */
	public void setMob(Mob mob) {
		this.mob = mob;
	}

	/**
	 * Determine if mob is a boss
	 * @return A boolean representing if mob is a boss
	 */
	public boolean isBoss() {
		return bossTile;
	}
	
	/**
	 * Draw Tile with player and mob health
	 */
	public void drawSingle(Player p) {
		if(mob.isDead()) {
			if(bossTile) {
				p.win();
			} else {
				System.out.println(mt + " -> Dead");
				System.out.print(s_tile);
			}
		} else {
			if(p.getHealth() > 0) {
				System.out.println(mt + " -> Health: " + mob.getHealth());
				System.out.print(s_tile);
			}
		}
	}
}
