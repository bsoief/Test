package test.deadlock.main;

import test.deadlock.staticobject.ClassA;
import test.deadlock.staticobject.ClassB;

/**
 * 测试synchronized死锁
 * @author admin
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		test1();
	}

	public static void test1() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				ClassA.m1();
			}
		};

		Runnable runnable2 = new Runnable() {
			@Override
			public void run() {
				ClassB.m1();
			}
		};

		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable2);
		t1.start();
		t2.start();
	}
}
