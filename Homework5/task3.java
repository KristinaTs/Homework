import java.util.Scanner;

public class task3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1= scan.next();
		String str2= scan.next();
		boolean areSame=true;
		
		if(str1.length()==str2.length()){
			System.out.println("����� ���� �� � ����� �������.");
			System.out.println("������� �� �������:");
			
			for(int index=0; index<str1.length();index++){
				if(str1.charAt(index)!=str2.charAt(index)){
					areSame=false;
					System.out.println(index + " " + str1.charAt(index)+ "-" + str2.charAt(index));
					
				}
				}
			if(areSame==true){
				System.out.println("���� �������.");
			}
		}
		if(str1.length()<str2.length()){
			System.out.println("����� ���� �� � �������� �������.");
			}
		if(str2.length()<str1.length()){
			System.out.println("����� ���� �� � �������� �������.");
			}
		
			
		
		
		

	}

}

