
public class task2 {

	public static void main(String[] args) {
		int [] arr = {1,4,5,6,7,7,8,4};
		int []	arr1= new int[arr.length*2];
		System.out.println(arr.length);
		System.out.println(arr1.length);
		
		
		for(int index=0;index<arr.length;index++){
			
			arr1[index]=arr[index];
		}
		 int index=arr1.length-1;
		 int i=0;
		while(index>=arr1.length/2){
			arr1[index]=arr[i];
			i++;
			index--;
		}
//		
//		
		for(int t=0; t<arr1.length;t++){
			System.out.print(arr1[t]);
	}
	//}

}
}
