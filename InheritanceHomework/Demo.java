
public class Demo {

	public static void main(String[] args) {
		Person[] people = new Person[10];
		
		Person sladkar = new Person("Pesho",56,true);
		Person dyado = new Person("Ivan",35,true);
		
		Student numberOne= new Student("Krisi",20,false,6.0);
		Student secondOne= new Student("Kaloyan",19,true,6.0);
		
		Employee employeeOfTheMonth=new Employee("Yavor",22,true,8.5);
		Employee worstEmployee=new Employee("Aneta",20,false,6.5);
		
		people[0]=sladkar;
		people[1]=dyado;
		people[2]=numberOne;
		people[3]=secondOne;
		people[4]=employeeOfTheMonth;
		people[5]=worstEmployee;
		
		int index=0;
		while(people[index]!=null){
			if (people[index] instanceof Student) {
				((Student) people[index]).showStudentInfo();
				index++;
				continue;
				}
			
			if (people[index] instanceof Employee) {
			((Employee) people[index]).showEmployeeInfo();
			index++;
			continue;
			}
			
			if (people[index] instanceof Person) {
				( people[index]).showPersonInfo();
				}
			index++;
			}
		
		int index1=0;
		while(people[index1]!=null){
			if (people[index1] instanceof Employee) {
				System.out.println("Overtime: " +((Employee) people[index1]).calculateOvertime(2));
			
				}
			index1++;
		}
		
		

	}

}
