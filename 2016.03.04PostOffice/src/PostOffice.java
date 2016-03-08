import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PostOffice {

	private Map<LocalDate, List<MailObject>> archive = new TreeMap<LocalDate, List<MailObject>>();
	private List<MailObject> repository = new LinkedList<MailObject>();

	private static Set<Postman> staff = new HashSet<Postman>();

	void registerPostMan(Postman postman) {

		staff.add(postman);
	}

	class PostOfficeQueryManager {

		public List<MailObject> getMailObjectsByDate(LocalDate date) throws MailboxException {
			if (archive.containsKey(date))
				return archive.get(date);
			throw new MailboxException("Nqma pisma na tazi data");
		}

		public double getProcentOfLetters() {
			List<MailObject> lettersForToday = archive.get(LocalDate.now());
			int numberOfLetters = 0;
			for (MailObject m : lettersForToday) {
				if (m instanceof Letter) {
					numberOfLetters++;
				}
			}
			return (double) numberOfLetters / lettersForToday.size() * 100.00;
		}

		public double gerPercentOfProcessedFragilePercels() {
			int total = 0;
			int numberOfProcessedFragilePercels = 0;
			for (LocalDate date : archive.keySet()) {
				for (MailObject m : archive.get(date)) {
					if (m instanceof Parcel) {
						if (((Parcel) m).isFragile() && !repository.contains(m)) {
							numberOfProcessedFragilePercels++;
						}
						total++;
					}

				}
			}
			return (double) numberOfProcessedFragilePercels / total * 100;
		}

		public void printInfoForPostMan() {
			ArrayList<Postman> list = new ArrayList<Postman>(staff);
			Collections.sort(list, (p1, p2) -> p1.getProcessedMailObjects() - p2.getProcessedMailObjects());
			for (Postman p : list) {
				System.out.println(p.toString() + " obraboti " + p.getProcessedMailObjects());
			}
		}

	}

	public int getNumberOfMailObjects() {
		return repository.size();
	}

	public void addMailObject(MailObject mail) {
		this.addMailObject(Arrays.asList(mail));

	}

	public void addMailObject(List<? extends MailObject> mailObjects) {
		if (mailObjects != null) {
			synchronized (repository) {
				repository.addAll(mailObjects);
			}
			synchronized (archive) {
				if (!archive.containsKey(LocalDate.now())) {
					archive.put(LocalDate.now(), new LinkedList<MailObject>());
				}
				archive.get(LocalDate.now()).addAll(mailObjects);
			}
		}
	}

	public List<MailObject> takeMails(int number) throws MailboxException {

		synchronized (repository) {
			if (number > repository.size())
				number = repository.size();
			List<MailObject> result = repository.subList(0, number);
			repository.removeAll(result);
			return result;
		}

	}

}
