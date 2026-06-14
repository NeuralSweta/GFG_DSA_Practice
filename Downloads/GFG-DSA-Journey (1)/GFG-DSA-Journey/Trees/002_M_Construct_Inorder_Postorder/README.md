# Binary Tree from Inorder and Postorder

| Field | Details |
|-------|---------|
| **Topic** | Trees |
| **Difficulty** | 🟡 Medium |
| **GFG Link** | [Solve](https://www.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/0) |
| **Approach** | Recursion + HashMap for inorder index |
| **Time Complexity** | O(n) |
| **Space Complexity** | O(n) |

## Key Takeaway
> postorder[last] = root. Find in inorder → recurse right first, then left.
