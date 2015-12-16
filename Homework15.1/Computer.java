
public class Computer {
	int year;
	double price;
	boolean isNotebook;
	int hardDiskMemory;
	int freeMemory;
	String operationSystem;
	
	void changeOperationSystem( String newOperationSystem){
		this.operationSystem=newOperationSystem;
	}
	int useMemory(int memory){
		
		if(freeMemory<memory){
			System.out.println("Not enough free memory");
			return 0;
		}else{
			freeMemory=freeMemory-memory;
			return freeMemory;
		}
	}
	
}
