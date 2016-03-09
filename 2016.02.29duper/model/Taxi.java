package bg.ittalents.duper.model;

public class Taxi {
	private int id;
	private String model;
	private Driver driver;
	
	public Taxi(int id, String model, Driver driver) {
		this.setId(id);
		this.model = model;
		this.driver = driver;
	}
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	

}
