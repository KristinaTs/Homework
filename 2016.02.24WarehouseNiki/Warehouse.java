import java.util.List;

public class Warehouse extends TradeObject {
	
	private static final int HOW_MANY_TO_DELIVER = 5;
	private static final int MININUM_QUANTITY_IN_WAREHOUSE = 15;
	static final int QUANTITY_TO_ADD = 25;
	

	@Override
	public void addDefficitGoods() {
		// has defficit 
		List<Product> defProducts = defficitGoods(MININUM_QUANTITY_IN_WAREHOUSE);
		for (Product p : defProducts) {
			try {
				this.addProduct(p, QUANTITY_TO_ADD);
			} catch (WarehouseException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Product getProductByName(String name) {
		return new Product(name, ProductType.FRUITS);
	}

	@Override
	public void takeGoods(String name, int quantity) {
		Product product = getProductByName(name);
		
		while (defficitGoods(MININUM_QUANTITY_IN_WAREHOUSE).contains(product)) {
			try {
				synchronized (this) {
					wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			this.sellProduct(product, quantity);
			synchronized (this) {
				notifyAll();
			}
		} catch (WarehouseException e) {
			e.printStackTrace();
		}
		
	}
	
	public void takeGoods(String name) {
		this.takeGoods(name, HOW_MANY_TO_DELIVER);
	}
	
	
}
