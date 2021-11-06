import java.util.ArrayList;

/**
 * Player Class
 * <p>A player with many features
 */
public class Player {
	private int coins;
	private short health;
	private Dice atkDice;
	private Dice thrDice;
	private ArrayList<Item> inv;
	private Position currTile;
	private boolean ending;
	
	/**
	 * Constructor for Player
	 */
	public Player() {
		ending = false;
		reset();
	}
	
	private void reset() {
		coins = 0;
		health = 100;
		atkDice = new Dice(10, 2, 3);
		thrDice = new Dice(10, 4, 5);
		inv = new ArrayList<Item>();
		inv.add(new Item("potion", 3, 50, 25));
		inv.add(new Item("throwable", 1, 200, 100));
		currTile = new Position(0,0);
	}
	
	/**
	 * Determine if player has reached the end state
	 * @return A boolean representing if player has reached the end state
	 */
	public boolean hasEnded() {
		return ending;
	}
	
	/**
	 * Gets the number of player's coins
	 * @return An integer representing the number of coins the player has
	 */
	public int getCoins() {
		return coins;
	}

	/**
	 * Sets the number of player's coins
	 * @param coins An integer containing the new number of the player's coins
	 */
	public void setCoins(int coins) {
		this.coins = coins;
	}

	/**
	 * Gets the player's current tile
	 * @return A position representing the player's current tile
	 */
	public Position getCurrTile() {
		return currTile;
	}

	/**
	 * Sets the player's current tile
	 * @param currTile A position representing the player's new current tile 
	 */
	public void setCurrTile(Position currTile) {
		this.currTile = currTile;
	}
	
	/**
	 * Determine if current tile is a mob tile
	 * @param m A 2d tile array representing a map
	 * @return A boolean representing if player is currently on a mob tile
	 */
	public boolean onMobTile(Tile[][] m) {
		return (m[currTile.getX()][currTile.getY()] instanceof MobTile);
	}
	
	/**
	 * Determine if current tile is a loot tile
	 * @param m A 2d tile array representing a map
	 * @return A boolean representing if player is currently on a loot tile
	 */
	public boolean onLootTile(Tile[][] m) {
		return (m[currTile.getX()][currTile.getY()] instanceof LootTile);
	}

	/**
	 * Gets the inventory
	 * @return An arraylist of items representing an inventory
	 */
	public ArrayList<Item> getInv() {
		return inv;
	}
	
	/**
	 * Prints the player's inventory
	 */
	public void printInventory() {
		System.out.println("====================");
		System.out.println("Health: " + health);
		System.out.println("Coins: " + coins);
		System.out.println("--------------------");
		for(Item i: inv) {
	        System.out.println(i.getName() + ": " + i.getAmount());
	    }
		System.out.println("====================");
	}
	
	/**
	 * Moves the player to a new tile
	 * @param m A 2d tile array representing a map
	 * @param dir A direction to move
	 */
	public void move(Tile[][] m, Directions dir) {
		try {
			switch(dir) {
				case NORTH:
					if(contains(m[currTile.getX()-1][currTile.getY()].getDirs(), 's')) {
						currTile.set(currTile.getX()-1, currTile.getY());
					} else { throw new Exception(); }
					break;
				case EAST:
					if(contains(m[currTile.getX()][currTile.getY()+1].getDirs(), 'w')) {
						currTile.set(currTile.getX(), currTile.getY()+1);
					} else { throw new Exception(); }
					break;
				case SOUTH:
					if(contains(m[currTile.getX()+1][currTile.getY()].getDirs(), 'n')) {
						currTile.set(currTile.getX()+1, currTile.getY());
					} else { throw new Exception(); }
					break;
				case WEST:
					if(contains(m[currTile.getX()][currTile.getY()-1].getDirs(), 'e')) {
						currTile.set(currTile.getX(), currTile.getY()-1);
					} else { throw new Exception(); }
					break;
				default:
					System.out.println("Error: Direction does not exist!");
			}
			if(m[currTile.getX()][currTile.getY()] instanceof LootTile && !m[currTile.getX()][currTile.getY()].discovered()) {
				LootTile ls = (LootTile)m[currTile.getX()][currTile.getY()];
				coins += ls.getCoins();
				System.out.println("You found " + coins + " coins!");
			}
			if(!m[currTile.getX()][currTile.getY()].discovered()) {
				m[currTile.getX()][currTile.getY()].discover(true);
			}
		} catch (Exception e) { System.out.println("Error: You can not go that direction!"); }
	}
	
	/**
	 * Check if character is in an array of characters
	 * @param characters A character array to be searched through
	 * @param character A character to search for
	 * @return A boolean representing if the character is in the array of characters
	 */
	public static boolean contains(char[] characters, char character) {
        for(int c : characters){
            if(c == character){
                return true;
            }
        }
        return false;
    }
	
	/**
	 * Attack a mob with attack dice
	 * @param m A mob to attack
	 */
	public void attack(Mob m) {
		m.setHealth((short)(m.getHealth()-atkDice.roll()));
		if(m.getHealth() > 0) {
			m.attack(this);
		}
	}
	
	/**
	 * Attack a mob with throwable dice
	 * @param m A mob to attack
	 */
	public void throwable(Mob m) {
		for(Item i: inv) {
			if(i.getName() == "throwable") {
				if(i.getAmount() > 0) {
					m.setHealth((short)(m.getHealth()-thrDice.roll()));
					m.attack(this);
					i.setAmount(i.getAmount()-1);
				} else {
					System.out.println("You do not have any more throwables!");
				}
			}
		}
	}
	
	/**
	 * Win game
	 */
	public void win() {
		ending = true;
		System.out.println("You have beat the final boss!");
		System.out.println("Thank you for playing.");
		System.out.println("Credits: Russell");
	}
	
	/**
	 * Kill player
	 */
	private void die() {
		ending = true;
		System.out.println("You died!");
		System.out.println("Thank you for playing.");
	}
	
	/**
	 * Gets player health
	 * @return A short representing the player's health
	 */
	public short getHealth() {
		return health;
	}
	
	/**
	 * Heal player
	 */
	private void heal() {
		this.health = 100;
	}
	
	/**
	 * Use a potion to heal player
	 */
	public void usePotion() {
		for(Item i: inv) {
			if(i.getName() == "potion") {
				if(i.getAmount() > 0) {
					if(health < 100) {
						heal();
						i.setAmount(i.getAmount()-1);
						System.out.println("You are now at max health!");
					} else {
						System.out.println("You are already at max health!");
					}
				} else {
					System.out.println("You have no potions!");
				}
			}
		}
	}

	/**
	 * Sets the health of the player
	 * @param health A short containing the new health for the player
	 */
	public void setHealth(short health) {
		if(health > 100) {
			this.health = 100;
		} else if(health <= 0) {
			this.health = 0;
			die();
		} else {
			this.health = health;
		}
	}
}
