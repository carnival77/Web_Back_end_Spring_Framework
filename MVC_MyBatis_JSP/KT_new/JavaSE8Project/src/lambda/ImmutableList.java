package lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ImmutableList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// �ڹ� 9���� ����
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bbbb");
		list.add("cccc");
		List<String> list2 = Collections.unmodifiableList(list);

//		list2.add("eeeeeeee");

		// �ڹ� 9 ����
		// List.of �� ���� ����Ʈ�� unmodifiableList
		List<String> ofList = List.of("aaaa", "bbbb", "ddd");
//		ofList.add("cccc"); // error

	}

}
