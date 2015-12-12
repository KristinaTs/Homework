
public class task4 {

	public static void main(String[] args) {
	
		int [][] arr={
					{1,2,3,4},
					{5,6,7,8},
					{9,10,11,12},
					{13,14,15,16}
		};
		
		int [][] arr1= new int[4][4];
		
		for(int index=0;index<4;index++){
		int row=3;
		int col=0;
		while(row>=0){
			arr1[index][col]=arr[row][index];
			row--;
			col++;
		}
		}
		
		for(int i=0; i<4;i++){
			for(int j=0;j<4;j++){
			System.out.print(arr1[i][j]+ " ");
			}
			System.out.println();
		}
		
		
		

	}

}
