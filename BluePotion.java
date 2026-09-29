/**
 * A potion that restores HP. Extends Potion and implements getValue().
 */
public class BluePotion extends Potion {

	/**
	 * Creates a blue potion.
	 * @param value the amount of HP it restores
	 */
	public BluePotion(int value) {
		super(value); // reuse Potion's constructor, including its validation
	}

	/**
	 * Returns how much HP this potion restores.
	 * @return the base value
	 */
	@Override // confirms this method overrides Potion.getValue()
	public int getValue() {
		return this.value;
	}
}
