
public class Dostavchik implements Runnable {
	private IWarehouse myWarehouse;
	private Thread store;

	public Dostavchik(IWarehouse wareHouse) {
		if (wareHouse != null)
			this.myWarehouse = wareHouse;
	}

	@Override
	public void run() {
		while (myWarehouse.isFull()) {
			try {
				myWarehouse.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}

		

		synchronized (myWarehouse) {
			myWarehouse.productsDelivery();
			if(myWarehouse.isFullEnoughForStore()){
			myWarehouse.notifyAll();
			}
		}

	}

}
