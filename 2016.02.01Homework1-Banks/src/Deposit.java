
public class Deposit extends BankProduct {

	private double payedMoneyPerMonth;

	public Deposit(int annualInterestRate, int period, double moneyInProduct) {
		super(annualInterestRate, period, moneyInProduct);

	}

	public double getPayedMoneyPerMonth() {
		return payedMoneyPerMonth;
	}

	public void setPayedMoneyPerMonth(double payedMoneyPerMonth) {
		this.payedMoneyPerMonth = payedMoneyPerMonth;
	}

}
