# Count BST Nodes in Given Range

| Field | Details |
|-------|---------|
| **Topic** | BST |
| **Difficulty** | 🟡 Medium |
| **GFG Link** | [Solve](https://www.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/0) |
| **Approach** | Recursive range check |
| **Time Complexity** | O(n) |
| **Space Complexity** | O(h) |

## Key Takeaway
> If node in [lo,hi] count it. Prune left if node.val <= lo, prune right if node.val >= hi.
