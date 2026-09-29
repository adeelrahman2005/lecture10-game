/**
 * The base class for every character in the game. Stores current and maximum
 * HP and handles taking damage. WarriorType and SuperWarrior extend this class.
 */
public class CharacterType {

	/**
	 *  Smallest allowed maximum HP. static final makes it one shared constant. 
	 */
	public static final int MIN_MHP = 1;

	// protected so subclasses like WarriorType and SuperWarrior can use these directly
	/** 
	 * Current hit points, between 0 and mhp. 
	 */
	protected int hp;

	/** 
	 * Maximum hit points, at least MIN_MHP.  
	 */
	protected int mhp;

	/**
	 * Creates a character, keeping hp between 0 and mhp.
	 * @param hp  the starting hit points
	 * @param mhp the maximum hit points
	 */
	public CharacterType(int hp, int mhp) {
		if (mhp < MIN_MHP)
			mhp = MIN_MHP; // a character must be able to hold at least 1 HP
		this.mhp = mhp;

		if (hp > mhp)
			hp = mhp; // cannot start with more HP than the maximum
		if (hp < 0)
			hp = 0; // prevents a character from starting with negative HP
		this.hp = hp;
	}

	/**
	 * Reduces HP by the given amount, never going below 0.
	 * SuperWarrior overrides this to apply its shield first.
	 * @param amount the damage to apply
	 */
	public void decreaseHp(int amount) {
		this.hp = this.hp - amount;
		if (this.hp < 0)
			this.hp = 0;
	}

	/**
	 * Returns the current HP.
	 * @return the current hit points
	 */
	public int getHP() {
		return hp;
	}

	/**
	 * Returns the maximum HP.
	 * @return the maximum hit points
	 */
	public int getMHP() {
		return mhp;
	}

	/**
	 * Returns the character's health as text.
	 * @return a string like [hp=5, mhp=10]
	 */
	@Override
	public String toString() {
		return "[hp=" + hp + ", mhp=" + mhp + "]";
	}
}
