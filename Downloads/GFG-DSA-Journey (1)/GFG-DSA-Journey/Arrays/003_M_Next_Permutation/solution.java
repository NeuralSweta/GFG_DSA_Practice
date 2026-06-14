// Problem: Next Permutation
// Difficulty: Medium | Topic: Arrays
// GFG Link: https://www.geeksforgeeks.org/problems/next-permutation5226/1

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        // Step 1: Find rightmost index where nums[i] < nums[i+1]
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) { pivot = i; break; }
        }

        // Step 2: If no pivot, entire array is descending → reverse all
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find rightmost element greater than nums[pivot]
        for (int j = n - 1; j > pivot; j--) {
            if (nums[j] > nums[pivot]) {
                int tmp = nums[j]; nums[j] = nums[pivot]; nums[pivot] = tmp;
                break;
            }
        }

        // Step 4: Reverse suffix after pivot
        reverse(nums, pivot + 1, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l]; nums[l++] = nums[r]; nums[r--] = tmp;
        }
    }
}
