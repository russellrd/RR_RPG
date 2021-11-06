/**
 * Mob Class
 * <p>Entities with the ability to attack and be attacked
 */
public class Mob {
	private short MAX_HEALTH;
	private short health;
	private Dice atkDice;
	private boolean dead;
	
	/**
	 * Constructor for Mob
	 * @param mt Type of mob
	 */
	public Mob(MobType mt) {
		switch(mt) {
			case ZOMBIE:
				MAX_HEALTH = 30;
				atkDice = new Dice(20, 1, 2);
				break;
			case BEAR:
				MAX_HEALTH = 80;
				atkDice = new Dice(10, 10, 5);
				break;
			case GOBLIN:
				MAX_HEALTH = 20;
				atkDice = new Dice(8, 2, 2);
				break;
			default:
				System.out.println("Error: MobType does not exist!");
		}
		health = MAX_HEALTH;
		dead = false;
	}
	
	/**
	 * Attack a player with attack dice
	 * @param p A player to attack
	 */
	public void attack(Player p) {
		p.setHealth((short)(p.getHealth()-atkDice.roll()));
	}
	
	/**
	 * Kill mob
	 */
	private void die() {
		dead = true;
	}
	
	/**
	 * Gets the health of mob
	 * @return A short representing the health of mob
	 */
	public short getHealth() {
		return health;
	}
	
	/**
	 * Gets the dead state of mob
	 * @return A boolean representing if the mob is dead
	 */
	public boolean isDead() {
		return dead;
	}
	
	/**
	 * Sets the health of mob
	 * @param health A short containing the new health for mob
	 */
	public void setHealth(short health) {
		if(health > MAX_HEALTH) {
			this.health = MAX_HEALTH;
		} else if(health <= 0) {
			this.health = 0;
			die();
		} else {
			this.health = health;
		}
	}
}
