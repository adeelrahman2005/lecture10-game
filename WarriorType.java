/**
 * A character that can attack and use potions. Extends CharacterType to reuse
 * its HP logic and adds attack points (ap). The two use() methods show method
 * overloading.
 */
public class WarriorType extends CharacterType {

	/** 
	 * Attack points: how much damage this warrior deals. Never negative. 
	 */
	protected int ap;

	/**
	 * Creates a warrior with the given health and attack points.
	 * @param hp  the starting hit points
	 * @param mhp the maximum hit points
	 * @param ap  the starting attack points, set to 0 if negative
	 */
	public WarriorType(int hp, int mhp, int ap) {
		super(hp, mhp); // runs CharacterType's constructor first to set up hp and mhp
		if (ap < 0)
			ap = 0;
		this.ap = ap;
	}

	/**
	 * Returns how much damage this warrior deals.
	 * @return the current attack points
	 */
	public int attack() {
		return ap;
	}

	/**
	 * Uses a blue potion to restore HP, without going above maximum HP.
	 * @param bluePotion the potion to use
	 */
	public void use(BluePotion bluePotion) {
		this.hp = this.hp + bluePotion.getValue();
		if (this.hp > this.mhp)
			this.hp = this.mhp; // healing is capped at the maximum
	}

	/**
	 * Uses a red potion to increase attack points.
	 * @param redPotion the potion to use
	 */
	public void use(RedPotion redPotion) {
		// RedPotion.getValue() returns double its base value,
		// so a RedPotion(4) adds 8 attack points.
		this.ap = this.ap + redPotion.getValue();
	}

	/**
	 * Returns the warrior's stats as text.
	 * @return a string like [hp=9, mhp=20, ap=15]
	 */
	@Override
	public String toString() {
		return "[hp=" + hp + ", mhp=" + mhp + ", ap=" + ap + "]";
	}
}
