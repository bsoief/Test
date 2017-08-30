package test.proto.main;

/**
 * 另外可使用“D:\software\java\jdk1.7\jdk1.7\jre\bin\java -server -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly >> log2.txt”
 * 命令查看CPU执行的汇编指令
 * @author admin
 *
 */
public class Main {

	volatile int a = 1;

	static int b = 2;

	public int sum(int c) {
		return a + b +c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		main.sum(3);
	}

}
