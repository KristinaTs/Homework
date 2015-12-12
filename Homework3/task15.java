import java.util.Scanner;

public class task15 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Въведете големината на масива:");
		int size = scan.nextInt();
		double [] arr = new double [size];
		
		System.out.println("Въведете стойностите в масива:");
		for(int index=0; index<size;index++){
			arr[index]=scan.nextDouble();
		}
		
		
        for (int i = 1; i < arr.length; i++) {
            for(int j = i ; j > 0 ; j--){
            	if(arr[j]>0){
                if(arr[j] > arr[j-1]){
                   double temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                }
            	if(arr[j]<=0){
            		arr[j]=-arr[j];
            		 if(arr[j] > arr[j-1]){
                         double temp = arr[j];
                          arr[j] = arr[j-1];
                          arr[j-1] = temp;
                      }
            	}
            	
            }
        }
        
        

		for(int index1=0; index1<3;index1++){
			System.out.print(arr[index1] + " ");
		}
		

	}

}
