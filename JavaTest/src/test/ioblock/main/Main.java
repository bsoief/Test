package test.ioblock.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}

	public static void test1() {
		Runnable run = new Runnable() {
			@Override
			public void run() {
				System.out.println("请输入你的名字：");
				Scanner cin=new Scanner(System.in);
				while (true) {
					String name=cin.nextLine();
					System.out.println(name);
					if ("exit".equals(name)) {
						cin.close();
						break;
					}
				}
				System.exit(0);
			}
		};
		
		Thread t = new Thread(run);
		t.setName("test");
		t.start();
		
	}
}
