

public class demo {
	public static void main(String[] args) throws InvalidDataException, NoMoneyException {
		Bank bulgarianBank = Bank.createTheBank("Bulgarian Bank", "address yeah", 1_000_000);

		Customer[] clients = { new Customer("MItko", "bul.Bulgaria", 30000, 1000),
				new Customer("Sasha", "bul.Bulgaria", 50000, 2000), new Customer("Vasil", "bul.Bulgaria", 60000, 1200),
				new Customer("Petkan", "bul.Bulgaria", 2000, 1300), new Customer("Tihomir", "bul.Bulgaria", 6000, 1400),
				new Customer("Blagoi", "bul.Bulgaria", 10000, 1500), new Customer("Stefan", "bul.Bulgaria", 1000, 1600),
				new Customer("Hristo", "bul.Bulgaria", 66000, 1700), new Customer("Iliqn", "bul.Bulgaria", 2500, 1800),
				new Customer("Batvlad", "bul.Bulgaria", 3400, 1900), };

		for (int index = 0; index < clients.length; index++) {

			double random = Math.random() * ((clients[index].getBalance() * 20) / 100)
					+ (clients[index].getBalance() * 80) / 100;
			if (index % 2 == 0) {
				clients[index].leaveShortDeposit(random);
			} else {
				clients[index].leaveLongDeposit(random);
			}

		}

		System.out.println("Money in the bank " +bulgarianBank.getMoneyInBank());
		System.out.println("Money in the reserve "+bulgarianBank.getReserve());

		for (int index = 0; index < clients.length; index++) {

			double random = Math.random() * 1000 + 100;
			if (index % 2 == 0) {
				clients[index].askForCredit(new HomeCredit(10, random));
			} else {
				clients[index].askForCredit(new ConsumerCredit(5, random));
			}

		}
		
		for(Customer client : clients){
			System.out.println(client.getName());
			client.seeDeposits();
			client.seeCredits();
		}
		System.out.println("Money in the bank " +bulgarianBank.getMoneyInBank());
		System.out.println("Money in the reserve "+bulgarianBank.getReserve());
		

	}

}
