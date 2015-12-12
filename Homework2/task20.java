
public class task20 {

	public static void main(String[] args) {
		int[][] arr = new int[10][10];
		
		for(int i =1; i<10;i++){
			for(int j=0; j<=9;j++){
				for(int k = 0;k<=9;k++){
				arr[j][i]=k;
				}
				System.out.print(arr[j][i]+ " ");
				
				}
			System.out.println();
			
		}
		
	}

}
