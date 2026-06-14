# Next Permutation

| Field | Details |
|-------|---------|
| **Topic** | Arrays |
| **Difficulty** | 🟡 Medium |
| **GFG Link** | [Next Permutation](https://www.geeksforgeeks.org/problems/next-permutation5226/1) |
| **Approach** | Find Pivot → Swap → Reverse |
| **Time Complexity** | O(n) |
| **Space Complexity** | O(1) |

## Problem Summary
Rearrange array to its lexicographically next permutation in-place.

## Algorithm
1. Find rightmost `pivot` where `nums[i] < nums[i+1]`
2. If no pivot → reverse entire array (last permutation)
3. Find rightmost element greater than `nums[pivot]`, swap
4. Reverse suffix after `pivot`

## Key Takeaway
> Classic 3-step in-place permutation algorithm. Master the pivot logic.
