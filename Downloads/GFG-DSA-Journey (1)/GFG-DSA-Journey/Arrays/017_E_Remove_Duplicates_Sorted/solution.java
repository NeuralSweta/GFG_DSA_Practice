// Problem: Remove Duplicates from Sorted Array | Difficulty: Easy | Topic: Arrays
// GFG: https://www.geeksforgeeks.org/problems/remove-duplicate-elements-from-sorted-array/0
class Solution {
    public int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < arr.length; j++)
            if (arr[j] != arr[i]) arr[++i] = arr[j];
        return i + 1;
    }
}
