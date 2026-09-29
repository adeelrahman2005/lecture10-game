/**
 * Runs the game demo: a warrior using potions, then a super warrior with a shield.
 */
public class Main {

	/**
	 * Private constructor, since Main only holds the static main method.
	 */
	private Main() {
	}

	/**
	 * Runs both demos. static lets it run without creating a Main object.
	 * @param args command-line arguments (unused)
	 */
	public static void main(String[] args) {
		// Part 1: inheritance, method overloading, and abstraction 
		CharacterType hero = new CharacterType(5, 10);
		System.out.println("Hero: " + hero);

		WarriorType warrior = new WarriorType(3, 20, 7);

		// Potion potion = new Potion(3); // would NOT compile: Potion is abstract
		BluePotion bluePotion = new BluePotion(6);
		RedPotion redPotion = new RedPotion(4);

		System.out.println("Warrior's HP: " + warrior.getHP()); // getHP() is inherited from CharacterType
		System.out.println("Warrior's AP: " + warrior.attack());
		System.out.println("==========");
		warrior.use(bluePotion); // overloading: the compiler picks use(BluePotion)
		warrior.use(redPotion); // overloading: the compiler picks use(RedPotion)
		System.out.println("Warrior's HP: " + warrior.getHP());
		System.out.println("Warrior's AP: " + warrior.attack());
		System.out.println();

		// Part 2: composition (SuperWarrior has a ShieldType)
		ShieldType superShield = new ShieldType(5);
		SuperWarrior akira = new SuperWarrior(77, 100, 53, superShield);
		System.out.println("Akira before hit: " + akira);
		akira.decreaseHp(50); // the shield divides the damage by its durability
		System.out.println("Akira after hit:  " + akira);

		// Polymorphism: a CharacterType variable holding a SuperWarrior still runs
		// SuperWarrior's overridden decreaseHp(), so the shield still applies.
		CharacterType asCharacter = akira;
		asCharacter.decreaseHp(40);
		System.out.println("Akira after 2nd:  " + akira);
	}
}
