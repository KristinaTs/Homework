
public class task14 {

	
	static int facturiel(int n){
		if(n==0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		return n*facturiel(n-1);
	}
	public static void main(String[] args) {
		int result=facturiel(5);
		System.out.println(result);
	}

}
