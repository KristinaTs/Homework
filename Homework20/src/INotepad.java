
public interface INotepad {
	void addText(int pageNumber, String text);

	void replaceText(int pageNumber, String text);

	void deleteText(int pageNumber);

	void showPages();

	boolean searchWord(String word);
	
	void printAllPagesWithDigits();
}
