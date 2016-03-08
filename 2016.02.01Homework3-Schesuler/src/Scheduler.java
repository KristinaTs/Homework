import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Scheduler {

	Queue<Task> taskQueue = new LinkedList<Task>();
	
	
	void push(Task task) throws InvalidTaskException{
		if(task!=null){
		taskQueue.offer(task);
		}else{
			throw new InvalidTaskException("There is no such task");
		}
	}
	
	void main(){
		for(Iterator it=taskQueue.iterator();it.hasNext();){
			Task task=(Task) it.next();
			task.doWork();
			it.remove();
			
		}
	}
	
	
	
}
