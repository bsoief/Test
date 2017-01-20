package test.ioblock.main;

import java.util.Scanner;

/**
 * 测试IO阻塞是否是线程阻塞（请使用jvisualvm工具查看线程状态，实际为RUNNABLE状态）
 * @author admin
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}

	public static void test1() {
		Runnable run = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Scanner scanner = new Scanner(System.in);
				System.out.println("请输入");
				System.out.println(scanner.next());
				scanner.close();
			}
		};
		
		Thread t = new Thread(run);
		t.start();
	}
}
