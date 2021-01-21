package lambda;

public class LambdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Thread를 상속받은 후, MyThread 객체를 생성
		Thread t1 = new MyThread();
		t1.setName("TT");
		t1.start();

		// 2. Runnable을 구현한 MyRunnable을 Thread 생성자의 인자로 전달
		Thread t2 = new Thread(new MyRunnable());
		t2.setName("러너블");
		t2.start();

		// 3. Runnalbe을 Anonymous(익명) Inner class 로 생성
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName());
			}
		});
		t3.setName("어나니머스 이너 클래스");
		t3.start();

		// 4. Runnable이 Functional Interface이므로 Lambda 식으로 생성
		Thread t4 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
		t4.setName("람다");
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