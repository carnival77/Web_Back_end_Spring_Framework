package chap03.types;

public class PrimitiveTypeTest {

	static boolean isFlag;
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// boolean
		isFlag = true;
		System.out.println("Boolean Type : " + isFlag);
	
		// char
		char mychar = '\u0000'; // ���� ����
		System.out.println("Char Type : "+mychar);
		
		String name="ȫ�浿";
		mychar = name.charAt(0); // String -> char
		System.out.println(mychar);
		
		// ������ byte, short, int, long
		short num1=100;
		short num2=200;
		short result = (short)(num1+num2); // short�� + short�� = int��. result�� short�� ����ȯ����� �Ѵ�. 
		int result2 = num1 + num2;
		
		PrimitiveTypeTest test = new PrimitiveTypeTest();
		test.myMethod(4);
		
		// �Ǽ��� float, double
		// �Ǽ��� literal�� data type�� double
		float pie = 3.14F; // double�ε� �ڿ� F�� �־ float�� �ٲ�
		float pie2 = (float)3.14;
		
		
	}// main
	
	// Method overloading ( �ߺ� ���� ) 
	public void myMethod(short val) {
		System.out.println("short");
	}
	public void myMethod(int val) {
		System.out.println("int");
	}
	public void myMethod(long val) {
		System.out.println("long");
	}
	
//	// Auto Boxing, Unboxing
//	int num = 10;
//	
//	Auto Boxing : 
//		Integer num2 = num;
	
	
	
	
}