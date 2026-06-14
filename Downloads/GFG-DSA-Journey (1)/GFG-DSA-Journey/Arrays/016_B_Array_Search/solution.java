// Problem: Array Search | Difficulty: Basic | Topic: Arrays
// GFG: https://www.geeksforgeeks.org/problems/search-an-element-in-an-array-1587115621/0
class Solution {
    public static int search(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == k) return i;
        return -1;
    }
}
