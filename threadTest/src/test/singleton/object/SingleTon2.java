package test.singleton.object;


public class SingleTon2 {

	private static class Single {
		private volatile static SingleTon2 instance = new SingleTon2();
	}

	public static SingleTon2 getInstance() {
		return Single.instance;
	}

	private volatile String value;

	private SingleTon2() {
		value = "init";
	}

	public synchronized String getValue() {
		return value;
	}

	public synchronized void setValue(String value) {
		this.value = value;
	}
}
