
public class Client implements Runnable {

	private Shop shop;
	
	public Client(Shop shop) {
		this.shop = shop;
	}


	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				return;
			}
			String[] names = new String[]
					{"Banana","Tomato","Apple","Beef","Chicken","Cucumber"};
			
			String randomName = names[(int) (Math.random() * names.length)];
			try {
				shop.sellProduct(new Product(randomName, 
						ProductType.VEGETABLES), ((int)(Math.random() * 4)) + 1);
			} catch (WarehouseException e) {
				e.printStackTrace();
			}
		}
	}

}
