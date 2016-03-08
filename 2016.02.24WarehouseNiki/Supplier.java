
public class Supplier implements Runnable {

	private Warehouse warehouse;
	
	public Supplier(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@Override
	public void run() {
		while (true) {
			while (!hasDefficitProducts()) {
				try {
					synchronized (warehouse) {
						warehouse.wait();	
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			warehouse.addDefficitGoods();
			
			synchronized (warehouse) {
				warehouse.notifyAll();	
			}
		}
	}

	private boolean hasDefficitProducts() {
		return warehouse.defficitGoods(Warehouse.QUANTITY_TO_ADD).size() > 0;
	}


}
