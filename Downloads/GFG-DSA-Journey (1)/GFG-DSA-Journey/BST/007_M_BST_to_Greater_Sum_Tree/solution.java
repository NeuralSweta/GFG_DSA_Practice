// Problem: BST to Greater Sum Tree | Difficulty: Medium | Topic: BST
// GFG: https://www.geeksforgeeks.org/problems/bst-to-greater-sum-tree/0
class Solution {
    int sum = 0;
    public void toGreaterSumTree(Node root) {
        if (root == null) return;
        toGreaterSumTree(root.right);   // reverse inorder: right first
        sum += root.data;
        root.data = sum;
        toGreaterSumTree(root.left);
    }
}
