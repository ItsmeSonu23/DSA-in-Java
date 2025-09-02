public class Sorting {

    /**
     * This method performs selection sort on the given array.
     *
     * Selection sort is a simple sorting algorithm that works by repeatedly finding
     * the minimum
     * element from the unsorted part of the array and placing it at the beginning.
     * The algorithm
     * maintains two subarrays in a given array: the subarray which is already
     * sorted, known as the
     * sorted subarray, and the subarray which is unsorted, known as the unsorted
     * subarray. The
     * algorithm keeps selecting the minimum element from the unsorted subarray and
     * swaps it with
     * the first element of the unsorted subarray. This process continues until the
     * entire array is
     * sorted.
     *
     * @param arr The array to be sorted.
     * @param n   The size of the array.
     */
    public static void selectionSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int mini = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[mini]) {
                    mini = j;
                }
            }
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * This method performs bubble sort on the given array.
     *
     * @param arr The array to be sorted.
     * @param n   The size of the array.
     * 
     *            Bubble Sort algorithm:
     *            1. Iterate through the array from the last element to the first,
     *            and compare adjacent elements.
     *            2. If the first element is greater than the second, swap them.
     *            3. Repeat step 2 until no more swaps are needed.
     *            4. Repeat step 1 until the array is sorted.
     */
    public static void bubbleSort(int arr[], int n) {
        for (int i = n - 1; i >= 0; i--) {
            int swap = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    swap = 1;
                }
            }

            if (swap == 0) {
                break;
            }
        }
    }

    public static void insertionSort(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                j--;
            }
        }
    }

    public static void mergeSort(int arr[], int st, int end) {
        if (end > st) {
            int mid = st+ (end-st)/2;
            mergeSort(arr, st, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, st, mid, end);
        }
    }

    public static void merge(int arr[], int st, int mid, int end) {
        int arr1[] = new int[end-st+1];
        int i = st;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                arr1[k] = arr[i];
                k++;
                i++;
            }
            else{
                arr1[k] = arr[j];
                k++;
                j++;
            }
        }
        while(i<=mid){
            arr1[k] = arr[i];
            k++;
            i++;
        }
        while(j<=end){
            arr1[k] = arr[j];
            k++;
            j++;
        }
        for(int l = st; l<=end; l++){
            arr[l] = arr1[l-st];
        }
    }

    public static void main(String[] args) {
        int arr[] = { 23, 45, 12, 67, 43 };
        int n = arr.length;
        // selectionSort(arr,n);
        // bubbleSort(arr, n);
        // insertionSort(arr, n);
        mergeSort(arr, 0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}