// Problem: Min and Max in Array | Difficulty: Basic | Topic: Arrays
// GFG: https://www.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/0
class Solution {
    public int[] minMax(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int x : arr) { min = Math.min(min, x); max = Math.max(max, x); }
        return new int[]{min, max};
    }
}
