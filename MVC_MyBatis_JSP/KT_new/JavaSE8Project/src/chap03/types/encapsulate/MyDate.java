package chap03.types.encapsulate;

public class MyDate {

	private int year = 2020;
	private int month = 1;
	private int day = 1;
	// public -> private : �� Ŭ���� �ܿ��� ������ ���� �Ұ���.

//	default constructor
//	: ������ �̸��� Ŭ������ �ݵ�� ���ƾ� �Ѵ�.
//	    ���� Ÿ���� ����. ( void�� �ƴ� )
//	  ��ü �����Ǵ� ������ ȣ��ȴ�.
//	  ���� : �ν��Ͻ� ���� �ʱ�ȭ

	public MyDate() {
		System.out.println("�⺻ ������ ȣ���.");
		year = 2022;
		month = 12;
		day = 20;
	}

	// Constructor Overloading (������ �ߺ� ����)
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
//		this.month = month;
//		this.day = day;
		setMonth(month);
		setDay(day);
	}
	// �����ڰ� ���Ƿ� ���ǵǾ� ���� ���, �⺻ �����ڴ� ��������� �ʴ´�.

	@Override
	public String toString() {
		return "MyDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		if (month >= 1 & month <= 12) {
			this.month = month;
		} else {
			System.out.println("Invalid Month Value");
		}
	}

	public void setDay(int day) {
		if (day >= 1 & day <= 31) {
			this.day = day;
		} else {
			System.out.println("Invalid Day Value");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyDate other = (MyDate) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

//	@Override
//	// myDate.equals(myDate2)
//	public boolean equals(Object obj) {
//		boolean isEqual = false;
//		if (obj instanceof MyDate) {
//			MyDate date = (MyDate) obj;
//			if ((this.year == date.year) && (this.month == date.month) && (this.day == date.day)) {
//				isEqual = true;
//			}
//		}
//		return isEqual;
//	}
//	
//	@Override
//	public int hashCode() {
//		// TODO Auto-generated method stub
//		return this.year ^ this.month ^ this.day;
//	}
	
	

}
