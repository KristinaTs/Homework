
public class SecuredNotepad implements ISecuredNotepad {
	private String password;
	private static final int MIN_NUMBER_OF_PAGES = 10;
	private Page[] pages;

	public SecuredNotepad (String password, int numberOfPages)throws Exception {
		if (isPasswordStrong(password)==false) {
			throw new Exception("Invalid Password");
		}else{
			this.password = password;
			if (numberOfPages > 0) {
				this.pages = new Page[numberOfPages];
			} else {
				this.pages = new Page[MIN_NUMBER_OF_PAGES];
			}

			for (int index = 0; index < this.pages.length; index++) {
				this.pages[index] = new Page();
			}
		
		}

	}

	@Override
	public void addText(int pageNumber, String text, String password) {
		if (this.pages != null && this.password != null) {
			if (this.pages[pageNumber] != null && this.password.equals(password)) {
				if (pageNumber >= 0 && pageNumber < this.pages.length) {
					if (this.pages[pageNumber].getText() == null) {
						this.pages[pageNumber].setText(text);
					} else {
						this.pages[pageNumber].setText(this.pages[pageNumber].getText() + " " + text);
					}
				} else {
					System.out.println("No such page");
				}
			} else {
				System.out.println("Incorrect password");
			}
		} else {
			System.out.println("No such object");
		}
	}

	@Override
	public void replaceText(int pageNumber, String text, String password) {
		if (this.password.equals(password)) {
			if (pageNumber >= 0 && pageNumber < this.pages.length && this.pages[pageNumber] != null) {
				this.pages[pageNumber].setText(text);
			} else {
				System.out.println("No such page");
			}
		} else {
			System.out.println("Incorrect password");
		}

	}

	@Override
	public void deleteText(int pageNumber, String password) {
		if (this.password.equals(password)) {
			if (pageNumber >= 0 && pageNumber < this.pages.length && this.pages[pageNumber] != null) {
				this.pages[pageNumber] = null;
			} else {
				System.out.println("No such page");
			}
		} else {
			System.out.println("Incorrect password");
		}
	}

	@Override
	public void showPages(String password) {

		if (this.password.equals(password)) {
			for (int index = 0; index < this.pages.length; index++) {
				if (this.pages[index] != null && this.pages[index].getText() != null) {
					this.pages[index].showPage();
				}
			}
		} else {
			System.out.println("Incorrect password");
		}

	}

	public boolean isPasswordStrong(String password) {
		boolean strong = false;
		int len = password.length();
		int haveDigit = 0;
		int haveLowerCase = 0;
		int haveUpperCase = 0;
		int count = 0;

		if (len >= 5)

		{
			while (count < len) {
				char ch = password.charAt(count);
				if (Character.isDigit(ch)) {
					haveDigit++;
				}
				if (Character.isLowerCase(ch)) {
					haveLowerCase++;
				}
				if (Character.isUpperCase(ch)) {
					haveUpperCase++;
				}
				count++;
			}
		}
		if (haveDigit >= 1 && haveLowerCase >= 1 && haveUpperCase >= 1) {
			strong = true;
		} else {
			strong = false;
		}
		return strong;

	}

}
