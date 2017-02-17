package test.singleton.main;

import test.singleton.object.SingleTon;
import test.singleton.object.SingleTon2;

/**
 * 单例模式测试
 * @author admin
 *
 */
public class Main {

	public static void main(String[] args) {
		// 先获取单例，再循环。不使用volatile或synchronized，会导致重排序问题
//		test1();
		// 先获取单例，再循环。对单例的类使用synchronized加锁，也不能阻止重排序问题
//		test2();
		// 先获取单例，再循环。对单例的对象使用synchronized加锁，也不能阻止重排序问题
//		test3();
		// 先获取单例，再循环。对单例的方法使用volatile和synchronized加锁，也不能阻止重排序问题
//		test4();
		test5();
	}

	public static void test1() {
		Runnable run = new Runnable() {
			@Override
			public void run() {
				SingleTon instance = SingleTon.getInstance();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("InterruptedException happen");
				}
				instance.setValue("test1");
			}
		};

		Runnable run2 = new Runnable() {
			@Override
			public void run() {
				SingleTon instance = SingleTon.getInstance();
				System.out.println("run2 instance.getValue() : " + instance.getValue());
				while (true) {
					if ("test1".equals(instance.getValue())) {
						System.out.println(instance.getValue());
						break;
					}
				}
				System.out.println("run2 instance.getValue() : " + instance.getValue());
			}
		};

		Thread t = new Thread(run);
		Thread t2 = new Thread(run2);
		t.start();
		t2.start();
	}

	public static void test2() {
		Runnable run = new Runnable() {
			@Override
			public void run() {
				SingleTon instance = SingleTon.getInstance();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("InterruptedException happen");
				}
				instance.setValue("test1");
			}
		};

		Runnable run2 = new Runnable() {
			@Override
			public void run() {
				SingleTon instance = SingleTon.getInstance();
				System.out.println("run2 instance.getValue() : " + instance.getValue());
				synchronized (SingleTon.class) {
					while (true) {
						if ("test1".equals(instance.getValue())) {
							System.out.println(instance.getValue());
							break;
						}
					}
				}
				System.out.println("run2 instance.getValue() : " + instance.getValue());
			}
		};

		Thread t = new Thread(run);
		Thread t2 = new Thread(run2);
		t.start();
		t2.start();
	}

	public static void test3() {
		Runnable run = new Runnable() {
			@Override
			public void run() {
				SingleTon instance = SingleTon.getInstance();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("InterruptedException happen");
				}
				instance.setValue("test1");
				System.out.println("run1 value has set");
			}
		};

		Runnable run2 = new Runnable() {
			@Override
			public void run() {
				SingleTon instance = SingleTon.getInstance();
				System.out.println("run2 instance.getValue() : " + instance.getValue());
				synchronized (instance) {
					while (true) {
						if ("test1".equals(instance.getValue())) {
							System.out.println(instance.getValue());
							break;
						}
					}
				}
				System.out.println("run2 instance.getValue() : " + instance.getValue());
			}
		};

		Thread t = new Thread(run);
		Thread t2 = new Thread(run2);
		t.start();
		t2.start();
	}

	public static void test4() {
		Runnable run = new Runnable() {
			@Override
			public void run() {
				SingleTon instance = SingleTon.getInstance();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("InterruptedException happen");
				}
				instance.setValue("test1");
				System.out.println("run1 value has set");
			}
		};

		Runnable run2 = new Runnable() {
			@Override
			public void run() {
				SingleTon2 instance = SingleTon2.getInstance();
				System.out.println("run2 instance.getValue() : " + instance.getValue());
				synchronized (instance) {
					while (true) {
						if ("test1".equals(instance.getValue())) {
							System.out.println(instance.getValue());
							break;
						}
					}
				}
				System.out.println("run2 instance.getValue() : " + instance.getValue());
			}
		};

		Thread t = new Thread(run);
		Thread t2 = new Thread(run2);
		t.start();
		t2.start();
	}

	public static void test5() {
		Runnable run = new Runnable() {
			@Override
			public void run() {
				SingleTon instance = SingleTon.getInstance();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("InterruptedException happen");
				}
				instance.setValue("test1");
				System.out.println("run1 value has set");
			}
		};

		Runnable run2 = new Runnable() {
			@Override
			public void run() {
				synchronized (SingleTon.class) {
					while (true) {
						SingleTon instance = SingleTon.getInstance();
						if ("test1".equals(instance.getValue())) {
							System.out.println(instance.getValue());
							break;
						}
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
