
public abstract class BankProduct {
	private static long uniqueName = 100_000;
	private long name;
	private double annualInterestRate;
	private double monthlyInterestRate;
	private int period;
	private double moneyInProduct;

	public BankProduct(int annualInterestRate, int period, double moneyInProduct) {
		this.name = uniqueName;
		uniqueName++;

		if (annualInterestRate > 0) {
			this.annualInterestRate = annualInterestRate;
		}
		if (period > 0)
			this.period = period;
		if (moneyInProduct > 0)
			this.moneyInProduct = moneyInProduct;
	}

	public double calculatePerMonthlyRate() {
		this.monthlyInterestRate = this.getAnnualInterestRate() / 12;
		return this.monthlyInterestRate;
	}

	public long getName() {
		return name;
	}

	public void setName(long name) {
		this.name = name;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public double getMoneyInProduct() {
		return moneyInProduct;
	}

	public void setMoneyInProduct(double moneyInProduct) {
		this.moneyInProduct = moneyInProduct;
	}

}
