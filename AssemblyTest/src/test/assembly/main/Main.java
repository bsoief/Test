package test.assembly.main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}

	public static void test1() {
		SingleTon instance = SingleTon.getInstance();
		System.out.println(instance.getValue());
	}
}
