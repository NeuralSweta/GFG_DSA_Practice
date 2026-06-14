# Longest Consecutive Subsequence

| Field | Details |
|-------|---------|
| **Topic** | Arrays |
| **Difficulty** | 🟡 Medium |
| **GFG Link** | [Solve](https://www.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/0) |
| **Approach** | HashSet — start sequence only at chain beginning |
| **Time Complexity** | O(n) |
| **Space Complexity** | O(n) |

## Key Takeaway
> Add all to HashSet. For each n, if n-1 not in set → count chain length. O(n) total.
