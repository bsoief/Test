package test.volatiles.main;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
				person.setMale(true);
			}
		};
		Thread t = new Thread(run);
		t.start();

		while (true) {
			if (person.isMale() == true) {
				System.out.println(person.isMale());
				break;
			}
		}
	}
}
