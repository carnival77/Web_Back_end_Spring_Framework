package workshop.person.control;

import java.util.ArrayList;
import java.util.List;

import workshop.person.entity.PersonEntity;

public class PersonManagerUsingList {

	public PersonManagerUsingList() {
	}

	PersonEntity person_entity = new PersonEntity();

//	public void showPerson(PersonEntity[] persons) {
	public void fillPersons(List<PersonEntity> persons) {

		persons.add(new PersonEntity("�̼�ȣ", "7212121028102", "��õ ��籸", "032-392-2932"));
		persons.add(new PersonEntity("���ϴ�", "7302132363217", "���� ������", "02-362-1932"));
		persons.add(new PersonEntity("�ڿ���", "7503111233201", "���� ���ϱ�", "02-887-1542"));
		persons.add(new PersonEntity("���μ�", "7312041038988", "���� ������", "032-384-2223"));
		persons.add(new PersonEntity("ȫ����", "7606221021341", "���� ��õ��", "02-158-7333"));
		persons.add(new PersonEntity("�̹̼�", "7502142021321", "���� ������", "02-323-1934"));
		persons.add(new PersonEntity("�ڼ���", "7402061023101", "���� ���α�", "02-308-0932"));
		persons.add(new PersonEntity("������", "7103282025101", "���� ����", "02-452-0939"));
		persons.add(new PersonEntity("Ȳ����", "7806231031101", "��õ �߱�", "032-327-2202"));
		persons.add(new PersonEntity("��ö��", "7601211025101", "��õ ��籸", "032-122-7832"));

//		persons[0] = new PersonEntity("�̼�ȣ", "7212121028102", "��õ ��籸", "032-392-2932");
//		persons[1] = new PersonEntity("���ϴ�", "7302132363217", "���� ������", "02-362-1932");
//		persons[2] = new PersonEntity("�ڿ���", "7503111233201", "���� ���ϱ�", "02-887-1542");
//		persons[3] = new PersonEntity("���μ�", "7312041038988", "���� ������", "032-384-2223");
//		persons[4] = new PersonEntity("ȫ����", "7606221021341", "���� ��õ��", "02-158-7333");
//		persons[5] = new PersonEntity("�̹̼�", "7502142021321", "���� ������", "02-323-1934");
//		persons[6] = new PersonEntity("�ڼ���", "7402061023101", "���� ���α�", "02-308-0932");
//		persons[7] = new PersonEntity("������", "7103282025101", "���� ����", "02-452-0939");
//		persons[8] = new PersonEntity("Ȳ����", "7806231031101", "��õ �߱�", "032-327-2202");
//		persons[9] = new PersonEntity("��ö��", "7601211025101", "��õ ��籸", "032-122-7832");

	}

//	public void showPerson(PersonEntity[] persons) {
	public void showPerson(List<PersonEntity> persons) {
		for (PersonEntity personEntity : persons) {
			System.out.println("[�̸�] " + personEntity.getName() + "\t" + "[����] " + personEntity.getGender() + "\t"
					+ "[��ȭ��ȣ] " + personEntity.getPhone());
		}
	}

//	public int findbyGender(PersonEntity[] persons, char gender) {
	public int findbyGender(List<PersonEntity> persons, char gender) {
		int count = 0;
		for (PersonEntity personEntity : persons) {
			if (personEntity.getGender() == '��') {
				count = count + 1;
			}
		}
		return count;
	}

//	public void showPerson(PersonEntity[] persons, String name) {
	public void showPerson(List<PersonEntity> persons, String name) {
		for (PersonEntity personEntity : persons) {
			if (personEntity.getName().equals(name)) {
				System.out.println("[�̸�] " + personEntity.getName() + "\n" + "[����] " + personEntity.getGender() + "\n"
						+ "[��ȭ��ȣ] " + personEntity.getPhone() + "\n" + "[�ּ�] " + personEntity.getAddress());
			}
		}
	}

	public static void main(String[] args) {

		PersonManagerUsingList pManager = new PersonManagerUsingList();
		List<PersonEntity> persons = new ArrayList<PersonEntity>();

		pManager.fillPersons(persons);
		pManager.showPerson(persons);
		System.out.println();
		int girl_count = pManager.findbyGender(persons, '��');
		System.out.println("���� �� :" + girl_count);
		System.out.println();
		pManager.showPerson(persons, "���ϴ�");

//		PersonEntity[] persons = new PersonEntity[10];
//
//		pManager.fillPersons(persons);
//		pManager.showPerson(persons);
//		System.out.println();
//		int girl_count = pManager.findbyGender(persons, '��');
//		System.out.println("���� �� :" + girl_count);
//		System.out.println();
//		pManager.showPerson(persons, "���ϴ�");
	}

}
