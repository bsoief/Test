package test.volatiles.main;

/**
 * ����synchronized��volatile���滻
 * @author admin
 */
public class Main2 {
	
	private static boolean flag = true;
	
	public static synchronized boolean getFlag() {
		return flag;
	}
	
	public static synchronized void setFlag(boolean flag) {
		Main2.flag = flag;
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
				System.out.println("Main2.flag : " + Main2.flag);
				Main2.flag = false;
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.out.println("exception ");
				}
				System.exit(0);
			}
		};
		
		Thread t = new Thread(run);
		t.start();
		
		while (true) {
			// ���synchronized���η�����ʹ���̻߳�ȡ����ֵʱ�������ڴ����»�ȡ
			// ���ֱ��ʹ��Main2.flag�����޷���ȡ���޸ĺ��flagֵ
			if (getFlag() == false) {
				System.out.println(flag);
				break;
			}
		}
	}
}
