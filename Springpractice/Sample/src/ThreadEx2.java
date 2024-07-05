
public class ThreadEx2 extends Thread{
	
	public void run() {
		try {
			
			for(int i=0; i<10; i++) {
			
				Thread.sleep(500);
				System.out.println(i);
				
			} 
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		ThreadEx2 e2 = new ThreadEx2();
		e2.start();
	}

}
