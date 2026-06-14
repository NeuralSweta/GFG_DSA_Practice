// Problem: BST Insert | Difficulty: Easy | Topic: BST
// GFG: https://www.geeksforgeeks.org/problems/insert-a-node-in-a-bst/0
class Node { int data; Node left, right; Node(int d){data=d;} }
class Solution {
    public Node insert(Node root, int data) {
        if (root == null) return new Node(data);
        if (data < root.data) root.left = insert(root.left, data);
        else if (data > root.data) root.right = insert(root.right, data);
        return root;
    }
}
