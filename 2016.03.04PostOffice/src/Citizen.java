import java.util.ArrayList;
import java.util.List;

public class Citizen implements Runnable {
	private static final int NUMBER_OF_ITEMS = 30;
	private String firstName;
	private String lastName;
	private String address;
	private static  PostOffice postOffice;

	private static List<Mailbox> mailboxes ;
	
	
	static{
		mailboxes= new ArrayList<Mailbox>();
		for(int mailbox=1;mailbox<=25;mailbox++){
			mailboxes.add(new Mailbox());
		}
		postOffice= new PostOffice();
	}

	public Citizen(String firstName, String lastName, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Citizen [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}

	@Override
	public void run() {
		for (int numberOfLetters = 1; numberOfLetters < NUMBER_OF_ITEMS; numberOfLetters++) {
			try {
				System.out.println("Shte pratq obekt nomer " + numberOfLetters);
				sendRandomMailObject();
			} catch (MailboxException e) {
				e.printStackTrace();
			}

		}

	}

	private MailObject sendRandomMailObject() throws MailboxException {
		MailObject result = null;
		if (Math.random() > 0.5) {
			result = new Letter(this, new Citizen("Hrisos", "Da ima", "bul.andrei lqpchev"));
			int randomIndex = (int) (Math.random() * mailboxes.size());
			
			Mailbox mailbox = mailboxes.get(randomIndex);
			if (Math.random() > 0.5) {
				System.out.println("Shte pusna tuk pismo v kutiq " + randomIndex);
				mailbox.addLetter((Letter) result);
			} else {
				System.out.println("Shte go pusna v offisa");
				postOffice.addMailObject(result);
			}
			mailbox.addLetter((Letter) result);

		} else {
			result = new Parcel(this, new Citizen("Mara", "otvarachkata", "nqkyv adress"), generateRandom(),
					generateRandom(), generateRandom(), Math.random() > 0.5);
			postOffice.addMailObject(result);
			System.out.println("Shte pusna kolet");

		}
		return result;
	}

	

	public static List<Mailbox> getMailboxes() {
		return mailboxes;
	}

	private int generateRandom() {
		return (int) (Math.random() * 100);
	}

	public static PostOffice getPostOffice() {
		return postOffice;
	}

}
