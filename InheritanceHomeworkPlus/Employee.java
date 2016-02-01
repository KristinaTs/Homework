
public class Employee {
	private String name;
	private Task currentTask;
	private int hoursLeft;
	static AllWork allWork;
	
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
	
	public void startWorkingDay(){
		this.setHoursLeft(8);
	}
	
	public int getHoursLeft(){
		return this.hoursLeft;
		
	}
	public void setHoursLeft(int hours){
		if(hours>=0){
			this.hoursLeft=hours;
		}else{
			this.hoursLeft=0;
		}
		
	}
	
	public String getCurrentTask(){
		if(currentTask!=null){
		return this.currentTask.getName();
		}
		return null;
	}
	
	public void setCurrentTask(Task task){
		if(task!=null){
			this.currentTask=task;
		}
	}
	public void work(){
		
		if(Employee.allWork !=null && Employee.allWork.isAllWorkDone()==false){
			if(this.hoursLeft==0){
				return;
			}
			Task task=Employee.allWork.getNextTask();
			this.setCurrentTask(task);
			Employee.allWork.setCurrentUnassingTask();
			
			}
		if(this.currentTask!=null && this.currentTask.getWorkingHours()>0 && this.hoursLeft>0){
			
			if(this.currentTask.getWorkingHours()>=this.hoursLeft){
			this.currentTask.setWorkingHours(this.currentTask.getWorkingHours()-this.hoursLeft);
			this.hoursLeft=0;
			this.showReport();
			//Employee.allWork.setCurrentUnassingTask();
			return;
			}else{
			this.hoursLeft-=this.currentTask.getWorkingHours();
			this.currentTask.setWorkingHours(0);
			this.showReport();
			
			}
		}
	}
	public void showReport(){
		System.out.println("The name of the employee is: " + this.name);
		if(this.currentTask!=null){
			System.out.println("The name of the task is : " + this.currentTask.getName());
			System.out.println("The hours left on the task are: " + this.currentTask.getWorkingHours());
		}
		System.out.println("Hours left at work for the employee are :" + this.hoursLeft);
	}
}
