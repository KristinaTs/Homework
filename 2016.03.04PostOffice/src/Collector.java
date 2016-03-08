import java.util.List;

public class Collector extends Postman {

	public Collector(String firstName, String lastName, String address) {
		super(firstName, lastName, address);

	}
	@Override
	public int getProcessedMailObjects() {
		return 0;
	}

	@Override
	public void run() {
		while (true) {
			while (getPostOffice().getNumberOfMailObjects() >= MINIMUM_NUMBER_OF_LETTERS) {
				synchronized (getPostOffice()) {
					try {
						System.out.println("Az sm collector i shte chakam zashoto ima mnogo pisma");
						getPostOffice().wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println("Sega shte sloja pisma v poshtata");

			for (Mailbox mailbox : getMailboxes()) {
				List<Letter> list = mailbox.getAll();
				getPostOffice().addMailObject(list);
				System.out.println("Shte dobavq pisma v poshtata");
				synchronized (getPostOffice()) {
					getPostOffice().notifyAll();
				}
			}

		}
	}

}
