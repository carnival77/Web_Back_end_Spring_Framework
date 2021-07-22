package chap06.class1;

public class Test {
	public static void main(String[] args) {
		Child child = new Child("HI");
		Parent parent = new Parent("HELLO");
	}
}

class Parent {
	String s;

	public Parent(String st) {
		s = st;
		System.out.println(s);
	}

}

class Child extends Parent {
	String s;

	public Child(String st) {
		super(st);
		s = st;
		System.out.println(s);
	}
}