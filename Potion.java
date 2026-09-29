/**
 * An abstract potion. It can't be created directly; subclasses like BluePotion
 * and RedPotion must implement getValue().
 */
public abstract class Potion {

	/** Smallest strength a potion can have. */
	public static final int MIN_VALUE = 1;

	/** The potion's base strength. */
	protected int value;

	/**
	 * Sets the potion's strength. Called by subclasses using super(value).
	 * @param value the base strength, raised to MIN_VALUE if smaller
	 */
	public Potion(int value) {
		// Ensure the potion has at least the minimum allowed strength. The parameter
		// is corrected before it is stored, so the field is assigned only once.
		if (value < MIN_VALUE)
			value = MIN_VALUE;
		this.value = value;
	}

	/**
	 * Returns the effect of this potion. Abstract, so each subclass defines it.
	 * @return the amount this potion changes a stat by
	 */
	public abstract int getValue();
}
