
public class Product {
	private String name;
	private int nalichnost;
	private ProductsType type;



	public Product(String name, int nalichnost, ProductsType type) {
		this.name = name;
		this.nalichnost = nalichnost;
		this.type = type;
	}

	

	public ProductsType getType() {
		return type;
	}

	public int getNalichnost() {
		return nalichnost;
	}

	public void setNalichnost(int nalichnost) {
		this.nalichnost = nalichnost;
	}
	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Product) {
			if (this.getName().equals(((Product) obj).getName())) {
				return true;
			}
		}
		return false;
	}
}
