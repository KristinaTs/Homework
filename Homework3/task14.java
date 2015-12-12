
public class task14 {

	public static void main(String[] args) {

		double [] arr = { 7.1,8.5,0.2,3.7,0.99,1.4,-3.5,-110,212,341,1.2};
		for(int index=0; index<arr.length;index++){
			if(arr[index]>-2.99 && arr[index]<2.99){
				System.out.print(arr[index]+ " ");
			}
		}
	}

}
