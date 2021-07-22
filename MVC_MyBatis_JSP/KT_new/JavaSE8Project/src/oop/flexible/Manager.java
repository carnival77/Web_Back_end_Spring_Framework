package oop.flexible;

/* ������ Ŭ���� */
public class Manager extends Employee {
	private String department;

	public Manager(String name, double salary) {
//		this.name = name;
//		this.salary = salary;
		super(name, salary);
	}

	public Manager(String name, double salary, String department) {
		this(name, salary);
		this.department = department;
	}

	@Override
	public void manageSalary(double rate) {
		salary = salary + salary * (rate / 100);
		salary += 20; // 20������ �߰��� �޴´�.
	}

	public String getDepartment() {
		return department;
	}

//	public void setDepartment(String department) {
//		this.department = department;
//	}

}
