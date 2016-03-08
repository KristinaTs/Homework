import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class TradeObject implements ITradeObject {
	
	private static final int DEFAULT_QUANTITY = 15;
	private Map<Product, Integer> products = 
			new ConcurrentHashMap<Product, Integer>();
	
	public TradeObject() {
		for (String productName : Arrays.asList("Banana", "Orange", "Apple")) {
			products.put(new Product(productName, ProductType.FRUITS), DEFAULT_QUANTITY);
		}
		
		for (String productName : Arrays.asList("Potato", "Eggplant", "Cucumber")) {
			products.put(new Product(productName, ProductType.VEGETABLES), DEFAULT_QUANTITY);
		}
		
		for (String productName : Arrays.asList("Pork", "Beef", "Chicken")) {
			products.put(new Product(productName, ProductType.MEATS), DEFAULT_QUANTITY);
		}
	}
	
	public void addProduct(Product p, int quantity) throws WarehouseException {
		if (quantity > 0 && p != null && products.containsKey(p)) {
			products.put(p, products.get(p) + quantity);
		}
		else {
			throw new WarehouseException("Kvi sa tiq parametri be galmak!");
		}
	}
	
	public void sellProduct(Product p, int quantity) throws WarehouseException {
		if (quantity > 0 && p != null && products.containsKey(p) && quantity <= products.get(p)) {
			products.put(p, products.get(p) - quantity);
		}
		else {
			throw new WarehouseException("Kvi sa tiq parametri be galmak!");
		}
	}
	
	/* (non-Javadoc)
	 * @see ITradeObject#addGoods()
	 */
	@Override
	public abstract void addDefficitGoods();
	
	/* (non-Javadoc)
	 * @see ITradeObject#takeGoods(java.lang.String, int)
	 */
	@Override
	public abstract void takeGoods(String name, int quantity);
	
	public List<Product> defficitGoods(int minimumQuantity) {
		List<Product> defProd = new ArrayList<Product>();
		
		for (Product p : products.keySet()) {
			if (products.get(p) <= minimumQuantity) {
				defProd.add(p);
			}
		}
		
		return defProd;
	}
}
