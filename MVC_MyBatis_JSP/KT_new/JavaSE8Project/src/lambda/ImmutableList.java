package lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ImmutableList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 자바 9버젼 이전
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bbbb");
		list.add("cccc");
		List<String> list2 = Collections.unmodifiableList(list);

//		list2.add("eeeeeeee");

		// 자바 9 이후
		// List.of 로 만든 리스트는 unmodifiableList
		List<String> ofList = List.of("aaaa", "bbbb", "ddd");
//		ofList.add("cccc"); // error

	}

}
