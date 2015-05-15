
public class HeapNode {
	private int size;
	private int swapping;
	private int[] heap;
	private final static int maxArray=101;
	/**
	 * Default Constructor 
	 */
	public HeapNode() {
		size=0;
		swapping=0;
		heap = new int[maxArray];
	}
	/**
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @return swapping
	 */
	public int getSwapping() {
		return swapping;
	}
	/**
	 * @return heap[]
	 */
	public int[] getHeap() {
		return heap;
	}
	/**
	 * Checks if the heap at location is empty
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	/**
	 * Checks if the heap at location is full
	 * @return
	 */
	public boolean isFull() {
		return size == heap.length;
	}
	/**
	 * Checks if the given data is a duplicate in a given array
	 * @return
	 */
	public boolean isDuplicate(int h) {
		for(int i = 0; i < heap.length; i++) {
			if(heap[i] == h){
				return true;
			}
		}
		return false;
	}
	/**
	 * Adds a given number onto a given array in a Sequential insertion.
	 */
	public void addSeqeuntial(int h) {		
		int n = 0, x = (size-1)/2 , tempSize = size;
		boolean check = false;
		if(isEmpty()) {
			heap[size] = h;
			check = true;
			size++;
		} else {
			if(!isDuplicate(h)) {
				while(!check) {
					if(h > heap[x]) {
						n = heap[x];
						heap[x] = h;
						heap[tempSize] = n;
						tempSize = x;
						x = (x-1)/2;
						swapping++;
					} else if(h < heap[x]) {
						heap[tempSize] = h;
						size++;
						check = true;
					} else {
						check = true;
						size++;
					}
				}
			}
		}
	}
	/**
	 * Places all values in the given array first
	 * helper method for Optimal	
	 */
	public void addOptimal(int h) {
		if(!isDuplicate(h)) {
			if(size == 0){
				heap[size] = h;
			} else {
				heap[size] = h;
			}
			size++;
		}
	}
	/**
	 * Reheaps a given array up untill all of the characteristics
	 * of a heap tree are met
	 */
	public void optimalUp(){
		int n = 0,tempSwapping = swapping;
		do {
			tempSwapping = swapping;
			for(int i = size; i > 0; i--) {
				int x = (i-1)/2;
				if(i%2 != 0) {
					if(heap[i] > heap[x]) {
						n = heap[x];
						heap[x] = heap[i];
						heap[i] = n;
						swapping++;
					}
				} else if(i%2 == 0) {
					if(heap[i] > heap[i-1]) {
						if(heap[i] > heap[x]) {
							n = heap[x];
							heap[x] = heap[i];	
							heap[i] = n;
							swapping++;
						}
					} else {
						if(heap[i-1] > heap[x]) {
							n = heap[x];
							heap[x] = heap[i-1];
							heap[i-1] = n;
							swapping++;
						}
					}
					i--;
				}
			}
		} while(tempSwapping != swapping);
	}
	/**
	 * Removes the the root number which is in the spot index(0), 
	 * then replaces it with the last number of the
	 * array. the method then reheaps up untill all of the 
	 * characteristics of a heap are met.
	 */
	public void remove() {
		if(!isEmpty()) {
			int index = swapping;
			heap[0] = heap[size-1];
			heap[size-1] = -1;
			size--;
			while(swapping == index) {
				index = swapping;
				optimalUp();
			}
		}
	}
	/**
	 * Prints the first 10 numbers in array
	 */
	public void printHeap() {
		for(int i=0; i<10 ; i++) {
			System.out.print(heap[i] + ",");
		}
		System.out.print("...");
		System.out.println();
	}
}
