import java.time.LocalDateTime;
import java.util.Comparator;

public class Magazine extends ReadingMaterial {

	private LocalDateTime date;
	private int number;
	
	public Magazine(LocalDateTime date, int number,String name, String publisher) {
		super(name, publisher);
		this.date=date;
		this.number=number;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public boolean canBeTaken() {
		return false;
	}

	@Override
	public String toString() {
		return "Magazine [date=" + date + ", number=" + number + ", getName()=" + getName() + ", getPublisher()="
				+ getPublisher() + "]";
	}

	@Override
	public Comparator getComparator() {
		return new MagazineComparator();
	}
	public int getSecondsForTake() throws LibraryException {
		throw new LibraryException("Sposanieto ne se vzima");
	}

	@Override
	public Double getPrice() throws LibraryException {
	throw new LibraryException("Nqma taksa za tova spisanie");
	}

}
