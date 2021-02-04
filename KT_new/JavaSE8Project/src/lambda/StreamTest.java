package lambda;

import java.util.List;
//import java.util.stream.Collectors;
// -> static method를 import 하면, Collertors.toList() -> toList()
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {

		// Q. 400칼로리 이하인 음식의 이름 출력하기

		// 1. List<Dish> -> Stream<Dish> 로 변환
		Stream<Dish> dishes = Dish.menu.stream();

		// 2. 칼로리가 400 이하인 Dish를 필터링(filter)
		// Predicate boolean test(T t)
		dishes = dishes.filter(dish -> dish.getCalories() < 400);

		// 3. 400 이하인 Dish 의 이름만 담은 Stream 생성
		// Stream<Dish> -> Stream<String>
		// Function R apply(T t)
		Stream<String> dish_names = dishes.map(dish -> dish.getName());

		// 4. Stream<String> -> List<String> 로 변환
//		List<String> dish_list = dish_names.collect(Collectors.toList());
		List<String> dish_list = dish_names.collect(toList());

		for (String dish_name : dish_list) {
			System.out.println(dish_name);
		}

		List<String> dish_names1 = Dish.menu.stream().filter(dish -> dish.getCalories() < 400)
//				.map(dish -> dish.getName()).collect(Collectors.toList());
				.map(dish -> dish.getName()).collect(toList());

		// Iterable의 forEach(Consumer co)
		// Consumer void accept(T t)
		System.out.println();
		dish_names1.forEach(name -> System.out.println(name));

		// Method Reference
		dish_names1.forEach(System.out::println);

	}

}
