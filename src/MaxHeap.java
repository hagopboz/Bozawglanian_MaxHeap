import java.util.Random;
import java.util.Scanner;

public class MaxHeap {

    public static void main(String[] args) {
    	
    	Scanner kb = new Scanner(System.in);
    	int choice = 0;
    	int user;
		HeapNode bSequential = new HeapNode();
		HeapNode bOptimal = new HeapNode();
		int count = 0,sumSequential = 0, sumOptimal = 0;
    	
    	while (choice < 2) {
        	System.out.println("===========================================================================\n");
        	System.out.println("\nPlease select how to test the program:");
        	System.out.println("(1) 20 sets of 100 randomly generated integers");
        	System.out.println("(2) Fixed integer values 1-100");
        	System.out.print("Enter choice:");
        	user = kb.nextInt();
        	switch(user) {
        	case 1:
				for(int i = 0; i < 20; i++) {
					randInsertSequential(bSequential);
					sumSequential += bSequential.getSwapping();
					randInsertOptimal(bOptimal);
					sumOptimal += bOptimal.getSwapping();

					bSequential = new HeapNode();
					bOptimal = new HeapNode();
				}
				System.out.println("Average swaps for series of insertions: " + Avg(sumSequential,20));
				System.out.println("Average swaps for optimal method: " + Avg(sumOptimal,20));
				break;
        	case 2:
        		fixInsertSequential(bSequential);
        		fixInsertOptimal(bOptimal);
				System.out.print("Heap built using series of insertions: ");
				printTen(bSequential);
				printSwap(bSequential);
				removeTen(bSequential);
				System.out.print("Heap after 10 removals: ");
				printTen(bSequential);	
				System.out.print("\nHeap build using optimal method: ");
				printTen(bOptimal);
				printSwap(bOptimal);
				removeTen(bOptimal);
				System.out.print("Heap after 10 removals: ");
				printTen(bOptimal);					
				choice = 2;
        		break;
        	default:
        		System.out.println("Please put in valid response.");
        		break;
        	}
    	}
    }

	public static void randInsertSequential(HeapNode s) {
		Random gen = new Random();
		do {
			s.addSeqeuntial(gen.nextInt(100)+1);
		} while(s.getSize() != 100);
	}
	
	public static void randInsertOptimal(HeapNode o) {
		Random gen = new Random();
		do {
			o.addOptimal(gen.nextInt(100) + 1);
		} while(o.getSize() != 100);
		o.optimalUp();
	}
	
	public static void fixInsertSequential(HeapNode s) {
		for(int i = 1 ; i < 101; i++){
			s.addSeqeuntial(i);
		}
	}
	
	public static void fixInsertOptimal(HeapNode o) {
		for(int i = 1; i < 101; i++)
			o.addOptimal(i);
		o.optimalUp();		
	}
	
	public static void printTen(HeapNode h) {
		h.printHeap();
	}
	
	public static void removeTen(HeapNode h) {
		for(int i = 0 ; i < 9; i++)
			h.remove();
	}
	
	public static void printSwap(HeapNode h) {
		System.out.println("Number of Swaps: " + h.getSwapping());
	}
	
	public static int Avg(int sum, int count) {
		return sum/count;
	}
}
