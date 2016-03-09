package bg.ittalents.duper.model;

// POJO
public class Driver {
	private int id;
	private String name;
	private float tariff;
	
	
	public Driver(int id, String name, float tariff) {
		this.id = id;
		this.name = name;
		this.tariff = tariff;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getTariff() {
		return tariff;
	}
	public void setTariff(float tariff) {
		this.tariff = tariff;
	}
}
