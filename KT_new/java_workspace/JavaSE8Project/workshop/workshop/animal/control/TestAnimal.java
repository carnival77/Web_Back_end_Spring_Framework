package workshop.animal.control;

import workshop.animal.entity.Animal;
import workshop.animal.entity.Cat;
import workshop.animal.entity.Fish;
import workshop.animal.entity.Pet;
import workshop.animal.entity.Spider;

public class TestAnimal {
	public static void main(String[] args) {
		Fish d = new Fish();
		Cat c = new Cat("Fluffy");
		Animal a = new Fish();
		Animal e = new Spider();
		Pet p = new Cat();
		
		Cat cat1 = new Cat();
		cat1.setName("J");
		System.out.println(cat1.getName());
		cat1.play();
		cat1.eat();
		cat1.walk();
		
		Pet cat2 = new Cat();
		cat2.setName("K");
		System.out.println(cat2.getName());
		cat2.play();

		Animal cat3 = new Cat();
		cat3.eat();
		cat3.walk();
	}
}
