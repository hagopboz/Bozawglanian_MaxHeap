
public class MaxHeap {

    public static int[] Arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
    public static int counter = 0;

    public static void main(String[] args) {
        int kk;
        for (kk = 0; kk <= Arr.length - 1; kk++) {
            heapM(Arr, kk);
        }

        for (int krk = 0; krk < Arr.length; krk++) {
            System.out.println(Arr[krk]);
        }



    }

    public static void heapM(int[] Arr, int i) {

        int largest;
        int left = i * 2;
        int right = i * 2 + 1;
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


            heapM(Arr, largest);
        }
    }

    private static void swap(int i, int largest) {
        int t = Arr[i];
        Arr[i] = Arr[largest];
        Arr[largest] = t;

    }
}
