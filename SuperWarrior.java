/**
 * A warrior with a shield that reduces incoming damage. Extends WarriorType
 * (inheritance, "is-a") and has a ShieldType (composition, "has-a").
 */
public class SuperWarrior extends WarriorType {

	/**
	 * The shield this warrior carries. final means it can't be replaced with a
	 * different shield, but the shield's durability can still change.
	 */
	private final ShieldType shield;

	/**
	 * Creates a super warrior with the given stats and shield.
	 * @param hp     the starting hit points
	 * @param mhp    the maximum hit points
	 * @param ap     the starting attack points
	 * @param shield the shield to carry; a basic shield is used if null
	 */
	public SuperWarrior(int hp, int mhp, int ap, ShieldType shield) {
		super(hp, mhp, ap);
		// avoid a NullPointerException in decreaseHp() if no shield is given
		this.shield = (shield != null) ? shield : new ShieldType(ShieldType.MIN_DURABILITY);
	}

	/**
	 * Returns this warrior's shield.
	 * @return the shield
	 */
	public ShieldType getShield() {
		return shield;
	}

	/**
	 * Takes damage reduced by the shield, then wears the shield down by 1.
	 * Overrides CharacterType.decreaseHp().
	 * @param amount the damage before the shield is applied
	 */
	@Override
	public void decreaseHp(int amount) {
		amount = amount / shield.getDurability(); // durability is always >= 1, so no divide-by-zero
		super.decreaseHp(amount); // reuse the parent's logic so HP still can't go below 0
		shield.decreaseDurability(1); // each hit wears the shield down
	}

	/**
	 * Returns the warrior's stats and shield durability as text.
	 * @return a string like [hp=67, mhp=100, ap=53, sd=4]
	 */
	@Override
	public String toString() {
		return "[hp=" + hp + ", mhp=" + mhp + ", ap=" + ap + ", sd=" + shield.getDurability() + "]";
	}
}
