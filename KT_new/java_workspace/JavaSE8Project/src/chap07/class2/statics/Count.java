package chap07.class2.statics;

public class Count {
	private int serialNumber;
	private static int counter = 0;
	private final int PIE;

	public Count() {
		PIE = 2;
		counter++;
		serialNumber = counter;
	}

	public String toString() {
		return "Count object: serial number is " + serialNumber + " counter is " + counter;
	}

	public static void main(String[] args) {

		Count count1 = new Count();
		Count count2 = new Count();

		System.out.println(count1);
		System.out.println(count2);

		count2 = null;
		// static 변수는 객체 생성과 전혀 관련이 없다.
		// caount2 변수가 null이지만, counter static 변수를 출력 가능하다.
		System.out.println(count2.counter);
		System.out.println(Count.counter);

//		Count[] c = new Count[10];
//
//		for (int i = 0; i < 10; i++) {
//			c[i] = new Count();
//		}
//		for (int i = 0; i < 10; i++) {
//			System.out.println(c[i]);
//		}
	}
}
