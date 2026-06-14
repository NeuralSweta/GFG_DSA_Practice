// Problem: Minimum in BST | Difficulty: Easy | Topic: BST
// GFG: https://www.geeksforgeeks.org/problems/minimum-element-in-bst/0
class Solution {
    public int minValue(Node root) {
        while (root.left != null) root = root.left;
        return root.data;
    }
}
