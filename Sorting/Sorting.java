public class Sorting{
    
    /**
     * This method performs selection sort on the given array.
     *
     * @param arr The array to be sorted.
     * @param n The size of the array.
     */
    public static void selectionSort(int arr[], int n){
        for(int i = 0; i<n-1;i++){
            int mini = i;
            for(int j = i+1; j <n; j++){
                if(arr[j]<arr[mini]){
                    mini = j;
                }
            }
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }
    }


    public static void main(String[] args) {
        int arr[] = {23,45,12,67,43};
        int n = arr.length;
        selectionSort(arr,n);
        for(int i = 0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}