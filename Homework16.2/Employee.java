
public class Employee {
	private String name;
	private Task currentTask;
	private int hoursLeft;
	
	public Employee(String name) {
		if (name != null) {
			this.name = name;

		}
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		if(name!=null){
			this.name=name;
		}
	}
	
	
	public int getHoursLeft(){
		return this.hoursLeft;
	}
	public void setHoursLeft(int hours){
		this.hoursLeft=hours;
		
	}
	
	public String getTask(){
		return this.currentTask.getName();
	}
	
	public void setTask(Task task){
		if(task!=null){
			this.currentTask=task;
		}
	}
	public void work(){
		if(this.currentTask!=null && this.currentTask.getWorkingHours()>0 && this.hoursLeft>0){
			if(this.currentTask.getWorkingHours()>=this.hoursLeft){
			this.currentTask.setWorkingHours(this.currentTask.getWorkingHours()-this.hoursLeft);
			this.hoursLeft=0;
			this.showReport();
			}else{
			this.hoursLeft-=this.currentTask.getWorkingHours();
			this.currentTask.setWorkingHours(0);
			this.showReport();
			}
		}
	}
	public void showReport(){
		System.out.println(this.name);
		if(this.currentTask!=null){
			System.out.println(this.currentTask.getName());
			System.out.println(this.currentTask.getWorkingHours());
		}
		System.out.println(this.hoursLeft);
	}
}
