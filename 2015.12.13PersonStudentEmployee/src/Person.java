
public class Person {
	private String name;
	private int age;
	boolean isMale;

	Person(String name, int age, boolean isMale) {
		if (name != null && age > 0) {
			this.name = name;
			this.age = age;
			this.isMale = isMale;
		}
	}

	public void showPersonInfo() {
		System.out.print("Name: " + this.name + " Age: " + this.age);
		if (isMale == true) {
			System.out.println(" Gender: male ");
		} else {
			System.out.println(" Gender: woman ");
		}
		
	}

	void setName(String name) {
		if (name != null) {
			this.name = name;
		}
	}

	String getName() {
		return this.name;
	}

	void setAge(int age) {
		if (age >= 0) {
			this.age = age;
		}
	}

	int getAge() {
		return this.age;
	}
	
	
}
