class AutoSave extends Thread{
	
	public void save() {
		System.out.println("작업 내용을 저장합니다");
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				break;
			}
			save();
		}
	}
	
}


public class Ex3 {

	public static void main(String[] args) {
		
		AutoSave as = new AutoSave();
		as.setDaemon(true);
		as.start();
		try {
			Thread.sleep(3000);
		}catch(Exception e) {
			
		}
		System.out.println("메인 스레드 종료");

	}

}
