package lambda;

public class LambdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Thread�� ��ӹ��� ��, MyThread ��ü�� ����
		Thread t1 = new MyThread();
		t1.setName("TT");
		t1.start();

		// 2. Runnable�� ������ MyRunnable�� Thread �������� ���ڷ� ����
		Thread t2 = new Thread(new MyRunnable());
		t2.setName("���ʺ�");
		t2.start();

		// 3. Runnalbe�� Anonymous(�͸�) Inner class �� ����
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName());
			}
		});
		t3.setName("��ϸӽ� �̳� Ŭ����");
		t3.start();

		// 4. Runnable�� Functional Interface�̹Ƿ� Lambda ������ ����
		Thread t4 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
		t4.setName("����");
		t4.start();
	}

}

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println(currentThread().getName());
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
	}

}