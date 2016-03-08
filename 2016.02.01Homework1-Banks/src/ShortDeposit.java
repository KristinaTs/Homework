
public class ShortDeposit extends Deposit{

	private static final int SHORT_DEPOSIT_RATE = 3;
	private static final int SHORT_DEPOSIT_PERIOD = 3;

	public ShortDeposit(double moneyInProduct) {
		super(SHORT_DEPOSIT_RATE,SHORT_DEPOSIT_PERIOD, moneyInProduct);
		
	}



}
