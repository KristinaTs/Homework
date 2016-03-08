
public class Magaziner implements Runnable {

	private Store myStore;
	private Thread dostavchik;

	public Magaziner(Store myStore, Thread dostavchik) {
		super();
		this.myStore = myStore;
		this.dostavchik = dostavchik;
	}

	@Override
	public void run() {

		while (myStore.isStoreFull()) {
			synchronized (myStore) {
				try {
					myStore.wait();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		}

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		synchronized (myStore) {
			if(!myStore.isStoreFull()){
				myStore.notifyAll();
			}

		}
	}
}
