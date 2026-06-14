# Buy and Sell a Stock — Single Transaction

| Field | Details |
|-------|---------|
| **Topic** | Arrays |
| **Difficulty** | 🟢 Easy |
| **GFG Link** | [Buy Stock](https://www.geeksforgeeks.org/problems/buy-stock-2/1) |
| **Approach** | Track minimum price, compute max profit |
| **Time Complexity** | O(n) |
| **Space Complexity** | O(1) |

## Key Takeaway
> Track `minPrice` as you scan. At each step, `profit = price[i] - minPrice`.
