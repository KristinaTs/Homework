
public class SimpleNotepad implements INotepad {
	private static final int MIN_NUMBER_OF_PAGES = 10;
	private Page[] pages;

	public SimpleNotepad(int numberOfPages) {
		if (numberOfPages > 0) {
			this.pages = new Page[numberOfPages];
		} else {
			this.pages = new Page[MIN_NUMBER_OF_PAGES];
		}

		for (int index = 0; index < this.pages.length; index++) {
			this.pages[index] = new Page();
		}
	}

	// public int count() {
	//
	// int count = 0;
	// for (int index = 0; index < this.pages.length; index++) {
	// if (this.pages[index] != null) {
	// count++;
	// }
	// }
	// return count;
	// }

	@Override
	public void addText(int pageNumber, String text) {
		if (pageNumber >= 0 && pageNumber < this.pages.length && this.pages[pageNumber] != null) {
			if (this.pages[pageNumber].getText() == null) {
				this.pages[pageNumber].setText(text);
			} else {
				this.pages[pageNumber].setText(this.pages[pageNumber].getText() + " " + text);
			}
		} else {
			System.out.println("No such page");
		}

	}

	@Override
	public void replaceText(int pageNumber, String text) {
		if (pageNumber >= 0 && pageNumber < this.pages.length && this.pages[pageNumber] != null) {
			this.pages[pageNumber].setText(text);
		} else {
			System.out.println("No such page");
		}

	}

	@Override
	public void deleteText(int pageNumber) {
		if (pageNumber >= 0 && pageNumber < this.pages.length && this.pages[pageNumber] != null) {
			this.pages[pageNumber].deleteText();
		} else {
			System.out.println("No such page");
		}

	}

	@Override
	public void showPages() {
		for (int index = 0; index < this.pages.length; index++) {
			if (this.pages[index] != null && this.pages[index].getText() != null) {
				this.pages[index].showPage();
			}

		}

	}

	@Override
	public boolean searchWord(String word) {
		for (int index = 0; index < this.pages.length; index++) {
			if (this.pages[index] != null && this.pages[index].searchWord(word)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void printAllPagesWithDigits() {
		for (int index = 0; index < this.pages.length; index++) {
			if (this.pages[index] != null && this.pages[index].containsDigit()) {
				this.pages[index].showPage();

			}
		}
	}
}
