
public class AllWork {
	private static final int MAX_NUMBER_OF_TASKS = 10;
	Task[] tasks;
	private int freePlacesForTasks;
	private int currentUnassingTask = 0;
	private int count = 0;

	public AllWork() {

		this.tasks = new Task[MAX_NUMBER_OF_TASKS];
		freePlacesForTasks = MAX_NUMBER_OF_TASKS;
		this.currentUnassingTask = 0;
	}

	public void setCurrentUnassingTask() {
		this.currentUnassingTask++;
	}

	public int countTasks() {

		for (int index = 0; index < this.tasks.length; index++) {
			if (this.tasks[index] != null) {
				count++;
			}
		}
		return count;

	}

	public void addTask(Task task) {
		if (this.freePlacesForTasks >= 0) {
			this.tasks[count] = task;
			count++;
			freePlacesForTasks--;
		} else {
			System.out.println("No more room");
		}
	}

	public Task getNextTask() {
		for (int index = 0; index < this.tasks.length; index++) {
			if (this.tasks[index] != null && this.tasks[index].getWorkingHours() > 0) {
				currentUnassingTask = index;
				break;
			}
		}
		return this.tasks[currentUnassingTask];
	}

	public boolean isAllWorkDone() {

		boolean allWork = true;
		for (int index = 0; index < tasks.length; index++) {
			if (tasks[index] != null) {
				int hoursLeft = tasks[index].getWorkingHours();
				if (hoursLeft > 0) {
					allWork = false;
				}
			}
		}

		return allWork;
	}

}
