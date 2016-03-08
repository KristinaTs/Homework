
public class ElectronicSecuredNotepad extends SecuredNotepad implements IElectronicDevice {
	private boolean isStarted = false;

	public ElectronicSecuredNotepad(String password, int numberOfPages) throws Exception {
	super(password, numberOfPages);

	}

	@Override
	public void start() {
		System.out.println("The device is on");
		this.isStarted = true;

	}

	@Override
	public void stop() {
		System.out.println("The device is off");
		this.isStarted = false;

	}

	@Override
	public boolean isStarted() {
		if (isStarted) {
			return true;
		}
		return false;
	}

	@Override
	public void addText(int pageNumber, String text, String password) {
		if(isStarted==true){
		super.addText(pageNumber, text, password);
		}else{
			System.out.println("No can do");
		}
	}

	@Override
	public void replaceText(int pageNumber, String text, String password) {
		if(isStarted==true){
		super.replaceText(pageNumber, text, password);
		}else{
			System.out.println("No can do");
		}
	}

	@Override
	public void deleteText(int pageNumber, String password) {
		if(isStarted==true){
		super.deleteText(pageNumber, password);
		}else{
			System.out.println("No can do");
		}
	}

	@Override
	public void showPages(String password) {
		if(isStarted==true){
		super.showPages(password);
		}else{
			System.out.println("No can do");
		}
	}
	
	
}
