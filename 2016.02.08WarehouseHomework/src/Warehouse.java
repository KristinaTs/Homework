import java.util.ArrayList;
import java.util.List;



public class Warehouse implements IWarehouse {

	private static final double FULLNESS_COEFFICIENT = 0.5;
	private static final int MAX_CAPACITY_PER_PRODUCT = 40;
	private static final int MIN_PRODUCTS = 5;
	private static final int MAX_CAPACITY_OF_WAREHOUSE = 60;
	private String ProductsNames[] = { "Banana", "Orange", "Apple", "Potato", "Eggplant",
			"Cucumber", "Pork", "Beef","Chicken" };

	private List<Product> products = new ArrayList<Product>();

	public Warehouse() {
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
	public void productsDelivery() {

		synchronized (products) {
			for (int index = 0; index < products.size(); index++) {
				if (products.get(index) != null && products.get(index).getNalichnost() <= MIN_PRODUCTS) {
					int nalichnost = products.get(index).getNalichnost() + 25;
					products.get(index).setNalichnost(nalichnost);
				}
			}
		}
	}

	@Override
	public Product productTake(Product product) throws WarehouseException {
		synchronized (products) {
			for (int index = 0; index < products.size(); index++) {
				if (products.get(index).equals(product)) {
					if (products.get(index).getNalichnost() <= 5) {
						throw new WarehouseException("Not enough products");
					} else {
						products.get(index).setNalichnost(products.get(index).getNalichnost() - 5);
					}
				}

			}

			return new Product(product.getName(), 5 , product.getType());
		}
	}

	@Override
	public boolean isFull() {
		boolean isFull = true;
		for (int index = 0; index < products.size(); index++) {
			if (products.get(index).getNalichnost() < MAX_CAPACITY_PER_PRODUCT) {
				isFull = false;
			}
		}

		return isFull;
	}

	public boolean isFullEnoughForStore() {
		return products.size() >= (int) (MAX_CAPACITY_OF_WAREHOUSE * FULLNESS_COEFFICIENT);
	}

}
