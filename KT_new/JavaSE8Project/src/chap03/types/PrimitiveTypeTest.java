package chap03.types;

public class PrimitiveTypeTest {

	static boolean isFlag;
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// boolean
		isFlag = true;
		System.out.println("Boolean Type : " + isFlag);
	
		// char
		char mychar = '\u0000'; // 공백 문자
		System.out.println("Char Type : "+mychar);
		
		String name="홍길동";
		mychar = name.charAt(0); // String -> char
		System.out.println(mychar);
		
		// 정수형 byte, short, int, long
		short num1=100;
		short num2=200;
		short result = (short)(num1+num2); // short형 + short형 = int형. result를 short로 형변환해줘야 한다. 
		int result2 = num1 + num2;
		
		PrimitiveTypeTest test = new PrimitiveTypeTest();
		test.myMethod(4);
		
		// 실수형 float, double
		// 실수형 literal의 data type은 double
		float pie = 3.14F; // double인데 뒤에 F를 넣어서 float로 바꿈
		float pie2 = (float)3.14;
		
		
	}// main
	
	// Method overloading ( 중복 정의 ) 
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