
public class Shemadjiq implements Runnable {

	private IShtaiga myShtaiga;
	private Thread mySelyanin;

	public Shemadjiq(IShtaiga myShtaiga, Thread selyanin) {
		super();
		this.myShtaiga = myShtaiga;
		this.mySelyanin=selyanin;
	}

	@Override
	public void run() {
		while (mySelyanin.isAlive()|| !myShtaiga.isEmpty()) {
			while (myShtaiga.isEmpty()) {
				System.out.println("Az sm shemadjiq i shte pochakam");
				synchronized (myShtaiga) {
					try {
						myShtaiga.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			try {
				Thread.sleep(10);
				
				synchronized (myShtaiga) {
					
					System.out.println("Sega vzeh tova " + myShtaiga.vzemiFruit());
				
					if(myShtaiga.daliSePoizprazni()){
						System.out.println("Shte izvikam onq da proizvede neshto ");
						myShtaiga.notifyAll();
					}
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
