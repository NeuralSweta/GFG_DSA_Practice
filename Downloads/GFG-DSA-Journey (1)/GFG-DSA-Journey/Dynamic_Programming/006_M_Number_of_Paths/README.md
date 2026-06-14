# Number of Paths in Grid

| Field | Details |
|-------|---------|
| **Topic** | Dynamic_Programming |
| **Difficulty** | 🟡 Medium |
| **GFG Link** | [Solve](https://www.geeksforgeeks.org/problems/number-of-paths0926/0) |
| **Approach** | 2D DP — sum from top and left |
| **Time Complexity** | O(m×n) |
| **Space Complexity** | O(m×n) |

## Key Takeaway
> dp[i][j] = dp[i-1][j] + dp[i][j-1]. Same as Unique Paths.
