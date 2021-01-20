package chap09.collections;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> my_map = new HashMap<Integer, String>();

		my_map.put(100, "자바");
		my_map.put(200, "스프링");
		my_map.put(100, "부트");

		String val = my_map.get(200);

		System.out.println(val);

		// keySet() Set<Integer>
		for (Integer key : my_map.keySet()) {
			String value = my_map.get(key);
			System.out.println(key + "=" + value);
		}

		// entrySet()
		for (Map.Entry entry : my_map.entrySet()) {
			System.out.println(entry.getKey()+" = "+entry.getValue());
		}

	}

}
