package test.volatiles.main;

import java.util.Date;

import test.volatiles.staticobject.Person;

/**
 * 测试volatile对对象的作用
 * @author admin
 */
public class Main3 {

	public static volatile Person person = new Person();
	static {
		person.setMale(false);
	}
	public static void test1() {
		Runnable run = new Runnable() {
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
				System.out.println("setMale");
				person.setMale(true);
			}
		};
		Thread t = new Thread(run);
		t.start();
		Boolean result = person.isMale() == true;
		while (true) {
			if (result) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}

}
