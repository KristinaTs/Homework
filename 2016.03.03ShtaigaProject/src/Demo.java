
public class Demo {
	public static void main(String[] args) {
		for(int index=0;index<=100;index++){
		IShtaiga myShtaiga = new Shtaiga();
		Thread sel= new Thread(new Selyanin(myShtaiga));
		sel.start();
		new Thread(new Shemadjiq(myShtaiga,sel)).start();
		}
	}

}
