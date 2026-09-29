/**
 * A potion that increases attack points. Extends Potion and implements
 * getValue() differently from BluePotion by doubling its value.
 */
public class RedPotion extends Potion {

	/** Multiplier applied to the base value, kept as a named constant. */
	public static final int MULTIPLIER = 2;

	/**
	 * Creates a red potion.
	 * @param value the base strength
	 */
	public RedPotion(int value) {
		super(value);
	}

	/**
	 * Returns how many attack points this potion adds.
	 * @return double the base value
	 */
	@Override
	public int getValue() {
		return MULTIPLIER * this.value;
	}
}
