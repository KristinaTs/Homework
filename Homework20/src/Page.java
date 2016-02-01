
public class Page {
	private String name;
	private String text;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {

		this.text = text;

	}

	public void deleteText() {
		this.text = null;
	}

	public void showPage() {
		if(this.name!=null){
		System.out.println(this.name);
		}else{
			System.out.println("No title");
		}
		if(this.text!=null){
			System.out.println(this.text);
		}else{
			System.out.println("No text");
		}
		
		

	}

	public boolean searchWord(String word) {
		if (this.text!=null && this.text.contains(word)) {
			return true;
		}
		return false;

	}
	
	public final boolean containsDigit() {
	    boolean containsDigit = false;

	    if (this.text != null && !this.text.isEmpty()) {
	        for (char c : this.text.toCharArray()) {
	            if (containsDigit = Character.isDigit(c)) {
	                break;
	            }
	        }
	    }

	    return containsDigit;
	}

}
