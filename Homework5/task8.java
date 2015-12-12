import java.util.Scanner;

public class task8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		
		String str=scan.next();
		int begging=0;
		int end=str.length()-1;
		boolean isPalidrome=true;
		while(begging<str.length()/2 && end>str.length()/2 ){
			if(str.charAt(begging)!=str.charAt(end)){
				isPalidrome=false;
			}
			begging++;
			end--;
		}
		if(isPalidrome==true){
			System.out.println("Да");
		}else{
			System.out.println("Не");
		}

	}
	

}
