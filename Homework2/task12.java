
public class task12 {

	public static void main(String[] args) {
		for(int num=100;num<=999;num++){
			int firstDigit=num/100;
			int secondDigit=(num/10)%10;
			int thirtDigit=num%10;
			if(firstDigit==secondDigit || secondDigit==thirtDigit || firstDigit==thirtDigit){
				continue;
			}
			System.out.print(num+ " ");
		}

	}

}
