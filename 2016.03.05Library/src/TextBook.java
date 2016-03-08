import java.util.Comparator;

public class TextBook extends ReadingMaterial {
	@Override
	public String toString() {
		return "TextBook [author=" + author + ", getName()=" + getName() + ", getPublisher()=" + getPublisher() + "]";
	}

	private String author;

	public TextBook(String author,String name, String publisher) {
		super(name, publisher);
		this.author=author;
	
	}

	@Override
	public Comparator getComparator() {
		return  new TextBookComparator();
	}
	
	public int getSecondsForTake() {
		return 1500;
	}

	@Override
	public Double getPrice() {
		return 3.0;
	}

}
