# Sort 0s 1s and 2s

| Field | Details |
|-------|---------|
| **Topic** | Arrays |
| **Difficulty** | 🟡 Medium |
| **GFG Link** | [Solve](https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/0) |
| **Approach** | Dutch National Flag (3 pointers) |
| **Time Complexity** | O(n) |
| **Space Complexity** | O(1) |

## Key Takeaway
> lo=0, mid=0, hi=n-1. Swap based on arr[mid]: 0→swap lo, 2→swap hi, 1→mid++.
