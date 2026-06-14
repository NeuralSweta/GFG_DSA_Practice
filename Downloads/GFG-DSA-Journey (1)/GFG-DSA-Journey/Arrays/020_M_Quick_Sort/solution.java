// Problem: Quick Sort | Difficulty: Medium | Topic: Arrays
// GFG: https://www.geeksforgeeks.org/problems/quick-sort/0
class Solution {
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) { i++; int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp; }
        }
        int tmp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = tmp;
        return i + 1;
    }
}
