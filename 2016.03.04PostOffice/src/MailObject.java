
public abstract class MailObject {
	private Citizen sender;
	private Citizen receiver;
	public MailObject(Citizen sender, Citizen receiver) {
		
		super();
		this.sender = sender;
		this.receiver = receiver;
	}
	
	public abstract float getTax();
	public abstract float getTimeToDeliver();

	public Citizen getSender() {
		return sender;
	}

	public void setSender(Citizen sender) {
		this.sender = sender;
	}

	public Citizen getReceiver() {
		return receiver;
	}

	public void setReceiver(Citizen receiver) {
		this.receiver = receiver;
	}
	
	
}
