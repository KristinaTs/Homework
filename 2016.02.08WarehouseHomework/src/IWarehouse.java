
public interface IWarehouse {
void productsDelivery();

boolean isFull();
boolean isFullEnoughForStore();
Product productTake(Product product) throws WarehouseException;

}
