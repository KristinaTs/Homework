import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Dostavchik implements Runnable {
	private MusicShop myShop;

	public Dostavchik(MusicShop myShop) {
		super();
		this.myShop = myShop;
	}

	private String instruments[] = { "Accordion", "Acoustic bass guitar", "Acoustic guitar", "Aeolian harp",
			"Agung a Tamlang", "Ahoko", "Ajaeng", "Alboka", "Alphorn", "Alpine bell", "Alto clarinet", "Alto flute",
			"Alto horn", "Alto sarrusophone", "Alto saxophone", "Angklung", "Appalachian dulcimer", "Archlute",
			"Arghul", "Arpa anottolini", "Arpeggione", "Array Mbira", "Aru-ding", "Aulochrome", "Babendil", "Baglama",
			"Balafon" };
	private ConcurrentMap<Instrument, Date> instrumentsInTruck = new ConcurrentHashMap<Instrument, Date>();

	public void addInstrument(Instrument instrument, Date date) {
		if (instrumentsInTruck.containsKey(instrument)) {
			return;
		} else {
			instrumentsInTruck.put(instrument, date);
		}
	}

	private void deliverInstrument() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int name = (int) (Math.random() * instruments.length);
		int stock = (int) (Math.random() * 10 + 1);

		System.out.println("I will deliver " + stock + " of " + instruments[name]);
		synchronized (myShop) {

			try {
				myShop.buyInstrument(instruments[name], stock);
			} catch (InvalidInstrumentException e) {

				e.printStackTrace();
			}
		}
	}

	public void deliverSpecialInstrument(String name, int stock) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("I will deliver " + stock + " of " + name);
		synchronized (myShop) {

			try {
				myShop.buyInstrument(name, stock);
			} catch (InvalidInstrumentException e) {

				e.printStackTrace();
			}
		}
		
	}
	
	public void deliveryForTheMonth(String name, int stock){
		try {
			Thread.sleep(10000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Delivery for the month");
		this.deliverSpecialInstrument(name, stock);
	}

	@Override
	public void run() {
		while (true) {
			this.deliverInstrument();
			// myShop.notifyAll();
		}
	}

}
