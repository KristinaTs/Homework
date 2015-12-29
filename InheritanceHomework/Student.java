
public class Student extends Person {
	private double score;

	Student(String name, int age, boolean isMale, double score) {
		super(name, age, isMale);
		if (score > 1 && score < 7) {
			this.score = score;
		} else {
			this.score = 0;
		}

	}

	public void setScore(double score) {
		if (score > 2 && score < 6) {
			this.score = score;
		} else {
			this.score = 2;
		}
	}

	public double getScore() {
		return this.score;
	}

	void showStudentInfo() {
		this.showPersonInfo();
		System.out.println(" score: " + this.score);
		
	}

}
