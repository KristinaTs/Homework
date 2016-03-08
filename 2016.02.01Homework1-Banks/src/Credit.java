
public class Credit extends BankProduct {

	private double monthlyPayment;

	public Credit(int annualInterestRate, int period, double moneyInProduct) {
		super(annualInterestRate, period, moneyInProduct);

	}

	public void calculateMonthlyPayment() {
		this.monthlyPayment = this.getMoneyInProduct() / this.getPeriod();
	}

	public double getMontlyPayment() {
		calculateMonthlyPayment();
		return this.monthlyPayment;
	}

}
