# Max Sum of Non-Adjacent Elements (House Robber)

| Field | Details |
|-------|---------|
| **Topic** | Dynamic Programming |
| **Difficulty** | 🟡 Medium |
| **GFG Link** | [Max Sum Without Adjacents](https://www.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1) |
| **Approach** | Space-optimized DP (track prev1 & prev2) |
| **Time Complexity** | O(n) |
| **Space Complexity** | O(1) |

## Key Takeaway
> `curr = max(prev1, arr[i] + prev2)`. Skip one element each time.
