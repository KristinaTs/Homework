package systemCollege;

public class College {

	public static void main(String[] args) {
		Student student1= new Student("Blagoi", "Math", 13);
		Student student2= new Student();
		student2.subject="Music";
		
		student1.receiveScolarship(4, 500);
		System.out.println(student1.money);
		student2.upYear();
		System.out.println(student2.yearInCollege);
		
		StudentGroup group3= new StudentGroup("Math");
		StudentGroup group4= new StudentGroup("Music");
		String str1=student1.subject;
		String str2=group3.groupSubject;
		//System.out.println(str1.equalsIgnoreCase(str2));
		//System.out.println(str1);
		//System.out.println(str2);
		
		group3.addStudent(student1);
		group3.addStudent(student2);
		group4.addStudent(student1);
		group4.addStudent(student2);
		
	
		String theBest = group3.theBestStudent();
		System.out.println(theBest);

	}

}
