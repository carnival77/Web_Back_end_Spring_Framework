package workshop.book.control;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.ReferenceBook;

public class ManageBook {
	public static void main(String[] args) {
		Publication[] pub = new Publication[5];

		pub[0] = new Magazine("마이크로소프트마이크로소프트", "2007-10-01", 328, 9900, "매월");
		pub[1] = new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월");
		pub[2] = new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설");
		pub[3] = new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설");
		pub[4] = new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학");

		System.out.println("==== Book 정보 출력 ====\n");

		for (Publication publication : pub) {
			System.out.println(publication.toString());
		}

		System.out.println("\n==== 가격정보 변경 전 ====");
		System.out.printf("%s : %d\n", pub[2].getTitle(), pub[2].getPrice());

		new ManageBook().modifyPrice(pub[2]);
		;

		System.out.println("==== 가격정보 변경 후 ====");
		System.out.printf("%s : %d\n", pub[2].getTitle(), pub[2].getPrice());

	}

	public void modifyPrice(Publication pub) {
		if (pub instanceof Magazine) {
			pub.setPrice((int) (pub.getPrice() * 0.6));
		} else if (pub instanceof Novel) {
			pub.setPrice((int) (pub.getPrice() * 0.8));
		} else {
			pub.setPrice((int) (pub.getPrice() * 0.9));
		}
	}

}
