import java.util.Scanner;

public class task6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�������� ���������� �� ������:");
		int size=scan.nextInt();
		int [] arr = new int [size];
		System.out.println("�������� ����������� � ������:");
		for(int index=0; index<size;index++){
			arr[index]=scan.nextInt();
		}
		
		System.out.println("�������� ���������� �� ������:");
		int size1=scan.nextInt();
		int [] arr1 = new int [size1];
		System.out.println("�������� ����������� � ������:");
		for(int index=0; index<size1;index++){
			arr1[index]=scan.nextInt();
		}
		
		
	
		
		boolean isEquel=false;
		if(size!=size1){
			System.out.println("�������� �� �� � ������� ������");
		}else{
			for(int ind=0; ind<size;ind++){
				if(arr[ind]==arr1[ind]){
					isEquel=true;
				}
			}
			if(isEquel==true){
				System.out.println("������ �� � ������� ������ � �� �������!");
			}else{
				System.out.println("������ �� � ������� ������,�� �� ��������!");
			}
		}
	}

}
