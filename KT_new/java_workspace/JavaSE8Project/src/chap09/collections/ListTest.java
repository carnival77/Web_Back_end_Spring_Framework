package chap09.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strList = new ArrayList<String>();
		strList.add("java");
		strList.add("python");
//		strList.add(4);

		String value = strList.get(1);
		System.out.println(value);

		for (String string : strList) {
			System.out.println(string);
		}

		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));
		}
		
		// Iterator 사용
		Iterator<String> iterator = strList.iterator();
		while(iterator.hasNext()) {
			value = iterator.next();
		}
		
		// Iterator 사용
		strList.forEach(val -> System.out.println(val));
		
		System.out.println("Iterable Method Reference");
		strList.forEach(System.out :: println);
	}

}
