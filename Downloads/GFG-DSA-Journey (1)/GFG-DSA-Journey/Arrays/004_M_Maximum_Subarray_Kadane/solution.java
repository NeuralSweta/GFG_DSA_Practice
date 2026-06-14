// Problem: Maximum Subarray Sum (Kadane's Algorithm)
// Difficulty: Medium | Topic: Arrays
// GFG Link: https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1

class Solution {
    public long maxSubarraySum(int[] arr) {
        long maxSum = arr[0], currentSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
