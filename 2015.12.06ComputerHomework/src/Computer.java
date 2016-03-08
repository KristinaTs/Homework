import org.omg.Messaging.SyncScopeHelper;

public class Computer {
	int year;
	double price;
	boolean isNotebook;
	double  hardDiskMemory;
	double  freeMemory;
	String operationSystem;
	
	
	Computer(){
		this.isNotebook=false;
		this.operationSystem="Win XP";
	}
	
	Computer(int year,double price,double hardDiskMemory,double freeMemory){
		this();
		if(year>1980 && price>0 && hardDiskMemory>0&&freeMemory>=0){
			this.year=year;
			this.price=price;
			this.hardDiskMemory=hardDiskMemory;
			this.freeMemory=freeMemory;
		}else{
			System.out.println("Invalid types");
		}
	}
	Computer(int year,double price,boolean isNotebook,double hardDiskMemory,double freeMemory,String operationSystem){
		this( year, price, hardDiskMemory, freeMemory);
		this.isNotebook=isNotebook;
		if(operationSystem!=null){
			this.operationSystem=operationSystem;
		}else{
			this.operationSystem="";
		}
		
	}
	void changeOperationSystem( String newOperationSystem){
		this.operationSystem=newOperationSystem;
	}
	double useMemory(double memory){
		
		if(freeMemory<memory){
			System.out.println("Not enough free memory");
			return 0;
		}else{
			freeMemory=freeMemory-memory;
			return freeMemory;
		}
	}
	
	int comparePrice(Computer c) {
		
		if (c != null) {

			if (this.price > c.price) {
				return -1;
			}
			if (this.price < c.price) {
				return 1;
			}
			if (this.price == c.price) {
				return 0;
			}
		}
		return -1;
		

	}

}

