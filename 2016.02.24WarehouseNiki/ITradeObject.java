
public interface ITradeObject {

	void addDefficitGoods();

	void takeGoods(String name, int quantity);

	public void addProduct(Product p, int quantity) throws WarehouseException;
	
	public void sellProduct(Product p, int quantity) throws WarehouseException;
}