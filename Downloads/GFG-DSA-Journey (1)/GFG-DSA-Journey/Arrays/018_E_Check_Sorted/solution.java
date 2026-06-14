// Problem: Check Whether Array is Sorted | Difficulty: Easy | Topic: Arrays
// GFG: https://www.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701--140001/0
class Solution {
    public boolean arraySortedOrNot(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] > arr[i + 1]) return false;
        return true;
    }
}
