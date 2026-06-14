// Problem: Search a Node in BST | Difficulty: Easy | Topic: BST
// GFG: https://www.geeksforgeeks.org/problems/search-a-node-in-bst/0
class Solution {
    public boolean search(Node root, int x) {
        if (root == null) return false;
        if (root.data == x) return true;
        return x < root.data ? search(root.left, x) : search(root.right, x);
    }
}
