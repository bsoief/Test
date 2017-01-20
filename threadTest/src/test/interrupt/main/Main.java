package test.interrupt.main;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		test1();
	}

	public static void test1() throws Exception{
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.out.println("interrupt");
				}
			}
		};
		Thread t = new Thread(r);
		t.start();
		Thread.sleep(500);
		t.interrupt();
	}
}
