package test.singleton.object;

/**
 * 使用静态类来延迟加载
 * @author admin
 *
 */
public class SingleTon {

	private static class Single {
		private static SingleTon instance = new SingleTon();
	}
	
	public static SingleTon getInstance() {
		return Single.instance;
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
