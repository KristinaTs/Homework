
public class Demo {
public static void main(String[] args) {
	Library lib = new Library();
	Client gergana = new Client(lib);
	Thread t = new Thread(gergana);
	t.start();
	try {
		Thread.sleep(23000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	lib.logTakenMaterials();
}
}
