// Problem: k-th Smallest in BST | Difficulty: Medium | Topic: BST
// GFG: https://www.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/0
class Solution {
    int count = 0, result = -1;
    public int KthSmallestElement(Node root, int k) {
        inorder(root, k);
        return result;
    }
    private void inorder(Node node, int k) {
        if (node == null) return;
        inorder(node.left, k);
        if (++count == k) { result = node.data; return; }
        inorder(node.right, k);
    }
}
