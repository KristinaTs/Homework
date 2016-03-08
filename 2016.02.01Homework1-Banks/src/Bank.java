import java.util.ArrayList;

public class Bank {
	private static Bank theBank = null;
	private String name;
	private String address;
	private double moneyInBank;
	private double reserve;
	private ArrayList<BankProduct> bankProducts = new ArrayList<BankProduct>(10);

	private Bank(String name, String address, double moneyInBank) {
		if(name!=null)
		this.name = name;
		if(address!=null)
		this.address = address;
		if(moneyInBank>0)
		this.moneyInBank = moneyInBank;
		this.reserve=(moneyInBank*10)/100;

	}

	public static Bank createTheBank(String name, String address, double moneyInBank) {
		if (theBank == null) {
			if (name != null && address != null & moneyInBank > 0) {
				theBank = new Bank(name, address, moneyInBank);
			} // else {
			// throw new InvalidDataException("Invalid name, address or money in
			// bank!");
			// }

		}
		return theBank;

	}

	public void takeDeposit(BankProduct deposit) throws InvalidDataException {
		if (deposit.getMoneyInProduct() > 0) {
			this.moneyInBank += deposit.getMoneyInProduct();
			this.reserve += ((deposit.getMoneyInProduct() * 90) / 100);
			bankProducts.add(deposit);
		} else {
			throw new InvalidDataException("Deposit money should be more than 0!");
		}
	}

	public void updateDeposits() {
		for (BankProduct product : bankProducts) {
			if (product != null && product instanceof Deposit) {
				double rate = ((Deposit) product).calculatePerMonthlyRate();
				((Deposit) product).setPayedMoneyPerMonth(product.getMoneyInProduct() * rate);
				product.setMoneyInProduct(product.getMoneyInProduct() + product.getMoneyInProduct() * rate);
				this.moneyInBank-=product.getMoneyInProduct() + product.getMoneyInProduct() * rate;
			}
		}
	}

	public boolean giveCredit(Customer cusmoter, Credit newCredit) throws NoMoneyException {
		boolean success = true;
		if (cusmoter != null && newCredit != null) {
			if (cusmoter.checkIfOKForCredit(newCredit) && newCredit.getMoneyInProduct()<this.reserve) {
				bankProducts.add(newCredit);
				this.moneyInBank-=newCredit.getMoneyInProduct();
				this.reserve-=(newCredit.getMoneyInProduct()*90)/100;
			}else{
				success=false;
				throw new NoMoneyException("No more money in the bank!");
			}
		}
		return success;
	}
	
	public double getReserve() {
		return reserve;
	}


	public void takeMoneyFromCredit(Credit credit){
		if(credit!=null)
		this.moneyInBank+=credit.getMontlyPayment();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getMoneyInBank() {
		return moneyInBank;
	}

}
