package test.singleton.main;

import test.singleton.object.SingleTon;
import test.singleton.object.StaticClass;

/**
 * 单例模式测试
 * @author admin
 *
 */
public class Main {

	public static void main(String[] args) {
		// 不使用volatile或synchronized，会导致重排序问题
		test1();
//		test2();
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
				StaticClass instance = StaticClass.instance;
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("InterruptedException happen");
				}
				instance.setFlag(true);
				StaticClass.staticFlag = true;
			}
		};

		Runnable run2 = new Runnable() {
			@Override
			public void run() {
				StaticClass instance = StaticClass.instance;
				System.out.println("run2 instance.getValue() : " + instance.isFlag());
				System.out.println("run2 StaticClass.staticFlag : " + StaticClass.staticFlag);

				while (true) {
					if (StaticClass.staticFlag == true) {
						System.out.println(StaticClass.staticFlag);
						break;
					}
				}
				System.out.println("run2 instance.getValue() : " + instance.isFlag());
				System.out.println("run2 StaticClass.staticFlag : " + StaticClass.staticFlag);
			}
		};

		Thread t = new Thread(run);
		Thread t2 = new Thread(run2);
		t.start();
		t2.start();
	}
}
