# Longest Subarray with Sum K

| Field | Details |
|-------|---------|
| **Topic** | Arrays |
| **Difficulty** | 🟡 Medium |
| **GFG Link** | [Solve](https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/0) |
| **Approach** | HashMap storing prefix sum → first index |
| **Time Complexity** | O(n) |
| **Space Complexity** | O(n) |

## Key Takeaway
> Store prefixSum index. If prefixSum-K exists in map, update maxLen.
