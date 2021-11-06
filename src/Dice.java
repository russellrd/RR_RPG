import java.util.Random;

/**
 * Dice Class
 * <p>Many variations of dice that can be rolled.
 */
public class Dice {
	private int sides, numDice, modifier;
	
	/**
	 * Constructor for Dice (1 Parameter)
	 * @param sides Number of sides on the die
	 */
	public Dice(int sides) {
		this.sides = sides;
		this.numDice = 1;
		this.modifier = 0;
	}
	
	/**
	 * Constructor for Dice (3 Parameters)
	 * @param sides Number of sides on the dice
	 * @param numDice Number of dice
	 * @param modifier Number added to a dice roll
	 */
	public Dice(int sides, int numDice, int modifier) {
		this.sides = sides;
		this.numDice = numDice;
		this.modifier = modifier;
	}
	
	/**
	 * Rolls dice with values from the constructor
	 * @return An integer containing the dice roll
	 */
	public int roll() {
		Random r = new Random();
		byte total = 0;
		for(int i = 0; i < numDice; i++) {
			total += r.nextInt(sides)+1;
		}
		return total+modifier;
	}
}
