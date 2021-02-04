package chap09.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import chap03.types.encapsulate.MyDate;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set_temp = new HashSet<String>();
		set_temp.add("자바");
		set_temp.add("파이썬");
		set_temp.add("씨언어");
		set_temp.add("자바");

		for (String string : set_temp) {
			System.out.println(string);
		}

		Set<MyDate> dateSet = new HashSet<MyDate>();

		MyDate myDate1 = new MyDate(2020, 1, 1);
		MyDate myDate2 = new MyDate(2021, 1, 1);
		MyDate myDate3 = new MyDate(2022, 1, 1);
		
		for (MyDate myDate : dateSet) {
			System.out.println("hashcode : "+myDate.hashCode());
		}

		dateSet.add(myDate1);
		dateSet.add(myDate2);
		dateSet.add(myDate3);
		
		Iterator<MyDate> iterator = dateSet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}
