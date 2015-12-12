import java.util.Scanner;

public class task9 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		int sum=0;
		for(int i=a; i<=b;i++){
			
			if(i%3==0){
				System.out.print("skip 3 " + ",");
				continue;
			}
			sum+=i*i;
			if(sum>=200){
				break;
			}
			System.out.print(i*i + " ," );
			}
		//System.out.println(sum);

}
}
