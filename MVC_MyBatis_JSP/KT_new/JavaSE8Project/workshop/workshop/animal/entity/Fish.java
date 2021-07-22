package workshop.animal.entity;

public class Fish extends Animal implements Pet {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Fish(int legs) {
		super(legs);
		// TODO Auto-generated constructor stub
	}

	public Fish() {
		super(0);
		// TODO Auto-generated constructor stub
	}

	public void play() {

	}

	public void walk() {
		System.out.println("fish cannot walk");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub

	}

}
