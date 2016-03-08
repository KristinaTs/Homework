
public class LongDeposit extends Deposit{

	private static final int LONG_DEPOSIT_PERIOD = 12;
	private static final int LONG_DEPOSIT_RATE = 5;

	public LongDeposit(double moneyInProduct) {
		super(LONG_DEPOSIT_RATE, LONG_DEPOSIT_PERIOD, moneyInProduct);
		
	}

}
