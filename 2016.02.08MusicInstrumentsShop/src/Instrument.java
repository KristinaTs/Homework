
public class Instrument {
	private String name;
	private double price;
	private int stock;
	private InstrumentType type;
	private int numberOfSales = 0;

	public int getNumberOfSales() {
		return numberOfSales;
	}

	public void setNumberOfSales(int numberOfSales) {
		if (numberOfSales > 0)
			this.numberOfSales = numberOfSales;
	}

	public Instrument(String name, double price, int stock) throws InvalidInstrumentException {
		if (name != null && price > 0 && stock > 0) {
			this.name = name;
			this.price = price;
			this.stock = stock;

		} else {
			throw new InvalidInstrumentException("The data you have entered is incorrect!");
		}
	}

	public void setType(InstrumentType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public InstrumentType getType() {
		return type;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Instrument) {
			if (this.name.equals(((Instrument) obj).name)) {
				return true;
			}
		}
		return false;
	}

}
