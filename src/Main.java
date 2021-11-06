/*
 * TODO:
 * - (?) Use BufferedWriter instead of scanner
 * - (?) Add Multiple maps
 */

/**
 * A text based roll playing game
 * <p>
 * Beat the boss to win.
 * Movement Controls:
 * n: move north
 * e: move east
 * s: move south
 * w: move west
 * 
 * @author Russell
 * @version 1.0
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean exit = false;
		char menu;
		Tile[][] map = {
				{new Tile(TileType.SE_CORNER, true), new Tile(TileType.S_TRI), new Tile(TileType.SW_CORNER), new LootTile(TileType.N_CUL, 1234), new Tile(TileType.BLANK), new Tile(TileType.BLANK), new Tile(TileType.BLANK), new Tile(TileType.BLANK)},
				{new Tile(TileType.E_TRI), new LootTile(TileType.QUAD, 1337), new Tile(TileType.QUAD), new Tile(TileType.W_TRI), new Tile(TileType.BLANK), new Tile(TileType.SE_CORNER), new Tile(TileType.SW_CORNER), new Tile(TileType.BLANK)},
				{new Tile(TileType.E_TRI), new Tile(TileType.N_TRI), new LootTile(TileType.NW_CORNER, 254), new Tile(TileType.E_TRI), new MobTile(TileType.EW_SINGLE, MobType.GOBLIN), new Tile(TileType.W_TRI), new Tile(TileType.E_TRI), new MobTile(TileType.E_CUL, MobType.ZOMBIE, true)},
				{new MobTile(TileType.NE_CORNER, MobType.BEAR), new Tile(TileType.EW_SINGLE), new Tile(TileType.EW_SINGLE), new Tile(TileType.NW_CORNER), new Tile(TileType.BLANK), new Tile(TileType.NE_CORNER), new Tile(TileType.NW_CORNER), new Tile(TileType.BLANK)}};
		Player player = new Player();
		
		loadData(player, map);
		Title.print();
		System.out.print("Press enter to start!");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
		// Game loop
		while(!exit) {
			map[player.getCurrTile().getX()][player.getCurrTile().getY()].drawSingle(player);
			if(player.hasEnded()) {
				File dataFile = new File("Data.txt"); 
				dataFile.delete();
				break;
			}
			map[player.getCurrTile().getX()][player.getCurrTile().getY()].listDirections();
			System.out.println("m:map, i:inventory, g:general_store, h:heal, q:quit");
			menu = scan.next().charAt(0);
			
			// Menu options
			switch(Character.toLowerCase(menu)) {
				// North
				case 'n':
					player.move(map, Directions.NORTH);
					break;
				// East
				case 'e':
					player.move(map, Directions.EAST);
					break;
				// South
				case 's':
					player.move(map, Directions.SOUTH);
					break;
				// West
				case 'w':
					player.move(map, Directions.WEST);
					break;
				// Map
				case 'm':
					drawMapAndPlayer(player, map);
					break;
				// Inventory
				case 'i':
					player.printInventory();
					break;
				// General Store
				case 'g':
					System.out.println("b:buy, s:sell, q:quit_store");
					menu = scan.next().charAt(0);
					switch(Character.toLowerCase(menu)) {
						// Buy
						case 'b':
							System.out.println("Select an item from the list.");
							for(int i = 0; i < player.getInv().size(); i++) {
								System.out.println(player.getInv().get(i).getName().substring(0,1) + ":" + player.getInv().get(i).getName() + " $" + player.getInv().get(i).getB_price());
							}
							menu = scan.next().charAt(0);
							for(Item i: player.getInv()) {
								if(i.getName().charAt(0) == menu) {
									System.out.println("How many " + i.getName() + "s do you want buy?");
									int amt = scan.nextInt();
									if(player.getCoins() >= i.getB_price()*amt) {
										i.setAmount(i.getAmount() + amt);
										player.setCoins(player.getCoins()-(i.getB_price()*amt));
									} else {
										System.out.println("You do not have enough money!");
									}
									break;
								}
							}
							break;
						// Sell
						case 's':
							System.out.println("Select an item from the list.");
							for(int i = 0; i < player.getInv().size(); i++) {
								System.out.println(player.getInv().get(i).getName().substring(0,1) + ":" + player.getInv().get(i).getName() + " $" + player.getInv().get(i).getS_price() + "( " + player.getInv().get(i).getAmount() + ")");
							}
							menu = scan.next().charAt(0);
							for(Item i: player.getInv()) {
								if(i.getName().charAt(0) == menu) {
									System.out.println("How many " + i.getName() + "s do you want to sell?");
									int amt = scan.nextInt();
									if(i.getAmount() >= amt) {
										i.setAmount(i.getAmount() - amt);
										player.setCoins(player.getCoins()+(i.getS_price()*amt));
									} else {
										System.out.println("You do not have enough " + i.getName() + "s !");
									}
									break;
								}
							}
							break;
						// Quit Store
						case 'q':
							break;
						default:
							System.out.println();
					}
					break;
				// Heal
				case 'h':
					player.usePotion();
					break;
				// Quit
				case 'q':
					exit = true;
					break;
				default:
					System.out.println("Error: Option not available.");
			}
			// Handle mob tile
			if(player.onMobTile(map)) {
				MobTile mt = (MobTile)map[player.getCurrTile().getX()][player.getCurrTile().getY()];
				if(mt.getMob().getHealth() > 0) {
					while(player.getHealth() > 0 && !mt.getMob().isDead()) {
						System.out.println("Player -> Health: " + player.getHealth());
						mt.drawSingle(player);
						System.out.println("s:Use sword, t:Use throwable");
						menu = scan.next().charAt(0);
						switch(Character.toLowerCase(menu)) {
							case 's':
								player.attack(mt.getMob());
								break;
							case 't':
								player.throwable(mt.getMob());
								break;
							default:
								System.out.println("Error: Option not available.");
						}
					}
				}
			}
			// Save all data
			saveData(player, map);
		}
		System.out.println("See you next time!");
		scan.close();
	}
	
	/**
	 * Load data
	 * @param p A player to load
	 * @param m A 2d tile array representing a map
	 */
	public static void loadData(Player p, Tile[][] m) {
		try {
			Scanner dataScanner = new Scanner(new File("Data.txt"));
			p.setCoins(dataScanner.nextInt());
			p.setHealth(dataScanner.nextShort());
			p.getCurrTile().set(dataScanner.nextInt(), dataScanner.nextInt());
			for(Item i: p.getInv()) {
				i.setAmount(dataScanner.nextInt());
			}
			for(int i = 0; i < m.length; i++) {
				for(int j = 0; j < m[0].length; j++) {
					if (dataScanner.nextBoolean() == true)
						m[i][j].discover(false);
					if(m[i][j] instanceof MobTile) {
						MobTile bs = (MobTile)m[i][j];
						bs.getMob().setHealth(dataScanner.nextShort());
					}
				}
			}
			dataScanner.close();
		} catch (Exception e) { saveData(p, m); }
	}
	
	/**
	 * Save data
	 * @param p A player to save
	 * @param m A 2d tile array representing a map
	 */
	public static void saveData(Player p, Tile[][] m) {
		try {
			PrintWriter writer = new PrintWriter("Data.txt", "UTF-8");
			writer.println(p.getCoins());
			writer.println(p.getHealth());
			writer.println(p.getCurrTile().getX() + " " + p.getCurrTile().getY());
			for(Item i: p.getInv()) {
				writer.print(i.getAmount() + " ");
		    }
			writer.println();
			for(int i = 0; i < m.length; i++) {
				for(int j = 0; j < m[0].length; j++) {
					writer.print(m[i][j].discovered() + " ");
					if(m[i][j] instanceof MobTile) {
						MobTile bs = (MobTile)m[i][j];
						writer.print(bs.getMob().getHealth() + " ");
					}
				}
			}
			writer.close();
		} catch (Exception e) {}
	}
	
	/**
	 * Draw map with player
	 * @param p A player to draw
	 * @param m A 2d tile array representing a map
	 */
	public static void drawMapAndPlayer(Player p, Tile[][] m) {
		String t = "";
		for(int j = 0; j < m.length; j++) {
			for(int k = 0; k < m[0][0].getSa().length; k++) {
				for(int l = 0; l < m[0].length; l++) {
					if(m[j][l].discovered()) {
						if(k == 3 && m[p.getCurrTile().getX()][p.getCurrTile().getY()] == m[j][l]) {
							StringBuilder sb = new StringBuilder(m[j][l].getSa()[k]);
							sb.setCharAt(m[j][l].getSa()[k].length()/2, 'x');
							t += sb.toString();
						} else {
							t += m[j][l].getSa()[k];
						}
					} else {
						t += Tile.getBlankTileArray()[k];
					}
				}
				System.out.println(t);
				t = "";
			}
		}
	}
}
