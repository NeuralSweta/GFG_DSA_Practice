# Stickler Thief (House Robber II)

| Field | Details |
|-------|---------|
| **Topic** | Dynamic_Programming |
| **Difficulty** | 🟡 Medium |
| **GFG Link** | [Solve](https://www.geeksforgeeks.org/problems/stickler-theif-1587115621/0) |
| **Approach** | Space-optimized DP — skip adjacent |
| **Time Complexity** | O(n) |
| **Space Complexity** | O(1) |

## Key Takeaway
> Same as House Robber. dp[i] = max(dp[i-1], arr[i] + dp[i-2]).
