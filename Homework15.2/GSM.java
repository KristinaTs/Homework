
public class GSM {
	
		public String model;
		boolean hasSimCard;
		String simMobileNumber;
		int outgoingCallsDuration;
		Call lastIncomingCall;
		Call lastOutgoingCall;


	
		public void insertSimCard(String simMobileNumber) {
			if(simMobileNumber.charAt(0)=='0' && simMobileNumber.charAt(1)=='8' && simMobileNumber.length()==10 ){
				this.simMobileNumber=simMobileNumber;
				hasSimCard=true;
			}else{
				System.out.println("Wrong number!");
			}
			
		}

		void removeSimCard(){
			hasSimCard=false;
			this.simMobileNumber="";
		}
		void call(GSM receiver,int duration){
			if(this.hasSimCard==true && receiver.hasSimCard==true && duration>=0 && this.simMobileNumber.equals(receiver.simMobileNumber)==false){
				Call call=new Call();
				call.duration=duration;
				this.lastOutgoingCall=call;
				receiver.lastIncomingCall=call;
				this.outgoingCallsDuration+=duration;
			}else{
				System.out.println("Invalid call");
			}
		}
		double getSumForCall(){
			return (this.outgoingCallsDuration)*Call.priceForAMinute;
		}
		void printInfoForTheLastOutgoingCall(){
			if(this.lastOutgoingCall!=null){
			System.out.println(this.lastOutgoingCall);
			}else{
				System.out.println("No outgoing call");
			}
		}
		void printInfoForTheLAstIncomingCall(){
			if(this.lastIncomingCall!=null){
			System.out.println(this.lastIncomingCall);
			}else{
				System.out.println("No incoming calls");
			}
		}
		



	


}
