package test.ioblock.main;

import java.util.Scanner;

/**
 * ����IO�����Ƿ����߳���������ʹ��jvisualvm���߲鿴�߳�״̬��ʵ��ΪRUNNABLE״̬��
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
				System.out.println("������");
				System.out.println(scanner.next());
				scanner.close();
			}
		};
		
		Thread t = new Thread(run);
		t.start();
	}
}
