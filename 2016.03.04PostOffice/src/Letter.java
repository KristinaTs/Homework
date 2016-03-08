
public class Letter extends MailObject {

	private static final float TAX = 0.2f;
	private static final int TIME_TO_DELIVER = 1500;

	public Letter(Citizen sender, Citizen receiver) {
		super(sender, receiver);

	}

	@Override
	public float getTax() {
		return TAX;
	}

	@Override
	public float getTimeToDeliver() {
		
		return TIME_TO_DELIVER;
	}

}
