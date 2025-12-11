public class QuickSort{
    public static void quickSort(int[]arr,int start,int end){
        if (start >= end);
        return;
        int pivot= partition(arr,start,end);
        quick_sort(arr, start,pivot-1);
        quick_sort(arr,pivot+1,end);
    }
    public static int partition (int []arr,int start,int end){
        int pivot = start;
        int i= start+1;
        int j= end;
        while(i<j){
            while(arr[pivot]>=arr[j]);i++;
            while(arr[pivot]<arr[j]);j--;
            if(i<j){
                swap (arr[i],arr[j]);
            }
            swap(arr[pivot],arr[j]);
            return j;
        }
        public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    }
    public static void main(String[], args){
        QuickSort qs = new QuickSort();
        int arr[]={10,7,6,12,18,2,9};
        System.out.prinln("The Original array:")
        printArray(arr);
        
        qs.quickSort(arr, 0, arr.length - 1);
        
        System.out.println("Sorted array:");
        printArray(arr);
    }
    
    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}