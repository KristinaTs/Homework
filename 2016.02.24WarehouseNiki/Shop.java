import java.util.List;

public class Shop extends TradeObject  {

	private static final int QUANTITY_TO_ADD = 10;
	private static final int MININUM_QUANTITY_IN_SHOP = 5;
	private Warehouse warehouse;

	public Shop(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
//	run ()
//	{
//	addDefficitGoods();
//	}
	@Override
	public void addDefficitGoods() {
		List<Product> products = defficitGoods(MININUM_QUANTITY_IN_SHOP);
		if (products.size() > 0) {
			for (Product p : products) {
				try {
					warehouse.takeGoods(p.getName());
					this.addProduct(p, QUANTITY_TO_ADD);
				} catch (WarehouseException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Product getProductByName(String name) {
		return new Product(name, ProductType.FRUITS);
	}

	@Override
	public void takeGoods(String name, int quantity) {
		Product product = getProductByName(name);
		
		while (defficitGoods(MININUM_QUANTITY_IN_SHOP).contains(product)) {
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
			
			addDefficitGoods();
		} catch (WarehouseException e) {
			e.printStackTrace();
		}
		
	}
}
