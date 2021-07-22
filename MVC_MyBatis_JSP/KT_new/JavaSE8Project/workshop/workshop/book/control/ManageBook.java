package workshop.book.control;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.ReferenceBook;

public class ManageBook {
	public static void main(String[] args) {
		Publication[] pub = new Publication[5];

		pub[0] = new Magazine("����ũ�μ���Ʈ����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�");
		pub[1] = new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�");
		pub[2] = new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�");
		pub[3] = new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�");
		pub[4] = new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������");

		System.out.println("==== Book ���� ��� ====\n");

		for (Publication publication : pub) {
			System.out.println(publication.toString());
		}

		System.out.println("\n==== �������� ���� �� ====");
		System.out.printf("%s : %d\n", pub[2].getTitle(), pub[2].getPrice());

		new ManageBook().modifyPrice(pub[2]);
		;

		System.out.println("==== �������� ���� �� ====");
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
