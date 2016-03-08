
public class ComputerDemo {

	public static void main(String[] args) {
		//Part of homework15
//		Computer naBabaCompa = new Computer();
//		Computer moqSiComp=new Computer();
//		
//		naBabaCompa.year=1998;
//		naBabaCompa.price=56;
//		naBabaCompa.hardDiskMemory=50;
//		naBabaCompa.isNotebook=false;
//		naBabaCompa.freeMemory=25;
//		naBabaCompa.operationSystem="Windows 98";
//		
//		moqSiComp.year=2013;
//		moqSiComp.price=2200;
//		moqSiComp.hardDiskMemory=500;
//		moqSiComp.isNotebook=true;
//		moqSiComp.freeMemory=150;
//		moqSiComp.operationSystem="Windows 7";
//		
//		naBabaCompa.changeOperationSystem("Windows 99");
//		moqSiComp.useMemory(100);
//		
//		
//		System.out.println("Granny's computer");
//		System.out.println("Year:"+naBabaCompa.year);
//		System.out.println("Price:"+naBabaCompa.price);
//		System.out.println("Hard Disk Memory:"+naBabaCompa.hardDiskMemory);
//		System.out.println("Is it a notebook:"+naBabaCompa.isNotebook);
//		System.out.println("Free memory:"+naBabaCompa.freeMemory);
//		System.out.println("Operation System:"+naBabaCompa.operationSystem);
//		
//		System.out.println();
//		
//		System.out.println("My computer");
//		System.out.println("Year:"+moqSiComp.year);
//		System.out.println("Price:"+moqSiComp.price);
//		System.out.println("Hard Disk Memory:"+ moqSiComp.hardDiskMemory);
//		System.out.println("Is it a notebook:"+moqSiComp.isNotebook);
//		System.out.println("Free memory:"+moqSiComp.freeMemory);
//		System.out.println("Operation System:"+moqSiComp.operationSystem);
		
		
		Computer myComputer=new Computer(2013, 2000, 500, 150);
		System.out.println(myComputer.price);
		Computer theBoss = new Computer(2014, 3000, true, 600, 300, "Windows 10");
		System.out.println(theBoss.operationSystem);
		
		int difference =myComputer.comparePrice(theBoss);
		if(difference==-1){
			System.out.println("MyComputer is more expensive than theBoos");
		}
		if(difference==0){
			System.out.println("The price is the same");
		}
		if(difference==1){
			System.out.println("TheBoss is more expensive");
		}
		int result=myComputer.comparePrice(null);
		System.out.println(result);

	}

}
