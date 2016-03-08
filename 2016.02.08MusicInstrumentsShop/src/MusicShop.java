
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MusicShop {

	private volatile double money;
	private volatile double moneyFromSails = 0;
	private Dostavchik dostavchik;

	

	public MusicShop(double money) {
		super();
		this.money = money;
		
	}

	public Dostavchik getDostavchik() {
		return dostavchik;
	}

	public void setDostavchik(Dostavchik dostavchik) {
		if(dostavchik!=null)
		this.dostavchik = dostavchik;
	}

	private ConcurrentMap<String, Instrument> instrumentsInShop = new ConcurrentHashMap<String, Instrument>();
	private ConcurrentMap<String, Instrument> soldInstruments = new ConcurrentHashMap<String, Instrument>();

	public void sellInstrument(String name, int stock) throws InvalidInstrumentException {
		this.check(name, stock);
		if (!instrumentsInShop.containsKey(name)) {
			System.out.println("You will have your instrument in 5 seconds");
			dostavchik.deliverSpecialInstrument(name, stock);
		}
		if (instrumentsInShop.get(name) == null) {
			throw new InvalidInstrumentException(
					"There is no such instrument, please check if the name is correct:" + name);
		}

		int instrumentStockAvailable = instrumentsInShop.get(name).getStock();
		Instrument instrumentInShop = instrumentsInShop.get(name);
		if (instrumentInShop.getStock() < 0) {
			throw new InvalidInstrumentException("There is no more left of the product");
		}

		// sells the instrument and decreases the value for stock
		if (stock > 0 && instrumentsInShop.containsKey(name) && instrumentStockAvailable >= stock) {
			System.out.println("We sold " + stock + " of " + name);
			this.money += instrumentsInShop.get(name).getPrice() * stock;
			instrumentInShop.setStock(instrumentInShop.getStock() - stock);
			this.moneyFromSails += instrumentsInShop.get(name).getPrice() * stock;

			// adds the instrument to the soldInstruments list
			for (String key : instrumentsInShop.keySet()) {
				if (soldInstruments.containsKey(key)) {
					int numberOfSales = soldInstruments.get(key).getNumberOfSales();
					numberOfSales++;
					soldInstruments.get(key).setNumberOfSales(numberOfSales);
				} else {
					soldInstruments.put(key, new Instrument(instrumentsInShop.get(key).getName(), instrumentsInShop.get(key).getPrice(), instrumentStockAvailable));
					if(instrumentsInShop.get(key)!=null)
					soldInstruments.get(key).setNumberOfSales(1);
				}
			}

		}
	}

	public void buyInstrument(String name, int stock) throws InvalidInstrumentException {
		this.check(name, stock);
		if (instrumentsInShop.containsKey(name)) {
			int currentStock = instrumentsInShop.get(name).getStock();
			instrumentsInShop.get(name).setStock(currentStock + stock);
		} else {
			instrumentsInShop.put(name, new Instrument(name, (Math.random() * 40) + 1, stock));
			instrumentsInShop.get(name).setType(InstrumentType.STRUNNI);
		}
	}

	public void check(String name, int stock) throws InvalidInstrumentException {

		if (name == null || name.equals("")) {
			throw new InvalidInstrumentException("The name of the instrument is invalid");
		}

		if (stock < 0) {
			throw new InvalidInstrumentException("The count is too low");
		}

	}

	public void showInstrumentByType() {
		for (String key : instrumentsInShop.keySet()) {
			System.out.println("Duhovi:");
			if (instrumentsInShop.get(key) != null && instrumentsInShop.get(key).getType() != null
					&& instrumentsInShop.get(key).getType().equals(InstrumentType.DUHOVI)) {
				System.out.println(instrumentsInShop.get(key).getName());
			}
			System.out.println("Elektronni:");
			if (instrumentsInShop.get(key) != null && instrumentsInShop.get(key).getType() != null
					&& instrumentsInShop.get(key).getType().equals(InstrumentType.ELEKTRONNI)) {
				System.out.println(instrumentsInShop.get(key).getName());
			}
			System.out.println("Klavishni:");
			if (instrumentsInShop.get(key) != null && instrumentsInShop.get(key).getType() != null
					&& instrumentsInShop.get(key).getType().equals(InstrumentType.KLAVISHNI)) {
				System.out.println(instrumentsInShop.get(key).getName());
			}
			System.out.println("Strunni:");
			if (instrumentsInShop.get(key) != null && instrumentsInShop.get(key).getType() != null
					&& instrumentsInShop.get(key).getType().equals(InstrumentType.STRUNNI)) {
				System.out.println(instrumentsInShop.get(key).getName());
			}
			System.out.println("Udarni:");
			if (instrumentsInShop.get(key) != null && instrumentsInShop.get(key).getType() != null
					&& instrumentsInShop.get(key).getType().equals(InstrumentType.UDARNI)) {
				System.out.println(instrumentsInShop.get(key).getName());
			}
		}
	}

	public void showInstrumentByName() {
		java.util.List<String> nameList = new ArrayList<String>(instrumentsInShop.keySet());
		Object arrayOfInstruments[] = nameList.toArray();

		sortByName(arrayOfInstruments);
		for (Object instrument : arrayOfInstruments) {
			if (instrument != null) {
				System.out.println(instrument);
			}
		}

	}

	public void showInstrumentByPrice¿scending() {
		java.util.List<Instrument> priceList = new ArrayList<Instrument>(instrumentsInShop.values());
		Object arrayOfInstruments[] = priceList.toArray();
		sortByPrice¿scending(arrayOfInstruments);
		for (Object instrument : arrayOfInstruments) {
			if (instrument != null) {
				System.out.println(((Instrument) instrument).getName() + " " + ((Instrument) instrument).getPrice());
			}
		}

	}

	public void showInstrumentByPriceDecreasing() {
		java.util.List<Instrument> priceList = new ArrayList<Instrument>(instrumentsInShop.values());
		Object arrayOfInstruments[] = priceList.toArray();
		sortByPriceDecreased(arrayOfInstruments);
		for (Object instrument : arrayOfInstruments) {
			if (instrument != null) {
				System.out.println(((Instrument) instrument).getName() + " " + ((Instrument) instrument).getPrice());
			}
		}

	}

	public void InstrumentsInStock() {
		for (String key : instrumentsInShop.keySet()) {
			if (instrumentsInShop.get(key).getStock() > 0) {
				System.out.println(instrumentsInShop.get(key).getName());
			}
		}
	}

	public void showInstrumentsByNumberOfSales() {
		java.util.List<Instrument> numberOfSalesList = new ArrayList<Instrument>(soldInstruments.values());
		Object arrayOfInstruments[] = numberOfSalesList.toArray();
		sortByNumberOfSales(arrayOfInstruments);
		for (Object instrument : arrayOfInstruments) {
			if (instrument != null) {
				System.out.println(
						((Instrument) instrument).getName() + " " + ((Instrument) instrument).getNumberOfSales());
			}
		}

	}

	public void showMostSoldInstrument() {
		java.util.List<Instrument> numberOfSalesList = new ArrayList<Instrument>(soldInstruments.values());
		Object arrayOfInstruments[] = numberOfSalesList.toArray();
		sortByNumberOfSales(arrayOfInstruments);
		System.out.println(arrayOfInstruments[0]);
	}

	public void showLeastSoldInstrument() {
		java.util.List<Instrument> numberOfSalesList = new ArrayList<Instrument>(soldInstruments.values());
		Object arrayOfInstruments[] = numberOfSalesList.toArray();
		sortByNumberOfSales(arrayOfInstruments);
		System.out.println(arrayOfInstruments[arrayOfInstruments.length - 1]);
	}

	public void ShowMostCommonSoldTypeOfInstrument() {

		Counter countTypeDuhovi = new Counter(0, InstrumentType.DUHOVI);
		Counter countTypeElektronni = new Counter(0, InstrumentType.ELEKTRONNI);
		Counter countTypeKlavishni = new Counter(0, InstrumentType.KLAVISHNI);
		Counter countTypeStrunni = new Counter(0, InstrumentType.STRUNNI);
		Counter countTypeUdarni = new Counter(0, InstrumentType.UDARNI);

		Counter[] countType = { countTypeDuhovi, countTypeElektronni, countTypeKlavishni, countTypeStrunni,
				countTypeUdarni };
		for (String name : soldInstruments.keySet()) {
			if (soldInstruments.get(name) != null
					&& soldInstruments.get(name).getType().equals(InstrumentType.DUHOVI)) {
				countTypeDuhovi.count++;
			}
			if (soldInstruments.get(name) != null
					&& soldInstruments.get(name).getType().equals(InstrumentType.ELEKTRONNI)) {
				countTypeElektronni.count++;
			}
			if (soldInstruments.get(name) != null
					&& soldInstruments.get(name).getType().equals(InstrumentType.KLAVISHNI)) {
				countTypeKlavishni.count++;
			}
			if (soldInstruments.get(name) != null
					&& soldInstruments.get(name).getType().equals(InstrumentType.STRUNNI)) {
				countTypeStrunni.count++;
			}
			if (soldInstruments.get(name) != null
					&& soldInstruments.get(name).getType().equals(InstrumentType.UDARNI)) {
				countTypeUdarni.count++;
			}

		}

		sortByCountAcseding(countType);
		System.out.println(countType[0].type + " " + countType[0].count);

	}

	public void ShowLeastCommonSoldTypeOfInstrument() {

		Counter countTypeDuhovi = new Counter(0, InstrumentType.DUHOVI);
		Counter countTypeElektronni = new Counter(0, InstrumentType.ELEKTRONNI);
		Counter countTypeKlavishni = new Counter(0, InstrumentType.KLAVISHNI);
		Counter countTypeStrunni = new Counter(0, InstrumentType.STRUNNI);
		Counter countTypeUdarni = new Counter(0, InstrumentType.UDARNI);

		Counter[] countType = { countTypeDuhovi, countTypeElektronni, countTypeKlavishni, countTypeStrunni,
				countTypeUdarni };
		for (String name : soldInstruments.keySet()) {
			if (soldInstruments.get(name) != null
					&& soldInstruments.get(name).getType().equals(InstrumentType.DUHOVI)) {
				countTypeDuhovi.count++;
			}
			if (soldInstruments.get(name) != null
					&& soldInstruments.get(name).getType().equals(InstrumentType.ELEKTRONNI)) {
				countTypeElektronni.count++;
			}
			if (soldInstruments.get(name) != null
					&& soldInstruments.get(name).getType().equals(InstrumentType.KLAVISHNI)) {
				countTypeKlavishni.count++;
			}
			if (soldInstruments.get(name) != null
					&& soldInstruments.get(name).getType().equals(InstrumentType.STRUNNI)) {
				countTypeStrunni.count++;
			}
			if (soldInstruments.get(name) != null
					&& soldInstruments.get(name).getType().equals(InstrumentType.UDARNI)) {
				countTypeUdarni.count++;
			}

		}

		sortByCountDecreasing(countType);
		System.out.println(countType[0].type + " " + countType[0].count);

	}

	public void setTypeOfInstrument(String name, InstrumentType type) throws InvalidInstrumentException {
		if (name == null || name.equals("") || !instrumentsInShop.containsKey(name)) {
			throw new InvalidInstrumentException("No such instrument");
		} else {
			instrumentsInShop.get(name).setType(type);
		}

	}

	// sort instruments in alphabetical order
	private static void sortByName(Object instruments[]) {
		int index;
		boolean flag = true;
		String temp;

		while (flag) {
			flag = false;
			for (index = 0; index < instruments.length - 1; index++) {
				if (instruments[index] instanceof String)
					if (((String) instruments[index]).compareToIgnoreCase((String) (instruments[index + 1])) > 0) {
						temp = (String) instruments[index];
						instruments[index] = instruments[index + 1];
						instruments[index + 1] = temp;
						flag = true;
					}
			}
		}
	}

	// sort instruments by price ascending
	private static void sortByPrice¿scending(Object instruments[]) {
		int index;
		boolean flag = true;
		Object temp;

		while (flag) {
			flag = false;
			for (index = 0; index < instruments.length - 1; index++) {
				if (instruments[index] instanceof Instrument)
					if (((Instrument) instruments[index]).getPrice() > ((Instrument) (instruments[index + 1]))
							.getPrice()) {
						temp = (Instrument) instruments[index];
						instruments[index] = instruments[index + 1];
						instruments[index + 1] = temp;
						flag = true;
					}
			}
		}
	}

	// sorts instruments by price(decrease)
	private static void sortByPriceDecreased(Object instruments[]) {
		int index;
		boolean flag = true;
		Object temp;

		while (flag) {
			flag = false;
			for (index = 0; index < instruments.length - 1; index++) {
				if (instruments[index] instanceof Instrument)
					if (((Instrument) instruments[index]).getPrice() < ((Instrument) (instruments[index + 1]))
							.getPrice()) {
						temp = (Instrument) instruments[index];
						instruments[index] = instruments[index + 1];
						instruments[index + 1] = temp;
						flag = true;
					}
			}
		}
	}

	private static void sortByNumberOfSales(Object instruments[]) {
		int index;
		boolean flag = true;
		Object temp;

		while (flag) {
			flag = false;
			for (index = 0; index < instruments.length - 1; index++) {
				if (instruments[index] instanceof Instrument)
					if (((Instrument) instruments[index]).getNumberOfSales() > ((Instrument) (instruments[index + 1]))
							.getNumberOfSales()) {
						temp = (Instrument) instruments[index];
						instruments[index] = instruments[index + 1];
						instruments[index + 1] = temp;
						flag = true;
					}
			}
		}
	}

	private static void sortByCountAcseding(Counter countType[]) {
		int index;
		boolean flag = true;
		Counter temp;
		while (flag) {

			flag = false;
			for (index = 0; index < countType.length - 1; index++) {
				if (countType[index].count > countType[index + 1].count) {
					temp = countType[index];
					countType[index] = countType[index + 1];
					countType[index + 1] = temp;
					flag = true;
				}
			}
		}
	}

	private static void sortByCountDecreasing(Counter countType[]) {
		int index;
		boolean flag = true;
		Counter temp;
		while (flag) {

			flag = false;
			for (index = 0; index < countType.length - 1; index++) {
				if (countType[index].count < countType[index + 1].count) {
					temp = countType[index];
					countType[index] = countType[index + 1];
					countType[index + 1] = temp;
					flag = true;
				}
			}
		}
		
}
	public void checkForInstument(){
		for(String name : instrumentsInShop.keySet()){
			if(instrumentsInShop.get(name).getStock()==0){
				dostavchik.deliveryForTheMonth(name, 5);
			}
		}
	}

	public class Counter {
		int count;
		InstrumentType type;

		public Counter(int count, InstrumentType type) {
			super();
			this.count = count;
			this.type = type;
		}

	}

}
