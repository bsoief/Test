package test.singleton.object;

public class StaticClass {

	public static StaticClass instance = new StaticClass();
	
	public static boolean staticFlag = false;
	
	private boolean flag;
	
	private StaticClass() {
		flag = false;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
