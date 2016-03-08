
public class Demo {

	public static void main(String[] args) {

		Warehouse warehouse = new Warehouse();
		Thread dostavchik = new Thread(new Dostavchik(warehouse));
		dostavchik.start();
		
		Store myStore = new Store(warehouse);
		Thread store = new Thread(myStore);
	
		
		store.start();
		
		
		Magaziner magazinera = new Magaziner(myStore, dostavchik);
		

		for (int index = 0; index < 9; index++) {
			Thread client = new Thread(new Client(myStore));
			client.start();
		}

	}

}
