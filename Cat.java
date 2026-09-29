/**
 * A cat that implements the Animal interface.
 */
public class Cat implements Animal {

	/**
	 * Creates a cat.
	 */
	public Cat() {
	}

	/**
	 * Prints the cat's sound.
	 */
	@Override // fulfills the makeSound() method required by Animal
	public void makeSound() {
		System.out.println("The cat says: meow");
	}
}
