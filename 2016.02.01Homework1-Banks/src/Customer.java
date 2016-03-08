import java.util.LinkedList;
import java.util.List;



public class Customer {
	
	private static Bank theBank= Bank.createTheBank("THE BIG BANK", "address number1",1000);
	private String name;
	private String address;
	private double balance;
	private double salary;
	private List<Deposit> deposits = new LinkedList<Deposit>();
	private List<Credit> credits= new LinkedList<Credit>();

	public Customer(String name, String address, double balance, double salary) {
		if(name!=null)
		this.name = name;
		if(address!=null)
		this.address = address;
		if(balance>0)
		this.balance = balance;
		if(salary>0)
		this.salary = salary;
	}
	
	public void leaveShortDeposit(double someMoney) throws InvalidDataException{
		if(this.balance>=someMoney){
		if(someMoney>0){
			Deposit deposit = new ShortDeposit(someMoney);
			this.deposits.add(deposit);
			theBank.takeDeposit(deposit);
		}else{
			throw new InvalidDataException("invalid money or period");
		}
	
	}else{
		throw new InvalidDataException("Not enought money");
	}

}
	
	public void leaveLongDeposit(double someMoney) throws InvalidDataException{
		if(this.balance>=someMoney){
		if(someMoney>0){
			Deposit deposit = new LongDeposit(someMoney);
			this.deposits.add(deposit);
			theBank.takeDeposit(deposit);
		}else{
			throw new InvalidDataException("invalid money or period");
		}
	
	}else{
		throw new InvalidDataException("Not enought money");
	}

}
	
	public void askForCredit(Credit newCredit) throws NoMoneyException{
		if(theBank.giveCredit(this, newCredit)){
			this.credits.add(newCredit);
			this.balance+=newCredit.getMoneyInProduct();
		}else{
			throw new NoMoneyException("You don't have money!");				
		}
		
	}
	
	

	public void payCredit(){
		for(Credit credit:credits){
			if(credit!=null){
			this.balance-=credit.getMontlyPayment();
			theBank.takeMoneyFromCredit(credit);
			}
		}
	}
	
	public void addCredit(Credit newCredit){
		if(newCredit!=null){
			credits.add(newCredit);
		}
	}
	
	public boolean checkIfOKForCredit(Credit newCredit){
		double moneyCheck=newCredit.getMontlyPayment();
		for(Credit credit:credits){
			if(credit!=null){
			moneyCheck+=credit.getMontlyPayment();
			}
		}
		
		
		if(moneyCheck>this.salary/2){
		return false;
		}
		return true;
	}
	
	
	public void seeDeposits(){
		for(Deposit deposit: deposits){
			if(deposit!=null){
			System.out.println("The name of the deposit is  " + deposit.getName() +" money in product: "+ deposit.getMoneyInProduct());
			}
		}
	}
	
	public void seeCredits(){
		for(Credit credit: credits){
			if(credits!=null){
			System.out.println("The name of the credit is " + credit.getName() + " money in product: "+credit.getMoneyInProduct());
			}
		}
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	

	
}
