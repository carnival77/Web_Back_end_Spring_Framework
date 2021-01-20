package chap03.types.encapsulate;

public class MyDateTest {
	public static void main(String[] args) {
		MyDate myDate = new MyDate();
		myDate.setYear(2030);
		myDate.setMonth(13);
		myDate.setDay(35);
		// public -> private : 이 클래스 외에는 변수값 변경 불가능.
		
		System.out.println(myDate.getYear());
		System.out.println(myDate.getMonth());
		System.out.println(myDate.getDay());
		
		MyDate myDate2 = new MyDate(2021,10,27);
		System.out.println(myDate2.toString());
		
	}
}
