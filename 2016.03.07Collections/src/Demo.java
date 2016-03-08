import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
	List<String> arrayList= new ArrayList<String>();
	LinkedList<String> linkedList=new LinkedList<String>();
	
	arrayList.add("String1");
	//arrayList.add(5, "String4");ne pozvolqva ako nqmame dostatychno mqsto
	linkedList.addFirst("String2");
	
	//linkedList.add(5, "String3"); ne pozvolqva ako nqma predishen index
	//arrayList.get(3);
	
	MyRunnable runnable = new MyRunnable();
	Thread t1= new Thread(runnable, "Thread1");
	Thread t2= new Thread(runnable, "Thread2");
	Thread t3= new Thread(runnable, "Thread3");
	
	t1.start();
	t2.start();
	t3.start();
	
	t1.join();
	t2.join();
	t3.join();
	
	System.out.println("Main thread");
	
	
	}
	
	
	

}
