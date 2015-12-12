
public class task1 {

	public static void main(String[] args) {
		int [][] arr = {
						{48,72,13,14,15},
						{21,22,53,24,75},
						{31,57,33,34,35},
						{41,95,43,44,45},
						{59,52,53,54,55},
						{61,69,63,64,65}
					};
		int min=arr[0][0];
		int max=arr[0][0];
		for(int row=0; row<6;row++){
			for(int col=0;col<5;col++){
				if(arr[row][col]<=min){
					min =arr[row][col];
				}
				if(arr[row][col]>=max){
					max=arr[row][col];
				}
			}
		}
		
		System.out.print("Най-малкото е: ");
		System.out.println(min);
		System.out.print("Най-голямато е: ");
		System.out.println(max);

	}

}
