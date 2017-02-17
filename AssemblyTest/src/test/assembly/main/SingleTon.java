package test.assembly.main;

/**
 * @author admin
 *
 */
public class SingleTon {

	private static SingleTon instance;

	public static SingleTon getInstance() {
		if (instance == null) {
			synchronized (SingleTon.class) {
				if (instance == null) {
					instance = new SingleTon();
				}
			}
		}
		return instance;
	}

	private String value;

	private SingleTon() {
		value = "init";
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
