# Min Cost Climbing Stairs

| Field | Details |
|-------|---------|
| **Topic** | Dynamic_Programming |
| **Difficulty** | 🟡 Medium |
| **GFG Link** | [Solve](https://www.geeksforgeeks.org/problems/min-cost-climbing-stairs/0) |
| **Approach** | DP — choose cheaper step |
| **Time Complexity** | O(n) |
| **Space Complexity** | O(1) |

## Key Takeaway
> dp[i] = cost[i] + min(dp[i-1], dp[i-2]). Answer = min(dp[n-1], dp[n-2]).
