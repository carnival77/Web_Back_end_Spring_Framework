package chap05.arrays;

import chap03.types.encapsulate.MyDate;

public class ReferenceTypeArray {
	public static void main(String[] args) {
		MyDate[] dates = new MyDate[3];
		System.out.println(dates); // MyDate[]
		System.out.println(dates[0]); // MyDate
		
		dates[0] = new MyDate(2020,1,1);
		dates[1] = new MyDate(2021,2,3);
		dates[2] = new MyDate(2022,3,4);
		
		ReferenceTypeArray test = new ReferenceTypeArray();
		
		test.printArray(dates);
	}

	private static void printArray(MyDate[] dates) {
		for (MyDate myDate : dates) {
			System.out.println(myDate);
		}
		
		for(int i=0;i<dates.length;i++) {
			System.out.println(dates[i]);
		}
	}
}
