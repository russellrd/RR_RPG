/**
 * Item Class
 * <p>Custom items that can be used in an inventory
 */
public class Item {
	private String name;
	private int amount;
	private int b_price;
	private int s_price;
	
	/**
	 * Constructor for Item
	 * @param name Name of item
	 * @param amount Amount of items
	 * @param b_price Buy price of item
	 * @param s_price Sell price of item
	 */
	public Item(String name, int amount, int b_price, int s_price) {
		this.name = name;
		this.amount = amount;
		this.b_price = b_price;
		this.s_price = s_price;
	}

	/**
	 * Gets the item name
	 * @return A string of the item name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the item name
	 * @param name A string that contains the new item name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the quantity of a given item 
	 * @return An integer containing the quantity of item
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Sets the quantity of a given item
	 * @param amount An integer containing the quantity of item
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * Gets the buy price of item
	 * @return An integer representing the buy price
	 */
	public int getB_price() {
		return b_price;
	}

	/**
	 * Gets the sell price of item
	 * @return An integer representing the sell price
	 */
	public int getS_price() {
		return s_price;
	}
}
