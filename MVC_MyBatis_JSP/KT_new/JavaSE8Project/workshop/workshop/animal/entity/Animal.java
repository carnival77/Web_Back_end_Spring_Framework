package workshop.animal.entity;

public abstract class Animal {
	protected int legs;

	protected Animal(int legs) {
		super();
		this.legs = legs;
	}

	public abstract void eat();

	public void walk() {
		System.out.println("walk with " + legs + " legs");
	}
}
