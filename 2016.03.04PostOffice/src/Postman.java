import java.util.List;



public class Postman extends Citizen {

	protected static final int MINIMUM_NUMBER_OF_LETTERS = 50;
	private int processedMailObjects=1;

	public Postman(String firstName, String lastName, String address) {
		super(firstName, lastName, address);
		getPostOffice().registerPostMan(this);

	}

	@Override
	public void run() {
		while (true) {
			while (getPostOffice().getNumberOfMailObjects() <= MINIMUM_NUMBER_OF_LETTERS) {
				synchronized (getPostOffice()) {
					try {
						System.out.println("Poshtaliona chaka zashtoto nqma pisma");
						getPostOffice().wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						return;
					}
				}
				System.out.println("Pochvam da gi razdavam");
				int numberOfActivePostMan = Thread.currentThread().getThreadGroup().activeCount();
				int numberOfMailsToGet = getPostOffice().getNumberOfMailObjects() / numberOfActivePostMan;
				try {
					List<MailObject> mails = getPostOffice().takeMails(numberOfMailsToGet);
					for (MailObject m : mails) {

						Thread.sleep((long) m.getTimeToDeliver());
						System.out.println("Shte razdav tozi obekt " + m);

					}
					this.processedMailObjects+=mails.size();
					
					synchronized (getPostOffice()) {
						getPostOffice().notifyAll();
					}
				} catch (MailboxException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public int getProcessedMailObjects() {
		return processedMailObjects;
	}

}
