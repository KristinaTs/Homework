
public class Demo {

	public static void main(String[] args) {
		GSM moq =new GSM();
		GSM tvoq=new GSM();
		
	moq.model="Doogee";
	tvoq.model="Samsung";
	
	moq.hasSimCard=true;
	moq.insertSimCard("0889559434");
	System.out.println(moq.simMobileNumber);
	
	moq.removeSimCard();
	System.out.println(moq.simMobileNumber + moq.hasSimCard);
	
	moq.insertSimCard("0889559434");
	tvoq.insertSimCard("0888102162");
	
	moq.call(tvoq, 2);
	System.out.println(moq.lastOutgoingCall.duration);
	System.out.println(tvoq.lastIncomingCall.duration);
	}
	
	

}
