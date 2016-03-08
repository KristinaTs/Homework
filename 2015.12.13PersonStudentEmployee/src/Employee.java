
public class Employee extends Person {
	

	private static final double OVERTIME_BONUS_PER_HOUR = 1.5;
	private double daySalary;

	public Employee(String name,int age, boolean isMale,double daySalary) {
		super(name,age,isMale);
		if(daySalary>0){
			this.daySalary=daySalary;
		}
			
	}

	double  calculateOvertime(double hours){
		if(hours>0){
		if(this.getAge()<18){
			return 0;
		}
		return (daySalary/8)*OVERTIME_BONUS_PER_HOUR*hours;
		}
		return 0;
		
	}

	public void showEmployeeInfo() {
		this.showPersonInfo();
		System.out.println(" Daily salary: " + this.daySalary);
	}

	

}
