
public class task6 {

	public static void main(String[] args) {
		int [][] arr = {
				{11,12,13,14,15,16},
				{21,22,23,24,25,26},
				{31,32,33,34,35,36},
				{41,42,43,44,45,46},
				{51,52,53,54,55,56},
				{61,62,63,64,65,66}
		};
		
		int [] arr1 = new int[3];
		for(int row=0,index=0;row<6 && index<3;row+=2,index++){
			int sum=0;
			for(int col=0;col<6;col++){
				sum=sum+arr[row][col];
				}
			arr1[index]=sum;
			}
			
		
		
		for(int row=0,index=0;row<6 && index<3;row+=2,index++){
			for(int col=0;col<6;col++){
			System.out.print(arr[row][col]+ " ");
			}
			System.out.println("сума: " + arr1[index]);
		}
		int sum1=0;
		for(int index=0;index<3;index++){
			sum1=sum1+arr1[index];
		}
		System.out.println("Сума на елементите: " + sum1);
	}

}
