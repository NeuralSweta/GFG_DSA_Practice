# Dijkstra's Shortest Path Algorithm

| Field | Details |
|-------|---------|
| **Topic** | Graph |
| **Difficulty** | 🟡 Medium |
| **GFG Link** | [Dijkstra Shortest Path](https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1) |
| **Approach** | Greedy + Min-Heap (Priority Queue) |
| **Time Complexity** | O((V + E) log V) |
| **Space Complexity** | O(V + E) |

## Key Takeaway
> Use a min-heap of `{dist, node}`. Skip stale entries (`d > dist[u]`).
> Dijkstra works only for **non-negative weights**.
