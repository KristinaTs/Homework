
public class DemoScheduler {

	public static void main(String[] args) throws InvalidTaskException {
		Scheduler myTasks = new Scheduler();
		DoHomework myHomework = new  DoHomework();
		DoMakeUp myMakeUp = new DoMakeUp();
		DoTheDishesh dishesh = new DoTheDishesh();
		DoTheLaundry laundry = new DoTheLaundry();
		
		myTasks.push(myHomework);
		myTasks.push(myMakeUp);
		myTasks.push(dishesh);
		myTasks.push(laundry);
		
		myTasks.main();
		
	}

}
