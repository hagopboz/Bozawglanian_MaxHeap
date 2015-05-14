import java.util.Scanner;

public class MaxHeap {

    public static int[] Arr;
    public static int counter = 0;
    static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
    	
    	int choice = 0;
    	int user;
    	
        int kk;
        for (kk = Arr.length -1; kk >= 0; kk--) {
            heapM(Arr, kk);
            }
        for (int krk = 0; krk < Arr.length; krk++) {
            System.out.println(Arr[krk]);
        }
    	
    	while (choice < 2) {
        	System.out.println("===========================================================================");
        	System.out.println("/n/n/n");
        	System.out.println("Please select how to test the program:");
        	System.out.println("(1) 20 sets of 100 randomly generated integers");
        	System.out.println("(2) Fixed integer values 1-100");
        	System.out.println("Enter choice:");
        	user = kb.nextInt();
        	switch(user) {
        	case 1:
        		
        		break;
        	case 2:
        		
        		break;
        	default:
        		System.out.println("Please put in valid response.");
        		break;
        	}
    	}
    	
    }

    public static void heapM(int[] Arr, int i) {

        int largest;
        int left = 2*i+1;
        int right = 2*i + 2;
        if (((left < Arr.length) && (Arr[left] > Arr[i]))) {
            largest = left;
        } else {
            largest = i;
        }
        if (((right < Arr.length) && (Arr[right] > Arr[largest]))) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            counter ++;
            heapM(Arr, largest);
        }
    }

    private static void swap(int i, int largest) {
        int t = Arr[i];
        Arr[i] = Arr[largest];
        Arr[largest] = t;
        
    }
}
