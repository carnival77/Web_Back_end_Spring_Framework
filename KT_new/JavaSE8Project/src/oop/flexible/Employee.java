package oop.flexible;

public abstract class Employee {
	
//	abstract method를 하나 이상 가지면 자동으로 abstract 클래스가 된다.
//	abstract 클래스는 스스로 객체를 생성할 수 없다.
//	Employee emp = new Employee();	 	(X)
//	Employee mgr = new Manager(); 	 	(O)
//	Employee clerk = new MereClerk();	(O)
//	

//	protected String name;
	private String name;
	protected double salary;

	public Employee() {
		super();
	}

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return this.name;
	}

	public double getSalary() {
		return this.salary;
	}
	
	// 추상 메서드 선언 - body가 없고 선언만 되어 있는 메소드
	public abstract void manageSalary(double rate);

}