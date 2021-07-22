package oop.flexible;

public class FlexibleCompanyDemo {
	public static void main(String[] args) {

//        MereClerk mereClerk1 = new MereClerk("ö��", 100);
//        MereClerk mereClerk2 = new MereClerk("����", 100);
//        Manager manager = new Manager("ȫ�浿", 200);

		Employee[] emps = new Employee[3];
		emps[0] = new MereClerk("ö��", 100);
		emps[1] = new MereClerk("����", 100);
		emps[2] = new Manager("ȫ�浿", 200, "IT");

		System.out.println("���� �����Դϴ�.");

		printEmployeeInfo(emps);

//        System.out.println(mereClerk2.getName() + "�� ���� ������ " + mereClerk2.getSalary() + " ���� �Դϴ�.");
//        System.out.println(manager.getName() + "�� ���� ������ " + manager.getSalary() + " ���� �Դϴ�.");

		System.out.println("");

		for (Employee employee : emps) {
			employee.manageSalary(10);
		}

		System.out.println("�ø� ���� �����Դϴ�.");

		printEmployeeInfo(emps);

//		mereClerk1.manageSalary(10);
//		System.out.println(mereClerk1.getName() + "�� ���� ������ " + mereClerk1.getSalary() + " ���� �Դϴ�.");
//
//		mereClerk2.manageSalary(10);
//		System.out.println(mereClerk2.getName() + "�� ���� ������ " + mereClerk2.getSalary() + " ���� �Դϴ�.");
//
//		manager.manageSalary(10);
//		System.out.println(manager.getName() + "�� ���� ������ " + manager.getSalary() + " ���� �Դϴ�.");

	}

	private static void printEmployeeInfo(Employee[] emps) {
		for (Employee employee : emps) {
			if (employee instanceof Manager) {
				Manager mgr = (Manager) employee;
				System.out.print("�μ��� : " + mgr.getDepartment());
			}

//			System.out.print("�μ��� : " + ((Manager) employee).getDepartment());
			System.out.println(employee.getName() + "�� ���� ������ " + employee.getSalary() + " ���� �Դϴ�.");
		}
	}
}
