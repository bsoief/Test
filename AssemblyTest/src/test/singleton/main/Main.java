package test.singleton.main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}

	public static void test1() {
		SingleTon singleTon = SingleTon.getInstance();
		System.out.println(singleTon.getValue());
	}
}
