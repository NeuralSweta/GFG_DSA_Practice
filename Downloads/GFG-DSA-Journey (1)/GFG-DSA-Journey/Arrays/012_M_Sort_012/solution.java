// Problem: Sort 0s 1s and 2s (Dutch National Flag) | Difficulty: Medium | Topic: Arrays
// GFG: https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/0
class Solution {
    public void sort012(int[] arr) {
        int lo = 0, mid = 0, hi = arr.length - 1;
        while (mid <= hi) {
            if (arr[mid] == 0) { swap(arr, lo++, mid++); }
            else if (arr[mid] == 1) { mid++; }
            else { swap(arr, mid, hi--); }
        }
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
    }
}
