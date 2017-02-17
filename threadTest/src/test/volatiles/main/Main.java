package test.volatiles.main;

/**
 * 测试volatile功能
 * @author admin
 *
 */
public class Main {

	public static volatile boolean flag = true;

	public static void main(String[] args) {
		test1();
	}

	public static void test1() {

		Runnable run = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.out.println("exception ");
				}
				System.out.println("run start");
				Main.flag = false;
			}
		};
		Thread t = new Thread(run);
		t.start();

		while (true) {
			if (flag == false) {
				System.out.println(flag);
				break;
			}
		}
	}

}
