
public class task16 {

	public static void main(String[] args) {
		float [] arr = {0,  -1.12F, -2.43F, 3.1F, 4.2F, 0F, 6.4F, - 7.5F, 8.6F, 9.1F, -4F};
		
		System.out.print("Реалните числа са: ");
		for(int index1=1; index1<arr.length;index1++){
			System.out.print(arr[index1] + " ");
		}
		
		System.out.println();
	
		for(int index=1; index<arr.length;index++){
			if(arr[index]<=-0.231){
				arr[index]= (float)index*index+ 41.25F;
			}
			else{
				arr[index]=(float)index*arr[index];
			}
		}
		
		float sum=0;
		int count=0;;
		for(int index3=1; index3<arr.length;index3++){
			if(arr[index3]!=0){
				sum=(float)sum+arr[index3];
				count++;
			}
			
		}
		System.out.print("Новите числа са: ");
		for(int index2=1; index2<arr.length;index2++){
			System.out.print(arr[index2] + " ");
		}
		System.out.println();
		System.out.println(sum/count);
		
		
	}

}
