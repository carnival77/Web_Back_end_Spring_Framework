package lambda;

import java.util.List;
//import java.util.stream.Collectors;
// -> static method�� import �ϸ�, Collertors.toList() -> toList()
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {

		// Q. 400Į�θ� ������ ������ �̸� ����ϱ�

		// 1. List<Dish> -> Stream<Dish> �� ��ȯ
		Stream<Dish> dishes = Dish.menu.stream();

		// 2. Į�θ��� 400 ������ Dish�� ���͸�(filter)
		// Predicate boolean test(T t)
		dishes = dishes.filter(dish -> dish.getCalories() < 400);

		// 3. 400 ������ Dish �� �̸��� ���� Stream ����
		// Stream<Dish> -> Stream<String>
		// Function R apply(T t)
		Stream<String> dish_names = dishes.map(dish -> dish.getName());

		// 4. Stream<String> -> List<String> �� ��ȯ
//		List<String> dish_list = dish_names.collect(Collectors.toList());
		List<String> dish_list = dish_names.collect(toList());

		for (String dish_name : dish_list) {
			System.out.println(dish_name);
		}

		List<String> dish_names1 = Dish.menu.stream().filter(dish -> dish.getCalories() < 400)
//				.map(dish -> dish.getName()).collect(Collectors.toList());
				.map(dish -> dish.getName()).collect(toList());

		// Iterable�� forEach(Consumer co)
		// Consumer void accept(T t)
		System.out.println();
		dish_names1.forEach(name -> System.out.println(name));

		// Method Reference
		dish_names1.forEach(System.out::println);

	}

}
