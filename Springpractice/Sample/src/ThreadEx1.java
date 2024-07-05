class ThreadTest extends Thread{
	public void run() {
		for(int i=1; i<5; i++) {
			System.out.println("재미있는 자바 : " + i);
		}
	}
}


public class ThreadEx1 {

	public static void main(String[] args) {
		
		ThreadTest t1 = new ThreadTest();
		t1.start();
		ThreadTest t2 = new ThreadTest();
		t2.start();
		ThreadTest t3 = new ThreadTest();
		t3.start();
	}
}
