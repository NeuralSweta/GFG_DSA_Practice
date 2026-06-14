// Problem: Count BST Nodes in Given Range | Difficulty: Medium | Topic: BST
// GFG: https://www.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/0
class Solution {
    public int getCount(Node root, int lo, int hi) {
        if (root == null) return 0;
        int count = (root.data >= lo && root.data <= hi) ? 1 : 0;
        if (root.data > lo) count += getCount(root.left, lo, hi);
        if (root.data < hi) count += getCount(root.right, lo, hi);
        return count;
    }
}
