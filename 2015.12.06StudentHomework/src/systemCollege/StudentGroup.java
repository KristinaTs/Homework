package systemCollege;

public class StudentGroup {
 String groupSubject;
 Student [] students;
 int freePlaces;
 int numberOfStudents=0;
 StudentGroup(){
	 this.students = new Student[5];
	 this.freePlaces=5;
	 
 }
 
 StudentGroup(String subject){
	 this();
	 if(subject!=null){
		 this.groupSubject=subject;
	 }
	 
 }
 void countFreeSpaces(){
	 for(int index=0;index<this.students.length-1;index++){
		 if(this.students[index]!=null){
			 numberOfStudents++;
		 }
	 }
 }
 
 void addStudent(Student s){
	 if(s!=null &&groupSubject!=null && s.subject!=null && s.subject.equalsIgnoreCase(groupSubject)==true&& this.freePlaces>0){
			 this.students[numberOfStudents]=s;
			 this.freePlaces--;
			 this.numberOfStudents++;
			 System.out.println(s.name + ": added to the group");
		 }else{
			 System.out.println("The student is not added");
		 }
	 
 }
 
 void emptyGroup(){
	 this.students = new Student[5];
	 freePlaces=5;
 }
 
 String theBestStudent(){
	 if(this.numberOfStudents>0 && this.students[0]!=null){
	 Student bestStudent=students[0];
	 for(int index=1;index<this.numberOfStudents;index++){
		 if(this.students[index].grade>this.students[index].grade){
			 bestStudent=students[index];
		 }
	 }
	 return bestStudent.name;
	 }
	 return "No students";
	 
 }
 
 void printStudentInGroup(){
	 if(this.students[0]!=null){
		 for(int index=0;index<this.numberOfStudents-1;index++){
		 
		 System.out.println(this.students[index].name + " " + this.students[index].grade+ " "+this.students[index].yearInCollege );
		 }
	 }
	 
 }
}
