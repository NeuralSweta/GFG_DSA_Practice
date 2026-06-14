# Unique Paths in a Grid

| Field | Details |
|-------|---------|
| **Topic** | Dynamic Programming |
| **Difficulty** | 🟡 Medium |
| **GFG Link** | [Unique Paths](https://www.geeksforgeeks.org/problems/unique-paths-in-a-grid--170647/1) |
| **Approach** | 2D DP with 1-indexed array |
| **Time Complexity** | O(m×n) |
| **Space Complexity** | O(m×n) |

## Key Takeaway
> `dp[i][j] = dp[i-1][j] + dp[i][j-1]`. First row and column = 1 (only one way).
> Use 1-indexed `dp[m+1][n+1]` to avoid boundary checks.
