
public class task5 {

	public static void main(String[] args) {
		int [][] arr={
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
	};
		int maxSumRow=0;
		for(int row=0;row<4;row++){
			int sum=0;
			for(int col=0;col<4;col++){
				sum=sum+arr[row][col];
				if(sum>maxSumRow){
					maxSumRow=sum;
				}
			}
		}
		
		int maxSumCol=0;
		for(int col=0;col<4;col++){
			int sum=0;
			for(int row=0;row<4;row++){
				sum=sum+arr[row][col];
				if(sum>maxSumCol){
					maxSumCol=sum;
				}
			}
		}
		
		System.out.print("���-������ ���� �� ������: ");
		System.out.println(maxSumRow);
		System.out.print("���-������ ���� �� ������: ");
		System.out.println(maxSumCol);
		
		if(maxSumRow>maxSumCol){
			System.out.println("������������ ���� �� ������ � > �� ������������ ���� �� ������");
		}
		
		if(maxSumRow==maxSumCol){
			System.out.println("������������ ���� �� ������ � = �� ������������ ���� �� ������");
		}
		if(maxSumRow<maxSumCol){
			System.out.println("������������ ���� �� ������ � < �� ������������ ���� �� ������");
		}
		

	}

}
