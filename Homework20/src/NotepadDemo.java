
public class NotepadDemo {
	

	public static void main(String[] args) throws Exception {
		SimpleNotepad pad=new SimpleNotepad(20);
		 pad.addText(1, "Have fun");
		 pad.addText(1, "text");
		 pad.showPages();
		 pad.deleteText(3);
		 pad.replaceText(1, "Happy life");
		 pad.showPages();
		
		 SecuredNotepad secure = new SecuredNotepad("poolA12A", 20);
		 secure.addText(1, "text", "poolA12A");
		 secure.showPages("poolA12A");
		 
		
		
		

		 ISecuredNotepad pad2=new SecuredNotepad("poolBBB5",20);
		 pad2.addText(0,"text in interface","poolBBB5");
		 pad2.showPages("poolBBB5");
		
		 ElectronicSecuredNotepad iphone=new ElectronicSecuredNotepad("fake101V",
		 30);
		 iphone.start();
		 iphone.addText(0, "new iphone", "fake101V");
		 iphone.showPages("fake101V");
		 iphone.stop();
		 iphone.showPages("fake101V");

	

	}
}
