
import java.util.ArrayList;
import java.util.List;

public class Store implements Runnable {

	private static final int CUSTOMER_AMOUNT = 5;
	private static final int CAPACITY_FOR_PRODUCT = 30;
	private IWarehouse storeWarehouse;
	private Thread myStore=Thread.currentThread();
	private List<Product> products = new ArrayList<Product>();

	public Store(IWarehouse newWarehouse) {
		if (newWarehouse != null)
			this.storeWarehouse = newWarehouse;
		products.add(new Product("Banana", 15, ProductsType.FRUIRT));
		products.add(new Product("Apple", 15, ProductsType.FRUIRT));
		products.add(new Product("Orange", 15, ProductsType.FRUIRT));
		
		products.add(new Product("Potato", 15, ProductsType.VEGETABLE));
		products.add(new Product("Eggplant", 15, ProductsType.VEGETABLE));
		products.add(new Product("Cucumber", 15, ProductsType.VEGETABLE));
		
		products.add(new Product("Pork", 15, ProductsType.MEAT));
		products.add(new Product("Beef", 15, ProductsType.MEAT));
		products.add(new Product("Chichen", 15, ProductsType.MEAT));
	
		
	}

	

	@Override
	public void run() {
		while (isStoreFull() && !storeWarehouse.isFullEnoughForStore()) {

			try {
				
				storeWarehouse.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
		synchronized (products) {
			this.takeProduct();

		}
	
		
	}

	public boolean isStoreFull() {
		for (int index = 0; index < products.size(); index++) {
			if (products.get(index).getNalichnost() <= CAPACITY_FOR_PRODUCT) {
				return false;
			}
		}
		return true;
	}

	public void takeProduct() {
		for (int index = 0; index < products.size(); index++)
			if (products.get(index).getNalichnost() <= 15) {
				int newNalichnost;
				try {

					Product newProduct = storeWarehouse.productTake(products.get(index));
					newNalichnost = products.get(index).getNalichnost() + newProduct.getNalichnost();
					products.get(index).setNalichnost(newNalichnost);
				} catch (WarehouseException e) {

					e.printStackTrace();
				}

			}
	}

	public void sellProduct(Product product) {
		synchronized (products) {

			for (int index = 0; index < products.size(); index++) {
				if (products.get(index).equals(product)) {
					if (products.get(index).getNalichnost() >= CUSTOMER_AMOUNT) {
						products.get(index).setNalichnost(products.get(index).getNalichnost() - CUSTOMER_AMOUNT);
					} else {
						myStore.notify();
					}
				}
			}
		}
	}
}
