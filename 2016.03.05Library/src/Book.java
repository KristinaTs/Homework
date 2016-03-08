import java.time.LocalDateTime;
import java.util.Comparator;

public class Book extends ReadingMaterial {

	@Override
	public String toString() {
		return "Book [author=" + author + ", date=" + date + ", getName()=" + getName() + ", getPublisher()="
				+ getPublisher() + "]";
	}

	private String author;
	private LocalDateTime date;

	public Book(LocalDateTime date, String autror, String name, String publisher) {
		super(name, publisher);
		this.author = autror;
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public Comparator getComparator() {
		return new BookComparator();

	}

	@Override
	public int getSecondsForTake() {
		return 3000;
	}

	@Override
	public Double getPrice() {
		return 2.0;
	}
}
