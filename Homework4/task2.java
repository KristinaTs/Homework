import java.util.Scanner;

public class task2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("�������� ���������� �� �����a:");
		int size = scan.nextInt();
		int [][] arr = new int[size][size];
		
		System.out.println("�������� ����������� � �����a:");
		for(int row=0; row<size;row++){
			for(int col=0;col<size;col++){
			arr[row][col]=scan.nextInt();
			}
		}
		
		System.out.print("������ �������� �: ");
		for(int index=0;index<size;index++){
			System.out.print(arr[index][index]+ " ");
		}
		System.out.println();
		
		System.out.print("������ �������� �: ");
		int r=3;
		int c=0;
		
		while(r>0 || c<size){
			System.out.print(arr[r][c]+ " ");
			r--;
			c++;
		}
		
		

	}

}
