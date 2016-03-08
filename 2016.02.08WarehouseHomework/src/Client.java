import org.omg.CORBA.Current;

public class Client implements Runnable {

	private static final String[] productsNames = { "Banana", "Orange", "Apple", "Potato", "Eggplant", "Cucumber",
			"Pork", "Beef", "Chicken" };

	private Store myStore;

	public Client(Store myStore) {
		this.myStore = myStore;
	}

	@Override
	public void run() {

		synchronized (myStore) {
			while(!myStore.isStoreFull()){
				try {
					myStore.wait();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			int nameOfProduct = (int) (Math.random() * productsNames.length);
			if (productsNames[nameOfProduct].equals("Banana") || productsNames[nameOfProduct].equals("Orange")
					|| productsNames[nameOfProduct].equals("Apple")) {
				myStore.sellProduct(new Product(productsNames[nameOfProduct], 5, ProductsType.FRUIRT));

			}
			if (productsNames[nameOfProduct].equals("Potato") || productsNames[nameOfProduct].equals("Eggplant")
					|| productsNames[nameOfProduct].equals("Cucumber")) {
				myStore.sellProduct(new Product(productsNames[nameOfProduct], 5, ProductsType.VEGETABLE));

			}
			if (productsNames[nameOfProduct].equals("Pork") || productsNames[nameOfProduct].equals("Beef")
					|| productsNames[nameOfProduct].equals("Chicken")) {
				myStore.sellProduct(new Product(productsNames[nameOfProduct], 5, ProductsType.MEAT));

			}
			

			myStore.notifyAll();
		}
	}

}
