import java.util.Scanner;

public class task2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Въведете големината на масивa:");
		int size = scan.nextInt();
		int [][] arr = new int[size][size];
		
		System.out.println("Въведете стойностите в масивa:");
		for(int row=0; row<size;row++){
			for(int col=0;col<size;col++){
			arr[row][col]=scan.nextInt();
			}
		}
		
		System.out.print("Първия диагонал е: ");
		for(int index=0;index<size;index++){
			System.out.print(arr[index][index]+ " ");
		}
		System.out.println();
		
		System.out.print("Втория диагонал е: ");
		int r=3;
		int c=0;
		
		while(r>0 || c<size){
			System.out.print(arr[r][c]+ " ");
			r--;
			c++;
		}
		
		

	}

}
