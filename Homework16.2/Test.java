
public class Test {

	public static void main(String[] args) {

		Task t=new Task("Domashno",5);
		Employee noob= new Employee("Atanas");
		noob.setHoursLeft(8);
		noob.setTask(t);
		noob.work();
		
		
		System.out.println(noob.getName());
	}

}
