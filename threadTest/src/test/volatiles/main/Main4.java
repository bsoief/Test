package test.volatiles.main;

/**
 * 尝试验证可见性问题（失败）
 * @author Administrator
 *
 */
public class Main4 {
	
	public static int flag = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}

	public static void test1() {
		Runnable run = new Runnable() {
			@Override
			public void run() {
				for (;;) {
//					lock.lock();
					flag++;
//					System.out.println("set already flag : " + flag);
//					lock.unlock();
					if (flag == 100000000) {
						break;
					}
				}
			}
		};
		Runnable run2 = new Runnable() {
			@Override
			public void run() {
				int f = 0;
				for (;;) {
//					lock.lock();
					f = flag;
//					lock.unlock();
					if (flag == 100000000) {
						System.out.println("end");
						break;
					}
				}
			}
		};
		
		Thread t = new Thread(run);
		Thread t2 = new Thread(run2);
		t.start();
		t2.start();
	}
}
