package test.volatiles.main;

/**
 * 测试Client模式下，非volatile修饰的对象的可见性
 * 另外可使用“D:\software\java\jdk1.7\jdk1.7\jre\bin\java -server -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly >> log2.txt”
 * 命令查看CPU执行的汇编指令
 *
 * @author admin
 *
 */
public class Main {

	public static boolean flag = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		main.test1();
	}

	public void test1() {
		Runnable run = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					System.out.println("exception ");
				}
				System.out.println("run start");
				Main.flag = false;
			}
		};
		Thread t = new Thread(run);
		t.start();

		System.out.println(flag);
		while (true) {
			if (!flag) {
				System.out.println("exit flag : " + flag);
				break;
			}
//			System.out.println(flag);
		}

	}
}
