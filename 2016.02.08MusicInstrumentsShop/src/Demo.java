
public class Demo {
public static void main(String[] args) throws InvalidInstrumentException {
	MusicShop myShop=new MusicShop(2000);
	myShop.buyInstrument("Kitara", 10);
	myShop.buyInstrument("Kitara", 10);
	myShop.buyInstrument("Kitara", 10);
	myShop.buyInstrument("Kitara", 10);
	myShop.buyInstrument("Kitara", 10);
	
	myShop.buyInstrument("¿·‡", 10);

	myShop.buyInstrument("¿ı‡ı", 10);
	myShop.buyInstrument("¡ÂË", 10);

	myShop.showInstrumentByType();
	myShop.showInstrumentByName();
	myShop.showInstrumentByPrice¿scending();
	myShop.showInstrumentByPriceDecreasing();
	
	myShop.InstrumentsInStock();
	
	Dostavchik dostavchika = new Dostavchik(myShop);
	myShop.setDostavchik(dostavchika);
	Thread dostavchik = new Thread(dostavchika);
	dostavchik.start();
	
	Client clienta = new Client("Joro", myShop);
	Thread client = new Thread(clienta);
	client.start();
	
	
	
	
}
}
