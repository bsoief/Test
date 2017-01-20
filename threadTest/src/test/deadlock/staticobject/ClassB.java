package test.deadlock.staticobject;

public class ClassB {

	public synchronized static void m1() {
		System.out.println("ClassB.m1 start");
		for (int i = 0; i < 100; i++) {
			
		}
		ClassA.m2();
	}
	
	public synchronized static void m2() {
		System.out.println("ClassB.m2 start");
	}
}
