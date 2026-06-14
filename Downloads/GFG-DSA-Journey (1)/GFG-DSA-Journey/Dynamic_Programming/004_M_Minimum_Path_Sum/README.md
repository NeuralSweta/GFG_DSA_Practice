# Minimum Path Sum in Grid

| Field | Details |
|-------|---------|
| **Topic** | Dynamic Programming |
| **Difficulty** | 🟡 Medium |
| **GFG Link** | [Minimum Path Sum](https://www.geeksforgeeks.org/problems/minimum-sum-path-in-a-triangle/1) |
| **Approach** | 2D DP, 1-indexed |
| **Time Complexity** | O(m×n) |
| **Space Complexity** | O(m×n) |

## Key Takeaway
> `dp[i][j] = grid[i-1][j-1] + min(dp[i-1][j], dp[i][j-1])`.
> Guard against out-of-bounds on first row/col with `Integer.MAX_VALUE`.
