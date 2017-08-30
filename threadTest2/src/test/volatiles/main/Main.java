package test.volatiles.main;

/**
 * 测试Client和Server模式下，非volatile修饰的对象的可见性
 *
 * @author admin
 *
 */
public class Main {

	public static boolean flag = true;

	public static void main(String[] args) {
		Main main = new Main();
		main.test1();
	}

	public void test1() {
		Runnable run = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(50);
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
			if (!flag) {
				System.out.println("exit flag : " + flag);
				break;
			}
		}
	}
}
