
public interface ISecuredNotepad{
	void addText(int pageNumber, String text,String password);

	void replaceText(int pageNumber, String text,String password);

	void deleteText(int pageNumber,String password);

	void showPages(String password);
	
	boolean isPasswordStrong(String password);
}
