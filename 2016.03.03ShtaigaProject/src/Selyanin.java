
public class Selyanin implements Runnable {
	private static final int KOLKO_DA_PROIZVEDE = 100;
	private IShtaiga myShtaiga;

	public Selyanin(IShtaiga myShtaiga) {
		if (myShtaiga != null)
			this.myShtaiga = myShtaiga;
	}

	@Override
	public void run() {
		final String[] fruits = { "qbylki", "nar", "domati", "mango", "dyuli", "mushuli", "galagunki", "slivki",
				"zarzali" };

		for (int count = 1; count <= KOLKO_DA_PROIZVEDE && !Thread.currentThread().isInterrupted();) {
			while (myShtaiga.isFull()) {
				System.out.println("Shtaigata mi e pylna:selyaninShte chakam");
				try {
					synchronized (myShtaiga) {
						myShtaiga.wait();
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
			}

			for (int index = 1; index <= 10; index++) {
				try {
					String fruit = fruits[(int) (Math.random() * fruits.length)];
					myShtaiga.turiFruit(fruit);
					System.out.println("Az sm selyanin i shte turna tozi product " + fruit);
					count++;
					synchronized (myShtaiga) {
						if (myShtaiga.daliSePonapylni()) {
							System.out.println("Selqynin sm i shte izvikam da kupuvat");
							myShtaiga.notifyAll();
						}
					}
				} catch (ShtaigaException e) {

				}
			}

		}
	}
}
