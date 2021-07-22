package oop.flexible;

public abstract class Employee {
	
//	abstract method�� �ϳ� �̻� ������ �ڵ����� abstract Ŭ������ �ȴ�.
//	abstract Ŭ������ ������ ��ü�� ������ �� ����.
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
	
	// �߻� �޼��� ���� - body�� ���� ���� �Ǿ� �ִ� �޼ҵ�
	public abstract void manageSalary(double rate);

}