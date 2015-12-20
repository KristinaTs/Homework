import java.util.Scanner;

public class Horse {

	static void horseMovement(char[][]arr, int row, int col){
		int rows=arr.length;
		int cols=arr[0].length;
		
		arr[row][col]='*';
		
		if(row-2>-1 && col-1>-1){
			if(arr[row-2][col-1]!='*'){
				horseMovement(arr,row-2,col-1);
			}
		}
		if(row-2>-1 && col+1<cols){
			if(arr[row-2][col+1]!='*'){
				horseMovement(arr,row-2,col+1);
			}
		}
		if(row-1>-1 && col-2>-1){
			if(arr[row-1][col-2]!='*'){
				horseMovement(arr,row-1,col-2);
			}
		}
		if(row-1>-1 && col+2<cols){
			if(arr[row-1][col+2]!='*'){
				horseMovement(arr,row-1,col+2);
			}
		}
		if(row+1<rows && col-2>-1){
			if(arr[row+1][col-2]!='*'){
				horseMovement(arr,row+1,col-2);
			}
		}
		if(row+1<rows && col+2<cols){
			if(arr[row+1][col+2]!='*'){
				horseMovement(arr,row+1,col+2);
			}
		}
		if(row+2<rows && col-1>-1){
			if(arr[row+2][col-1]!='*'){
				horseMovement(arr,row+2,col-1);
			}
		}
		if(row+2<rows && col+1<cols){
			if(arr[row+2][col+1]!='*'){
				horseMovement(arr,row+2,col+1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char [][] arr = new char [0][0];
		System.out.println("Въведете големината на масива:");
		int rows=scan.nextInt();
		int cols=scan.nextInt();
		if(rows<0 && cols<0){
			System.out.println("Invalid lengths!");
			return;
		}else{
			arr = new char [rows][cols];
		}
		
		System.out.println("Въведете координатите на точката:");
		int firstCoordinate=scan.nextInt();
		int secondCoordinate=scan.nextInt();
		
		if(firstCoordinate<0 || secondCoordinate<0 ||firstCoordinate>rows || secondCoordinate>cols){
			System.out.println("Invalid coordinates!");
			return;
		}else{
			horseMovement(arr,firstCoordinate,secondCoordinate);
		}
	
	
	
	
	
	for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){
			System.out.print(arr[i][j]+" ");
		}
		System.out.println();
	
	}
	
	}

}
