package test.deadlock.staticobject;

public class ClassA {
	
	public synchronized static void m1() {
		System.out.println("ClassA.m1 start");
		for (int i = 0; i < 100; i++) {
			
		}
		ClassB.m2();
	}
	
	public synchronized static void m2() {
		System.out.println("ClassA.m2 start");
	}
}
