
public class task12 {
//	�� �� ������� �����, ����� ������ �� ������ ����� ����� N �
//	����� ����� �� ����� � ������� N, ����� ������� ������ �����
//	�� 1 �� N.
	
	
	static int[] buildArray(int n){
		int[]arr=new int[n];
		
		for(int index=0,number=1;index<arr.length && number<=n;index++,number++){
			arr[index]=number;
		}
		return arr;
	}
	public static void main(String[] args) {
		
		int[] arr =buildArray(5);
		for(int index=0;index<arr.length;index++){
			System.out.print(arr[index]+ " ");
		}

	}

}
