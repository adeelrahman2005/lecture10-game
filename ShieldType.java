/**
 * A shield that reduces the damage a SuperWarrior takes. SuperWarrior holds
 * one as a field, which is composition.
 */
public class ShieldType {

	/** 
	 * Lowest durability allowed. Kept at 1 because SuperWarrior divides by it.
	 */
	public static final int MIN_DURABILITY = 1;

	/** 
	 * The shield's current durability, which controls how much damage is reduced.
	 */
	private int durability; // private so it can only change through the methods below

	/**
	 * Creates a shield with the given durability.
	 * @param durability the starting durability, raised to MIN_DURABILITY if smaller
	 */
	public ShieldType(int durability) {
		if (durability < MIN_DURABILITY)
			durability = MIN_DURABILITY;
		this.durability = durability;
	}

	/**
	 * Returns the shield's current durability.
	 * @return the durability
	 */
	public int getDurability() {
		return durability;
	}

	/**
	 * Wears the shield down, never going below MIN_DURABILITY.
	 * @param decrement how much durability to remove
	 */
	public void decreaseDurability(int decrement) {
		durability = durability - decrement;
		if (durability < MIN_DURABILITY)
			durability = MIN_DURABILITY; // prevents SuperWarrior from dividing by zero
	}
}
