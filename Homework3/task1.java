
public class task1 {

	public static void main(String[] args) {
 int [] arr = {10,8,6,-3,7,6,4,9};
 int min=arr[0];
 boolean isNum=true;
 for(int i=0; i<arr.length;i++){
	 isNum=true;
	 if(arr[i]%3==0 && arr[i]<min ){
		 min=arr[i];
	 }
	 if(arr[i]%3!=0){
		 isNum=false;
	 }
	 
	 }
 if(isNum==true){
 System.out.println(min);
	}
 else{
	 System.out.println("Nqma takova chislo");
 }
	}

}
