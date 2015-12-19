package systemCollege;

public class Student {
	String name;
	String subject;
	double grade;
	int yearInCollege;
	int age;
	boolean isDegree;
	double money;//money from scholarship
	
	Student(){
		this.grade=4.0;
		this.yearInCollege=1;
		this.isDegree=false;
		this.money=0;
		}

	Student(String name,String subject,int age){
		this();
		if(name!=null){
		this.name=name;
		}
		if(subject!=null){
		this.subject=subject;
		}
		if(age>0){
			this.age=age;
		}
	}
	
	void upYear() {
		if (this.isDegree == false) {
			if (this.yearInCollege < 4) {
				this.yearInCollege++;
			}
			if (this.yearInCollege == 4) {
				isDegree = true;
				System.out.println("You are free!");
			}

		}

	}
	
	double receiveScolarship(double min, double amount){
		if(this.grade>=min && this.age<30){
		this.money+=amount;
		}
		return this.money;
	}
	
	
	
}
