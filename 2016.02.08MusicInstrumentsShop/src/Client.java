
public class Client implements Runnable {
	private String name;
	private MusicShop myShop;

	private String instruments[] = { "Accordion", "Acoustic bass guitar", "Acoustic guitar", "Aeolian harp",
			"Agung a Tamlang", "Ahoko", "Ajaeng", "Alboka", "Alphorn", "Alpine bell", "Alto clarinet", "Alto flute",
			"Alto horn", "Alto sarrusophone", "Alto saxophone", "Angklung", "Appalachian dulcimer", "Archlute",
			"Arghul", "Arpa anottolini", "Arpeggione", "Array Mbira", "Aru-ding", "Aulochrome", "Babendil", "Baglama",
			"Balafon" };

	public Client(String name, MusicShop myShop) {
		this.name = name;
		this.myShop = myShop;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int name = (int) (Math.random() * instruments.length);
			int stock = (int) (Math.random() * 3 + 1);
			try {
				myShop.sellInstrument(instruments[name], stock);
				System.out.println("I bought " + stock + "  " + instruments[name]);

			} catch (InvalidInstrumentException e) {
				e.printStackTrace();
			}
		}
	}

}
