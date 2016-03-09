package bg.ittalents.duper.model;

import java.time.LocalDateTime;

public class Order {
	private int id;
	private String from;
	private String to;
	private LocalDateTime timeOfOrdering;
	private Taxi taxi;
	
	
	public Order(int id, String from, String to, LocalDateTime timeOfOrdering, Taxi taxi) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.timeOfOrdering = timeOfOrdering;
		this.taxi = taxi;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public LocalDateTime getTimeOfOrdering() {
		return timeOfOrdering;
	}
	public void setTimeOfOrdering(LocalDateTime timeOfOrdering) {
		this.timeOfOrdering = timeOfOrdering;
	}
	public Taxi getTaxi() {
		return taxi;
	}
	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}
	
	
}
