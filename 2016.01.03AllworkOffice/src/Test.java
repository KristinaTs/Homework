
public class Test {

	public static void main(String[] args) {

		Task t = new Task("Domashno", 5);
		Employee noob = new Employee("Atanas");
		Employee ivan = new Employee("Ivan");
		Employee isus = new Employee("Hristos");
		Employee jesus = new Employee("Hose");

		Task game = new Task("Igra na tronove", 8);
		Task waterFill = new Task("SomeWater", 5);
		Task web = new Task("Ednajena.bg", 4);
		Task designe = new Task("Ploshadka", 3);
		Task throwTrash = new Task("Razhodi se", 11);
		Task program = new Task("Calculator", 17);
		Task sims = new Task("DevelopingSims", 9);
		Task belot = new Task("Belot", 6);
		Task poker = new Task("Poker", 7);
		Task blackJack = new Task("Black Jack", 21);

		AllWork workInOffice = new AllWork();
		workInOffice.addTask(game);
		workInOffice.addTask(waterFill);
		workInOffice.addTask(web);
		workInOffice.addTask(designe);
		workInOffice.addTask(throwTrash);
		workInOffice.addTask(program);
		workInOffice.addTask(sims);
		workInOffice.addTask(belot);
		workInOffice.addTask(poker);
		workInOffice.addTask(blackJack);

		Employee.allWork = workInOffice;
		Employee[] workPower = { noob, ivan, isus, jesus };

		while (workInOffice.isAllWorkDone() == false) {

			for (int index = 0; index < workPower.length; index++) {
				workPower[index].startWorkingDay();
			}
			int number = 0;
			while (workPower[number].getHoursLeft() > 0) {

				for (int index1 = number; index1 < workPower.length; index1++) {
					workPower[index1].work();

				}
				number++;
				if (number == 4) {
					number = 0;
				}
				if(workPower[number].getHoursLeft()==0){
					number++;
				}

			}

		}
	}
}