package test.staticobject.main;

import test.staticobject.object.Person;

/**
 * 测试静态final的类对象能否被修改（可以）
 * @author Administrator
 *
 */
public class Main {
	
	private static final Person person = new Person();

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
					System.out.println("interrupt");
				}
				System.out.println("person : " + person.getId());
			}
		};
		
		Thread t = new Thread(run);
		t.start();
		
		person.setId(2);
	}
}
