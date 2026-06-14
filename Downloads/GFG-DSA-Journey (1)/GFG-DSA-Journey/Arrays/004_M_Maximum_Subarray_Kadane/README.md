# Maximum Subarray Sum — Kadane's Algorithm

| Field | Details |
|-------|---------|
| **Topic** | Arrays |
| **Difficulty** | 🟡 Medium |
| **GFG Link** | [Kadane's Algorithm](https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1) |
| **Approach** | Kadane's Algorithm (DP on array) |
| **Time Complexity** | O(n) |
| **Space Complexity** | O(1) |

## Problem Summary
Find the contiguous subarray with the maximum sum.

## Key Takeaway
> At each index: extend current subarray or start fresh. `currentSum = max(arr[i], currentSum + arr[i])`
