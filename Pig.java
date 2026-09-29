/**
 * A pig that implements the Animal interface and adds its own sleep() method.
 */
public class Pig implements Animal {

	/**
	 * Creates a pig.
	 */
	public Pig() {
	}

	/**
	 * Prints the pig's sound.
	 */
	@Override
	public void makeSound() {
		System.out.println("The pig says: wee wee");
	}

	/**
	 * Prints a sleeping message. Not part of Animal.
	 */
	public void sleep() {
		System.out.println("Zzz");
	}

	/**
	 * Shows that an Animal variable can hold a Pig or a Cat.
	 * @param args command-line arguments (unused)
	 */
	public static void main(String[] args) {
		// declared as Animal, but each object runs its own makeSound()
		Animal animal0 = new Pig();
		animal0.makeSound();

		Animal animal1 = new Cat();
		animal1.makeSound();

		// animal0.sleep(); // would NOT compile: Animal does not declare sleep()
		Pig pig = new Pig();
		pig.sleep(); // works, because the declared type is Pig
	}
}
