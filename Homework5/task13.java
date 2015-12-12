
public class task13 {
//	Да се създаде метод, който приема два масива от числа и връща
//	масив, съдържащ всички елементи на подадените масиви, като в
//	първата част на масива са елементите на първия подаден масив,
//	а във втората част – тези на втория подаден масив.
	
	
	
	static int[] creation(int[] arr1,int[] arr2){
		int [] arr3=new int [arr1.length +arr2.length];
		
				for(int index=0;index<arr1.length;index++){
					arr3[index]=arr1[index];
				}
				for(int index=arr1.length,i=0;index<arr3.length && i<arr2.length;index++,i++){
					arr3[index]=arr2[i];
				}
				return arr3;
						
	}
	public static void main(String[] args) {
		int [] arr1={1,2,3,4,5,6,7};
		int [] arr2={8,9,1,2,3,4};
		int [] arr3=creation(arr1,arr2);
		for(int index=0;index<arr3.length;index++){
			System.out.print(arr3[index]+ " ");
		}
	}

}
