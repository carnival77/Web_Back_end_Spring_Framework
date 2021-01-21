package lambda;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateTimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate now = LocalDate.now(); // alt shift l

		LocalDate now2 = LocalDate.now();

		System.out.println(now);
		System.out.println(now2);

		System.out.println(now.compareTo(now2) == 0);

		System.out.println(now.getYear());
		System.out.println(now.getMonth());
		System.out.println(now.getDayOfMonth());
		System.out.println(now.getDayOfYear());
		System.out.println(now.getDayOfWeek() + " " + now.getDayOfWeek().getValue());

	}

}
